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
public class ActualizarTuberia extends PageController {

    /**
     * Utilizado como controlador de página para la acción de actualizar una tubería.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    TuberiaModule module = (TuberiaModule) context.getBean("tuberiaModule");
    try {
      String id = request.getParameter("id");
      int idTuberia = Integer.parseInt(id);	  
	  String material = request.getParameter("material");
      String diametro = request.getParameter("diametro");
      String tipo = request.getParameter("tipo");
      String largo = request.getParameter("largo");
      String presionMaxima = request.getParameter("presionMaxima");
	  String fechaInstalacion = request.getParameter("fechaInstalacion");
	  String fechaUltimaInspeccion = request.getParameter("fechaUltimaInspeccion");
	  String estado = request.getParameter("estado");
	  
      module.actualizar(idTuberia,material, diametro, tipo, largo, presionMaxima, fechaInstalacion, fechaUltimaInspeccion, estado);
      response.sendRedirect("listaTuberias");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}
