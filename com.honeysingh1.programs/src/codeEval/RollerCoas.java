package codeEval;

//https://www.codeeval.com/open_challenges/156/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RollerCoas {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				StringBuilder st = new StringBuilder();
				if (!line.isEmpty()) {
					char[] str = line.toCharArray();
					int c = 0;
					st.append(Character.toUpperCase(str[0]));
					for(int i = 1; i < str.length; i++)
					{
						if(Character.isLetter(str[i]))
						{
							c++;
							if(c % 2 != 0)
							{
								st.append(Character.toLowerCase(str[i]));
							}
							else
								st.append(Character.toUpperCase(str[i]));
						}
						else
							st.append(str[i]);
						System.out.printf("lowercase: %2d", c);
					}
					System.out.println(st);
					
				}
			}
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}
}
