package test;

import static org.junit.Assert.*;

import org.junit.Test;

import app.App;
import app.Card;

public class Tests {

	@Test
	public void testFailingField() {
		Card[] cards = new Card[9];
		cards[0] = new Card(0, Card.STRIPED_BUTT, Card.STRIPED_HEAD, Card.STRIPED_BUTT, Card.STRIPED_HEAD);
		cards[1] = new Card(1, Card.STRIPED_HEAD, Card.STRIPED_BUTT, Card.STRIPED_HEAD, Card.STRIPED_BUTT);
		cards[2] = new Card(2, Card.STRIPED_BUTT, Card.STRIPED_HEAD, Card.STRIPED_BUTT, Card.STRIPED_HEAD);
		cards[3] = new Card(3, Card.NAKED_BUTT, Card.NAKED_BUTT, Card.NAKED_BUTT, Card.NAKED_BUTT);
		cards[4] = new Card(4, Card.STRIPED_BUTT, Card.STRIPED_HEAD, Card.STRIPED_BUTT, Card.STRIPED_HEAD);
		cards[5] = new Card(5, Card.STRIPED_HEAD, Card.STRIPED_BUTT, Card.STRIPED_HEAD, Card.STRIPED_BUTT);
		cards[6] = new Card(6, Card.STRIPED_BUTT, Card.STRIPED_HEAD, Card.STRIPED_BUTT, Card.STRIPED_HEAD);
		cards[7] = new Card(7, Card.STRIPED_HEAD, Card.STRIPED_BUTT, Card.STRIPED_HEAD, Card.STRIPED_BUTT);
		cards[8] = new Card(8, Card.STRIPED_BUTT, Card.STRIPED_HEAD, Card.STRIPED_BUTT, Card.STRIPED_HEAD);
		
		Card[][] combination = new Card[3][3];
		combination[0][0] = cards[0];
		combination[0][1] = cards[1];
		combination[0][2] = cards[2];
		combination[1][0] = cards[3];
		combination[1][1] = cards[4];
		combination[1][2] = cards[5];
		combination[2][0] = cards[6];
		combination[2][1] = cards[7];
		combination[2][2] = cards[8];
		
		assertEquals(false, App.check(combination));
	}

	
	@Test
	public void testCorrectField() {
		Card[] cards = new Card[9];
		cards[0] = new Card(0, Card.STRIPED_BUTT, Card.STRIPED_HEAD, Card.STRIPED_BUTT, Card.STRIPED_HEAD);
		cards[1] = new Card(1, Card.STRIPED_HEAD, Card.STRIPED_BUTT, Card.STRIPED_HEAD, Card.STRIPED_BUTT);
		cards[2] = new Card(2, Card.STRIPED_BUTT, Card.STRIPED_HEAD, Card.STRIPED_BUTT, Card.STRIPED_HEAD);
		cards[3] = new Card(3, Card.STRIPED_HEAD, Card.STRIPED_BUTT, Card.STRIPED_HEAD, Card.STRIPED_BUTT);
		cards[4] = new Card(4, Card.STRIPED_BUTT, Card.STRIPED_HEAD, Card.STRIPED_BUTT, Card.STRIPED_HEAD);
		cards[5] = new Card(5, Card.STRIPED_HEAD, Card.STRIPED_BUTT, Card.STRIPED_HEAD, Card.STRIPED_BUTT);
		cards[6] = new Card(6, Card.STRIPED_BUTT, Card.STRIPED_HEAD, Card.STRIPED_BUTT, Card.STRIPED_HEAD);
		cards[7] = new Card(7, Card.STRIPED_HEAD, Card.STRIPED_BUTT, Card.STRIPED_HEAD, Card.STRIPED_BUTT);
		cards[8] = new Card(8, Card.STRIPED_BUTT, Card.STRIPED_HEAD, Card.STRIPED_BUTT, Card.STRIPED_HEAD);
		
		Card[][] combination = new Card[3][3];
		combination[0][0] = cards[0];
		combination[0][1] = cards[1];
		combination[0][2] = cards[2];
		combination[1][0] = cards[3];
		combination[1][1] = cards[4];
		combination[1][2] = cards[5];
		combination[2][0] = cards[6];
		combination[2][1] = cards[7];
		combination[2][2] = cards[8];
		
		assertEquals(true, App.check(combination));
	}
	
