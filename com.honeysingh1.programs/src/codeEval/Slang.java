package codeEval;

//https://www.codeeval.com/open_challenges/174/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Slang {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			int c = 0;
			while ((line = in.readLine()) != null) {
				StringBuilder st = new StringBuilder();
				if (!line.isEmpty()) {
					char[] str = line.toCharArray();
					for(int i = 0; i < str.length; i++)
					{
						if(str[i] == '.' || str[i] == '?' || str[i] == '!')
						{
							c++;
							if(c % 2 == 0)
							{
								st.append(call(((c / 2) - 1) % 9));
							}
							else
								st.append(str[i]);
						}
						else
							st.append(str[i]);
					}
					System.out.println(st);
				}
			}
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}

	private static String call(int c) {
		switch(c)
		{
		case 0:
			return ", yeah!";
		case 1:
			return ", this is crazy, I tell ya.";
		case 2:
			return ", can U believe this?";
		case 3:
			return ", eh?";
		case 4:
			return ", aw yea.";
		case 5:
			return ", yo.";
		case 6:
			return "? No way!";
		case 7:
			return ". Awesome!";
		}
		return null;
	}
}
