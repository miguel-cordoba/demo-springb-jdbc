package mamc.demospringbjdbc.models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person p = new Person();
        p.setId(rs.getLong("id"));
        p.setName(rs.getString("name"));
        p.setSurname(rs.getString("surname"));
        p.setEmail(rs.getString("email"));
        return p;

    }
}
