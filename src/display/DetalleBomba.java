package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.BombaModule;
import domain.PozoModule;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class DetalleBomba extends PageController {

    /**
     * Utilizado como controlador de página para la acción de mostrar detalle de bombas.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException {
    BombaModule module = (BombaModule) context.getBean("bombaModule");
    try {
		//1- AGREGAR, 2- DETALLE, 3 ELIMINAR
		int tipo = Integer.parseInt(request.getParameter("tp"));
		if(tipo == 1){		
		
			//LISTA DE PROFESORES
			PozoModule pmodule = (PozoModule) context.getBean("pozoModule");
			 List data = pmodule.listado();
			 request.setAttribute("pozos",data);
			 
			 forward("/agregarBomba.jsp",request,response);		
		}else if(tipo == 2 || tipo == 4){
			String id = request.getParameter("id");
			int idBomba = Integer.parseInt(id);
			Map bomba = module.buscar(idBomba);	
			request.setAttribute("bomba",bomba);
			if(tipo == 2){
				request.setAttribute("modoIngreso","1");
			}else{
				request.setAttribute("modoIngreso","2");
			}			
			//LISTA DE PROFESORES
			PozoModule pmodule = (PozoModule) context.getBean("pozoModule");
			 List data = pmodule.listado();
			 request.setAttribute("pozos",data);
			 
			forward("/detalleBomba.jsp",request,response);		
		}else if(tipo == 3){
			String id = request.getParameter("id");
			int idBomba = Integer.parseInt(id);
			Map bomba = module.buscar(idBomba);
			
			//LISTA DE PROFESORES
			PozoModule pmodule = (PozoModule) context.getBean("pozoModule");
			 List data = pmodule.listado();
			 request.setAttribute("pozos",data);
			 
			request.setAttribute("bomba",bomba);
			forward("/eliminarBomba.jsp",request,response);
		}else{
			throw new Exception();
		}		
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}
