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
public class BorrarTuberia extends PageController {

    /**
     * Utilizado como controlador de página para la acción de borrar tuberías.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    TuberiaModule module = (TuberiaModule) context.getBean("tuberiaModule");
    try {
      String id = request.getParameter("id");
      int idTuberia = Integer.parseInt(id);
      module.eliminar(idTuberia);
      response.sendRedirect("listaTuberias");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}
