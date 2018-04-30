/**
 * Jennifer Storozum
 * COSI 12B PA3
 * Summer 2017
 This is the driver for a family database program. The person class represents a person and stores references to the
person’s mother, father, and any children the person has.
Bugs: Children doesn't work right although the method assigns the children to the parents correctly.
It worked fine when I had everything in one file but I wrote the methods badly so they don't
work in a non-static context. 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonDriver {
	
	
	static ArrayList<Person> uniqueFamilyMembers = new ArrayList<Person>();
	static ArrayList<Person> relationshipList = new ArrayList<Person>();
	
	/**
	 * The main method reads a file of names to initialize the name and parent-child relationships of each Person. 
	 * The main user interface that asks for a name and prints the maternal and parental family line for that person, 
	 * as well as their children.
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException{
		String filename = "tudor.dat";
		File f = new File(filename);
		Scanner scan = new Scanner(f);
		
		//add the first half of the list to uniqueFamilyMembers
		while(scan.hasNextLine()){
			String name = scan.nextLine();
			if(name.contains("END")){
				break;
			} else {
				Person familyMember = new Person(name);
				uniqueFamilyMembers.add(familyMember);
			}
		}
	
		//add the second half of the list to relationshipList
		while(scan.hasNextLine()){
			String name = scan.nextLine();
			if(name.contains("END")){
				break;
			} else {
				Person familyMember = new Person(name);
				relationshipList.add(familyMember);
			}
		}

		//set the relationship pointers for each Family member
		for(Person person: relationshipList){
			int i = relationshipList.indexOf(person); 
			if(i % 3 == 0){
				Person mother = relationshipList.get(i + 1);
				person.setMother(mother);
				Person father = relationshipList.get(i + 2);
				person.setFather(father);
			} else if(i % 3 == 1){
				Person child = relationshipList.get(i - 1);
				person.setChild(child);
			} else if(i % 3 == 2){
				Person child = relationshipList.get(i - 2);
				person.setChild(child);
			}
		}

		//get the name from the user and report the maternal line,
		//paternal line and children
		Scanner input = new Scanner(System.in);
		System.out.print("Person's name? ");
		String personsName = input.nextLine();
		int i = 0;
		for(Person p : relationshipList){
			if(p.getName().equals(personsName)){
				i = relationshipList.indexOf(p);
				break;
			}
		}
		
		Person toGet = relationshipList.get(i);
	
		System.out.print("Maternal line:");
		toGet.getMaternalLine(toGet);
		for(Person p : toGet.maternal){
			System.out.print("\n\t");
			System.out.print(p.getName());
		}
		
		System.out.println();
		System.out.print("Paternal line:");
		toGet.getPaternalLine(toGet);
		for(Person p: toGet.paternal){
			System.out.print("\n\t");
			System.out.print(p.getName());
		}
		
		System.out.println();
		System.out.print("Children:");
		ArrayList<Person> children = toGet.getChildren();
		for(Person c : children){
			System.out.print("\n\t");
			System.out.print(c.getName());
		}
	}
}
