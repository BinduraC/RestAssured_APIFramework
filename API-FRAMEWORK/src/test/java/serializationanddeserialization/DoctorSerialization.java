package serializationanddeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.POJOclasses.Doctor;
import com.POJOclasses.Spouse;


public class DoctorSerialization {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Long[] doctorPhNo ={9487563625L,9487563625L, 9487533625L};
		Long[] spousePhNo ={8948753336L,8911753336L};
		Spouse doctorSpouse = new Spouse("kiran", "kiran@gmail.com", spousePhNo);
		
		Doctor docObj = new Doctor("keerthy", 1234, "doc@gmail.com", doctorPhNo, doctorSpouse);
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(new File("./doctor.json"), docObj);
		}

}
