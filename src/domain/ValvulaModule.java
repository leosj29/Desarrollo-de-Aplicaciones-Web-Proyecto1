package domain;

import data.TableGateway;
import data.ValvulaGateway;

import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class ValvulaModule {

  private ValvulaGateway gateway;

    /**
     * Utilizada para establecer un gateway a la capa de datos
     * @param gateway
     */
    public void setGateway(TableGateway gateway) {
    this.gateway = (ValvulaGateway)gateway;
  }

    /**
     * Utilizada para agregar una nueva válvula, para ello este método utiliza la capa de datos(gateway)
     * @param marca
     * @param diametro
     * @param tipo
     * @param numeroSerie
     * @param presionMaxima
     * @param fechaInstalacion
     * @param fechaUltimaInspeccion
     * @param estado
     * @throws Exception
     */
    public void agregar(String marca, String diametro, String tipo, String numeroSerie, String presionMaxima, String fechaInstalacion, String fechaUltimaInspeccion, String estado) throws Exception {
	gateway.insert(marca, diametro, tipo, numeroSerie, presionMaxima, fechaInstalacion, fechaUltimaInspeccion,estado);
  }

    /**
     * Utilizada para actualizar una válvula, para ello este método utiliza la capa de datos(gateway)
     * @param id
     * @param marca
     * @param diametro
     * @param tipo
     * @param numeroSerie
     * @param presionMaxima
     * @param fechaInstalacion
     * @param fechaUltimaInspeccion
     * @param estado
     * @throws Exception
     */
    public void actualizar(int id, String marca, String diametro, String tipo, String numeroSerie, String presionMaxima, String fechaInstalacion, String fechaUltimaInspeccion, String estado) throws Exception {
    if (id <= 0)
      throw new Exception("Identificador de valvula incorrecto");
	else
		gateway.update(id, marca, diametro, tipo, numeroSerie, presionMaxima, fechaInstalacion, fechaUltimaInspeccion, estado);
  }

    /**
     * Utilizada para eliminar una válvula, para ello este método utiliza la capa de datos(gateway)
     * @param id
     * @throws Exception
     */
    public void eliminar(int id) throws Exception {
    if (id <= 0)
      throw new Exception("Identificador de valvula incorrecto");   
    gateway.delete(id);
  }

    /**
     * Utilizada para buscar una válvula en específico, para ello este método utiliza la capa de datos(gateway)
     * @param id
     * @return Retorna una válvula en específico
     * @throws Exception
     */
    public Map<String,Object> buscar(int id) throws Exception {
    if (id <= 0)
      throw new Exception("Identificador de valvula incorrecto");
    Map<String,Object> valvula = gateway.find(id+"");
    return valvula;
  }

    /**
     * Utilizada para listar todas las válvulas, para ello este método utiliza la capa de datos(gateway)
     * @return Retorna un listado con todas las válvulas
     * @throws Exception
     */
    public List<Map<String,Object>> listado() throws Exception {
    List<Map<String,Object>> valvulas = gateway.findAll();
    return valvulas;
  }
}
