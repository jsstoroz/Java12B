/**
 * Jennifer Storozum
 * 8/3/2017
 * COSI 12b PA4
 * This is the driver class that tests the class SortedIntList.java
 */

public class MyTestList {
	public static void main(String[] args){

		SortedIntList test1 = new SortedIntList(20);
		System.out.println("TEST 1");
		System.out.println("capacity: " + test1.__getCapacity());
		test1.add(-3);
		test1.add(7);
		test1.add(18);
		test1.add(42);
		test1.add(-3);
		test1.add(27);
		test1.add(1, 50);
		System.out.println(test1.toString());
		test1.remove(1);
		System.out.println(test1.toString());
		test1.remove(4);
		System.out.println(test1.toString());
		System.out.println("index of -3: " + test1.indexOf(-3));
		System.out.println("size: " + test1.size());
		System.out.println("index of 27: " + test1.indexOf(27));
		System.out.println("max: " + test1.max());
		System.out.println("min: " + test1.min());
		System.out.println();

		SortedIntList test2 = new SortedIntList(false, 10);
		System.out.println("TEST 2");
		System.out.println("capacity: " + test2.__getCapacity());
		test2.add(-3);
		test2.add(7);
		test2.add(-3);
		test2.add(7);
		test2.add(7);
		test2.add(5);
		test2.add(7);
		test2.add(0, 27);
		test2.add(50);
		System.out.println(test2.toString());
		System.out.println("index of -3: " +test2.indexOf(-3));
		System.out.println("size: " +test2.size());
		System.out.println("index of 27: " + test2.indexOf(27));
		System.out.println("max: " +test2.max());
		System.out.println("min: " +test2.min());
		test2.setUnique(true);
		System.out.println("After set unique = true:\n" + test2.toString());

	}
}
