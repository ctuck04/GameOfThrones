package data;

import java.util.ArrayList;
import java.util.List;

public interface CharDAO {
	public Char getCharacterByFirstName(String firstName);
	public ArrayList<Char> getCharactersByLastName(String lastName);
	public Char getMaleCharacters(String gender);
	public Char getFemaleCharacters(String gender);
	public Char getLivingCharacters(String status);
	public Char getDeadCharacters(String status);
	public List<Char> addCharacter(Char character);
	public List<Char> removeCharacter(String firstName);
	public List<Char> updateCharacter(String firstName, String lastName, String gender, String status, String oldFirstName);

}
