package mamc.demospringbjdbc.controller;


import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import mamc.demospringbjdbc.models.Person;
import mamc.demospringbjdbc.repositories.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api", produces = "application/json")
public class DemoSpringBJdbcController {

    @Autowired
    PersonsRepository repo;

    static final String INPUT_JSON_PATH = "src/main/resources/input.json";

    @GetMapping(value = "ping")
    public String ping() {
        return "pong";
    }
    // TODO: change repo for methods
    @PostMapping("addPerson")
    public ResponseEntity updatePersonInfo(@RequestBody Person person){
        return new ResponseEntity(repo.save(person)+" successfully added ", HttpStatus.OK);
     }

    @GetMapping("addAllPeople")
    public ResponseEntity addAllPersons() throws IOException {
        return new ResponseEntity(repo.saveAll(getPeople())+ "all dem people added", HttpStatus.OK);
    }

    @PostMapping("addPersonsBulk")
    public ResponseEntity updatePersonInfo(@RequestBody List<Person> personList){
        repo.saveAll(personList);
        return new ResponseEntity(repo.saveAll(personList)+ "yess", HttpStatus.OK);
    }


    //TODO: fix serializing
    @GetMapping("getAllPersons")
    public ResponseEntity<List<Person>> getAllPersons(){
        List<Person> personList = repo.findAll();
        return new ResponseEntity(repo.findAll().toString(), HttpStatus.OK);
    }

    @GetMapping("getPersonById/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") long id) {
        return new ResponseEntity(repo.findById(id).toString(), HttpStatus.OK);
    }

    @GetMapping("getPersonByName/{name}")
    public ResponseEntity<Person> getPersonByName(@PathVariable("name") String name) {
        return new ResponseEntity(repo.findByName(name).toString(), HttpStatus.OK);
    }

    @GetMapping("deletePerson/{id}")
    public ResponseEntity deletePerson(@PathVariable("id") long id){

        return new ResponseEntity<Person>(HttpStatus.OK);

    }

    @GetMapping("deleteAllPersons")
    public ResponseEntity deleteAllPersons(){
        return new ResponseEntity(HttpStatus.OK);
    }

    public List<Person> getPeople() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(Paths.get(INPUT_JSON_PATH).toFile(), Person[].class));
    }

}
