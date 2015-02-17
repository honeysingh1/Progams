package codeEval;

//https://www.codeeval.com/open_challenges/167/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadMore {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					if (line.length() <= 55)
						System.out.println(line);
					else {
						int c = 0;
						char[] str = line.toCharArray();
						String strn = String.copyValueOf(str, 0, 40);
						if(strn.contains(" "))
						{
							c = strn.lastIndexOf(' ');
							System.out.println(strn.substring(0, c)+"... <Read More>");
						}
						else
						{
							System.out.println(strn+"... <Read More>");
						}
					}
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}
}
