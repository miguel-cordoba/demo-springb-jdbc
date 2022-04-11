package mamc.demospringbjdbc.models;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class PersonSerializer extends JsonSerializer{

    @Override
    public void serialize(Object p, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {


    }

}
