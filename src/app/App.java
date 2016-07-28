package app;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.io.File;
import java.io.FileReader;

public class App{
	public static long num = 0;
	public static int threadNum = 0;
	public static LocalDateTime start = LocalDateTime.now();
	public static StringBuilder outputBuilder;
	public static int writesPending = 0;
//	public static void main(String[] args){
//		//TODO: Use a loop
//		Card[] cards = initCards();
//		for (int b0 = 0; b0 < 4; b0++){
//			App.startNewRotationThread(cards.clone());
////			App.tryAllRotations(cards);
//			cards[0].rotate();
//		}
//	}
	

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
	
	public static boolean equalsAny(int a, int... ints){
		boolean result = false;
		for (int i = 0; i < ints.length && !result; i++){
			if (a == ints[i]) result = true;
		}
		return result;
	}
	
	public static void tryAllRotations(Card[] cards){
		for (int b1 = 0; b1 < 4; b1++){
			for (int b2 = 0; b2 < 4; b2++){
				for(int b3 = 0; b3 < 4; b3++){
					for (int b4 = 0; b4 < 4; b4++){
						for (int b5 = 0; b5 < 4; b5++){
							for (int b6 = 0; b6 < 4; b6++){
								for (int b7 = 0; b7 < 4; b7++){
									for (int b8 = 0; b8 < 4; b8++){
//										startNewThread(cards);
										tryAllCombinations(cards);
										cards[8].rotate();
//										printRotations(cards);
//										try {
//											Thread.sleep(100);
//										} catch (InterruptedException e) {
//											// TODO Auto-generated catch block
//											e.printStackTrace();
//										}
									}
									cards[7].rotate();
								}
								cards[6].rotate();
							}
							cards[5].rotate();
						}
						cards[4].rotate();
					}
					cards[3].rotate();
				}
				cards[2].rotate();
			}
			cards[1].rotate();
		}
	}
	
	public static void tryAllCombinations(Card[] cards){
		Card[][] c = new Card[3][3];
		for (int a0 = 0; a0 < 9; a0++){
			c[0][0] = cards[a0];
			for (int a1 = 0; a1 < 9; a1++){
				if (!equalsAny(a1, a0)){
					c[0][1] = cards[a1];
					for (int a2 = 0; a2 < 9; a2++){
						if (!equalsAny(a2, a1, a0)){
							c[0][2] = cards[a2];
							for (int a3 = 0; a3 < 9; a3++){
								if(!equalsAny(a3, a2, a1, a0)){
									c[1][0] = cards[a3];
									for(int a4 = 0; a4 < 9; a4++){
										if(!equalsAny(a4, a3, a2, a1, a0)){
											c[1][1] = cards[a4];
											for(int a5 = 0; a5 < 9; a5++){
												if(!equalsAny(a5, a4, a3, a2, a1, a0)){
													c[1][2] = cards[a5];
													for (int a6 = 0; a6 < 9; a6++){
														if (!equalsAny(a6, a5, a4, a3, a2, a1, a0)){
															c[2][0] = cards[a6];
															for (int a7 = 0; a7 < 9; a7++){
																if(!equalsAny(a7, a6, a5, a4, a3, a2, a1, a0)){
																	c[2][1] = cards[a7];
																	for (int a8 = 0; a8 < 9; a8++){
																		if(!equalsAny(a8, a7, a6, a5, a4, a3, a2, a1, a0)){
																			c[2][2] = cards[a8];
																			num++;
																			if (num % 10000000 == 0){
																				Duration d = Duration.between(start, LocalDateTime.now());
																				if (d.getSeconds() != 0){
																					output(num/1000000d + " million combinations in " + d.getSeconds() + " seconds (" + num/d.getSeconds() + " combinations/sec, " + threadNum + " Threads)");																					
																				} else {
																					output("waiting...");
																				}
																			}
//																			num = (num + 1) % 1000000;
//																			if (num == 0) printBoard(c);
																			if (App.check(c)) printBoard(c);
//																			try {
//																				Thread.sleep(100);
//																			} catch (InterruptedException e) {
//																				// TODO Auto-generated catch block
//																				e.printStackTrace();
//																			}
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
						}
					}
				}
			}
		}
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
	
	public static void startNewCombinationThread(Card[] cards){
		class CombinationThread extends Thread{
			private Card[] cards;
			public CombinationThread(Card[] cards){
				this.cards = cards;
			}
			public void run(){
				App.threadNum++;
				App.tryAllCombinations(cards);
				App.threadNum--;
			}
		}
		if (threadNum < 10){
			new CombinationThread(cards.clone()).start();
		} else {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			startNewCombinationThread(cards);
		}
	}
	
	public static void startNewRotationThread(Card[] cards){
		class RotationThread extends Thread{
			private Card[] cards;
			public RotationThread(Card[] cards){
				this.cards = cards;
			}
			public void run(){
				App.threadNum++;
				App.tryAllRotations(cards);
				App.threadNum--;
			}
		}
		new RotationThread(cards).start();
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
}