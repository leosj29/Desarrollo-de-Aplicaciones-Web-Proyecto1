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
public class ActualizarValvula extends PageController {

    /**
     * Utilizado como controlador de página para la acción de actualizar una válvula.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
    ValvulaModule module = (ValvulaModule) context.getBean("valvulaModule");
	
    try {
      String id = request.getParameter("id");
      int idValvula = Integer.parseInt(id);	  
	  
	  String marca = request.getParameter("marca");
      String diametro = request.getParameter("diametro");
      String tipo = request.getParameter("tipo");
      String numeroSerie = request.getParameter("numeroSerie");
      String presionMaxima = request.getParameter("presionMaxima");
	  String fechaInstalacion = request.getParameter("fechaInstalacion");
	  String fechaUltimaInspeccion = request.getParameter("fechaUltimaInspeccion");
	  String estado = request.getParameter("estado");
	  
      module.actualizar(idValvula,marca, diametro, tipo, numeroSerie, presionMaxima, fechaInstalacion, fechaUltimaInspeccion, estado);
      response.sendRedirect("listaValvulas");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}
