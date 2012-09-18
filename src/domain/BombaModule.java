package domain;

import data.TableGateway;
import data.BombaGateway;

import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class BombaModule {

  private BombaGateway gateway;

    /**
     * Utilizada para establecer un gateway a la capa de datos
     * @param gateway
     */
    public void setGateway(TableGateway gateway) {
    this.gateway = (BombaGateway)gateway;
  }

    /**
     * Utilizada para agregar una nueva bomba, para ello este método utiliza la capa de datos(gateway)
     * @param marca
     * @param modelo
     * @param capacidad
     * @param fechaInstalacion
     * @param fechaUltimoMantenimiento
     * @param estado
     * @param idPozo
     * @throws Exception
     */
    public void agregar(String marca, String modelo, String capacidad, String fechaInstalacion, String fechaUltimoMantenimiento, String estado, String idPozo) throws Exception {
	gateway.insert(marca, modelo, capacidad, fechaInstalacion, fechaUltimoMantenimiento, estado, idPozo);
  }

    /**
     * Utilizada para actualizar una bomba, para ello este método utiliza la capa de datos(gateway)
     * @param id
     * @param marca
     * @param modelo
     * @param capacidad
     * @param fechaInstalacion
     * @param fechaUltimoMantenimiento
     * @param estado
     * @param idPozo
     * @throws Exception
     */
    public void actualizar(int id, String marca, String modelo, String capacidad, String fechaInstalacion, String fechaUltimoMantenimiento, String estado, String idPozo) throws Exception {
    if (id <= 0)
      throw new Exception("Identificador de bomba incorrecto");
	else
		gateway.update(id, marca, modelo, capacidad, fechaInstalacion, fechaUltimoMantenimiento, estado, idPozo);
  }

    /**
     *  Utilizada para eliminar una bomba, para ello este método utiliza la capa de datos(gateway)
     * @param id
     * @throws Exception
     */
    public void eliminar(int id) throws Exception {
    if (id <= 0)
      throw new Exception("Identificador de bomba incorrecto");   
    gateway.delete(id);
  }

    /**
     * Utilizada para buscar una bomba en específico, para ello este método utiliza la capa de datos(gateway)
     * @param id
     * @return Retorna una bomba en específico
     * @throws Exception
     */
    public Map<String,Object> buscar(int id) throws Exception {
    if (id <= 0)
      throw new Exception("Identificador de bomba incorrecto");
    Map<String,Object> bomba = gateway.find(id+"");
    return bomba;
  }

    /**
     * Utilizada para listar todas las bombas, para ello este método utiliza la capa de datos(gateway)
     * @return Retorna un listado con todas las bombas
     * @throws Exception
     */
    public List<Map<String,Object>> listado() throws Exception {
    List<Map<String,Object>> bombas = gateway.findAll();
    return bombas;
  }
  
    /**
     * Utilizada para listar todas las bombas dependiendo el id de pozo, para ello este método utiliza la capa de datos(gateway)
     * @param idPozo
     * @return Retorna un listado con las bombas dependiendo el id del pozo
     * @throws Exception
     */
    public List<Map<String,Object>> listadoPorPozo(String idPozo) throws Exception {
    List<Map<String,Object>> bombas = gateway.findWithPozoId(idPozo);
    return bombas;
  }
}
