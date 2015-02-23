package codeEval;

//https://www.codeeval.com/open_challenges/10/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MthToLast {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] wrd = line.split("\\s");
					int size = wrd.length;
					int m = Integer.parseInt(wrd[size - 1]);
					if(m < size)
						System.out.println(wrd[size - 1 - m]);
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}
}

