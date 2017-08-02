package com.test.distance;

import java.util.Arrays;

public class SwapDistance {

	/**
	 * Get the numeric position of a char for latin alphabet (upper case). Ex.:
	 * A -> 1, N -> 14
	 */
	public static int getNumericPosition(char c) {
		return (int) c - 64;
	}

	/**
	 * Get the numeric representation of a char array. Ex.: [A,N,N,E] ->
	 * [1,14,14,5]
	 */
	public static int[] getNumericRepresentation(char[] chars) {
		int[] nums = new int[chars.length];
		for (int i = 0; i < chars.length; i++) {
			nums[i] = getNumericPosition(chars[i]);
		}
		return nums;
	}
	
	public static boolean isAnagram(char[] word1, char[] word2) {
	     Arrays.sort(word1);
	     Arrays.sort(word2);
	     return Arrays.equals(word1, word2);
	}

	/**
	 * Calculate the minimum number of adjacent character swaps required to make
	 * the two strings the same Require strings in upper case The two strings
	 */
	public static int getMinNumAdjCharSwaps(String str1, String str2) {
		char[] word1 = str1.toCharArray();
		char[] word2 = str2.toCharArray();
		
		if(isAnagram(str1.toCharArray(), str2.toCharArray())){
			// Latin alphabet length
			int alphLen = 26;
			int strLen = word1.length;
			
			// Transform strings to numeric representation
			int[] num1 = getNumericRepresentation(word1);
			int[] num2 = getNumericRepresentation(word2);
				
			// Inverse of str2
			int[] inv = new int[alphLen];
			for (int i = 0; i < strLen; i++) {
				inv[num2[i]] = i;
			}
	
			// Calculate adjacent swaps
			int similarity = 100;
			for (int i = 0; i < strLen; i++) {
				for (int j = i + 1; j < strLen; j++) {
					// Check if num1[i] and num1[j] are inverted
					if (inv[num1[i]] > inv[num1[j]]){
						System.out.println("i :"+i+", j: "+j+", num1[i]: "+num1[i]+", num1[j]: "+num1[j]+", inv[num1[i]]: "+inv[num1[i]]+", inv[num1[j]]: "+inv[num1[j]]);					
						similarity -= 5;
					}
				}
			}
			
			if (similarity < 0) {
				similarity = 0;
			}
			return similarity; 
		}
		else{
			return 0;
		}
	}

	
	/**
	 * Main class with challenge test cases
	 */
	public static void main(String[] args) {
		// TEST CASES
		System.out.println("(\"ABCDEF\", \"ABCDEF\") returns " + SwapDistance.getMinNumAdjCharSwaps("ABCDEF", "ABCDEF"));
		System.out.println();
		System.out.println("(\"ABCDEF\", \"BBCDEF\") returns " + SwapDistance.getMinNumAdjCharSwaps("ABCDEF", "BBCDEF"));
		System.out.println();
		System.out.println("(\"BBDCEF\", \"BBCDEF\") returns " + SwapDistance.getMinNumAdjCharSwaps("BBDCEF", "BBCDEF"));
		System.out.println();
		System.out.println("(\"HARRIS\", \"HARIRS\") returns " + SwapDistance.getMinNumAdjCharSwaps("HARRIS", "HARIRS"));
		System.out.println();
		System.out.println("(\"HARRIS\", \"HRARIS\") returns " + SwapDistance.getMinNumAdjCharSwaps("HARRIS", "HRARIS"));
		System.out.println();
		System.out.println("(\"BACDFE\", \"ABCDEF\") returns " + SwapDistance.getMinNumAdjCharSwaps("BACDFE", "ABCDEF"));
		System.out.println();
		System.out.println("(\"ABCFDE\", \"ABCDEF\") returns " + SwapDistance.getMinNumAdjCharSwaps("ABCFDE", "ABCDEF"));
		System.out.println();
		System.out.println("(\"ANNE\", \"ENNA\") returns " + SwapDistance.getMinNumAdjCharSwaps("ANNE", "ENNA"));
		System.out.println();
		System.out.println("(\"FEDCBA\", \"ABCDEF\") returns " + SwapDistance.getMinNumAdjCharSwaps("FEDCBA", "ABCDEF"));
		System.out.println();
		System.out.println("(\"GFEDCBA\", \"ABCDEFG\") returns " + SwapDistance.getMinNumAdjCharSwaps("GFEDCBA", "ABCDEFG"));
		System.out.println();
	}

}
