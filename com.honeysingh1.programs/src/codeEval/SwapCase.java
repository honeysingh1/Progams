package codeEval;
//https://www.codeeval.com/open_challenges/96/
import java.io.*;

public class SwapCase {
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;

		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (!line.isEmpty()) {
				int len = line.length();
				int i = 0;
				while (i < len) {
					if (Character.isLowerCase(line.charAt(i))) {
						System.out.print(Character.toUpperCase(line.charAt(i)));
					} else if (Character.isUpperCase(line.charAt(i))) {
						System.out.print(Character.toLowerCase(line.charAt(i)));
					} else
						System.out.print(line.charAt(i));
					i++;
				}
			}
			System.out.println();
		}
		buffer.close();
		System.exit(0);
	}
}
