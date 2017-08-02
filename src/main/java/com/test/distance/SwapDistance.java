package com.test.distance;

import java.util.ArrayList;
import java.util.Arrays;

public class SwapDistance {

	/**
	 * Get the numeric position of a char for latin alphabet (upper case). Ex.:
	 * A -> 0, N -> 13
	 */
	public static int getNumericPosition(char c) {
		return (int) c - 65;
	}

	/**
	 * Get the numeric representation of a char array. Ex.: [A,N,N,E] ->
	 * [0,13,13,4]
	 */
	public static int[] getNumericRepresentation(char[] chars) {
		int[] nums = new int[chars.length];
		for (int i = 0; i < chars.length; i++) {
			nums[i] = getNumericPosition(chars[i]);
		}
		return nums;
	}

	/**
	 * Check if the strings are anagrams in O(n log(n))
	 * */
	public static boolean isAnagram(String str1, String str2) {
		char[] word1 = str1.toCharArray();
		char[] word2 = str2.toCharArray();
		Arrays.sort(word1);
		Arrays.sort(word2);
		return Arrays.equals(word1, word2);
	}

	
	/**
	 * Calculate the similarity of two strings by calculating the
	 * minimum number of adjacent character swaps required to make
	 * the two strings the same.
	 */
	public static int getSimilarity(String str1, String str2) {
		if (isAnagram(str1, str2)) {
			char[] word1 = str1.toCharArray();
			char[] word2 = str2.toCharArray();

			// Latin alphabet length
			int alphLen = 26;
			int strLen = word1.length;

			// Transform strings to numeric representation
			int[] num1 = getNumericRepresentation(word1);
			int[] num2 = getNumericRepresentation(word2);

			ArrayList<Integer>[] inverse = (ArrayList<Integer>[]) new ArrayList[alphLen];

			// Inverse of str1
			for (int i = 0; i < strLen; i++) {
				if (inverse[num1[i]] == null) {
					ArrayList<Integer> tmpArray = new ArrayList<Integer>();
					tmpArray.add(i);
					inverse[num1[i]] = tmpArray;
				} else {
					inverse[num1[i]].add(i);
				}
			}

			int[] num2Inv = new int[strLen];
			for (int i = 0; i < strLen; i++) {
				num2Inv[i] = inverse[num2[i]].remove(0);
				//System.out.println("num2Inv: " + num2Inv[i]);
			}
			
			int similarity = 100;
			for(int i = 0; i < num2Inv.length; i++){
		        for(int j = i; j < num2Inv.length; j++){
		            //System.out.println("i: "+num2Inv[i]+", j: "+num2Inv[j]);
		            if(num2Inv[i] > num2Inv[j]){
		            	similarity -= 5;
		            }
		        }
		    }

			if (similarity < 0) {
				similarity = 0;
			}
			return similarity;
		} else {
			return 0;
		}
	}

	/**
	 * Main class with challenge test cases
	 */
	public static void main(String[] args) {
		// TEST CASES
		System.out
				.println("(\"ABCDEF\", \"ABCDEF\") returns " + SwapDistance.getSimilarity("ABCDEF", "ABCDEF"));
		System.out
				.println("(\"ABCDEF\", \"BBCDEF\") returns " + SwapDistance.getSimilarity("ABCDEF", "BBCDEF"));
		System.out
				.println("(\"BBDCEF\", \"BBCDEF\") returns " + SwapDistance.getSimilarity("BBDCEF", "BBCDEF"));
		System.out
				.println("(\"HARRIS\", \"HARIRS\") returns " + SwapDistance.getSimilarity("HARRIS", "HARIRS"));
		System.out
				.println("(\"HARRIS\", \"HRARIS\") returns " + SwapDistance.getSimilarity("HARRIS", "HRARIS"));
		System.out
				.println("(\"BACDFE\", \"ABCDEF\") returns " + SwapDistance.getSimilarity("BACDFE", "ABCDEF"));
		System.out
				.println("(\"ABCFDE\", \"ABCDEF\") returns " + SwapDistance.getSimilarity("ABCFDE", "ABCDEF"));
		System.out.println("(\"ANNE\", \"ENNA\") returns " + SwapDistance.getSimilarity("ANNE", "ENNA"));
		System.out
				.println("(\"FEDCBA\", \"ABCDEF\") returns " + SwapDistance.getSimilarity("FEDCBA", "ABCDEF"));
		System.out.println(
				"(\"GFEDCBA\", \"ABCDEFG\") returns " + SwapDistance.getSimilarity("GFEDCBA", "ABCDEFG"));
	}

}
