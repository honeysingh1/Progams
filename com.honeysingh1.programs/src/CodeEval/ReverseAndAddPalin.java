package CodeEval;

//https://www.codeeval.com/open_challenges/45/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReverseAndAddPalin {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					long num = Long.parseLong(line);
					int count = 0;
					long total = 0;
					while (true) {
						long temp = num;
						count++;
						String st = "";
						while (num > 0) {
							st = st + Long.toString(num % 10);
							num /= 10;
						}
						total = temp + Long.parseLong(st);
						if (checkPalin(Long.toString(total))) {
							break;
						}
						num = total;
					}
					System.out.println(count + " " + total);
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}

	private static boolean checkPalin(String str) {
		StringBuilder st = new StringBuilder();
		st.append(str);
		String f = st.toString();
		st.reverse();
		String r = st.toString();
		if (f.equals(r)) {
			return true;
		} else
			return false;
	}
}
