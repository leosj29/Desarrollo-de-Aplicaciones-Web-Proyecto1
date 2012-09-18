package data;

import java.util.*;
import javax.sql.*;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class PozoGateway extends TableGateway {

  private final static String findStatement = "SELECT * FROM pozo "+ "WHERE id = ?";

    /**
     * Utilizada para buscar un pozo en específico
     * @param id
     * @return Retorna un pozo en específico
     */
    public Map<String, Object> find(String id) {
    List pozos = jdbcTemplate.queryForList(findStatement,id);
    return (Map<String, Object>)pozos.get(0);
  }

  private final static String findAllStatement = "SELECT * FROM pozo ";

    /**
     * Utilizada para buscar todos los pozos
     * @return Retorna un listado con todos los pozos
     */
    public List<Map<String, Object>> findAll() {
    return jdbcTemplate.queryForList(findAllStatement);
  }

  private static final String insertStatement = "INSERT INTO pozo VALUES (?,?,?,?,?,?)";

    /**
     * Utilizada para insertar un nuevo pozo
     * @param profundidad
     * @param tipoRevestimiento
     * @param diametro
     * @param capacidadMaximaEpocaSeca
     * @param capacidadMaximaEpocaLLuviosa
     * @return Retorna el id del pozo insertado.
     */
    public int insert(String profundidad,String tipoRevestimiento,String diametro,String capacidadMaximaEpocaSeca,String capacidadMaximaEpocaLLuviosa) {
    Random generator = new Random();
    int id = generator.nextInt();
	if (id < 0) id = id * -1;
      jdbcTemplate.update(insertStatement,id,profundidad,tipoRevestimiento,diametro,capacidadMaximaEpocaSeca,capacidadMaximaEpocaLLuviosa);
    return id;
  }

  private static final String updateStatement = "UPDATE pozo SET profundidad = ?, tipoRevestimiento = ?, diametro = ?, "+ "capacidadMaximaEpocaSeca = ?, capacidadMaximaEpocaLLuviosa = ? WHERE id = ?";

    /**
     * Utilizada para actualizar un pozo
     * @param id
     * @param profundidad
     * @param tipoRevestimiento
     * @param diametro
     * @param capacidadMaximaEpocaSeca
     * @param capacidadMaximaEpocaLLuviosa
     */
    public void update(int id,String profundidad,String tipoRevestimiento,String diametro,String capacidadMaximaEpocaSeca,String capacidadMaximaEpocaLLuviosa) {
      jdbcTemplate.update(updateStatement,profundidad,tipoRevestimiento,diametro,capacidadMaximaEpocaSeca,capacidadMaximaEpocaLLuviosa,id);
  }

  private static final String deleteStatement = "DELETE FROM pozo "+ "WHERE id = ?";

    /**
     *  Utilizada para eliminar un pozo
     * @param id
     */
    public void delete(int id) {
      jdbcTemplate.update(deleteStatement,id);
  }
}
