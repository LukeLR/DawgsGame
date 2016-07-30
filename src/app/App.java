package app;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.io.File;
import java.io.FileReader;

public class App extends Util {
	public static void main(String[] args){
		//TODO: Use a loop
		Card[] cards = initCards();
		for (int b0 = 0; b0 < 4; b0++){
			App.startNewRotationThread(cards.clone());
//			App.tryAllRotations(cards);
			cards[1].rotate();
		}
	}
	
	public static void tryAllRotations(Card[] cards){
//		for (int b1 = 0; b1 < 4; b1++){
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
//			cards[1].rotate();
//		}
	}
	
	public static void tryAllCombinations(Card[] cards){
		Card[][] c = new Card[3][3];
		for (int a0 = 0; a0 < 9; a0++){
			c[1][1] = cards[a0];
			for (int a1 = 0; a1 < 9; a1++){
				if (!equalsAny(a1, a0)){
					c[0][0] = cards[a1];
					for (int a2 = 0; a2 < 9; a2++){
						if (!equalsAny(a2, a1, a0)){
							c[0][1] = cards[a2];
							for (int a3 = 0; a3 < 9; a3++){
								if(!equalsAny(a3, a2, a1, a0)){
									c[0][2] = cards[a3];
									for(int a4 = 0; a4 < 9; a4++){
										if(!equalsAny(a4, a3, a2, a1, a0)){
											c[1][0] = cards[a4];
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
	

}