package codeEval;
/* Program calculates the largest prime palindrome in first 1000 integers*/
//https://www.codeeval.com/open_challenges/3/

public class PrimePalin {
	public static void main(String[] args) {
		for (int i = 1000; i > 0; i--) {
			if (chkprime(i)) {
				if(chkpalin(i))
				{
					System.out.println(i);
					System.exit(0);
				}
			}
		}
	}

	private static boolean chkprime(int j) {
		for (int i = 2; i < Math.sqrt(j); i++) {
			if (j % i == 0)
				return false;
		}
		return true;
	}

	private static boolean chkpalin(int j) {
		if (j % 10 == j / 100)
			return true;
		return false;
	}

}
