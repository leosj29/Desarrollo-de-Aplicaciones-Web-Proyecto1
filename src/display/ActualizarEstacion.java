package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.EstacionModule;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class ActualizarEstacion extends PageController {

    /**
     * Utilizado como controlador de página para la acción de actualizar una estación.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    EstacionModule module = (EstacionModule) context.getBean("estacionModule");
    try {
      String id = request.getParameter("id");
      int idEstacion = Integer.parseInt(id);	  
	  String presionEntrada = request.getParameter("presionEntrada");
      String presionSalida = request.getParameter("presionSalida");
      String tipo = request.getParameter("tipo");
      String capacidadMaxima = request.getParameter("capacidadMaxima");
      String cantidadBombas = request.getParameter("cantidadBombas");
	  String encargadoEstacion = request.getParameter("encargadoEstacion");
	  String telefono = request.getParameter("telefono");
	  
      module.actualizar(idEstacion,presionEntrada,presionSalida,tipo,capacidadMaxima,cantidadBombas,encargadoEstacion,telefono);
      response.sendRedirect("listaEstaciones");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}
