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
public class InsertarTanque extends PageController {

    /**
     * Utilizado como controlador de página para la acción de insertar tanque.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
    TanqueModule module = (TanqueModule) context.getBean("tanqueModule");
	
    try {
	
      String capacidad = request.getParameter("capacidad");
      String material = request.getParameter("material");
      String tipo = request.getParameter("tipo");
      String fechaInstalacion = request.getParameter("fechaInstalacion");
      String fechaUltimaInspeccion = request.getParameter("fechaUltimaInspeccion");
	  String estado = request.getParameter("estado");
	  
	  module.agregar(capacidad, material, tipo, fechaInstalacion, fechaUltimaInspeccion,estado);
      response.sendRedirect("listaTanques");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}
