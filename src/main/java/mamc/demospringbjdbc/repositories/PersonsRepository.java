package mamc.demospringbjdbc.repositories;

import mamc.demospringbjdbc.models.Person;
import mamc.demospringbjdbc.models.PersonMapper;
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
        return jdbcTemplate.update("UPDATE people SET name=?, surname=?, email=?",
                new Object[] { person.getName(), person.getSurname(), person.getEmail() });    }

    @Override
    public Person findById(Long id) {
        Person person = (Person) jdbcTemplate.queryForObject("SELECT * FROM people WHERE id=?",
                new Object[]{id}, new PersonMapper());
        return person;
    }

    @Override
    public Person findByName(String name) {
        Person person = (Person) jdbcTemplate.queryForObject("SELECT * FROM people WHERE name=?",         new Object[]{name}, new PersonMapper());
        return person;
    }

    @Override
    public int deleteById(Long id){
        return jdbcTemplate.update("DELETE * FROM people WHERE id=?");
    }

    @Override
    public List<Person> findAll() {
        List<Person> personList =  jdbcTemplate.query("SELECT * from people", new Object[]{}, new PersonMapper());

       return personList;

    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update("DELETE * FROM people");
    }
}
