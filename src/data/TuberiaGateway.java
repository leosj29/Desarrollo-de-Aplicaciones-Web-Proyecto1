package data;

import java.util.*;
import javax.sql.*;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class TuberiaGateway extends TableGateway {

  private final static String findStatement = "SELECT * FROM tuberia WHERE id = ?";

    /**
     * Utilizada para buscar una tubería en específico
     * @param id
     * @return Retorna una tubería en específico
     */
    public Map<String, Object> find(String id) {
    List tuberias = jdbcTemplate.queryForList(findStatement,id);
    return (Map<String, Object>)tuberias.get(0);
  }

  private final static String findAllStatement = "SELECT * FROM tuberia";
    /**
     * Utilizada para buscar todoas las tuberías
     * @return Retorna un listado con todas las tuberías
     */
    public List<Map<String, Object>> findAll() {
    return jdbcTemplate.queryForList(findAllStatement);
  }

  private static final String insertStatement = "INSERT INTO tuberia VALUES (?,?,?,?,?,?,?,?,?)"; 
    /**
     * Utilizada para insertar una nueva tubería
     * @param material
     * @param diametro
     * @param tipo
     * @param largo
     * @param presionMaxima
     * @param fechaInstalacion
     * @param fechaUltimaInspeccion
     * @param estado
     * @return Retorna el id de la tubería insertada.
     */
    public int insert(String material, String diametro, String tipo, String largo, String presionMaxima, String fechaInstalacion, String fechaUltimaInspeccion, String estado) {
    Random generator = new Random();
    int id = generator.nextInt();
	if (id < 0) id = id * -1;
      jdbcTemplate.update(insertStatement,id, material, diametro, tipo, largo, presionMaxima, fechaInstalacion, fechaUltimaInspeccion, estado);
    return id;
  }
  
  private static final String updateStatement = "UPDATE tuberia SET material = ?, diametro = ?, tipo = ?, "+ "largo = ?, presionMaxima = ?, fechaInstalacion = ?, fechaUltimaInspeccion = ? , estado  = ? WHERE id = ?";
    /**
     * Utilizada para actualizar una tubería
     * @param id
     * @param material
     * @param diametro
     * @param tipo
     * @param largo
     * @param presionMaxima
     * @param fechaInstalacion
     * @param fechaUltimaInspeccion
     * @param estado
     */
    public void update(int id, String material, String diametro, String tipo, String largo, String presionMaxima, String fechaInstalacion, String fechaUltimaInspeccion, String estado) {
      jdbcTemplate.update(updateStatement, material, diametro, tipo, largo, presionMaxima, fechaInstalacion, fechaUltimaInspeccion, estado, id);
  }

  private static final String deleteStatement = "DELETE FROM tuberia "+ "WHERE id = ?";
    /**
     * Utilizada para eliminar una tubería
     * @param id
     */
    public void delete(int id) {
      jdbcTemplate.update(deleteStatement,id);
  }
}
