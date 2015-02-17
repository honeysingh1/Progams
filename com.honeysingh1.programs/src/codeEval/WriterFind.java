package codeEval;

//https://www.codeeval.com/open_challenges/97/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WriterFind {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			
			while ((line = in.readLine()) != null) {
				StringBuffer st = new StringBuffer();
				if (!line.isEmpty()) {
					String[] wrd = line.split("\\| ");
					String[] nums = wrd[1].split("\\s");
					int size = nums.length;
					for(int i = 0; i < size; i++)
					{
						int pos = Integer.parseInt(nums[i]);
						st.append(wrd[0].charAt(pos - 1));
					}
					System.out.println(st.toString().trim());
				}
				
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}
}
