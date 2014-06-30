package smPackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringManipulation {

	private static String resultS;
	Map<String,Integer> stringCounter = new HashMap<String,Integer>();
	private static String s1,s2=null;


	/**
	 *  Used to get result after String manipulation
	 * @return result String
	 */

	public String ResultString() {
		return resultS;
	}

	/**
	 * Comparison of the two input string.
	 * 
	 * @param s1 String parameter 1
	 * @param s2 String parameter 2
	 */

	private void compare(String s1,String s2) {

		if(s1.length()==s2.length()) {

			System.out.println("MERGING THE STRINGS :-");
			resultS=merge(s1,s2);

		}else if(s1.length()<s2.length()){

			System.out.println("REVERSING THE STRINGS :-");
			resultS= reverse(s1) + "\tAND"+ " " + reverse(s2);

		}else if(s1.length()>s2.length()){

			System.out.println("MERGING OF THE TWO REVERSE STRINGS :-");
			resultS=reverse(merge(s1,s2));

		}
	}

	/**
	 * Merging of two Strings
	 * 
	 * @param s1 Merge String 1
	 * @param s2 Merge String 2
	 * @return
	 */

	private String merge(String s1, String s2) {
		// TODO Auto-generated method stub

		char arr1[] = s1.toCharArray();
		int len1=arr1.length;
		char arr2[] = s2.toCharArray();
		int len2 = arr2.length;
		int i=0;
		char mergedarr[] = new char[s1.length()+s2.length()];
		int j=0;

		for(i=0;i<len1;i++)
		{
			mergedarr[j++]=arr1[i];
			
			if(i<len2)
			{
				mergedarr[j++]=arr2[i];
			}
		}

		return new String(mergedarr);
	}

	/**
	 * Reverse a String
	 * 
	 * @param s1
	 * @return reversed string
	 */
	private String reverse(String s1) {
		// TODO Auto-generated method stub

		int i=0;
		char arr1[] = s1.toCharArray();
		int j = arr1.length-1;

		while(i<j)
		{
			char temp;
			temp=arr1[i];
			arr1[i]=arr1[j];
			arr1[j]=temp;
			j--;
			i++;
		}

		return new String(arr1);
	}

	/**
	 * Count the no of times the String is entered.
	 * @param s1
	 * @param stringCounter
	 * @return Count
	 */
	private int countString(String s1,Map<String,Integer> stringCounter)
	{
		if(stringCounter.containsKey(s1))
		{
			stringCounter.put(s1, stringCounter.get(s1)+1);
		}
		else
		{
			stringCounter.put(s1, 1);
		}

		return stringCounter.get(s1); 
	}

	/**
	 * Get the input String from user
	 */
	private void getInputStrin()
	{
		System.out.println("-------------------**********--------------------\n");
		System.out.println("ENTER THE FIRST STRING :-");
		Scanner in = new Scanner(System.in);
		s1 = in.nextLine();
		System.out.println("-------------------**********--------------------\n");
		System.out.println("ENTER THE SECOND STRING :-");
		in = new Scanner(System.in);
		s2 = in.nextLine();

	}

	/**
	 * 
	 * Start of the Program
	 */
	private void startProgram(){

		StringManipulation sM = new StringManipulation();
		sM.getInputStrin();

		int lenght1= s1.length();
		int length2=s2.length();


		if(lenght1<10 && lenght1>2 && length2<10 && length2>2){

			int count1=sM.countString(s1, stringCounter);	
			int count2=sM.countString(s2, stringCounter);
			System.out.println("-------------------**********--------------------\n");
			System.out.println("STRING\t"+s1+"\tHAS BEEN ENTERED"+" "+count1+" "+"times");
			System.out.println("STRING\t"+s2+"\tHAS BEEN ENTERED"+" "+count2+" "+"times");
			sM.compare(s1, s2);
			
			System.out.println("STRING RESULT IS :-" + sM.ResultString());
			
		}else
		{
			throw new RuntimeException("Length of the String inuput should be between 2 and 10");
		}

	}

	/**
	 * Main function of the project
	 *  
	 * @param args
	 */
	public static void main(String[] args)
	{

		StringManipulation sM = new StringManipulation();

		while(true)
		{
			System.out.println("[A] START PROGRAM :-");
			System.out.println("[Q] QUIT PROGRAM :-");
			System.out.println("ENTER YOUR CHOICE:-");
			Scanner reader = new Scanner(System.in);
			String c = reader.next();
			switch(c)
			{
			case "A": 
			case "a":
				sM.startProgram();
				break;

			case "q":
			case "Q":
				System.exit(0);
				break;
			default :
				System.out.println("WRONG CHOICE...");
				break;
			}

		}	
	}
}
