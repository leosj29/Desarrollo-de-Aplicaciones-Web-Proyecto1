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
public class ListaTanques extends PageController {

    /**
     * Utilizado como controlador de página para la acción de listar tanques.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    TanqueModule module = (TanqueModule) context.getBean("tanqueModule");
    try {
      List data = module.listado();
      request.setAttribute("tanques",data);
      forward("/listaTanques.jsp",request,response);
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}
