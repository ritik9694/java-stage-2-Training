package com.cognizant.app.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class findLargestTest {

	@Test
	void testFindLargest() {
		FindLargest larObj = new FindLargest();
		int nums[] = {23,34,63,45};
		
		int expectedVakue = 63;
		int actualValue = larObj.findLargest(nums);
		
		assertEquals(expectedVakue, actualValue);
	}
	
	@Test
	void testFindLargest_01() {
		FindLargest larObj = new FindLargest();
		int nums[] = {-23,-34,-63,-45};
		
		int expectedVakue = -23;
		int actualValue = larObj.findLargest(nums);
		
		assertEquals(expectedVakue, actualValue);
	}
	
	@Test
	void testFindLargest_02() {
		FindLargest larObj = new FindLargest();
		int nums[] = {};
		
		assertThrows(ArrayIndexOutOfBoundsException.class, ()-> larObj.findLargest(nums) );
	}

}
