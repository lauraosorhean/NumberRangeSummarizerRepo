package mainPkg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class solutionTest {
	
	solution solution;

	@Test
	void blank() {
		solution = new solution("");

		System.out.println(
				"Test Input: " + "" + 
				"\nExpected Output: " + "You have not entered any values." + 
				"\nActual Output: " + solution.output + "\n"
				);
		
		assertEquals("You have not entered any values.", solution.output);
	}
	
	@Test
	void nonNumerical() {
		solution = new solution("1,2,A,3,4");
		
		System.out.println(
				"Test Input: " + "1,2,A,3,4" + 
				"\nExpected Output: " + "You have entered an invalid input." + 
				"\nActual Output: " + solution.output + "\n"
				);
		
		assertEquals("You have entered an invalid input.", solution.output);
	}

	@Test
	void oneNumber() {
		solution = new solution("22");
		System.out.println(
				"Test Input: " + "22" + 
				"\nExpected Output: " + "All numbers are non-consecutive." + 
				"\nActual Output: " + solution.output + "\n"
				);
		assertEquals("All numbers are non-consecutive.", solution.output);
	}
	
	@Test
	void allConsecutive() {
		solution = new solution("55,56,57,58,59");
		System.out.println(
				"Test Input: " + "55,56,57,58,59" + 
				"\nExpected Output: " + "55-59" + 
				"\nActual Output: " + solution.output + "\n"
				);
		assertEquals("55-59", solution.output);
	}
	
	@Test
	void intervalStart() {
		solution = new solution("23,24,25,30,32,34,36");
		System.out.println(
				"Test Input: " + "23,24,25,30,32,33,35" + 
				"\nExpected Output: " + "23-25, 30, 32, 34, 36" + 
				"\nActual Output: " + solution.output + "\n"
				);
		assertEquals("23-25, 30, 32, 34, 36", solution.output);
	}
	
	@Test
	void intervalEnd() {
		solution = new solution("23,24,25,30,32,34,35,36");
		System.out.println(
				"Test Input: " + "23,24,25,30,32,33,35" + 
				"\nExpected Output: " + "23-25, 30, 32, 34-36" + 
				"\nActual Output: " + solution.output + "\n"
				);
		assertEquals("23-25, 30, 32, 34-36", solution.output);
	}
	
	@Test
	void twoConsecutive() { //only group if there are more than 3 consecutive numbers
		solution = new solution("76,78,79,80,81,83,84");
		System.out.println(
				"Test Input: " + "76,78,79,80,81,83,84" + 
				"\nExpected Output: " + "76, 79-81, 83, 84" + 
				"\nActual Output: " + solution.output + "\n"
				);
		assertEquals("76, 78-81, 83, 84", solution.output);
	}
	
	
	@Test
	void unsorted() { 
		solution = new solution("9,5,8,3,6,4");//3 4 5 6 8 9
		System.out.println(
				"Test Input: " + "9,5,8,3,6,4" + 
				"\nExpected Output: " + "3-6, 8, 9" + 
				"\nActual Output: " + solution.output + "\n"
				);
		assertEquals("3-6, 8, 9", solution.output);
	}

	@Test
	void duplicates() { 
		solution = new solution("1,1,2,2,3,5,8");//3 4 5 6 8 9
		System.out.println(
				"Test Input: " + "1,1,2,2,3,5,8" + 
				"\nExpected Output: " + "1-3, 5, 8" + 
				"\nActual Output: " + solution.output + "\n"
				);
		assertEquals("1-3, 5, 8", solution.output);
	}
	
	
	@Test
	void largerSet() { 
		solution = new solution("1,2,3,4,8,9,11,15,17,18,19,20,21,22,45,47,49,56,57,58,59,60,61,63,64,65,71,74,75,76,80,82,83,84,85,88,89,90,92,94,96,100,101,120");//3 4 5 6 8 9
		System.out.println(
				"Test Input: " + "1,2,3,4,8,9,11,15,17,18,19,20,21,22,45,47,49,56,57,58,59,60,61,63,64,65,71,74,75,76,80,82,83,84,85,88,89,90,92,94,96,100,101,120" + 
				"\nExpected Output: " + "1-4, 8, 9, 11, 15, 17-22, 45, 47, 49, 56-61, 63-65, 71, 74-76, 80, 82-85, 88-90, 92, 94, 96, 100, 101, 120" + 
				"\nActual Output: " + solution.output + "\n"
				);
		assertEquals("1-4, 8, 9, 11, 15, 17-22, 45, 47, 49, 56-61, 63-65, 71, 74-76, 80, 82-85, 88-90, 92, 94, 96, 100, 101, 120", solution.output);
	}
	
	
	@Test
	void sampleGiven() {
		solution = new solution("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
		System.out.println(
				"Test Input: " + "1,3,6,7,8,12,13,14,15,21,22,23,24,31" + 
				"\nExpected Output: " + "1, 3, 6-8, 12-15, 21-24, 31" + 
				"\nActual Output: " + solution.output + "\n"
				);
		assertEquals("1, 3, 6-8, 12-15, 21-24, 31", solution.output);
	}
		

}
