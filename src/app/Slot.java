package app;

public class Slot {
//	private int position;
	private Slot left, top, right, bottom;
	private Card2 card;
	
	
	public Slot(Slot left, Slot top, Slot right, Slot bottom){
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
	}
	
	public Slot(Card card){
		
	}
	
	public Slot left(){ return left; }
	public Slot top(){ return top; }
	public Slot bottom(){ return bottom; }
	public Slot right(){ return right; }
	public Card card(){ return card; }
	
	public boolean hasLeft(){ return left != null; }
	public boolean hasTop(){ return top != null; }
	public boolean hasBottom(){ return bottom != null; }
	public boolean hasRight(){ return right != null; }
	public boolean isEmpty(){ return card == null; }
	
	public boolean setCard(Card2 card){
		
		
		return false;
	}
	
	public void clear(){
		if (card != null){
			card.unused();
			card = null;
		}
	}
}
