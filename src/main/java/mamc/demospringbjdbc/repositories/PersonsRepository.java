package mamc.demospringbjdbc.repositories;

import mamc.demospringbjdbc.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonsRepository implements DemoRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int save(Person person) {
        return jdbcTemplate.update("INSERT INTO people (name, surname, email) VALUES(?,?,?)",
                new Object[] { person.getName(), person.getSurname(), person.getEmail() });
    }

    public int saveAll(List<Person> persons) {
            for (Person p : persons) {
                save(p);
            }
            return 1;
     }

    @Override
    public int update(Person person) {
        return 0;
    }

    @Override
    public Person findById(Long id) {
        Person person = jdbcTemplate.queryForObject("SELECT * FROM people WHERE id=?",         BeanPropertyRowMapper.newInstance(Person.class), id);
        return person;
    }

    @Override
    public Person findByName(String name) {
        Person person = jdbcTemplate.queryForObject("SELECT * FROM people WHERE name=?",         BeanPropertyRowMapper.newInstance(Person.class), name);
        return person;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public List<Person> findAll() {
        List<Person> personList =  jdbcTemplate.query("SELECT * from people", BeanPropertyRowMapper.newInstance(Person.class));

       return personList;

    }



    @Override
    public int deleteAll() {
        return 0;
    }
}
