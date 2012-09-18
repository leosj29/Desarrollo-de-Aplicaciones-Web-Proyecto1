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
public class BorrarMedidor extends PageController {

    /**
     * Utilizado como controlador de página para la acción de borrar medidores.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    MedidorModule module = (MedidorModule) context.getBean("medidorModule");
    try {
      String id = request.getParameter("id");
      int idMedidor = Integer.parseInt(id);
      module.eliminar(idMedidor);
      response.sendRedirect("listaMedidores");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}
