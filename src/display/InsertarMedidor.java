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
public class InsertarMedidor extends PageController {

    /**
     * Utilizado como controlador de página para la acción de insertar medidores.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    MedidorModule module = (MedidorModule) context.getBean("medidorModule");
    try {
      String material = request.getParameter("material");
      String marca = request.getParameter("marca");
      String tipo = request.getParameter("tipo");
      String diametro = request.getParameter("diametro");
      String presionTrabajo = request.getParameter("presionTrabajo");
	  String fechaInstalacion = request.getParameter("fechaInstalacion");
	  String fechaUltimaInspeccion = request.getParameter("fechaUltimaInspeccion");
	  String estado = request.getParameter("estado");
	  
	  module.agregar(material, marca, tipo, diametro, presionTrabajo, fechaInstalacion, fechaUltimaInspeccion, estado);
	  
      response.sendRedirect("listaMedidores");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}
