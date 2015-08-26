package org.yenbo.linecode.todo.easy;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

public class HashFunction {

	@Test
	public void test1() {
		Assert.assertEquals(78, hashCode("abcd".toCharArray(), 100));
	}

	@Test
	public void test2() {
		Assert.assertEquals(549, hashCode("ubuntu".toCharArray(), 1007));
	}

	@Test
	public void test3() {
		Assert.assertEquals(1673,
				hashCode("abcdefghijklmnopqrstuvwxyz".toCharArray(), 2607));
	}

	@Test
	public void test4() {
		Assert.assertEquals(382528955,
				hashCode("Wrong answer or accepted?".toCharArray(), 1000000007));
	}
	
	@Test
	public void test5() {
		
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < 200; i++) {
			builder.append("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
		}
		
		Assert.assertEquals(38011322,hashCode(builder.toString().toCharArray(),1000000007));
	}
	
	public int hashCode(char[] key, int HASH_SIZE) {

		// TODO poor performance
		BigInteger answer = BigInteger.valueOf(0);
		int size = key.length;

		for (int i = 0; i < size; i++) {
			answer = answer.add(BigInteger.valueOf(key[i]).multiply(BigInteger.valueOf(33).pow(size - i - 1)));
		}

		return answer.mod(BigInteger.valueOf(HASH_SIZE)).intValue();
	}
	
	public int hashCodeOverflow(char[] key, int HASH_SIZE) {

		// TODO overflow
		int answer = 0;
		int size = key.length;

		for (int i = 0; i < size; i++) {
			answer += key[i] * Math.pow(33, size - i - 1);
		}

		return answer % HASH_SIZE;
	}
}
