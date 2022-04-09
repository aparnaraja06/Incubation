package middle.pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import customexception.CustomException;

public class MiddlePattern {

	public String middlePattern(String word) throws CustomException {
		if (word == null || word.isEmpty()) {
			throw new CustomException("Input cannot be null or empty");
		}

		int length = word.length();
		int start = 0;
		int mid = (start + length) / 2;
		String result = "";
		String changeOrder = word.substring(mid, length) + word.substring(start, mid) + " ";

		for (int i = start; i < length; i++) {
			result += changeOrder.substring(start, i + 1) + "$" + " ";
		}
		return result;
	}

	public String remainingStr(String word, char character, int count) throws CustomException {
		if (word == null || word.isEmpty()) {
			throw new CustomException("Input cannot be null or empty");
		}

		if (count < 0) {
			throw new CustomException("Count should be in positive number");
		}

		int index = word.indexOf(character);
		if (index == -1) {
			throw new CustomException("Character not available");
		}
		int count1 = 0;
		int index1 = 0;
		String result = "";
		int length = word.length();
		for (int i = 0; i < length; i++) {
			if (word.charAt(i) == character) {
				count1++;
				index1 = i;

			}
			if (count1 == count) {
				result = word.substring(index1 + 1, length);
			}
		}
		if (result.isEmpty()) {
			result = "EmptyString";
		}
		return result;

	}

	public String reverseEach(String word) throws CustomException {
		if (word == null || word.isEmpty()) {
			throw new CustomException("Input cannot be null or empty");
		}

		String[] words = word.split("\\.");
		int length=words.length;
		String last=words[length-1];

		String result = "";
		for (String each : words) {
             
			if(each.equals(last))
			{
				result+=reverse(each);
			}
			else
			{
			result += reverse(each)+'.';
			}
		}

		return result;
	}

	public String reverse(String word) {
		String result = "";
		for (int i = (word.length() - 1); i >= 0; --i) {
			result += word.charAt(i);
		}
		return result;
	}

	public String reverseSpace(String word) throws CustomException {
		if (word == null || word.isEmpty()) {
			throw new CustomException("Input cannot be null or empty");
		}

		char[] char_arr = word.toCharArray();
		int length = (char_arr.length) - 1;
		int start = 0;
		while (start < length) {
			if (char_arr[start] == ' ') {
				start++;
				continue;
			}
			if (char_arr[length] == ' ') {
				length--;
				continue;
			} else {
				char temp = char_arr[start];
				char_arr[start] = char_arr[length];
				char_arr[length] = temp;
			}
			start++;
			length--;
		}
		String result = new String(char_arr);
		return result;
	}

