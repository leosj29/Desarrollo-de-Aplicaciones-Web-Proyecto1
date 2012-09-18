package domain;

import data.TableGateway;
import data.EstacionGateway;

import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class EstacionModule {

  private EstacionGateway gateway;

    /**
     * Utilizada para establecer un gateway a la capa de datos
     * @param gateway
     */
    public void setGateway(TableGateway gateway) {
    this.gateway = (EstacionGateway)gateway;
  }

    /**
     * Utilizada para agregar una nueva estación, para ello este método utiliza la capa de datos(gateway)
     * @param presionEntrada
     * @param presionSalida
     * @param tipo
     * @param capacidadMaxima
     * @param cantidadBombas
     * @param encargadoEstacion
     * @param telefono
     * @throws Exception
     */
    public void agregar(String presionEntrada, String presionSalida, String tipo, String capacidadMaxima, String cantidadBombas, String encargadoEstacion, String telefono) throws Exception {
	gateway.insert(presionEntrada, presionSalida, tipo, capacidadMaxima, cantidadBombas, encargadoEstacion, telefono);
  }

    /**
     * Utilizada para actualizar una estación, para ello este método utiliza la capa de datos(gateway)
     * @param id
     * @param presionEntrada
     * @param presionSalida
     * @param tipo
     * @param capacidadMaxima
     * @param cantidadBombas
     * @param encargadoEstacion
     * @param telefono
     * @throws Exception
     */
    public void actualizar(int id, String presionEntrada, String presionSalida, String tipo, String capacidadMaxima, String cantidadBombas, String encargadoEstacion, String telefono) throws Exception {
    if (id <= 0)
      throw new Exception("Identificador de estaci�n incorrecto");
	else
		gateway.update(id, presionEntrada, presionSalida, tipo, capacidadMaxima, cantidadBombas, encargadoEstacion, telefono);
  }

    /**
     * Utilizada para eliminar una estación, para ello este método utiliza la capa de datos(gateway)
     * @param id
     * @throws Exception
     */
    public void eliminar(int id) throws Exception {
    if (id <= 0)
      throw new Exception("Identificador de estaci�n incorrecto");   
    gateway.delete(id);
  }

    /**
     * Utilizada para buscar una estación en específico, para ello este método utiliza la capa de datos(gateway)
     * @param id
     * @return Retorna una estación en específico
     * @throws Exception
     */
    public Map<String,Object> buscar(int id) throws Exception {
    if (id <= 0)
      throw new Exception("Identificador de estaci�n incorrecto");
    Map<String,Object> estacion = gateway.find(id+"");
    return estacion;
  }

    /**
     * Utilizada para listar todas las estaciones, para ello este método utiliza la capa de datos(gateway)
     * @return Retorna un listado con todas las estaciones
     * @throws Exception
     */
    public List<Map<String,Object>> listado() throws Exception {
    List<Map<String,Object>> estaciones = gateway.findAll();
    return estaciones;
  }
}
