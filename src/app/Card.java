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

	public int number, top, right, bottom, left, rotation;

	public Card (int number, int top, int right, int bottom, int left){
		this.number = number;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		this.left = left;
		rotation = 0;
	}

	public static boolean fits(int type1, int type2){
		if (isOdd(type1)) return type1 - 1 == type2;
		else return type1 + 1 == type2;
	}

	public static boolean isOdd(int i){
		return i % 2 == 1;
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
		result[1] = "|  " + getTypeString(top) + "  |";
		result[2] = "|" + getTypeString(left) + "  " + getTypeString(right) + "|";
		result[3] = "|  " + getTypeString(bottom) + "  |";
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
	
	public String getTypeString(int type){
		switch(type){
		case NAKED_BUTT: return "NB";
		case NAKED_HEAD: return "NH";
		case STRIPED_BUTT: return "SB";
		case STRIPED_HEAD: return "SH";
		case TRIANGULAR_BUTT: return "TB";
		case TRIANGULAR_HEAD: return "TH";
		case CIRCULAR_BUTT: return "CB";
		case CIRCULAR_HEAD: return "CH";
		default: return "NA";
		}
	}
}