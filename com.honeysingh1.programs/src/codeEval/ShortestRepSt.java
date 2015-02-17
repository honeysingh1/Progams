package codeEval;

//https://www.codeeval.com/open_challenges/107/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ShortestRepSt {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			
			while ((line = in.readLine()) != null) {
				
				if (!line.isEmpty()) {
					int len = line.length();
					int p = 0;
					int flag = 0;
					for(int i = 1; i < len; i++)
					{
						if(line.charAt(0) == line.charAt(i))
						{
							if(i == 1 && (line.charAt(0) == line.charAt(len - 1)))
							{
								System.out.println(i);
								flag = 1;
								break;
							}
							else if(i == 1)
							{
								while(i < len)
								{
									if(line.charAt(0) == line.charAt(i + 1))
									{
										i++;
									}
									else
										break;	
								}
								continue;
							}
							System.out.println(i);
							flag = 1;
							break;
						}
					}
					if(flag == 0)
						System.out.println(len);						
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}

}
