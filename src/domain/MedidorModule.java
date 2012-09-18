package domain;

import data.TableGateway;
import data.MedidorGateway;

import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;

/**
 * 
 * @author Karla Salas y Leonardo Sanchez
 */
public class MedidorModule {

  private MedidorGateway gateway;

    /**
     * Utilizada para establecer un gateway a la capa de datos
     * @param gateway
     */
    public void setGateway(TableGateway gateway) {
    this.gateway = (MedidorGateway)gateway;
  }

    /**
     * Utilizada para agregar un nuevo medidor, para ello este método utiliza la capa de datos(gateway)
     * @param material
     * @param marca
     * @param tipo
     * @param diametro
     * @param presionTrabajo
     * @param fechaInstalacion
     * @param fechaUltimaInspeccion
     * @param estado
     * @throws Exception
     */
    public void agregar(String material, String marca, String tipo, String diametro, String presionTrabajo, String fechaInstalacion, String fechaUltimaInspeccion, String estado) throws Exception {
      gateway.insert(material, marca, tipo, diametro, presionTrabajo, fechaInstalacion, fechaUltimaInspeccion, estado);
  }

    /**
     * Utilizada para actualizar un medidor, para ello este método utiliza la capa de datos(gateway)
     * @param id
     * @param material
     * @param marca
     * @param tipo
     * @param diametro
     * @param presionTrabajo
     * @param fechaInstalacion
     * @param fechaUltimaInspeccion
     * @param estado
     * @throws Exception
     */
    public void actualizar(int id, String material, String marca, String tipo, String diametro, String presionTrabajo, String fechaInstalacion, String fechaUltimaInspeccion, String estado) throws Exception {
      gateway.update(id, material, marca, tipo, diametro, presionTrabajo, fechaInstalacion, fechaUltimaInspeccion, estado);
  }

    /**
     * Utilizada para eliminar un medidor, para ello este método utiliza la capa de datos(gateway)
     * @param id
     * @throws Exception
     */
    public void eliminar(int id) throws Exception {
    if (id <= 0)
      throw new Exception("Identificador de medidor incorrecto");   
    gateway.delete(id);
  }

    /**
     * Utilizada para buscar un nuevo medidor en específico, para ello este método utiliza la capa de datos(gateway)
     * @param id
     * @return Retorna un medidor en específico
     * @throws Exception
     */
    public Map<String,Object> buscar(int id) throws Exception {
    if (id <= 0)
      throw new Exception("Identificador de medidor incorrecto");
    Map<String,Object> medidor = gateway.find(id+"");
    return medidor;
  }

    /**
     * Utilizada para listar todos los  medidores, para ello este método utiliza la capa de datos(gateway)
     * @return Retorna un listado con todos los medidores
     * @throws Exception
     */
    public List<Map<String,Object>> listado() throws Exception {
    List<Map<String,Object>> medidores = gateway.findAll();
    return medidores;
  }
  
    /**
     * Utilizada para listar las lecturas de un medidor, para ello este método utiliza la capa de datos(gateway)
     * @param id
     * @return Retorna un listado con las lecturas de un medidor
     * @throws Exception
     */
    public List<Map<String,Object>> listadoLecturasMedidor(int id) throws Exception {
    if (id <= 0)
      throw new Exception("Identificador de medidor incorrecto");
    List<Map<String,Object>> lecturas = gateway.findLecturasMedidor(id+"");
    return lecturas;
  }
}
