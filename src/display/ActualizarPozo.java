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
public class ActualizarPozo extends PageController {

    /**
     * Utilizado como controlador de página para la acción de actualizar un pozo.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    PozoModule module = (PozoModule) context.getBean("pozoModule");
    try {
      String id = request.getParameter("id");
      int idPozo = Integer.parseInt(id);
      String profundidad = request.getParameter("profundidad");
      String tipoRevestimiento = request.getParameter("tipoRevestimiento");
      String diametro = request.getParameter("diametro");
      String capacidadMaximaEpocaSeca = request.getParameter("capacidadMaximaEpocaSeca");
      String capacidadMaximaEpocaLLuviosa = request.getParameter("capacidadMaximaEpocaLLuviosa");	  
	  
      module.actualizar(idPozo,profundidad,tipoRevestimiento,diametro,capacidadMaximaEpocaSeca,capacidadMaximaEpocaLLuviosa);
      response.sendRedirect("listaPozos");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}
