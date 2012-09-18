package data;

import java.util.*;
import javax.sql.*;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class BombaGateway extends TableGateway {

  private final static String findStatement = "SELECT * FROM bomba WHERE id = ?";

    /**
     * Utilizada para buscar una bomba en específico
     * @param id
     * @return Retorna una bomba en específico
     */
    public Map<String, Object> find(String id) {
    List bombas = jdbcTemplate.queryForList(findStatement,id);
    return (Map<String, Object>)bombas.get(0);
  }

  private final static String findAllStatement = "SELECT * FROM bomba";
    /**
     * Utilizada para buscar todas las bombas
     * @return Retorna un listado con todas las bombas
     */
    public List<Map<String, Object>> findAll() {
    return jdbcTemplate.queryForList(findAllStatement);
  }
  
  private final static String findStatementP =	"SELECT * FROM bomba WHERE idPozo  = ?";
    /**
     * Utilizada para buscar una bomba en específico dependiendo el pozo
     * @param idPozo
     * @return Retorna un listado de bombas dependiendo el id del pozo
     */
    public List<Map<String, Object>> findWithPozoId(String idPozo) {
    return jdbcTemplate.queryForList(findStatementP,idPozo);
  }

  private static final String insertStatement = "INSERT INTO bomba VALUES (?,?,?,?,?,?,?,?)"; 

    /**
     * Utilizada para insertar una nueva bomba
     * @param marca
     * @param modelo
     * @param capacidad
     * @param fechaInstalacion
     * @param fechaUltimoMantenimiento
     * @param estado
     * @param idPozo
     * @return Retorna el id de la bomba insertada.
     */
    public int insert(String marca, String modelo, String capacidad,String fechaInstalacion, String fechaUltimoMantenimiento, String estado, String idPozo) {
    Random generator = new Random();
    int id = generator.nextInt();
	if (id < 0) id = id * -1;
      jdbcTemplate.update(insertStatement,id,marca,modelo,capacidad,fechaInstalacion,fechaUltimoMantenimiento,estado,idPozo);
    return id;
  }

  private static final String updateStatement = "UPDATE bomba SET marca = ?, modelo = ?, capacidad = ?, "+ "fechaInstalacion = ?, fechaUltimoMantenimiento = ?, estado = ?, idPozo = ? WHERE id = ?";

    /**
     * Utilizada para actualizar una bomba
     * @param id
     * @param marca
     * @param modelo
     * @param capacidad
     * @param fechaInstalacion
     * @param fechaUltimoMantenimiento
     * @param estado
     * @param idPozo
     */
    public void update(int id,String marca, String modelo, String capacidad,String fechaInstalacion, String fechaUltimoMantenimiento, String estado, String idPozo) {
      jdbcTemplate.update(updateStatement,marca,modelo,capacidad,fechaInstalacion,fechaUltimoMantenimiento,estado,idPozo,id);
  }

  private static final String deleteStatement = "DELETE FROM bomba "+ "WHERE id = ?";

    /**
     * Utilizada para eliminar una bomba
     * @param id
     */
    public void delete(int id) {
      jdbcTemplate.update(deleteStatement,id);
  }
}
