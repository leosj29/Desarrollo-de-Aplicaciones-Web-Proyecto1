package domain;

import data.TableGateway;
import data.PozoGateway;

import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class PozoModule {

  private PozoGateway gateway;

    /**
     * Utilizada para establecer un gateway a la capa de datos
     * @param gateway
     */
    public void setGateway(TableGateway gateway) {
    this.gateway = (PozoGateway)gateway;
  }

    /**
     * Utilizada para agregar un nuevo pozo, para ello este método utiliza la capa de datos(gateway)
     * @param profundidad
     * @param tipoRevestimiento
     * @param diametro
     * @param capacidadMaximaEpocaSeca
     * @param capacidadMaximaEpocaLLuviosa
     * @throws Exception
     */
    public void agregar(String profundidad, String tipoRevestimiento, String diametro, String capacidadMaximaEpocaSeca, String capacidadMaximaEpocaLLuviosa) throws Exception {
      gateway.insert(profundidad, tipoRevestimiento, diametro, capacidadMaximaEpocaSeca, capacidadMaximaEpocaLLuviosa);
  }

    /**
     * Utilizada para actualizar un pozo, para ello este método utiliza la capa de datos(gateway)
     * @param id
     * @param profundidad
     * @param tipoRevestimiento
     * @param diametro
     * @param capacidadMaximaEpocaSeca
     * @param capacidadMaximaEpocaLLuviosa
     * @throws Exception
     */
    public void actualizar(int id,String profundidad, String tipoRevestimiento, String diametro, String capacidadMaximaEpocaSeca, String capacidadMaximaEpocaLLuviosa) throws Exception {
      gateway.update(id, profundidad, tipoRevestimiento, diametro, capacidadMaximaEpocaSeca, capacidadMaximaEpocaLLuviosa);
  }

    /**
     *  Utilizada para eliminar un pozo, para ello este método utiliza la capa de datos(gateway)
     * @param id
     * @throws Exception
     */
    public void eliminar(int id) throws Exception {
    if (id <= 0)
      throw new Exception("Identificador de pozo incorrecto");   
    gateway.delete(id);
  }

    /**
     * Utilizada para buscar un pozo en específico, para ello este método utiliza la capa de datos(gateway)
     * @param id
     * @return Retorna un pozo en específico
     * @throws Exception
     */
    public Map<String,Object> buscar(int id) throws Exception {
    if (id <= 0)
      throw new Exception("Identificador de pozo incorrecto");
    Map<String,Object> pozo = gateway.find(id+"");
    return pozo;
  }

    /**
     * Utilizada para listar todos los pozos, para ello este método utiliza la capa de datos(gateway)
     * @return Retorna un listado con todos los pozos
     * @throws Exception
     */
    public List<Map<String,Object>> listado() throws Exception {
    List<Map<String,Object>> pozos = gateway.findAll();
    return pozos;
  }
}
