package moderate;
//https://www.codeeval.com/open_challenges/13/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RemoveCharacters {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] wrd = line.split(", ");
					char[] ch = wrd[1].toCharArray();
					for (int j = 0; j < ch.length; j++) {
						wrd[0] = wrd[0].replace(ch[j], '@');
					}
					System.out.println(wrd[0].replaceAll("@", ""));
				}

			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}
}
