package lab4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Part1Test {
	
	public ArrayList<String> aList=new ArrayList();
	public Part1 main=new Part1();
	
	@BeforeEach
	void setUp() throws Exception {
		
		aList.add("banana");
		aList.add("apple");
		aList.add("orange");
		aList.add("banana");
	}
		
	@Test
	void removeTest() {
		
		main.remove(aList, "banana", "cherry");
		assertEquals(aList.get(3),"cherry");
		//fail("Not yet implemented");
	}
	
	@Test
	void deleteTest()
	{
		main.delete(aList, "apple");
		assertEquals(aList.get(1),"orange");
	}

}
