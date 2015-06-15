package org.yenbo.onlinecontest.sourcea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class Ball {

	@Test
	public void test() {
		
		ArrayList<String> inputFromConsole = new ArrayList<String>();
		inputFromConsole.add("1 2");
		inputFromConsole.add("2 3");
		inputFromConsole.add("3 4");
		inputFromConsole.add("4 1");
		
		Assert.assertEquals("1 4 2 3 5 6 7 8", Main.answer(2, inputFromConsole));
	}
	
	@Test
	public void test1() {
		
		// TODO performance issue
		ArrayList<String> inputFromConsole = new ArrayList<String>();
		inputFromConsole.add("1 3");
		inputFromConsole.add("6 8");
		inputFromConsole.add("3 5");
		inputFromConsole.add("2 6");
		inputFromConsole.add("3 7");
		inputFromConsole.add("3 4");
		inputFromConsole.add("4 7");
		inputFromConsole.add("2 4");
		inputFromConsole.add("1 3");
		inputFromConsole.add("2 7");
		inputFromConsole.add("2 7");
		inputFromConsole.add("2 4");
		inputFromConsole.add("6 7");
		inputFromConsole.add("1 7");
		inputFromConsole.add("3 4");
		inputFromConsole.add("1 6");
		
		Assert.assertEquals("1 8 3 4 5 2 7 6", Main.answer(1000000000, inputFromConsole));
	}
	
	/**
	 * Entry class for online coding test system.
	 * 
	 * TODO Remove "static" when passing to online coding test system.
	 * TODO Remember coping imports for JDK-only packages!
	 * 
	 * @author YENBO.HUANG
	 *
	 */
	public static class Main {

		/**
		 * Entry point of online coding test system.
		 * @param args
		 */
		public static void main(String[] args){
			
			Scanner sc = new Scanner(System.in);
			
			String[] tokens = sc.nextLine().split(" ");
			int numOfOpeations = Integer.parseInt(tokens[0]);
			int numOfSets = Integer.parseInt(tokens[1]);
			
			// read test case from console
			ArrayList<String> inputFromConsole = new ArrayList<String>();
			
			for (int i = 0; i < numOfSets; i++) {
				
				String str = sc.nextLine();
				if (str.length() > 0) {
					inputFromConsole.add(str);
				}
			}
			
			// output answer to console for online judgement
			System.out.println(answer(numOfOpeations, inputFromConsole));
			
			sc.close();
		}
		
		public static String answer(int numOfOpeations, ArrayList<String> inputFromConsole) {
		
			// A testable method for JUnit.
			int[] balls = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
			int numOfSets = inputFromConsole.size();
			
			int[] movePattern = new int[] {0, 1, 2, 3, 4, 5, 6, 7};
			
			for (int i = 0; i < numOfSets; i++) {
				
				String[] tokens = inputFromConsole.get(i).split(" ");
				
				int m = Integer.parseInt(tokens[0]) - 1;
				int n = Integer.parseInt(tokens[1]) - 1;
				
				int tmp = movePattern[n];
				movePattern[n] = movePattern[m];
				movePattern[m] = tmp;
			}
			
			int duplicatedAt = -1;
			
			for (int i = 0; i < numOfOpeations; i++) {
				
				int[] previous = Arrays.copyOf(balls, balls.length);
				
				for (int j = 0; j < movePattern.length; j++) {
					balls[j] = previous[movePattern[j]];
				}
				
				if (balls[0] == 1 &&
						balls[1] == 2 &&
						balls[2] == 3 &&
						balls[3] == 4 &&
						balls[4] == 5 &&
						balls[5] == 6 &&
						balls[6] == 7 &&
						balls[7] == 8) {
					// if the move is duplicated, find a way to skip pointless moves.
					duplicatedAt = i;
					break;
				}
			}
			
			if (duplicatedAt != -1) {
			
				balls = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
				int steps = numOfOpeations % (duplicatedAt + 1);
				
				for (int i = 0; i < steps; i++) {
					
					int[] previous = Arrays.copyOf(balls, balls.length);
					
					for (int j = 0; j < movePattern.length; j++) {
						balls[j] = previous[movePattern[j]];
					}
				}
			}
			
			return String.format("%d %d %d %d %d %d %d %d",
					balls[0],
					balls[1],
					balls[2],
					balls[3],
					balls[4],
					balls[5],
					balls[6],
					balls[7]);
		}
	}
}
