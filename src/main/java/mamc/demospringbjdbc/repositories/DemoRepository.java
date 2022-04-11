package mamc.demospringbjdbc.repositories;

import mamc.demospringbjdbc.models.Person;

import java.util.List;

public interface DemoRepository {

    int save(Person person );
    int update(Person person );
    Person findById(Long id);
    Person findByName(String name);
    int deleteById(Long id);
    List<Person> findAll();

    int deleteAll();
}
