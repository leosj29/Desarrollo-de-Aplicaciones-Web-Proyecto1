package data;

import java.util.*;
import javax.sql.*;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class MedidorGateway extends TableGateway {

  private final static String findStatement = "SELECT * FROM medidor "+ "WHERE id = ?";
    /**
     * Utilizada para buscar un medidor en específico
     * @param id
     * @return Retorna un medidor en específico
     */
    public Map<String, Object> find(String id) {
    List medidores = jdbcTemplate.queryForList(findStatement,id);
    return (Map<String, Object>)medidores.get(0);
  }

  private final static String findAllStatement = "SELECT * FROM medidor ";
    /**
     * Utilizada para buscar todos los medidores
     * @return Retorna un listado con todos los medidores
     */
    public List<Map<String, Object>> findAll() {
    return jdbcTemplate.queryForList(findAllStatement);
  }

  private static final String insertStatement = "INSERT INTO medidor VALUES (?,?,?,?,?,?,?,?,?)";
    /**
     * Utilizada para insertar un nuevo medidor
     * @param material
     * @param marca
     * @param tipo
     * @param diametro
     * @param presionTrabajo
     * @param fechaInstalacion
     * @param fechaUltimaInspeccion
     * @param estado
     * @return Retorna el id del medidor insertado.
     */
    public int insert(String material, String marca, String tipo, String diametro, String presionTrabajo, String fechaInstalacion, String fechaUltimaInspeccion, String estado) {
    Random generator = new Random();
    int id = generator.nextInt();
	if (id < 0) id = id * -1;
      jdbcTemplate.update(insertStatement, id, material, marca, tipo, diametro, presionTrabajo, fechaInstalacion, fechaUltimaInspeccion, estado);
    return id;
  }
  
  private static final String updateStatement = "UPDATE medidor SET material = ?, marca = ?, tipo = ?, diametro = ?, presionTrabajo = ?, fechaInstalacion = ?, fechaUltimaInspeccion = ?, estado = ? WHERE id = ?";
    /**
     * Utilizada para actualizar un medidor
     * @param id
     * @param material
     * @param marca
     * @param tipo
     * @param diametro
     * @param presionTrabajo
     * @param fechaInstalacion
     * @param fechaUltimaInspeccion
     * @param estado
     */
    public void update(int id, String material, String marca, String tipo, String diametro, String presionTrabajo, String fechaInstalacion, String fechaUltimaInspeccion, String estado) {
      jdbcTemplate.update(updateStatement,material, marca, tipo, diametro, presionTrabajo, fechaInstalacion, fechaUltimaInspeccion, estado, id);
  }

  private static final String deleteStatement = "DELETE FROM medidor "+ "WHERE id = ?";

    /**
     *  Utilizada para eliminar un medidor
     * @param id
     */
    public void delete(int id) {
      jdbcTemplate.update(deleteStatement,id);
  }
  
  private final static String findLecturasMedidorStatement = "SELECT * FROM lecturamedidor WHERE idMedidor = ?";
    /**
     *  Utilizada para listar las lecturas de un medidor
     * @param id
     * @return Listado de lecturas de un medidor
     */
    public List<Map<String, Object>> findLecturasMedidor(String id) {
    return jdbcTemplate.queryForList(findLecturasMedidorStatement,id);
  }
  
  
}
