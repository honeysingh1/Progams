package codeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Mixed {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			
			while ((line = in.readLine()) != null) {
				StringBuffer st = new StringBuffer();
				if (!line.isEmpty()) {
					String[] wrd = line.split("\\s");
					int size = wrd.length;
					for(int i = 0; i < size; i++)
					{
						String c = Character.toString(wrd[i].charAt(0));
						wrd[i] = wrd[i].replaceFirst(c, Character.toString(Character.toUpperCase(wrd[i].charAt(0))));
						st.append(wrd[i]+" ");
					}
				}
				System.out.println(st.toString().trim());
			}
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}
}
