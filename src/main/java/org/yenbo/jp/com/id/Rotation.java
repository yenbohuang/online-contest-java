package org.yenbo.jp.com.id;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class Rotation {

	@Test
	public void test1() {
		
		ArrayList<String> rotations = new ArrayList<String>();
		rotations.add("2 4 1");
		rotations.add("1 5 2");
		
		Assert.assertEquals("ceadb", Main.answer("abcde", rotations));
	}
	
	@Test
	public void test2() {
		
		ArrayList<String> rotations = new ArrayList<String>();
		rotations.add("7 10 63");
		rotations.add("8 8 7");
		rotations.add("7 10 58");
		rotations.add("4 10 26");
		rotations.add("3 5 75");
		rotations.add("3 4 60");
		rotations.add("6 9 21");
		rotations.add("1 10 15");
		rotations.add("3 3 81");
		rotations.add("7 10 20");
		rotations.add("7 8 37");
		rotations.add("2 3 34");
		rotations.add("3 9 8");
		rotations.add("2 2 63");
		rotations.add("6 10 1");
		rotations.add("1 8 95");
		rotations.add("5 7 94");
		rotations.add("3 4 27");
		rotations.add("5 7 32");
		rotations.add("4 7 60");
		
		Assert.assertEquals("vkidskofbk", Main.answer("okbfkkvdis", rotations));
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
			
			ArrayList<String> rotations = new ArrayList<String>();
			
			sc.nextLine(); // length of String, skip
			
			String source = sc.nextLine();
			
			int numOfRotations = Integer.parseInt(sc.nextLine());
			
			for (int i = 0; i < numOfRotations; i++) {
				rotations.add(sc.nextLine());
			}
			
			System.out.println(answer(source, rotations));
			
			sc.close();
		}
		
		/**
		 * A testable method for JUnit.
		 * 
		 * @param inputFromConsole
		 * @return
		 */
		public static String answer(String source, ArrayList<String> rotations) {
			
			char[] charArra = source.toCharArray();
			
			for (String r: rotations) {
				
				String[] tokens = r.split(" ");
				int nL = Integer.parseInt(tokens[0]);
				int nR = Integer.parseInt(tokens[1]);
				int nK = Integer.parseInt(tokens[2]);
				
				for (int i = 0; i < nK; i++) {
					
					char tmp = charArra[nR - 1];
					
					for (int j = nR - 1; j > nL - 1; j--) {
						charArra[j] = charArra[j - 1];
					}
					
					charArra[nL - 1] = tmp;
				}
			}
			
			return new String(charArra);
		}
	}
}
