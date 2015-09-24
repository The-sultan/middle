package uy.edu.fing.intmidd.pagosacme.lealtad.jms;

import java.io.IOException;

import uy.edu.fing.intmidd.pagosacme.lealtad.domain.DatosLealtad;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DatosLealtadDeserializer extends JsonDeserializer<DatosLealtad> {

	@Override
	public DatosLealtad deserialize(JsonParser parser, DeserializationContext cxt) throws IOException, JsonProcessingException {
		
		return null;
	}

}
