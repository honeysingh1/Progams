package codeEval;

/* Program calculates the sum of first thousand prime numbers*/

public class TousPrime {
	public static void main(String[] args) {
		long total = 2;
		int count = 2;
		int i = 3;
		while (count <= 1000) {
			if (i % 2 != 0) {
				if (chkprime(i)) {
					total += i;
					count++;
				}
			}
			i++;
		}
		System.out.println(total);
		System.exit(0);
	}

	private static boolean chkprime(int j) {
		for (int i = 3; i < Math.sqrt(j); i++) {
			if (j % i == 0)
				return false;
		}
		return true;
	}
}
