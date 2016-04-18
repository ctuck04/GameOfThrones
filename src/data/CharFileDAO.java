package data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;



public class CharFileDAO implements CharDAO{
	private static final String FILE_NAME="/WEB-INF/Cast.csv";
	private List<Char> characters = new ArrayList<>();
	
	@Autowired 
	private ApplicationContext ac;
	
	@PostConstruct
	public void init() {
		// Retrieve an input stream from the application context
		// rather than directly from the file system
		try (
				InputStream is = ac.getResource(FILE_NAME).getInputStream();
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));
			) {
			String line = buf.readLine();
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				String firstName = tokens[0];
				String lastName = tokens[1];
				String gender = tokens[2];
				String status = tokens[3];
				characters.add(new Char(firstName, lastName, gender, status));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}


	@Override
	public Char getCharacterByFirstName(String firstName) {
		Char c = null;
		for (Char character : characters) {
			if (character.getFirstName().equalsIgnoreCase(firstName)) {
				c = character;
				break;
			}
		}
		return c;
	}
	
	@Override
	public ArrayList<Char> getCharactersByLastName(String lastName) {
		Char c = null;
		ArrayList<Char> family = new ArrayList<Char>();
		
		for (Char character : characters) {
			if (character.getLastName().equalsIgnoreCase(lastName)) {
				c = character;
				family.add(c);
//				break;
			}
		}
		return family;
	}
	
	@Override
	public Char getMaleCharacters(String gender) {
		Char c = null;
		for (Char character : characters) {
			if (character.getGender().equals("Male")) {
				c = character;
			}
		}
		return c;
	}
	
	@Override
	public Char getFemaleCharacters(String gender) {
		Char c = null;
		for (Char character : characters) {
			if (character.getGender().equals("Female")) {
				c = character;
			}
		}
		return c;
	}
	
	@Override
	public Char getLivingCharacters(String status) {
		Char c = null;
		for (Char character: characters) {
			if (character.getStatus().equals("Alive")) {
				c = character;
			}
		}
		return c;
	}
	
	@Override
	public Char getDeadCharacters(String status) {
		Char c = null;
		for (Char character: characters) {
			if (character.getStatus().equals("Dead")) {
				c = character;
			}
		}
		return c;
	}
	
	@Override
	public List<Char> addCharacter(Char character) {
		characters.add(character);
		return characters;
	}
	
	@Override
	public List<Char> removeCharacter(String firstName) {
		for (Char character: characters) {
			if (character.getFirstName().equals(firstName)) {
				characters.remove(character);
				break;
			}
		}
		return characters;
	}
	
	@Override
	public List<Char> updateCharacter (String firstName, String lastName, String gender, String status, String oldFirstName) {
		int counter = 0;
		Char replacement = new Char(firstName, lastName, gender, status);
		//System.out.println(replacement.getFirstName());
		for (Char character: characters) {
			if (character.getFirstName().equals(oldFirstName)) {
				characters.set(counter, replacement);
			}
		counter++;
		}
		return characters;
	}
	
}
