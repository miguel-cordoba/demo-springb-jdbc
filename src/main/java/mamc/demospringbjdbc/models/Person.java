package mamc.demospringbjdbc.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize(using = PersonDeserializer.class)
@JsonSerialize(using = PersonSerializer.class)
public class Person {


    private Long id;
    private String name;
    private String surname;
    private String email;


    public Person(String name, String surname, String email){
        this.setName(name);
        this.setSurname(surname);
        this.setEmail(email);
    }
    public Person(String id, String name, String surname, String email){
        this.setId(Long.getLong(id));
        this.setName(name);
        this.setSurname(surname);
        this.setEmail(email);
    }
    public Person(){
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() { return id;}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSurname() { return surname;}
    public void setSurname(String surname) { this.surname = surname;}


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }



}

