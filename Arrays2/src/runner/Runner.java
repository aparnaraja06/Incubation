package runner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import customexception.CustomException;
import reader.Reader;

public class Runner {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Reader reader = new Reader();

		System.out.println("Enter the option");
		int option = scanner.nextInt();
		scanner.nextLine();

		switch (option) {
		case 1: {
			System.out.println("Enter the size of array");
			int num = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the values");
			int[] int_arr = new int[num];
			for (int i = 0; i < num; i++) {
				int_arr[i] = scanner.nextInt();
			}
			try {
				List<Integer> list = reader.rotateArray(int_arr);
				System.out.println(list);
			} catch (CustomException e) {
				System.out.println(e.getMessage());
			}
		}

		case 2: {
			System.out.println("Enter the size of array");
			int num = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the values");
			int[] int_arr = new int[num];
			for (int i = 0; i < num; i++) {
				int_arr[i] = scanner.nextInt();
			}
			System.out.println("Enter sum");
			int sum = scanner.nextInt();
			scanner.nextLine();
			try {
				int[] arr = reader.closestSum(int_arr, sum, num);
				for (int i = 0; i < 2; i++) {
					System.out.print(arr[i] + " ");
				}
			} catch (CustomException e) {
				System.out.println(e.getMessage());
			}

		}

		case 3: {
			System.out.println("Enter the size of array");
			int num = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the values");
			int[] int_arr = new int[num];
			for (int i = 0; i < num; i++) {
				int_arr[i] = scanner.nextInt();
			}
			try {
				int[] arr = reader.rotateLength(int_arr);
				for (int i = 0; i < num; i++) {
					System.out.print(arr[i]);
				}
			} catch (CustomException e) {
				System.out.println(e.getMessage());
			}
		}

		case 4: {
			System.out.println("Enter the size of array 1");
			int num1 = scanner.nextInt();
			ArrayList<Integer> list1 = new ArrayList<>();
			System.out.println("Enter the values");
			for (int i = 0; i < num1; i++) {
				list1.add(scanner.nextInt());
			}
			System.out.println("Enter the size of array 2");
			int num2 = scanner.nextInt();
			ArrayList<Integer> list2 = new ArrayList<>();
			System.out.println("Enter the values");
			for (int i = 0; i < num2; i++) {
				list2.add(scanner.nextInt());
			}

			try {
				HashSet<Integer> union = reader.union(list1, list2);
				System.out.println(union);
				ArrayList<Integer> intersect = reader.intersect(list1, list2);
				System.out.println(intersect);
				ArrayList<Integer> except = reader.except(list1, list2);
				System.out.println(except);
			} catch (CustomException e) {
				System.out.println(e.getMessage());
			}
		}
		
		case 5:
		{
			System.out.println("Enter the size of array");
			int num = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the values");
			int[] int_arr = new int[num];
			for (int i = 0; i < num; i++) {
				int_arr[i] = scanner.nextInt();
			}
			try {
				reader.numOfTimes(int_arr);
			}
			catch (CustomException e) {
				System.out.println(e.getMessage());
			}

		}
		
		case 6:
		{
			System.out.println("Enter the size of array 1");
			int num1 = scanner.nextInt();
			ArrayList<Integer> list1 = new ArrayList<>();
			System.out.println("Enter the values");
			for (int i = 0; i < num1; i++) {
				list1.add(scanner.nextInt());
			}
			try {
				int result=reader.largestProduct(list1);
				System.out.println(result);
			}
			catch (CustomException e) {
				System.out.println(e.getMessage());
			}
		}
		
		case 7:
		{
			System.out.println("Enter the number");
			int num=scanner.nextInt();
			scanner.nextLine();
			try
			{
				int result=reader.perfectNumber(num);
				System.out.println(result);
			}
			catch (CustomException e) {
				System.out.println(e.getMessage());
			}

		}
		
		case 8:
		{
			System.out.println("Enter the size of array");
			int num = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the values");
			int[] int_arr = new int[num];
			for (int i = 0; i < num; i++) {
				int_arr[i] = scanner.nextInt();
			}
			try {
				int[] arr=reader.minimumDifference(int_arr, num);
				for(int i=0;i<2;i++)
				{
				System.out.println(arr[i]);
				}
			}
			catch (CustomException e) {
				System.out.println(e.getMessage());
			}

		}
		
		case 9:
		{
			System.out.println("Enter the size of array");
			int num = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the values");
			int[] int_arr = new int[num];
			for (int i = 0; i < num; i++) {
				int_arr[i] = scanner.nextInt();
			}
			System.out.println("Enter the sum");
			int sum=scanner.nextInt();
			scanner.nextLine();
			try {
				ArrayList<Integer> list=reader.sumPair(int_arr, sum);
				System.out.println(list);
			}
			catch (CustomException e) {
				System.out.println(e.getMessage());
			}

		}
		
		case 10:
		{
			System.out.println("Enter the size of array");
			int num = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the values");
			int[] int_arr = new int[num];
			for (int i = 0; i < num; i++) {
				int_arr[i] = scanner.nextInt();
			}
			System.out.println("Enter the number of rotation");
			int rotate=scanner.nextInt();
			scanner.nextLine();
			try
			{
				int[] arr=reader.leftRotate(int_arr, rotate);
				for(int i=0;i<num;i++)
				{
				System.out.print(arr[i]);
				}
			}
			catch (CustomException e) {
				System.out.println(e.getMessage());
			}
		}
		
		case 11:
		{
			System.out.println("Enter the size of array");
			int num = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the values of array 1");
			char[] int_arr1= new char[num];
			for (int i = 0; i < num; i++) {
				int_arr1[i] = scanner.next().charAt(0);
			}
			System.out.println("Enter the values of array 2");
			char[] int_arr2= new char[num];
			for (int i = 0; i < num; i++) {
				int_arr2[i] = scanner.next().charAt(0);
			}
			try
			{
				ArrayList<String> list=reader.misMatchElement(int_arr1, int_arr2);
				System.out.println(list);
			}
			catch (CustomException e) {
				System.out.println(e.getMessage());
			}

		}
		
		case 12:
		{
			System.out.println("Enter the size of array");
			int num = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the values");
			int[] int_arr = new int[num];
			for (int i = 0; i < num; i++) {
				int_arr[i] = scanner.nextInt();
			}
			try
			{
				boolean result=reader.nonDecreasingArray(int_arr);
				System.out.println(result);
			}
			catch (CustomException e) {
				System.out.println(e.getMessage());
			}

		}
		case 13:
		{
			System.out.println("Enter the size of array");
			int num = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the values");
			int[] int_arr = new int[num];
			for (int i = 0; i < num; i++) {
				int_arr[i] = scanner.nextInt();
			}
			try
			{
				reader.pattern(int_arr);
			}catch (CustomException e) {
				System.out.println(e.getMessage());
			}
		}
		
		case 14:
		{
			System.out.println("Enter the size of array");
			int num = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the values");
			int[] int_arr = new int[num];
			for (int i = 0; i < num; i++) {
				int_arr[i] = scanner.nextInt();
			}
			try
			{
				int result=reader.longestSubSequence(int_arr, num);
				System.out.println(result);
			}
			catch (CustomException e) {
				System.out.println(e.getMessage());
			}
		}
		
		case 15:
		{
			System.out.println("Enter the size of array");
			int num = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the values");
			int[] int_arr = new int[num];
			for (int i = 0; i < num; i++) {
				int_arr[i] = scanner.nextInt();
			}
			System.out.println("Enter mid value");
			int mid=scanner.nextInt();
			scanner.nextLine();
			try
			{
				int result=reader.chocolate(int_arr, mid);
				System.out.println(result);
			}
			catch (CustomException e) {
				System.out.println(e.getMessage());
			}

		}
		
		case 16:
		{
			Map<String,List<String>> map=new HashMap<>();
			
			System.out.println("Enter the number of values");
			int num=scanner.nextInt();
			scanner.nextLine();
		    for(int i=0;i<num;i++)
			{
		    	System.out.println("Enter son name");
		    	String son=scanner.nextLine();
		    	System.out.println("Enter father name");
		    	String father=scanner.nextLine();
				if(map.get(father)!=null)
				{
					map.get(father).add(son);
				}
				else
				{
					List<String> list=new ArrayList<String>();
					list.add(son);
					map.put(father, list);
				}
			}
		    System.out.println("Enter the name ");
		    String name=scanner.nextLine();
		    System.out.println("Enter level");
		    int level=scanner.nextInt();
		    scanner.nextLine();
		    try
		    {
		    	int result=reader.grandsons(map, name, level);
		    	System.out.println(result);
		    }
		    catch (CustomException e) {
				System.out.println(e.getMessage());
			}
		}
		
		case 17:
		{
			System.out.println("Enter the size of array");
			int num = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the values");
			int[] int_arr = new int[num];
			for (int i = 0; i < num; i++) {
				int_arr[i] = scanner.nextInt();
			}
            try
            {
            	int[] arr=reader.ascendingSum(int_arr, num);
            	for(int i=0;i<arr.length;i++)
            	{
            	System.out.print(arr[i]+" ");
            	}
            }
            catch (CustomException e) {
				System.out.println(e.getMessage());
			}
		}
		
		case 18:
		{
			System.out.println("Enter the size of array");
			int num = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the values");
			int[] int_arr = new int[num];
			for (int i = 0; i < num; i++) {
				int_arr[i] = scanner.nextInt();
			}
			System.out.println("Enter the sum");
			int sum=scanner.nextInt();
			scanner.nextLine();
            try
            {
            	int arr=reader.NCents(int_arr, num, sum);
            	System.out.println(arr);
     
            }
            catch (CustomException e) {
				System.out.println(e.getMessage());
			}
		}
		
		}
	}
}
