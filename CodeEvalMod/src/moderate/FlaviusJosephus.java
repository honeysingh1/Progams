package moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FlaviusJosephus {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					ArrayList<Integer> ar = new ArrayList<Integer>();
					String[] wrd = line.split(",");
					int i = 0;
					for (i = 0; i < Integer.parseInt(wrd[0]); i++) {
						ar.add(i);
					}
					int j = -1;
					for (; j < ar.size(); j += Integer.parseInt(wrd[1])) {
						if (j + Integer.parseInt(wrd[1]) > i) {
							System.out.print(j+" ");
							j = Integer.parseInt(wrd[0]) - j - 1;
							ar.remove(j);
						}
						if (ar.contains(j)) {
							System.out.print(j + " ");
							ar.remove(j);
						}

					}
				}
				System.out.println();
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}
}
