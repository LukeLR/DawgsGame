public class App{
	public static void main(String[] args){
		Card[] cards = initCards();
		Card[][] c = new Card[3][3];
		for (int a0 = 0; a0 < 9; a0++){
			c[0][0] = cards[a0];
			for (int a1 = 0; a1 < 9; a1++){
				if (a0 != a1){
					c[0][1] = cards[a1];
					for (int a2 = 0; a2 < 9; a2++){
						if (a2 != a0 && a2 != a1){
							c[0][2] = cards[a2];
							for (int a3 = 0; a3 < 9; a3++){
								if(a3 != a0 && a3 != a1 && a3 != a2){
									c[1][0] = cards[a3];
									for(int a4 = 0; a4 < 9; a4++){
										if(a4 != a0 && a4 != a1 && a4 != a2 && a4 != a3){
											c[1][1] = cards[a4];
											for(int a5 = 0; a5 < 9; a5++){
												if(a5 != a0 && a5 != a1 && a5 != a2 && a5 != a3 && a5 != a4){
													c[1][2] = cards[a5];
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public static Card[] initCards(){
		Card[] cards = new Card[9];
		cards[0] = new Card(Card.STRIPED_HEAD, Card.CIRCULAR_BUTT, Card.STRIPED_BUTT, Card.NAKED_HEAD);
		cards[1] = new Card(Card.STRIPED_HEAD, Card.NAKED_BUTT, Card.TRIANGULAR_BUTT, Card.CIRCULAR_HEAD);
		cards[2] = new Card(Card.TRIANGULAR_HEAD, Card.NAKED_BUTT, Card.CIRCULAR_BUTT, Card.NAKED_HEAD);
		cards[3] = new Card(Card.STRIPED_HEAD, Card.CIRCULAR_BUTT, Card.TRIANGULAR_BUTT, Card.NAKED_HEAD);
		cards[4] = new Card(Card.CIRCULAR_HEAD, Card.TRIANGULAR_HEAD, Card.NAKED_BUTT, Card.TRIANGULAR_BUTT);
		cards[5] = new Card(Card.CIRCULAR_HEAD, Card.STRIPED_BUTT, Card.CIRCULAR_BUTT, Card.TRIANGULAR_HEAD);
		cards[6] = new Card(Card.TRIANGULAR_HEAD, Card.NAKED_BUTT, Card.STRIPED_BUTT, Card.CIRCULAR_HEAD);
		cards[7] = new Card(Card.TRIANGULAR_HEAD, Card.CIRCULAR_BUTT, Card.NAKED_BUTT, Card.STRIPED_HEAD);
		cards[8] = new Card(Card.TRIANGULAR_HEAD, Card.STRIPED_BUTT, Card.CIRCULAR_BUTT, Card.STRIPED_HEAD);
		return cards;
	}

	public static boolean check(Card[][] c){
		return
		Card.fits(c[0][0].right, c[1][0].left) &&
		Card.fits(c[0][0].bottom, c[0][1].top) &&
		Card.fits(c[1][0].right, c[2][0].left) &&
		Card.fits(c[1][0].bottom, c[1][1].top) &&
		Card.fits(c[2][0].bottom, c[2][1].top) &&

		Card.fits(c[0][1].right, c[1][1].left) &&
		Card.fits(c[0][1].bottom, c[0][2].top) &&
		Card.fits(c[1][1].right, c[2][1].left) &&
		Card.fits(c[1][1].bottom, c[1][2].top) &&
		Card.fits(c[2][1].bottom, c[2][2].top) &&

		Card.fits(c[0][2].right, c[1][2].left) &&
		Card.fits(c[1][2].right, c[2][2].left);
	}
}