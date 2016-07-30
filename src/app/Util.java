package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Util {
	public static StringBuilder outputBuilder;
	public static LocalDateTime start = LocalDateTime.now();
	public static long num = 0;
	public static int threadNum = 0;
	public static int writesPending = 0;
	
	public static Card[] initCards(){
		Card[] cards = new Card[9];
		cards[0] = new Card(0, Card.STRIPED_HEAD, Card.CIRCULAR_BUTT, Card.STRIPED_BUTT, Card.NAKED_HEAD);
		cards[1] = new Card(1, Card.STRIPED_HEAD, Card.NAKED_BUTT, Card.TRIANGULAR_BUTT, Card.CIRCULAR_HEAD);
		cards[2] = new Card(2, Card.TRIANGULAR_HEAD, Card.NAKED_BUTT, Card.CIRCULAR_BUTT, Card.NAKED_HEAD);
		cards[3] = new Card(3, Card.STRIPED_HEAD, Card.CIRCULAR_BUTT, Card.TRIANGULAR_BUTT, Card.NAKED_HEAD);
		cards[4] = new Card(4, Card.CIRCULAR_HEAD, Card.TRIANGULAR_HEAD, Card.NAKED_BUTT, Card.TRIANGULAR_BUTT);
		cards[5] = new Card(5, Card.CIRCULAR_HEAD, Card.STRIPED_BUTT, Card.CIRCULAR_BUTT, Card.TRIANGULAR_HEAD);
		cards[6] = new Card(6, Card.TRIANGULAR_HEAD, Card.NAKED_BUTT, Card.STRIPED_BUTT, Card.CIRCULAR_HEAD);
		cards[7] = new Card(7, Card.TRIANGULAR_HEAD, Card.CIRCULAR_BUTT, Card.NAKED_BUTT, Card.STRIPED_HEAD);
		cards[8] = new Card(8,Card.TRIANGULAR_HEAD, Card.STRIPED_BUTT, Card.CIRCULAR_BUTT, Card.STRIPED_HEAD);
		return cards;
	}
	
	public static boolean check(Card[][] c){
		//TODO: Use a loop
		if (c.length != 3 || c[0].length != 3)
			throw new RuntimeException("Invalid Field passed to Util.check! Must be of Type Card[3][3]!");
		return
		Util.fits(c[0][0].right, c[1][0].left) &&
		Util.fits(c[0][0].bottom, c[0][1].top) &&
		Util.fits(c[1][0].right, c[2][0].left) &&
		Util.fits(c[1][0].bottom, c[1][1].top) &&
		Util.fits(c[2][0].bottom, c[2][1].top) &&

		Util.fits(c[0][1].right, c[1][1].left) &&
		Util.fits(c[0][1].bottom, c[0][2].top) &&
		Util.fits(c[1][1].right, c[2][1].left) &&
		Util.fits(c[1][1].bottom, c[1][2].top) &&
		Util.fits(c[2][1].bottom, c[2][2].top) &&

		Util.fits(c[0][2].right, c[1][2].left) &&
		Util.fits(c[1][2].right, c[2][2].left);
		
	}
	
	public static boolean equalsAny(int a, int... ints){
		boolean result = false;
		for (int i = 0; i < ints.length && !result; i++){
			if (a == ints[i]) result = true;
		}
		return result;
	}
	
	public static void printRotations(Card[] cards){
		String result = "";
		for (int i = 0; i < cards.length; i++){
			result = result + "[" + cards[i].rotation + "]";
		}
		output(result);
	}
	
	public static void printBoard(Card[][] board){
		String[] strings = new String[board[0].length*5];
		for (int i = 0; i < strings.length; i++){
			strings[i] = "";
		}
		String[] current = new String[5];
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				current = board[i][j].print(false);
				for (int k = 0; k < current.length; k++){
					strings[k + i * 5] = strings[k + i*5] + current[k];
				}
			}
		}
		for (String s : strings){
			output(s);
		}
		output(System.lineSeparator());
	}

	public static void output(String line){
		System.out.println(line);
		if (outputBuilder == null) outputBuilder = new StringBuilder();
		outputBuilder.append(line + System.lineSeparator());
		App.writesPending++;
		if (App.writesPending==10){
			App.appendStringBuilder(new File("Log.txt"), outputBuilder);
			outputBuilder = new StringBuilder();
			App.writesPending = 0;
		}
	}
	
	public static void appendStringBuilder(File out, StringBuilder in){
		StringBuilder result = App.readStringBuilder(out);
//		result.append(System.lineSeparator());
		result.append(in);
		App.writeStringBuilder(out, result);
	}
	
	public static void writeStringBuilder (File out, StringBuilder in){
		BufferedWriter writer;
		try {
	    	writer = new BufferedWriter(new FileWriter(out));
			writer.append(in);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}

	public static void writeString (File out, String in){
		BufferedWriter writer;
		try {
	    	writer = new BufferedWriter(new FileWriter(out));
			writer.append(in);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}
	
	public static StringBuilder readStringBuilder (File in) {
	    StringBuilder text = new StringBuilder();
	    int read, N = 1024 * 1024;
	    char[] buffer = new char[N];

	    try {
	        FileReader fr = new FileReader(in);
	        BufferedReader br = new BufferedReader(fr);

	        while(true) {
	            read = br.read(buffer, 0, N);
	            text.append(new String(buffer, 0, read));

	            if(read < N) {
	            	br.close();
	                break;
	            }
	        }
	    } catch(Exception e) {
	    }

	    return text;
	}
	
	public static Card[] getUnusedCards(Card2[] cards){
		ArrayList<Card2> result = new ArrayList<Card2>();
		for (Card2 card : cards){
			if (!card.used) result.add(card);
		}
		return (Card[])result.toArray();
	}
	
	public static Card[] getFittingCards(Card center, int direction, Card[] availableCards){
		ArrayList<Card> result = new ArrayList<Card>();
		switch(direction){
		case Card.LEFT:
			for (Card card : availableCards){
				if (Util.fits(center.right, card.left)) result.add(card);
			}
			break;
		case Card.TOP:
			for (Card card : availableCards){
				if (Util.fits(center.top, card.bottom)) result.add(card);
			}
			break;
		case Card.RIGHT:
			for (Card card : availableCards){
				if (Util.fits(center.right, card.left)) result.add(card);
			}
			break;
		case Card.BOTTOM:
			for (Card card : availableCards){
				if (Util.fits(center.bottom, card.top)) result.add(card);
			}
			break;
		default:
			throw new RuntimeException("Wrong direction given to getFittingCards! Must be one of Card.LEFT, Card.TOP, Card.RIGHT, Card.BOTTOM!");
		}
		return (Card[])result.toArray();
	}
	
	public static String getTypeString(int type){
		switch(type){
		case Card.NAKED_BUTT: return "NB";
		case Card.NAKED_HEAD: return "NH";
		case Card.STRIPED_BUTT: return "SB";
		case Card.STRIPED_HEAD: return "SH";
		case Card.TRIANGULAR_BUTT: return "TB";
		case Card.TRIANGULAR_HEAD: return "TH";
		case Card.CIRCULAR_BUTT: return "CB";
		case Card.CIRCULAR_HEAD: return "CH";
		default: return "NA";
		}
	}
	
	public static boolean fits(int type1, int type2){
		if (isOdd(type1)) return type1 - 1 == type2;
		else return type1 + 1 == type2;
	}

	public static boolean isOdd(int i){
		return i % 2 == 1;
	}
}
