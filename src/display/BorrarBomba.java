package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.BombaModule;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class BorrarBomba extends PageController {

    /**
     * Utilizado como controlador de página para la acción de eliminar bombas.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    BombaModule module = (BombaModule) context.getBean("bombaModule");
    try {
      String id = request.getParameter("id");
      int idBomba = Integer.parseInt(id);
      module.eliminar(idBomba);
      response.sendRedirect("listaBombas");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}
