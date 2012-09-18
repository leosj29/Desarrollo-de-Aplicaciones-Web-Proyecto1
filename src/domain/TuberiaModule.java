package domain;

import data.TableGateway;
import data.TuberiaGateway;

import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class TuberiaModule {

  private TuberiaGateway gateway;

    /**
     * Utilizada para establecer un gateway a la capa de datos
     * @param gateway
     */
    public void setGateway(TableGateway gateway) {
    this.gateway = (TuberiaGateway)gateway;
  }

    /**
     * Utilizada para agregar una nueva tubería medidor, para ello este método utiliza la capa de datos(gateway)
     * @param material
     * @param diametro
     * @param tipo
     * @param largo
     * @param presionMaxima
     * @param fechaInstalacion
     * @param fechaUltimaInspeccion
     * @param estado
     * @throws Exception
     */
    public void agregar(String material, String diametro, String tipo, String largo, String presionMaxima, String fechaInstalacion, String fechaUltimaInspeccion, String estado) throws Exception {
	gateway.insert(material, diametro, tipo, largo, presionMaxima, fechaInstalacion, fechaUltimaInspeccion, estado);
  }

    /**
     * Utilizada para actualizar una tubería medidor, para ello este método utiliza la capa de datos(gateway)
     * @param id
     * @param material
     * @param diametro
     * @param tipo
     * @param largo
     * @param presionMaxima
     * @param fechaInstalacion
     * @param fechaUltimaInspeccion
     * @param estado
     * @throws Exception
     */
    public void actualizar(int id, String material, String diametro, String tipo, String largo, String presionMaxima, String fechaInstalacion, String fechaUltimaInspeccion, String estado) throws Exception {
    if (id <= 0)
      throw new Exception("Identificador de tuberia incorrecto");
	else
		gateway.update(id, material, diametro, tipo, largo, presionMaxima, fechaInstalacion, fechaUltimaInspeccion, estado);
  }

    /**
     * Utilizada para eliminar una tubería medidor, para ello este método utiliza la capa de datos(gateway)
     * @param id
     * @throws Exception
     */
    public void eliminar(int id) throws Exception {
    if (id <= 0)
      throw new Exception("Identificador de tuberia incorrecto");   
    gateway.delete(id);
  }

    /**
     * Utilizada para buscar una tubería en específico, para ello este método utiliza la capa de datos(gateway)
     * @param id
     * @return Retorna una tubería en específico
     * @throws Exception
     */
    public Map<String,Object> buscar(int id) throws Exception {
    if (id <= 0)
      throw new Exception("Identificador de tuberia incorrecto");
    Map<String,Object> tuberia = gateway.find(id+"");
    return tuberia;
  }

    /**
     * Utilizada para listar todas las tuberías, para ello este método utiliza la capa de datos(gateway)
     * @return Retorna un listado con todas las tuberías
     * @throws Exception
     */
    public List<Map<String,Object>> listado() throws Exception {
    List<Map<String,Object>> tuberias = gateway.findAll();
    return tuberias;
  }
}
