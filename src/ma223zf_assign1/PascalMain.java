package ma223zf_assign1;

import java.util.Arrays;

public class PascalMain {

	public static void main(String[] args) {
		int n=3;
		int [] arr=pascalRow(n);
		System.out.println("row "+n+": "+Arrays.toString(arr));
		
	}
	
	public static int[] pascalRow(int n){ //parameter represents the row number//
		if (n < 0) //if the parameter has negative number throw exception//
		throw new IllegalArgumentException("the parameter must be possitive"); 

		int [] num= new int[n+1]; //array represents the numbers for each row and its length is the row number +1//
		int[] row=new int[num.length]; // row array has num array length//
		num[0]=1; // the first value of a specific row in pascal triangle//
		num[n]=1; // the last value of a specific row in pascal triangle//
		if(n==0){ // the first row in pascal triangle contains only 1. we return the base case//
			return num;
		}
		row=pascalRow(n-1); //recursion process till reach the base case when n=0//
		for(int i=1;i<row.length;i++){ //calculate the values from second element for each row//
			num[i]=row[i]+row[i-1]; //value for each element is the element of same index in the previous row + the element of the index-1 in the previous row//
		}
		return num; 
	}
	
	/*another solution*/
	public static void  row(int n) { //specific row to be printed//
	    System.out.print("row "+n+": ");
		for (int i = 1; i <= n; i++) {
			System.out.print(rowValue(n, i) + " ");
		}
		System.out.println();
	}
    public static int rowValue(int n, int i) { //it gives the values of a specific row//
	   if (i == 1) {
		  return 1;
	  } else if (i == n) {
		 return 1;
	} 
	else {
		/*value of previous index of element in previous row added to value of same index element of the previous row*/
		return rowValue(n - 1, i - 1) + rowValue(n - 1, i); 
	}

}


}
