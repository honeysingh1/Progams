package CodeEval;

import java.io.File;
import java.math.BigInteger;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Milo {

	public static void main(String[] args) {
		Scanner scanner = null;
		// if (args.length > 0) {
		File file = new File("C://Users/Honey Singh/Desktop/test2.txt");
		try {
			scanner = new Scanner(file);
		} catch (Exception e) {
			System.err.println("File not found: " + e.toString());
			return;
		}
		// } else
		// System.out.println("Please provide a file path.");
		separate(scanner);

	}

	private static void separate(Scanner scanner) {

		while (scanner.hasNextLine()) {
			String[] both = scanner.nextLine().split(";");
			double total = 0;
			List<String> customers = Arrays.asList(both[0].split(","));
			List<String> products = Arrays.asList(both[1].split(","));
			for (String cust : customers) {
				double[] p = check(cust, products);
				int num = (int) p[1];
				products.set(num, "");
				System.out.println("tot " + p[0]);
				total += p[0];

			}
			System.out.println("Total: " + total);
		}

	}

	private static double[] check(String cust, List<String> products) {
		double temp = 0;
		double count = 0;
		int c = 0;
		int p = 0;
		double[] n = new double[2];
		for (String pro : products) {
			c++;
			if (!(pro.isEmpty())) {
				count = checkss(cust, even(pro));
				if (checkcom(pro, cust))
					count = count * 1.5;
				if (temp < count) {
					temp = count;
					p = c;
				}
			}
		}
		n[0] = temp;
		if(p > 0)
			n[1] = p - 1;
		return n;
	}

	private static boolean checkcom(String prod, String cust) {
		int plen = 0;
		int clen = 0;
		int i;
		for (i = 0; i < prod.length(); i++) {
			if (Character.isLetter(prod.charAt(i)))
				plen++;
		}
		for (i = 0; i < cust.length(); i++) {
			if (Character.isLetter(cust.charAt(i)))
				clen++;
		}
		if (BigInteger.valueOf(plen).gcd(BigInteger.valueOf(clen)).intValue() > 1) {
			return true;
		}
		return false;
	}

	private static double checkss(String customer, boolean b) {
		int count = 0;
		int bcount = 0;
		customer = customer.toLowerCase().replaceAll("\\s+", "");
		for (int i = 0; i < customer.length(); i++) {
			char c = customer.charAt(i);
			if (Character.isLetter(c)) {
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
						|| c == 'y') {
					count++;
				} else
					bcount++;
			}
		}
		if (b) {
			return count * 1.5;
		}
		return bcount;
	}

	private static boolean even(String product) {
		product = product.replaceAll("\\s+", "");
		int len = 0;
		for (int i = 0; i < product.length(); i++) {
			if (Character.isLetter(product.charAt(i))) {
				len++;
			}
		}
		if (len % 2 == 0) {
			return true;
		}
		return false;
	}

}
