package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.EstacionModule;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class BorrarEstacion extends PageController {

    /**
     * Utilizado como controlador de página para la acción de eliminar estaciones.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    EstacionModule module = (EstacionModule) context.getBean("estacionModule");
    try {
      String id = request.getParameter("id");
      int idEstacion = Integer.parseInt(id);
      module.eliminar(idEstacion);
      response.sendRedirect("listaEstaciones");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}
