package codeEval;
//https://www.codeeval.com/open_challenges/1/
import java.io.*;

public class Fizz {

	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] lineArray = line.split("\\s");
					if (lineArray.length > 0) {
						calculate(lineArray);
					}
				}
			}
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}

	}

	private static void calculate(String[] arr) {
		int x = Integer.parseInt(arr[0]);
		int y = Integer.parseInt(arr[1]);
		int n = Integer.parseInt(arr[2]);
		for (int i = 1; i <= n; i++) {
			if (i % x == 0 && i % y == 0) {
				System.out.print("FB");
			} else if (i % x == 0)
				System.out.print("F");
			else if (i % y == 0)
				System.out.print("B");
			else
				System.out.print(i);
			if (i != n)
				System.out.print(" ");
			else
				System.out.println();
		}
	}

}
