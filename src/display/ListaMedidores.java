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
public class ListaMedidores extends PageController {

    /**
     * Utilizado como controlador de página para la acción de listar medidores.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    MedidorModule module = (MedidorModule) context.getBean("medidorModule");
    try {
      List data = module.listado();
      request.setAttribute("medidores",data);
      forward("/listaMedidores.jsp",request,response);
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}
