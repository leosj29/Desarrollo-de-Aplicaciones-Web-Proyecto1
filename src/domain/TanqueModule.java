package domain;

import data.TableGateway;
import data.TanqueGateway;

import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class TanqueModule {

  private TanqueGateway gateway;

    /**
     * Utilizada para establecer un gateway a la capa de datos
     * @param gateway
     */
    public void setGateway(TableGateway gateway) {
    this.gateway = (TanqueGateway)gateway;
  }

    /**
     * Utilizada para agregar un nuevo tanque, para ello este método utiliza la capa de datos(gateway)
     * @param capacidad
     * @param material
     * @param tipo
     * @param fechaInstalacion
     * @param fechaUltimaInspeccion
     * @param estado
     * @throws Exception
     */
    public void agregar(String capacidad, String material, String tipo, String fechaInstalacion, String fechaUltimaInspeccion, String estado) throws Exception {
	gateway.insert(capacidad, material, tipo, fechaInstalacion, fechaUltimaInspeccion,estado);
  }

    /**
     * Utilizada para actualizar un tanque, para ello este método utiliza la capa de datos(gateway)
     * @param id
     * @param capacidad
     * @param material
     * @param tipo
     * @param fechaInstalacion
     * @param fechaUltimaInspeccion
     * @param estado
     * @throws Exception
     */
    public void actualizar(int id, String capacidad, String material, String tipo, String fechaInstalacion, String fechaUltimaInspeccion, String estado) throws Exception {
    if (id <= 0)
      throw new Exception("Identificador de tanque incorrecto");
	else
		gateway.update(id, capacidad, material,  tipo, fechaInstalacion, fechaUltimaInspeccion, estado);
  }

    /**
     * Utilizada para eliminar un tanque, para ello este método utiliza la capa de datos(gateway)
     * @param id
     * @throws Exception
     */
    public void eliminar(int id) throws Exception {
    if (id <= 0)
      throw new Exception("Identificador de tanque incorrecto");   
    gateway.delete(id);
  }

    /**
     * Utilizada para buscar un tanque en específico, para ello este método utiliza la capa de datos(gateway)
     * @param id
     * @return Retorna un tanque en específico
     * @throws Exception
     */
    public Map<String,Object> buscar(int id) throws Exception {
    if (id <= 0)
      throw new Exception("Identificador de tanque incorrecto");
    Map<String,Object> tanque = gateway.find(id+"");
    return tanque;
  }

    /**
     * Utilizada para listar todos los tanques, para ello este método utiliza la capa de datos(gateway)
     * @return Retorna un listado con todos los tanques
     * @throws Exception
     */
    public List<Map<String,Object>> listado() throws Exception {
    List<Map<String,Object>> tanques = gateway.findAll();
    return tanques;
  }
}
