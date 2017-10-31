package ma223zf_assign3;

public class EuclideanMain {

	public static void main(String[] args) {
		
		int m=24;
		int n=14;
		
		System.out.println("GCD"+"("+m+","+n+")"+" = "+gcd(m,n));
		
	}
	
	public static int gcd(int m, int n) { /*find gcd*/

		int temp;
		while (n != 0) {
			temp = n;
			n = m % n;
			m = temp;
		}
		return m;
	}

}
