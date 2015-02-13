package codeEval;

import java.io.*;

public class Reverse {

	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] words = line.split("\\s");
					if (words.length > 0) {
						calculate(words);
					}
				}
			}
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
	}

	private static void calculate(String[] words) {
		StringBuffer str = new StringBuffer();
		for (int i = words.length - 1; i >= 0; i--) {
			if (i == 0) {
				str.append(words[i].trim());
			} else
			{
				str.append(words[i]);
				str.append(" ");
			}
		}
		System.out.println(str);
	}
}
