package time;

import java.util.ArrayList;

public class TimeMeasurment {
   
	static long oneStringLength=0;
	static long eightyStringLength=0;
	static long oneStringBuilderLength=0;
	static long eightyStringBuilderLength=0;
	static long eightyStringCon;
	static long eightyStringBuilderAppend;
	static ArrayList<Long>lengthList=new ArrayList<Long>();
	static ArrayList<Long>conList=new ArrayList<Long>();
	
	
	public static void main(String[] args) {
        long length=0;
        long c=0;
		for (int i =0; i < 5; i++) {
			stringWithOneCharacter();
            lengthList.add(oneStringLength);
            length=length+lengthList.get(i);
		}
		long averageLength=length/5;
		System.out.println("Average: "+averageLength);
		System.out.println("Concatenation: "+averageLength);

		   length=0;
		   averageLength=0;
		   lengthList.clear();
		   
			for (int i =0; i < 5; i++) {
			   stringWithEightyCharacter();
		       lengthList.add(eightyStringLength);
	           length=length+lengthList.get(i);
	           conList.add(eightyStringCon);
	           c=c+conList.get(i);
			}
			averageLength=length/5;
			System.out.println("Average: "+averageLength);
			System.out.println("Concatenation: "+c/5);
			
					
			   length=0;
			   averageLength=0;
			   c=0;
			   lengthList.clear();
			   conList.clear();
			   
				for (int i =0; i < 5; i++) {
					stringBuilderWithOneCharacter();
		           lengthList.add(oneStringBuilderLength);
		            length=length+lengthList.get(i);
				}
				averageLength=length/5;
				System.out.println("Average: "+averageLength);
				
				 length=0;
				   averageLength=0;
				   lengthList.clear();
				   
					for (int i =0; i < 5; i++) {
						stringBuilderWithEightyCharacter();
			           lengthList.add(eightyStringBuilderLength);
			            length=length+lengthList.get(i);
			            conList.add(eightyStringBuilderAppend);
			            c=c+conList.get(i);
					}
					averageLength=length/5;
					System.out.println("Average: "+averageLength);
					System.out.println("Concatenation: "+c/5);
							
		}
	
	public static void stringWithOneCharacter() {
		String str = "";
		long start = System.currentTimeMillis();
		while ((System.currentTimeMillis() - start) < 1000) {
			str = str + "i";
		}
		long end = System.currentTimeMillis();
		int runTime = (int) (end - start);
		oneStringLength=str.length();
		System.out.println("Approximate time for concatenation one character: " + runTime + " milliseconds." + " Total concatenations: "
				+ str.length() + ".  Total length: " + str.length());
	}
	
	public static void stringWithEightyCharacter() {
		String str = "";
		long start = System.currentTimeMillis();
		while ((System.currentTimeMillis() - start) < 1000) {
			str = str + "hellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohello";
		}
		long end = System.currentTimeMillis();
		int runTime = (int) (end - start);
		eightyStringLength=str.length();
		eightyStringCon=str.length()/80;
		System.out.println("Approximate time for concatenation eighty character: " + runTime + " milliseconds." + " Total concatenations: "
				+ (str.length()/80) + ".  Total length: " + str.length());
	}
	
	public static void stringBuilderWithOneCharacter() {
		StringBuilder stb=new StringBuilder();
		long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis() - startTime) < 1000) {
			stb.append("i");
		}
		
		long convertStartTime = System.currentTimeMillis(); 
		stb.toString(); 
		long convertEndTime = System.currentTimeMillis(); 
		int toStringTime = (int) (convertEndTime - convertStartTime); 
		StringBuilder st = new StringBuilder(); 
		long start = System.currentTimeMillis(); 
		while ((System.currentTimeMillis() - start) < 1000 - toStringTime) { 
		st.append("i"); 
		} 
     	long end = System.currentTimeMillis(); 
		int runTime = (int) (end - start); 
		oneStringBuilderLength=st.length();
		System.out.println( "Approximate time for append one character to StringBuilder: " + (runTime +toStringTime) 
			+ " milliseconds.  Total concatenations: " + st.length() + ".  Total Length: " + st.length());
	}
	public static void stringBuilderWithEightyCharacter() {
		StringBuilder stb=new StringBuilder();
		long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis() - startTime) < 1000) {
			stb.append("");
		}
		
		long convertStartTime = System.currentTimeMillis(); 
		stb.toString(); 
		long convertEndTime = System.currentTimeMillis(); 
		int toStringTime = (int) (convertEndTime - convertStartTime); 
		StringBuilder st = new StringBuilder(); 
		long start = System.currentTimeMillis(); 
		while ((System.currentTimeMillis() - start) < 1000 - toStringTime) { 
		st.append("hellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohello"); 
		} 
     	long end = System.currentTimeMillis(); 
		int runTime = (int) (end - start); 
		eightyStringBuilderLength=st.length();
		eightyStringBuilderAppend=st.length()/80;
		System.out.println( "Approximate time for append eighty character to StringBuilder: " + (runTime + toStringTime) 
			+ " milliseconds.  Total concatenations: " + (st.length()/80) + ".  Total Length: " + st.length());
	}

}