	public boolean kPangram(String word, int count) throws CustomException {
		if (word == null || word.isEmpty()) {
			throw new CustomException("Input cannot be null or empty");
		}

		if (count < 0) {
			throw new CustomException("Operations should be in positive number");
		}

		String temp = word.replaceAll(" ", "");
		int count1 = 0;
		boolean result = false;
		int count2 = 0;
		boolean[] alphabet = new boolean[26];
		int index = 0;
		for (int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) >= 'a' && temp.charAt(i) <= 'z') {
				index = temp.charAt(i) - 'a';
				count1++;
			}
			alphabet[index] = true;
		}
		for (int i = 0; i < 26; i++) {
			if (alphabet[i] == false) {
				count2++;
			}

		}
		if (count2 <= count && count1 >= 26) {
			result = true;
		}
		return result;

	}

	public int maximumChar(String word) throws CustomException {
		int store=0;
		
		for(int i=0;i<word.length();i++)
		{
			store=Math.max(store, word.lastIndexOf(word.charAt(i)-i));
		}
		return store-1;
	}

	public String shuffleString(String word, int[] int_arr) throws CustomException {
		if (word == null || word.isEmpty()) {
			throw new CustomException("Input cannot be null or empty");
		}
		if (int_arr == null) {
			throw new CustomException("Input array cannot be null");
		}
		int length = word.length();

		if (length != int_arr.length) {
			throw new CustomException("both word and indices length should be equal");
		}

		char[] char_arr = new char[length];
		int j = 0;
		for (int index : int_arr) {
			char_arr[index] += word.charAt(j);
			j++;
		}
		String result = new String(char_arr);
		return result;
	}

	public boolean twoStrArray(String[] word1, String[] word2) throws CustomException {
		if (word1 == null || word2 == null) {
			throw new CustomException("Input array cannot be null");
		}

		String first = "";
		String second = "";
		boolean result = false;

		for (int i = 0; i < word1.length; i++) {
			first += word1[i];
		}
		for (int i = 0; i < word2.length; i++) {
			second += word2[i];
		}

		if (first.equals(second)) {
			result = true;
		}
		return result;
	}

	public String crossChar(String word) throws CustomException {
		if (word == null || word.isEmpty()) {
			throw new CustomException("Input cannot be null or empty");
		}
		int length = word.length();
		String result = "";

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (i == j || i + j == length - 1) {
					result += word.charAt(j) + " ";
				}

			}
		}
		return result;
	}

	public List<String> findPermutation(String word) throws CustomException {
		List<String> list = new ArrayList<>();

		if (word == null || word.isEmpty()) {
			throw new CustomException("Input cannot be null or empty");
		}

		char[] char_arr = word.toCharArray();
		Arrays.sort(char_arr);
		String sortStr = new String(char_arr);
		permutation("", sortStr, list);
		return list;

	}

	public void permutation(String addStr, String sortStr, List<String> list) {

		if (sortStr.length() == 0) {
			System.out.println("added");
			list.add(addStr);

		} 
			for (int i = 0; i < sortStr.length(); i++) {
				
				System.out.println("i:"+i+" add:"+sortStr);
				System.out.println("first "+addStr);
				permutation(addStr + sortStr.charAt(i), sortStr.substring(0, i) + sortStr.substring(i + 1), list);
			}

	}

	public List<List<String>> anagram(String[] words) throws CustomException {
		if (words == null) {
			throw new CustomException("Input should not be null");
		}
		List<List<String>> list = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();

		for (String word : words) {
			char[] char_arr = word.toCharArray();
			Arrays.sort(char_arr);
			String result = new String(char_arr);

			if (map.containsKey(result)) {
				List<String> temp = map.get(result);
				temp.add(word);
			} else {
				List<String> tempList = new ArrayList<>();
				tempList.add(word);
				map.put(result, tempList);
			}
		}
		list.addAll(map.values());
		return list;
	}

	public int wordBreak(String word, List<String> words) throws CustomException {

		int length = word.length();

		if (length == 0) {
			return 1;
		}
		for (int i = 1; i <= length; i++) {
			String first = word.substring(0, i);
			 //System.out.println("first"+first+"balance"+word.substring(i));
			// words.contains(first));
			if (words.contains(first) && (wordBreak(word.substring(i), words) == 1)) {
				return 1;
			}
		}
		return 0;

	}

	public int totalDecoding(String word) throws CustomException {
		if (word == null || word.isEmpty()) {
			throw new CustomException("Input cannot be empty or null");
		}

		int length = word.length();
		char[] char_arr = word.toCharArray();
		long modulo = 1000000007;
		long[] store = new long[length + 1];

		store[0] = store[1] = 1;

		for (int i = 1; i < length; i++) {
			if (char_arr[i] == '0' && char_arr[i - 1] > '2') {
				return 0;
			}
		}

		for (int i = 2; i <= length; i++) {
			if (char_arr[i - 1] > '0') {
				store[i] = store[i - 1];
			}

			if (char_arr[i - 2] == '1' || char_arr[i - 2] == '2' && char_arr[i - 1] < '7') {
				store[i] += store[i - 2];
			}

			store[i] %= modulo;
		}

		int result = (int) store[length];
		return result;
	}

}
