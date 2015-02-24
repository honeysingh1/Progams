package moderate;
//https://www.codeeval.com/open_challenges/150/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RomanAndArabic {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					int sum = 0;
					for (int i = 0; i < line.length(); i+=2) {
						int prev = convert(line.charAt(i+1));
						int next = 0;
						if(i + 3 < line.length())
						{
							next = convert(line.charAt(i+3));
						}
						if(next > prev)
						{
							sum -= Integer.parseInt(Character.toString(line.charAt(i))) * prev;
						}
						else
						{
							sum += Integer.parseInt(Character.toString(line.charAt(i))) * prev;
						}
					}
					System.out.println(sum);
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}

	private static int convert(char ch) {
		switch(ch)
		{
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}
		return 0;
	}
}
