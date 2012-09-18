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
public class InsertarEstacion extends PageController {

    /**
     * Utilizado como controlador de página para la acción de insertar estaciones.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    EstacionModule module = (EstacionModule) context.getBean("estacionModule");
    try {
      String presionEntrada = request.getParameter("presionEntrada");
      String presionSalida = request.getParameter("presionSalida");
      String tipo = request.getParameter("tipo");
      String capacidadMaxima = request.getParameter("capacidadMaxima");
      String cantidadBombas = request.getParameter("cantidadBombas");
	  String encargadoEstacion = request.getParameter("encargadoEstacion");
	  String telefono = request.getParameter("telefono");
	  
	  module.agregar(presionEntrada,presionSalida,tipo,capacidadMaxima,cantidadBombas,encargadoEstacion,telefono);
      response.sendRedirect("listaEstaciones");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}
