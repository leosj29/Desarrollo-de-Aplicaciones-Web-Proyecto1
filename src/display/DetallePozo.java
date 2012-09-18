package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.PozoModule;
import domain.BombaModule;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class DetallePozo extends PageController {

    /**
     * Utilizado como controlador de página para la acción de mostrar detalle de pozos.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException {
    PozoModule module = (PozoModule) context.getBean("pozoModule");
    try {
		//1- AGREGAR, 2- DETALLE, 3 ELIMINAR
		int tipo = Integer.parseInt(request.getParameter("tp"));		
		if(tipo == 1){
			forward("/agregarPozo.jsp",request,response);		
		}else if(tipo == 2){
			String id = request.getParameter("id");
			int idPozo = Integer.parseInt(id);
			Map pozo = module.buscar(idPozo);			
			//Bombas del Pozo
			BombaModule gmodule = (BombaModule) context.getBean("bombaModule");
			List data = gmodule.listadoPorPozo(id);
			request.setAttribute("bombas",data);		
			request.setAttribute("pozo",pozo);
			forward("/detallePozo.jsp",request,response);		
		}else if(tipo == 3){
			String id = request.getParameter("id");
			int idPozo = Integer.parseInt(id);
			Map pozo = module.buscar(idPozo);
			request.setAttribute("pozo",pozo);
			forward("/eliminarPozo.jsp",request,response);
		}else{
			throw new Exception();
		}		
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}