	@Test
	public void testFits(){
		assertEquals(true, Card.fits(Card.STRIPED_BUTT, Card.STRIPED_HEAD));
		assertEquals(true, Card.fits(Card.STRIPED_HEAD, Card.STRIPED_BUTT));
		assertEquals(true, Card.fits(Card.NAKED_BUTT, Card.NAKED_HEAD));
		assertEquals(true, Card.fits(Card.NAKED_HEAD, Card.NAKED_BUTT));
		assertEquals(true, Card.fits(Card.CIRCULAR_BUTT, Card.CIRCULAR_HEAD));
		assertEquals(true, Card.fits(Card.CIRCULAR_HEAD, Card.CIRCULAR_BUTT));
		assertEquals(true, Card.fits(Card.TRIANGULAR_BUTT, Card.TRIANGULAR_HEAD));
		assertEquals(true, Card.fits(Card.TRIANGULAR_HEAD, Card.TRIANGULAR_BUTT));
	}
	
	@Test
	public void testFitsFailed(){
		assertEquals(false, Card.fits(Card.CIRCULAR_BUTT, Card.STRIPED_BUTT));
		assertEquals(false, Card.fits(Card.CIRCULAR_BUTT, Card.STRIPED_HEAD));
		assertEquals(false, Card.fits(Card.CIRCULAR_BUTT, Card.NAKED_BUTT));
		assertEquals(false, Card.fits(Card.CIRCULAR_BUTT, Card.NAKED_HEAD));
		assertEquals(false, Card.fits(Card.CIRCULAR_BUTT, Card.TRIANGULAR_BUTT));
		assertEquals(false, Card.fits(Card.CIRCULAR_BUTT, Card.TRIANGULAR_HEAD));
		
		assertEquals(false, Card.fits(Card.NAKED_BUTT, Card.CIRCULAR_BUTT));
		assertEquals(false, Card.fits(Card.NAKED_BUTT, Card.CIRCULAR_HEAD));
		assertEquals(false, Card.fits(Card.NAKED_BUTT, Card.STRIPED_BUTT));
		assertEquals(false, Card.fits(Card.NAKED_BUTT, Card.STRIPED_HEAD));
		assertEquals(false, Card.fits(Card.NAKED_BUTT, Card.TRIANGULAR_BUTT));
		assertEquals(false, Card.fits(Card.NAKED_BUTT, Card.TRIANGULAR_HEAD));
		
		assertEquals(false, Card.fits(Card.STRIPED_BUTT, Card.CIRCULAR_BUTT));
		assertEquals(false, Card.fits(Card.STRIPED_BUTT, Card.CIRCULAR_HEAD));
		assertEquals(false, Card.fits(Card.STRIPED_BUTT, Card.NAKED_BUTT));
		assertEquals(false, Card.fits(Card.STRIPED_BUTT, Card.NAKED_HEAD));
		assertEquals(false, Card.fits(Card.STRIPED_BUTT, Card.TRIANGULAR_BUTT));
		assertEquals(false, Card.fits(Card.STRIPED_BUTT, Card.TRIANGULAR_HEAD));
		
		assertEquals(false, Card.fits(Card.TRIANGULAR_BUTT, Card.NAKED_BUTT));
		assertEquals(false, Card.fits(Card.TRIANGULAR_BUTT, Card.NAKED_HEAD));
		assertEquals(false, Card.fits(Card.TRIANGULAR_BUTT, Card.CIRCULAR_BUTT));
		assertEquals(false, Card.fits(Card.TRIANGULAR_BUTT, Card.CIRCULAR_HEAD));
		assertEquals(false, Card.fits(Card.TRIANGULAR_BUTT, Card.STRIPED_BUTT));
		assertEquals(false, Card.fits(Card.TRIANGULAR_BUTT, Card.STRIPED_HEAD));
	}
}
