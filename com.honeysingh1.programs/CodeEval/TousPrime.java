package CodeEval;

//https://www.codeeval.com/open_challenges/46/
//Modified to print prime numbers till the given num

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TousPrime {
	public static void main(String[] args) {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					int i = 3;
					StringBuilder st = new StringBuilder();
					st.append(2+",");
					while (i < Integer.parseInt(line)) {
						if (i % 2 != 0) {
							if (chkprime(i)) {
								st.append(i+",");
							}
						}
						i++;
					}
					st.setCharAt(st.length()-1, '\n');
					System.out.print(st);
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}

	private static boolean chkprime(int j) {
		for (int i = 3; i <= Math.sqrt(j); i++) {
			if (j % i == 0)
				return false;
		}
		return true;
	}
}
