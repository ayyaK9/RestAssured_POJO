package basic.rest.pojo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataSerializeandDeserialize {

	@Test
	public void createDataFromPOJO() throws JsonProcessingException
	{
		SamplePOJO employee = new SamplePOJO();
		
		employee.setFirstName("John");
		employee.setAge(28);
		employee.setLastName("Cena");
		employee.setGender("male");
		employee.setMarried(false);
		employee.setSalary(123456);
		
		ObjectMapper objectmapper = new ObjectMapper();
		String employeeJSON = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
		
		System.out.println(employeeJSON);
	}
	
	@Test
	public void getPOJOFromObject() throws JsonProcessingException
	{
		SamplePOJO employee = new SamplePOJO();
		
		employee.setFirstName("HH");
		employee.setAge(28);
		employee.setLastName("Triple");
		employee.setGender("male");
		employee.setMarried(false);
		employee.setSalary(123456);
		
		ObjectMapper objectmapper = new ObjectMapper();
		String employeeJSON = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
		
		SamplePOJO pojoObj = objectmapper.readValue(employeeJSON, SamplePOJO.class);
		System.out.println("first Name "+pojoObj.getFirstName());
		System.out.println("Salary "+pojoObj.getSalary());
		
	}
}
