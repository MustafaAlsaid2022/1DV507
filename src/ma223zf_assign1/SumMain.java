package ma223zf_assign1;

public class SumMain {

	public static void main(String[] args) {
		System.out.println(sum(1, 10));
	}

	private static int sum(int i, int n) {
	
		System.out.print("sum from "+i+" to "+n+" : ");
		return left(i, n / 2) + right(n / 2 + 1, n); //sum from 1 to n/2 and sum from n/2+1 to n//
	}

	private static int left(int start, int end) { //left method gives us sum from 1 to n/2//
		if (end == start) { //start 1 and end n/2//
			return end;
		}
		return start + left(start+1, end); //sum from 1 to n/2//
	}

	private static int right(int start, int end) { //right method gives us sum from m/2+1 to n//
		if (end == start) { // start n/2+1 and end n//
			return end;
		}
		return start + right(start + 1, end); //sum from n/2+1 to n//
	}

}
