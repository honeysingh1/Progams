package codeEval;

//Finds the lowest unique number in the list 
//https://www.codeeval.com/open_challenges/103/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UniqueNum {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				int[] pos = new int[10];
				if (!line.isEmpty()) {
					String[] num = line.split("\\s");
					int size = num.length;
					for(int i = 0; i < size; i++)
					{
						pos[Integer.parseInt(num[i])]++;
					}
					int temp = 10;
					for(int i =0;i<pos.length;i++)
					{
						if(pos[i] == 1)
						{
							if(temp > i)
								temp = i;
						}
					}
					if(temp == 10)
						System.out.println("0");
					else
						for(int i = 0; i < size;i++)
						{
							if(Integer.parseInt(num[i]) == temp)
							{
								System.out.println(i + 1);
							}
						}
				}
			}
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}
}
