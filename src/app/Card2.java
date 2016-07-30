package app;
public class Card2 extends Card {
	public boolean used = false;
	
	public Card2(int number, int top, int right, int bottom, int left) {
		super(number, top, right, bottom, left);
	}
	
	public void used(){used = true;}
	public void unused(){used = false;}
}
