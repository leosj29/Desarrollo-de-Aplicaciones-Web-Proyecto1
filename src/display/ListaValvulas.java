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
public class ListaValvulas extends PageController {

    /**
     * Utilizado como controlador de página para la acción de listar válvulas.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    ValvulaModule module = (ValvulaModule) context.getBean("valvulaModule");
    try {
      List data = module.listado();
      request.setAttribute("valvulas",data);
      forward("/listaValvulas.jsp",request,response);
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}
