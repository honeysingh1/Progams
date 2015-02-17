package codeEval;

//https://www.codeeval.com/open_challenges/131/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SplitMath {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;

			while ((line = in.readLine()) != null) {
				
				if (!line.isEmpty()) {
					String[] wrd = line.split("\\s");
					StringBuilder st = new StringBuilder();
					StringBuilder st2 = new StringBuilder();
					int i = 0;
					char ch = 0;
					while (i < wrd[1].length())
					{
						if(wrd[1].charAt(i) == '-' || wrd[1].charAt(i) == '+')
						{
							ch = wrd[1].charAt(i);
							break;
						}
						st.append(wrd[0].charAt(i));
						i++;
					}
					st2.append(wrd[0].charAt(i));
					for( int j = i + 1; j < wrd[0].length();j++)
					{
						st2.append(wrd[0].charAt(j));
					}
					switch(ch)
					{
					case '-':
						System.out.println(Long.parseLong(st.toString()) - Long.parseLong(st2.toString()) );
						break;
					case '+':
						System.out.println( Long.parseLong(st.toString()) +  Long.parseLong(st2.toString()) );
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
