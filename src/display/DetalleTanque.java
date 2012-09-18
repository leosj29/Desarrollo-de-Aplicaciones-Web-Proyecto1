package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.TanqueModule;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class DetalleTanque extends PageController {

    /**
     * Utilizado como controlador de página para la acción de mostrar detalle de tanque.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    TanqueModule module = (TanqueModule) context.getBean("tanqueModule");
    try {
		//1- AGREGAR, 2- DETALLE, 3 ELIMINAR
		int tipo = Integer.parseInt(request.getParameter("tp"));
		if(tipo == 1){			 
			 forward("/agregarTanque.jsp",request,response);		
		}else if(tipo == 2 || tipo == 4){
			String id = request.getParameter("id");
			int idTanque = Integer.parseInt(id);
			Map tanque = module.buscar(idTanque);	
			request.setAttribute("tanque",tanque);
			if(tipo == 2){
				request.setAttribute("modoIngreso","1");
			}else{
				request.setAttribute("modoIngreso","2");
			}			 
			forward("/detalleTanque.jsp",request,response);		
		}else if(tipo == 3){
			String id = request.getParameter("id");
			int idTanque = Integer.parseInt(id);
			Map tanque = module.buscar(idTanque);			 
			request.setAttribute("tanque",tanque);
			forward("/eliminarTanque.jsp",request,response);
		}else{
			throw new Exception();
		}		
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}
