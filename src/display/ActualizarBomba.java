package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.BombaModule;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class ActualizarBomba extends PageController {

    /**
     * Utilizado como controlador de página para la acción de actualizar una bomba.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    BombaModule module = (BombaModule) context.getBean("bombaModule");
    try {
      String id = request.getParameter("id");
      int idBomba = Integer.parseInt(id);	  
	  String marca = request.getParameter("marca");
      String modelo = request.getParameter("modelo");
      String capacidad = request.getParameter("capacidad");
      String fechaInstalacion = request.getParameter("fechaInstalacion");
      String fechaUltimoMantenimiento = request.getParameter("fechaUltimoMantenimiento");
	  String estado = request.getParameter("estado");
	  String idPozo = request.getParameter("idPozo");
	  
      module.actualizar(idBomba,marca,modelo,capacidad,fechaInstalacion,fechaUltimoMantenimiento,estado,idPozo);
      response.sendRedirect("listaBombas");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}
