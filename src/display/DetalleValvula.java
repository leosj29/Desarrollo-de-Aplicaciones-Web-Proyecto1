package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.ValvulaModule;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class DetalleValvula extends PageController {

    /**
     * Utilizado como controlador de página para la acción de mostrar detalle de válvula.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ValvulaModule module = (ValvulaModule) context.getBean("valvulaModule");
    try {
		//1- AGREGAR, 2- DETALLE, 3 ELIMINAR
		int tipo = Integer.parseInt(request.getParameter("tp"));
		if(tipo == 1){			 
			 forward("/agregarValvula.jsp",request,response);		
		}else if(tipo == 2 || tipo == 4){
			String id = request.getParameter("id");
			int idValvula = Integer.parseInt(id);
			Map valvula = module.buscar(idValvula);	
			request.setAttribute("valvula",valvula);
			if(tipo == 2){
				request.setAttribute("modoIngreso","1");
			}else{
				request.setAttribute("modoIngreso","2");
			}			 
			forward("/detalleValvula.jsp",request,response);		
		}else if(tipo == 3){
			String id = request.getParameter("id");
			int idValvula = Integer.parseInt(id);
			Map valvula = module.buscar(idValvula);			 
			request.setAttribute("valvula",valvula);
			forward("/eliminarValvula.jsp",request,response);
		}else{
			throw new Exception();
		}		
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}
