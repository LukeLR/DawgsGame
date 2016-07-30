package app;

public class Card2 extends Card {
	private Card2 leftCard, topCard, rightCard, bottomCard;
	public boolean used = false;
	
	public Card2(int number, int top, int right, int bottom, int left) {
		super(number, top, right, bottom, left);
	}

	public boolean hasLeft(){ return leftCard != null;}
	public boolean hasTop(){ return topCard != null;}
	public boolean hasRight(){ return rightCard != null;}
	public boolean hasBottom(){ return bottomCard != null;}
	
	public boolean setLeft(Card2 card){
		if (!card.used && Util.fits(left, card.right))
		{leftCard = card; card.used(); return true;}
		else return false;
	}
	
	public boolean setTop(Card2 card){
		if (!card.used && Util.fits(top, card.bottom))
		{topCard = card; card.used(); return true;}
		else return false;
	}
	
	public boolean setRight(Card2 card){
		if (!card.used && Util.fits(right, card.left))
		{rightCard = card; card.used(); return true;}
		else return false;
	}
	
	public boolean setBottom(Card2 card){
		if (!card.used && Util.fits(bottom, card.top))
		{bottomCard = card; card.used(); return true;}
		else return false;
	}
	
	public void used(){used = true;}
	public void unused(){used = false;}
}
