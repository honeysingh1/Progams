package codeEval;

// Program finds N mod M without inbuilt mod
//https://www.codeeval.com/open_challenges/62/

import java.io.*;

public class NmodM {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] num = line.split(",");
					mod(num);
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}

	private static void mod(String[] num) {
		int n = Integer.parseInt(num[0]);
		int m = Integer.parseInt(num[1]);
		int c = 1;
		while((m * c) <= n)
		{
			c++;
		}
		System.out.println(n - (m * --c));
	}

}
