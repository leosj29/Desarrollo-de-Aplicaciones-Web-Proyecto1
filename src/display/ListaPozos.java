package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.PozoModule;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class ListaPozos extends PageController {

    /**
     * Utilizado como controlador de página para la acción de listar pozos.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    PozoModule module = (PozoModule) context.getBean("pozoModule");
    try {
      List data = module.listado();
      request.setAttribute("pozos",data);
      forward("/listaPozos.jsp",request,response);
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}
