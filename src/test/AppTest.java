package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

	@Test
	public void test() {
		Card[] cards = new Card[9];
		cards[0] = new Card(0, Card.STRIPED_BUTT, Card.STRIPED_HEAD, Card.STRIPED_BUTT, Card.STRIPED_HEAD);
		cards[1] = new Card(1, Card.STRIPED_HEAD, Card.STRIPED_BUTT, Card.STRIPED_HEAD, Card.STRIPED_BUTT);
		cards[2] = new Card(2, Card.STRIPED_BUTT, Card.STRIPED_HEAD, Card.STRIPED_BUTT, Card.STRIPED_HEAD);
		cards[3] = new Card(3, Card.NAKED_BUTT, Card.STRIPED_BUTT, Card.STRIPED_HEAD, Card.STRIPED_BUTT);
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
		
		assertEquals()
	}

}
