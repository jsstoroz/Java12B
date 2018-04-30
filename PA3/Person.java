/**
 * Jennifer Storozum
 * COSI 12B PA3
 * Summer 2017
 * A person class that stores information about a person and their
 * family relationships.
 */
import java.util.*;
import java.io.*;

public class Person{
	//arrayLists to hold information
	
	ArrayList<Person> paternal = new ArrayList<Person>();
	ArrayList<Person> maternal = new ArrayList<Person>();
	ArrayList<Person> children = new ArrayList<Person>();
	
	//fields
	private String name;
	private Person mother;
	private Person father;
	
	
	//constructor
	public Person(String name){
		this.name = name;
		this.mother = null;
		this.father = null;
	}

	//getters and setters
	public void setMother(Person m){
		this.mother = m;
	}
	
	public Person getMother(){
		return this.mother;
	}
	
	public Person getFather(){
		return this.father;
	}
	
	public void setFather(Person f){
		this.father = f;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getMotherName(){
		return this.mother.name;
	}
	
	public String getFatherName(){
		return this.father.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	//getMaternalLine uses the relationship pointers to construct an arrayList of mothers
	public void getMaternalLine(Person p){
		if(p.mother == null){
			maternal.add(p);
		} else {
			maternal.add(p);
			getMaternalLine(p.mother);
		}
	}
	
	//getPaternalLine uses the relationship pointers to construct an arrayList of fathers
	public void getPaternalLine(Person p){
		if(p.father == null){
			paternal.add(p);
		} else {
			paternal.add(p);
			getPaternalLine(p.father);
		}
	}
	
	public ArrayList<Person> getChildren(){
		return this.children;
	}
	
	//setChildren uses the relationship pointers to construct an arrayList of children
	public void setChild(Person c){
		children.add(c);
	}
}
