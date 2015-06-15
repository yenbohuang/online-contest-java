package org.yenbo.onlinecontest.sourcea;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class Welcome {

	@Test
	public void test() {
		
		ArrayList<String> inputFromConsole = new ArrayList<String>();
		inputFromConsole.add("1");
		inputFromConsole.add("2 3");
		inputFromConsole.add("abc");
		
		Assert.assertEquals("6 abc", Main.answer(inputFromConsole));
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
			
			// read test case from console
			ArrayList<String> inputFromConsole = new ArrayList<String>();
			inputFromConsole.add(sc.nextLine());
			inputFromConsole.add(sc.nextLine());
			inputFromConsole.add(sc.nextLine());
			
			// output answer to console for online judgement
			System.out.println(answer(inputFromConsole));
			
			sc.close();
		}
		
		/**
		 * A testable method for JUnit.
		 * 
		 * @param inputFromConsole
		 * @return
		 */
		public static String answer(ArrayList<String> inputFromConsole) {
			
			int a = Integer.parseInt(inputFromConsole.get(0));
			
			String[] tokens = inputFromConsole.get(1).split(" ");
			
			int b = Integer.parseInt(tokens[0]);
			int c = Integer.parseInt(tokens[1]);
			
			return String.format("%d %s", a + b + c, inputFromConsole.get(2));
		}
	}
}
