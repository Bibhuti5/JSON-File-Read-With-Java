package com.cg.json.testjson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;



import com.cg.json.testjson.model.Person;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonMain {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File("data.json"));
			TypeReference<List<Person>> typeReference = new TypeReference<List<Person>>() {
			};
			List<Person> persons = mapper.readValue(inputStream,typeReference);
			System.out.println("**********Tall Persons List*************");
			List<Person> result = persons.stream().filter(h -> h.getHeight() > 140)
			        .collect(Collectors.toList());
			System.out.println(result);
			System.out.println("**********Small Persons List*************");
			List<Person> result2 = persons.stream().filter(h -> h.getHeight() < 140)
			        .collect(Collectors.toList());
			System.out.println(result2);
			System.out.println(">>>>>>>>>>>Male Persons List<<<<<<<<<<<<<<<");
			List<Person> result3 = persons.stream().filter(h -> h.getGender().equals("male"))
			        .collect(Collectors.toList());
			System.out.println(result3);
			
			
			System.out.println(">>>>>>>>>>>Female Persons List<<<<<<<<<<<<<<<");
			List<Person> result4 = persons.stream().filter(h -> h.getGender().equals("female"))
			        .collect(Collectors.toList());
			System.out.println(result4);
			

			
		}
		
	
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private static Person getStudentByName(List<Person> persons, String firstName) {

        Person result = null;
        for (Person temp : persons) {
            if (firstName.equals(temp.getFirstName())) {
                result = temp;
            }
        }
        return result;
    }
}
