package basic.rest.pojo;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONarraySerialization {
	String allEmployeesJson;

	@Test
	public void createJSONarrayPOJO() throws JsonProcessingException {
		JSONarrayPOJO John = new JSONarrayPOJO();
		John.setFirstName("John");
		John.setAge(28);
		John.setLastName("Cena");
		John.setGender("male");
		John.setMarried(false);
		John.setSalary(123456);

		JSONarrayPOJO dicap = new JSONarrayPOJO();
		dicap.setFirstName("Dicaprio");
		dicap.setAge(35);
		dicap.setLastName("john");
		dicap.setGender("male");
		dicap.setMarried(false);
		dicap.setSalary(123456);

		JSONarrayPOJO Brad = new JSONarrayPOJO();
		Brad.setFirstName("Brad");
		Brad.setAge(28);
		Brad.setLastName("Pitt");
		Brad.setGender("male");
		Brad.setMarried(false);
		Brad.setSalary(123456);

		ArrayList<JSONarrayPOJO> allEmployees = new ArrayList<JSONarrayPOJO>();

		allEmployees.add(John);
		allEmployees.add(dicap);
		allEmployees.add(Brad);

		ObjectMapper objMapper = new ObjectMapper();
		allEmployeesJson = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(allEmployees);
		System.out.println(allEmployeesJson);
	}

	@Test
	public void getPOJOFromObj() throws JsonMappingException, JsonProcessingException {
		ObjectMapper objMapper = new ObjectMapper();
		List<JSONarrayPOJO> listOfEmp = objMapper.readValue(allEmployeesJson, new TypeReference<List<JSONarrayPOJO>>() {
		});

		for (JSONarrayPOJO e : listOfEmp) {
			System.out.println("FirstName : " + e.getFirstName());
			System.out.println("LastName  : " + e.getLastName());
		}
	}
}
