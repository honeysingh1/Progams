package CodeEval;

//Checks if a number is self - describing
//https://www.codeeval.com/open_challenges/40/

import java.io.*;

public class Self {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {

					check(line);
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}

	private static void check(String x) {
		char[] ch = x.toCharArray();
		int[] pos = new int[ch.length];
		int n = 0;
		int c;
		while (n < ch.length) {
			c = 0;
			while (c < x.length()) {
				if ((int)Character.forDigit(n, 10) == (int)ch[c])
					pos[n]++;
				c++;
			}
			if ((int)Character.forDigit(pos[n], 10) != (int)ch[n]) {
				System.out.println("0");
				return;
			}
			n++;
		}
		System.out.println("1");
	}

}
