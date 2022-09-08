package serializationanddeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.POJOclasses.Doctor;
import com.POJOclasses.Spouse;


public class DoctorDeseriaization {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Doctor doc = objectMapper.readValue(new File("./doctor.json"), Doctor.class);

		System.out.println(doc.getDoctorID());
		System.out.println(doc.getDoctorName());
		System.out.println(doc.getDoctorEmail());
		
		Long[] doctorPhNos = doc.getDoctorPhNo();
		for(Long phNo :  doctorPhNos) {
			System.out.println(phNo);
		}
		
		Spouse doctorSpouseDetails = doc.getDoctorSpouseDetails();
		System.out.println(doctorSpouseDetails.getSpouseName());
		System.out.println(doctorSpouseDetails.getSpouseEmail());
		Long[] doctorSpousePhNos = doctorSpouseDetails.getSpousePhNo();
		for(Long docSpousephNo :  doctorSpousePhNos) {
			System.out.println(docSpousephNo);
		}
		
	}

}
