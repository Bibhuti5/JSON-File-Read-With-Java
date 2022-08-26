package com.cg.json.testjson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.cg.json.testjson.model.Person;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonData {
	public static void main(String[] args) {
		try {
			byte[] mapData = Files.readAllBytes(Paths.get("data.json"));
			Person[] personArr = null;
			ObjectMapper objectMapper = new ObjectMapper();
			personArr = objectMapper.readValue(mapData, Person[].class);
			// Reading Jason Data From the Table
			List<Person> personList = Arrays.asList(personArr);
			System.out.println("Person 1 \n" + personList.get(0));
			System.out.println("Person 2 \n" + personList.get(1));

		} catch (JsonMappingException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
