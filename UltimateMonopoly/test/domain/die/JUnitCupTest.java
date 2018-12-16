package domain.die;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author mmeltemgunay
 *
 */

class JUnitCupTest {

	@Test
	void testRollThreeRegularDices() {
		Cup testCup = new Cup();
		for(int i = 0 ; i < 100 ; i++) {
			testCup.rollThreeRegularDices();
			for(DieValue v : testCup.getFaceValues()) {
				assertNotEquals(v,DieValue.MRMONOPOLY);
				assertNotEquals(v,DieValue.BUSICON);
				assertNotEquals(v,DieValue.EMPTY);
				assertNotNull(v);
			}
		}
	}
	
	@Test
	void testGetTotal() {
		Cup testCup = new Cup();
		int sum;
		for(int i = 0 ; i < 100 ; i++) {
			testCup.rollDices();
			sum = testCup.getTotal();
			assertTrue(sum <= 15); 
			assertTrue(sum >= 2);
		}
		
		for(int i = 0 ; i < 100 ; i++) {
			testCup.rollTwoRegularDices();
			sum = testCup.getTotal();
			assertTrue(sum <= 12); 
			assertTrue(sum >= 2);
		}
	}
	
	@Test
	void testClearCup() {
		Cup testCup = new Cup();
		for(int i = 0 ; i < 100 ; i++) {
			testCup.rollDices();
			testCup.clearCup();
			for(DieValue v : testCup.getFaceValues()) {
				assertEquals(v,DieValue.EMPTY);
			}
			
		}
		for(int i = 0 ; i < 100 ; i++) {
			testCup.rollThreeRegularDices();
			testCup.clearCup();
			for(DieValue v : testCup.getFaceValues()) {
				assertEquals(v,DieValue.EMPTY);
			}
			
		}
		for(int i = 0 ; i < 100 ; i++) {
			testCup.rollTwoRegularDices();
			testCup.clearCup();
			for(DieValue v : testCup.getFaceValues()) {
				assertEquals(v,DieValue.EMPTY);
			}
			
		}
	}
	

	
	@Test
	void testFaceValuesChanged() {
		Cup testCup = new Cup();
		int val1 = testCup.getFaceValues()[0].getValue();
		int val2 = testCup.getFaceValues()[1].getValue();
		int val3 = testCup.getFaceValues()[2].getValue();
		boolean isChanged = false;
		for(int i = 0 ; i < 100 ; i++) {
			testCup.rollThreeRegularDices();
			for(int j = 0 ; j < 3 ; j++) {
				if(val1 != testCup.getFaceValues()[0].getValue() || val2 != testCup.getFaceValues()[1].getValue() || val3 != testCup.getFaceValues()[2].getValue()) {
					isChanged = true;
				}
			}
		}
		assertTrue(isChanged);	
	}
	
	
	
	
	@Test
	void repOKTestRollThreeRegularDices() {
		Cup testCup = new Cup();
		for(int i = 0 ; i < 100 ; i++) {
			testCup.rollThreeRegularDices();
			assertTrue(testCup.repOK());
		}
	}

	@Test
	void repOKTestClearCup() {
		Cup testCup = new Cup();
		for(int i = 0 ; i < 100 ; i++) {
			testCup = new Cup();
			testCup.clearCup();
			assertTrue(testCup.repOK());
		}
	}
}
