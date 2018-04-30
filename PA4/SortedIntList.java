/**
 * @author Jennifer Storozum
 * COSI 12B PA4
 * This class creates and maintains a list of integers (extended from the 
 * ArrayIntList class in sorted (non-decreasing) order, that also has an option to specify that 
 * the numbers should be unique (no duplicates).
 * 8/3/2017
 */

import java.util.*;

//must m
public class SortedIntList extends ArrayIntList{

	private boolean unique;
	
//	constructs an empty list with given capacity
//	and "unique" setting
	public SortedIntList(boolean unique, int capacity){
		super(capacity);
		this.unique = unique;
	}
	
//	constructs an empty list with given capacity,
//	allowing duplicates by default
	public SortedIntList(int capacity){
		this(false, capacity);
	}
	
//	constructs empty list of default capacity and
//	given "unique" setting
	public SortedIntList(boolean unique){
		this(unique, DEFAULT_CAPACITY);
	}
	
//	constructs an empty list of a default capacity,
//	allowing duplicates
	public SortedIntList(){
		this(false, DEFAULT_CAPACITY);
	}
	
	//adds an element to the list in sorted order if list size is less than 
	//capacity
	@Override
	public void add(int value){
		this.checkCapacity();
		int index = this.indexOf(value);
		if(index < 0){
			super.add((index * -1) - 1, value);
		} else {
			if(this.getUnique() == false){
				super.add(index, value);
			} else return;
		}
	} 
	
	@Override
//	possibly adds given value to list, maintaining
//	sorted order
	public void add(int index, int value){
		add(value);
	}
	
//	returns whether only unique values are allowed
//	in the list
	public boolean getUnique(){
		return this.unique;
	}
	
	@Override
//	returns index of an occurrence of the given
//	value (< 0 if not found)
	public int indexOf(int value){
		return Arrays.binarySearch(this.elementData, 0, this.size, value);
	}
	
//	returns the maximum integer value stored in the
//	list(throws a  NoSuchElementException if the list
//	is empty)
	public int max() throws NoSuchElementException{
		if(this.size() < 1){
			throw new NoSuchElementException("List empty.");
		} else {
			int max = this.get(0);
			for(int i = 1; i < this.size(); i++){
				if(this.get(i) > max){
					max = this.get(i);
				}
			}
			return max;
		}
	}
	
//	returns the minimum integer value stored in the
//	list (throws a  NoSuchElementException if the list
//	is empty)
	public int min() throws NoSuchElementException{
		if(this.size() < 1){
			throw new NoSuchElementException("List empty.");
		} else {
			int min = this.get(0);
			for(int i = 1; i < this.size(); i++){
				if(this.get(i) < min){
					min = this.get(i);
				}
			}
			return min;
		}
	}
	
//	sets whether only unique values are allowed in
//	the list; if set to  true , immediately removes
//	any existing duplicates from the list
	public void setUnique(boolean unique){
		this.unique = unique;
		if(unique == true && this.size() > 1){
			//remove duplicates
			for(int i = 0; i < this.elementData.length; i++){
				for(int j = i + 1; j < this.size(); j++){
					if(this.get(i) == this.get(i + 1)){
						this.remove(i + 1);
					} 
				}
			}
		}
	}
	
	@Override
//	returns a string version of the list, such as
//	"S:[4, 5, 17]U"
	public String toString(){
		String s = "S:" + super.toString();
		if(this.getUnique() == true){
			return s + "U";
		} else {
			return s;
		}
	}
	
    // Throws an array index out-of-bounds (OOB) exception if list is longer than 
	// capacity
	private void checkCapacity() {
    		if(this.size() < this.elementData.length){
    			return;
    		} else { throw new ArrayIndexOutOfBoundsException("Capacity exceeded");}
    }
}
