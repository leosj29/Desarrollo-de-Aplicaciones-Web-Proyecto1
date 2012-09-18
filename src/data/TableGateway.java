package data;

import java.util.*;
import javax.sql.*;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Karla Salas y Leonardo Sanchez
 */
public abstract class TableGateway {

    /**
     *
     */
    protected JdbcTemplate jdbcTemplate;

    /**
     *
     * @param dataSource
     */
    public void setDataSource(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }
}
