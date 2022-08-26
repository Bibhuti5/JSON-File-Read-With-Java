package com.cg.json.testjson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.cg.json.testjson.model.Person;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) throws ParseException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			InputStream inputStream = new FileInputStream(new File("data.json"));
			TypeReference <List<Person>> typeReference = new TypeReference<List<Person>>() {
			};
			
			List<Person> persons = mapper.readValue(inputStream,typeReference);

			for(Person p: persons){
				if(p.getHeight()>140) {
					System.out.println(p.getFirstName()+" "+p.getLastName()+"is a tall person");

				}
				else {
					System.out.println(p.getFirstName()+" "+p.getLastName()+"is a short person");
				}
				
			}	
		  
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (JsonParseException p){
			p.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
