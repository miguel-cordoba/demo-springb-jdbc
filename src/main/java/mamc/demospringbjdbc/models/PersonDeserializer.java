package mamc.demospringbjdbc.models;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;

public class PersonDeserializer extends JsonDeserializer<Person> {

    @Override
    public Person deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String name = node.get("name").asText();
        String surname = node.get("surname").asText();
        String email = node.get("email").asText();
        return new Person(name, surname, email);
    }
}
