package data;

import java.util.*;
import javax.sql.*;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class ValvulaGateway extends TableGateway {

  private final static String findStatement = "SELECT * FROM valvula WHERE id = ?";

    /**
     * Utilizada para buscar una válvula en específico
     * @param id
     * @return Retorna una válvula en específico
     */
    public Map<String, Object> find(String id) {
    List valvulas = jdbcTemplate.queryForList(findStatement,id);
    return (Map<String, Object>)valvulas.get(0);
  }

  private final static String findAllStatement = "SELECT * FROM valvula";
    /**
     * Utilizada para buscar todas las válvulas
     * @return Retorna un listado con todas las válvulas
     */
    public List<Map<String, Object>> findAll() {
    return jdbcTemplate.queryForList(findAllStatement);
  }

  private static final String insertStatement = "INSERT INTO valvula VALUES (?,?,?,?,?,?,?,?,?)"; 
    /**
     * Utilizada para insertar una nueva válvula
     * @param marca
     * @param diametro
     * @param tipo
     * @param numeroSerie
     * @param presionMaxima
     * @param fechaInstalacion
     * @param fechaUltimaInspeccion
     * @param estado
     * @return Retorna el id de la válvula insertada.
     */
    public int insert(String marca, String diametro, String tipo, String numeroSerie, String presionMaxima, String fechaInstalacion, String fechaUltimaInspeccion, String estado) {
    Random generator = new Random();
    int id = generator.nextInt();
	if (id < 0) id = id * -1;
      jdbcTemplate.update(insertStatement,id, marca, diametro, tipo, numeroSerie, presionMaxima, fechaInstalacion, fechaUltimaInspeccion,estado);
    return id;
  }
  
  private static final String updateStatement = "UPDATE valvula SET marca = ?, diametro = ?, tipo = ?, "+ "numeroSerie = ?, presionMaxima = ?, fechaInstalacion = ?, fechaUltimaInspeccion = ? , estado  = ? WHERE id = ?";
    /**
     * Utilizada para actualizar una válvula
     * @param id
     * @param marca
     * @param diametro
     * @param tipo
     * @param numeroSerie
     * @param presionMaxima
     * @param fechaInstalacion
     * @param fechaUltimaInspeccion
     * @param estado
     */
    public void update(int id, String marca, String diametro, String tipo, String numeroSerie, String presionMaxima, String fechaInstalacion, String fechaUltimaInspeccion, String estado) {
      jdbcTemplate.update(updateStatement, marca, diametro, tipo, numeroSerie, presionMaxima, fechaInstalacion, fechaUltimaInspeccion, estado, id);
  }

  private static final String deleteStatement = "DELETE FROM valvula "+ "WHERE id = ?";
    /**
     * Utilizada para eliminar una válvula
     * @param id
     */
    public void delete(int id) {
      jdbcTemplate.update(deleteStatement,id);
  }
}
