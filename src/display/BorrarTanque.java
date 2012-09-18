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
public class BorrarTanque extends PageController {

    /**
     * Utilizado como controlador de página para la acción de borrar tanque.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    TanqueModule module = (TanqueModule) context.getBean("tanqueModule");
    try {
      String id = request.getParameter("id");
      int idTanque = Integer.parseInt(id);
      module.eliminar(idTanque);
      response.sendRedirect("listaTanques");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}
