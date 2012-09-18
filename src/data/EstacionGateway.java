package data;

import java.util.*;
import javax.sql.*;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public class EstacionGateway extends TableGateway {

  private final static String findStatement = "SELECT * FROM estacionebombeo WHERE id = ?";

    /**
     * Utilizada para buscar una estación en específico
     * @param id
     * @return Retorna una estación en específico
     */
    public Map<String, Object> find(String id) {
    List estaciones = jdbcTemplate.queryForList(findStatement,id);
    return (Map<String, Object>)estaciones.get(0);
  }

  private final static String findAllStatement = "SELECT * FROM estacionebombeo";
    /**
     * Utilizada para buscar todas las estaciones
     * @return Retorna un listado con todas las estaciones
     */
    public List<Map<String, Object>> findAll() {
    return jdbcTemplate.queryForList(findAllStatement);
  }

  private static final String insertStatement = "INSERT INTO estacionebombeo VALUES (?,?,?,?,?,?,?,?)"; 
    /**
     * Utilizada para insertar una nueva estación
     * @param presionEntrada
     * @param presionSalida
     * @param tipo
     * @param capacidadMaxima
     * @param cantidadBombas
     * @param encargadoEstacion
     * @param telefono
     * @return Retorna el id de la estación insertada.
     */
    public int insert(String presionEntrada, String presionSalida, String tipo, String capacidadMaxima, String cantidadBombas, String encargadoEstacion, String telefono) {
    Random generator = new Random();
    int id = generator.nextInt();
	if (id < 0) id = id * -1;
      jdbcTemplate.update(insertStatement,id, presionEntrada, presionSalida, tipo, capacidadMaxima, cantidadBombas, encargadoEstacion, telefono);
    return id;
  }
  
  private static final String updateStatement = "UPDATE estacionebombeo SET presionEntrada = ?, presionSalida = ?, tipo = ?, "+ "capacidadMaxima = ?, cantidadBombas = ?, encargadoEstacion = ?, telefono = ? WHERE id = ?";
    /**
     * Utilizada para actualizar una estación
     * @param id
     * @param presionEntrada
     * @param presionSalida
     * @param tipo
     * @param capacidadMaxima
     * @param cantidadBombas
     * @param encargadoEstacion
     * @param telefono
     */
    public void update(int id, String presionEntrada, String presionSalida, String tipo, String capacidadMaxima, String cantidadBombas, String encargadoEstacion, String telefono) {
      jdbcTemplate.update(updateStatement, presionEntrada, presionSalida, tipo, capacidadMaxima, cantidadBombas, encargadoEstacion, telefono, id);
  }

  private static final String deleteStatement = "DELETE FROM estacionebombeo "+ "WHERE id = ?";
    /**
     * Utilizada para eliminar una estación
     * @param id
     */
    public void delete(int id) {
      jdbcTemplate.update(deleteStatement,id);
  }
}
