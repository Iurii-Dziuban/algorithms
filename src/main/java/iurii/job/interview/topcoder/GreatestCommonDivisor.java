package iurii.job.interview.topcoder;

public class GreatestCommonDivisor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 33;
		int b = 22;
		int gcd = gcd(a, b);
		int lcm = lcm(a, b);
		System.out.println(gcd);
		System.out.println(lcm);
	}

	private static int gcd(int a1, int b1) {
		int a;
		int b;
		if (a1 > b1) {
		    a = a1;
		    b = b1;
		} else {
			b = a1;
			a = b1;
		}
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
	
	private static int lcm (int a, int b) {
		return a*b/gcd(a,b);
	}

}
