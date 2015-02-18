package codeEval;

//https://www.codeeval.com/open_challenges/71/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReverseGrps {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;

			while ((line = in.readLine()) != null) {
				StringBuffer st = new StringBuffer();
				if (!line.isEmpty()) {
					String[] wrd = line.split(";");
					String[] num = wrd[0].split(",");
					int len = Integer.parseInt(wrd[1]);
					int size = num.length;
					for (int i = 0; i < size; i += len) {
						int j = i+len-1;
						int k = 0;
						while(k < len && j < size) 
						{
							st.append(num[j--] + ",");
							k++;
						}
					}
					if(size % len != 0)
					{
						for(int i = size-(size%len); i < size;i++)
							st.append(num[i]+",");
					}
				}
				st.setCharAt(st.length()-1, '\n');
				System.out.print(st);
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}
}
