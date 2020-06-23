package org.yenbo.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 * @author user
 *
 */
public class MergeSortedArray {

	@Test
	public void test1() {
		
		int[] nums1 = new int[] {1, 2, 3, 0, 0};
		int[] nums2 = new int[] {4, 5};
		
		mergeSortedArray(nums1, 3, nums2, 2);
		Assert.assertArrayEquals(new int[] {1,2,3,4,5}, nums1);
	}
	
	@Test
	public void test2() {
		
		int[] nums1 = new int[] {1, 3, 4, 6, 0, 0};
		int[] nums2 = new int[] {2, 5};
		
		mergeSortedArray(nums1, 4, nums2, 2);
		Assert.assertArrayEquals(new int[] {1,2,3,4,5,6}, nums1);
	}
	
	@Test
	public void test3() {
		
		int[] nums1 = new int[139];
		nums1[0] = 29;
		nums1[1] = 132;
		nums1[2] = 249;
		nums1[3] = 438;
		nums1[4] = 722;
		nums1[5] = 739;
		nums1[6] = 1294;
		nums1[7] = 1381;
		nums1[8] = 1646;
		nums1[9] = 1935;
		
		int[] nums2 = new int[] {
				20,34,53,66,75,81,97,111,136,164,
				166,175,190,210,231,260,273,288,311,313,
				321,332,335,383,389,391,399,409,427,529,
				530,550,569,571,607,612,613,625,638,671,
				681,687,705,719,720,738,788,791,803,817,
				823,869,931,933,959,977,985,988,988,992,
				996,1008,1025,1028,1046,1054,1103,1113,1118,1128,
				1160,1164,1169,1187,1195,1208,1256,1324,1335,1341,
				1354,1394,1400,1404,1409,1421,1434,1464,1485,1492,
				1492,1510,1528,1546,1552,1565,1567,1570,1584,1592,
				1609,1621,1624,1629,1641,1668,1682,1705,1713,1717,
				1741,1749,1769,1781,1783,1786,1796,1808,1856,1883,
				1889,1889,1894,1900,1904,1931,1933,1942,1953};
		
		mergeSortedArray(nums1, 10, nums2, 129);
		Assert.assertArrayEquals(
				new int[] {
						20,29,34,53,66,75,81,97,111,132,
						136,164,166,175,190,210,231,249,260,273,
						288,311,313,321,332,335,383,389,391,399,
						409,427,438,529,530,550,569,571,607,612,
						613,625,638,671,681,687,705,719,720,722,
						738,739,788,791,803,817,823,869,931,933,
						959,977,985,988,988,992,996,1008,1025,1028,
						1046,1054,1103,1113,1118,1128,1160,1164,1169,1187,
						1195,1208,1256,1294,1324,1335,1341,1354,1381,1394,
						1400,1404,1409,1421,1434,1464,1485,1492,1492,1510,
						1528,1546,1552,1565,1567,1570,1584,1592,1609,1621,
						1624,1629,1641,1646,1668,1682,1705,1713,1717,1741,
						1749,1769,1781,1783,1786,1796,1808,1856,1883,1889,
						1889,1894,1900,1904,1931,1933,1935,1942,1953},
				nums1);
	}
	
	@Test
	public void test4() {
		
		int[] nums1 = new int[] {1,2,3,0,0,0};
		int[] nums2 = new int[] {2,5,6};
		
		mergeSortedArray(nums1, 3, nums2, 3);
		Assert.assertArrayEquals(new int[] {1,2,2,3,5,6}, nums1);
	}
	
	@Test
	public void testShiftFunction() {
		
		int[] nums1 = new int[] {1, 2, 3, 0, 0};
		shift(nums1, 3, 0);
		
		Assert.assertArrayEquals(new int[] {1, 1, 2, 3, 0}, nums1);
	}
	
	public void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        
		for (int i = 0; i < n; i++) {
		
			boolean inserted = false;
			
			for (int j = 0; j < m; j++) {
				
				if (nums1[j] > nums2[i]) {
					shift(nums1, m, j);
					nums1[j] = nums2[i];
					m++;
					inserted = true;
					break;
				}
			}
			
			if (false == inserted) {
				nums1[m] = nums2[i];
				m++;
			}
		}
    }
	
	private void shift(int[] nums , int size, int start) {
		
		for (int i = size; i > start; i--) {
			nums[i] = nums[i - 1];
		}
	}
}
