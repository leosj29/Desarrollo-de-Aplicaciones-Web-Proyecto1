package data;

import java.util.*;
import javax.sql.*;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class TanqueGateway extends TableGateway {

  private final static String findStatement = "SELECT * FROM tanquealmacenamiento WHERE id = ?";

    /**
     * Utilizada para buscar un tanque en específico
     * @param id
     * @return Retorna un tanque en específico
     */
    public Map<String, Object> find(String id) {
    List tanques = jdbcTemplate.queryForList(findStatement,id);
    return (Map<String, Object>)tanques.get(0);
  }

  private final static String findAllStatement = "SELECT * FROM tanquealmacenamiento";
    /**
     * Utilizada para buscar todos los tanques
     * @return Retorna un listado con todos los tanques
     */
    public List<Map<String, Object>> findAll() {
    return jdbcTemplate.queryForList(findAllStatement);
  }

  private static final String insertStatement = "INSERT INTO tanquealmacenamiento VALUES (?,?,?,?,?,?,?)"; 
    /**
     * Utilizada para insertar un nuevo tanque
     * @param capacidad
     * @param material
     * @param tipo
     * @param fechaInstalacion
     * @param fechaUltimaInspeccion
     * @param estado
     * @return Retorna el id del tanque insertado.
     */
    public int insert(String capacidad, String material, String tipo, String fechaInstalacion, String fechaUltimaInspeccion, String estado) {
    Random generator = new Random();
    int id = generator.nextInt();
	if (id < 0) id = id * -1;
      jdbcTemplate.update(insertStatement,id, capacidad, material, tipo, fechaInstalacion, fechaUltimaInspeccion,estado);
    return id;
  }
  
  private static final String updateStatement = "UPDATE tanquealmacenamiento SET capacidad = ?, material = ?, tipo = ?, "+ " fechaInstalacion = ?, fechaUltimaInspeccion = ? , estado  = ? WHERE id = ?";
    /**
     * Utilizada para actualizar un tanque
     * @param id
     * @param capacidad
     * @param material
     * @param tipo
     * @param fechaInstalacion
     * @param fechaUltimaInspeccion
     * @param estado
     */
    public void update(int id, String capacidad, String material, String tipo, String fechaInstalacion, String fechaUltimaInspeccion, String estado) {
      jdbcTemplate.update(updateStatement, capacidad, material,  tipo, fechaInstalacion, fechaUltimaInspeccion, estado, id);
  }

  private static final String deleteStatement = "DELETE FROM tanquealmacenamiento "+ "WHERE id = ?";
    /**
     * Utilizada para eliminar un tanque
     * @param id
     */
    public void delete(int id) {
      jdbcTemplate.update(deleteStatement,id);
  }
}
