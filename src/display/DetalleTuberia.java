package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.TuberiaModule;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class DetalleTuberia extends PageController {

    /**
     * Utilizado como controlador de página para la acción de mostrar detalle de tubería.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    TuberiaModule module = (TuberiaModule) context.getBean("tuberiaModule");
    try {
		//1- AGREGAR, 2- DETALLE, 3 ELIMINAR
		int tipo = Integer.parseInt(request.getParameter("tp"));
		if(tipo == 1){			 
			 forward("/agregarTuberia.jsp",request,response);		
		}else if(tipo == 2 || tipo == 4){
			String id = request.getParameter("id");
			int idTuberia = Integer.parseInt(id);
			Map tuberia = module.buscar(idTuberia);	
			request.setAttribute("tuberia",tuberia);
			if(tipo == 2){
				request.setAttribute("modoIngreso","1");
			}else{
				request.setAttribute("modoIngreso","2");
			}			 
			forward("/detalleTuberia.jsp",request,response);		
		}else if(tipo == 3){
			String id = request.getParameter("id");
			int idTuberia = Integer.parseInt(id);
			Map tuberia = module.buscar(idTuberia);			 
			request.setAttribute("tuberia",tuberia);
			forward("/eliminarTuberia.jsp",request,response);
		}else{
			throw new Exception();
		}		
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}
