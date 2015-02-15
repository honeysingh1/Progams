package codeEval;

//Prints the position of the given character in a string. If not found print -1.
//https://www.codeeval.com/open_challenges/31/

import java.io.*;

public class Stright {
	public static void main(String[] args) {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] str = line.split(",");
					boolean flag = false;
					for(int i = str[0].length() - 1; i > 0; i--)
					{
						if(str[0].charAt(i) == str[1].charAt(0))
						{
							System.out.print(i);
							flag = true;
							break;
						}
					}
					if(flag)
						System.out.println();
					else
						System.out.println("-1");
				}
			}
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);

	}
}



