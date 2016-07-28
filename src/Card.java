public class Card {
	public static final int NAKED_BUTT = 0;
	public static final int NAKED_HEAD = 1;
	public static final int STRIPED_BUTT = 2;
	public static final int STRIPED_HEAD = 3;
	public static final int TRIANGULAR_BUTT = 4;
	public static final int TRIANGULAR_HEAD = 5;
	public static final int CIRCULAR_BUTT = 6;
	public static final int CIRCULAR_HEAD = 7;

	public int top, right, bottom, left;

	public Card (int top, int right, int bottom, int left){
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		this.left = left;
	}

	public static boolean fits(int type1, int type2){
		if (isOdd(type1)) return type1 - 1 == type2;
		else return type1 + 1 == type2;
	}

	public static boolean isOdd(int i){
		return i % 2 == 1;
	}

	public void turn(){
		int a = top;
		top = right;
		right = bottom;
		bottom = left;
		left = a;
	}
}