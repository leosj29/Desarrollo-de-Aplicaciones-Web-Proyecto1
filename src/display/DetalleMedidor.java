package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.MedidorModule;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class DetalleMedidor extends PageController {

    /**
     * Utilizado como controlador de página para la acción de mostrar detalle de medidores.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    MedidorModule module = (MedidorModule) context.getBean("medidorModule");
    try {
		//1- AGREGAR, 2- DETALLE, 3 ELIMINAR
		int tipo = Integer.parseInt(request.getParameter("tp"));		
		if(tipo == 1){
			forward("/agregarMedidor.jsp",request,response);		
		}else if(tipo == 2){
			String id = request.getParameter("id");
			int idMedidor = Integer.parseInt(id);
			Map medidor = module.buscar(idMedidor);			
			//Lecturas de medidor
			List data = module.listadoLecturasMedidor(idMedidor);
			request.setAttribute("lecturas",data);
			request.setAttribute("medidor",medidor);
			forward("/detalleMedidor.jsp",request,response);			
		}else if(tipo == 3){
			String id = request.getParameter("id");
			int idMedidor = Integer.parseInt(id);
			Map medidor = module.buscar(idMedidor);
			request.setAttribute("medidor",medidor);
			forward("/eliminarMedidor.jsp",request,response);
		}else{
			throw new Exception();
		}		
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}
