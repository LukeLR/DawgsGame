package app;
public class Card {
	public static final int NAKED_BUTT = 0;
	public static final int NAKED_HEAD = 1;
	public static final int STRIPED_BUTT = 2;
	public static final int STRIPED_HEAD = 3;
	public static final int TRIANGULAR_BUTT = 4;
	public static final int TRIANGULAR_HEAD = 5;
	public static final int CIRCULAR_BUTT = 6;
	public static final int CIRCULAR_HEAD = 7;
	
	public static final int TOP = -1;
	public static final int RIGHT = -2;
	public static final int BOTTOM = -3;
	public static final int LEFT = -4;

	public int number, top, right, bottom, left, rotation;
	
	public Card (int number, int top, int right, int bottom, int left){
		this.number = number;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		this.left = left;
		rotation = 0;
	}

	public void rotate(){
		int a = top;
		top = right;
		right = bottom;
		bottom = left;
		left = a;
		rotation = (rotation + 1) % 4;
	}
	
	public String[] print(){
		String[] result = new String[5];
		result[0] = "+------+";
		result[1] = "|  " + Util.getTypeString(top) + "  |";
		result[2] = "|" + Util.getTypeString(left) + "  " + Util.getTypeString(right) + "|";
		result[3] = "|  " + Util.getTypeString(bottom) + "  |";
		result[4] = "+------+";
		return result;
	}
	
	public String[] print(boolean debug){
		if (debug){
			String[] result = new String[5];
			result[0] = "+------+";
			result[1] = "|      |";
			result[2] = "|  " + String.valueOf(number) + String.valueOf(rotation) + "  |";
			result[3] = "|      |";
			result[4] = "+------+";
			return result;
		} else {
			return print();
		}
	}
}