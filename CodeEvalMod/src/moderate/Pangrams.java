package moderate;
//https://www.codeeval.com/open_challenges/37/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Pangrams {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					boolean[] ch = new boolean[128]; 
					int size = line.length();
					line = line.toLowerCase();
					for(int i = 0; i < size; i++)
					{
						ch[line.charAt(i)] = true;
					}
					int flag = 0;
					for(int i = 97; i < 123; i++)
					{
						if(!ch[i])
						{
							flag = 1;
							System.out.print((char)i);
						}
					}
					if(flag == 0)
						System.out.println("NULL");
					else
						System.out.println();	
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}
}

