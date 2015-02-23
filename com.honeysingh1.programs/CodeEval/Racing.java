package CodeEval;

//https://www.codeeval.com/open_challenges/136/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Racing {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			ArrayList<String> str = new ArrayList<String>();
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					str.add(line);
				}
			}
			calc(str);
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}

	private static void calc(ArrayList<String> str) {
		int size = str.size();
		int c = 0;
		for (int t = 0; t < size; t++) {
			int j = 0;
			if (t == 0) {
				for (int i = 0; i < str.get(0).length(); i++) {
					if (str.get(0).charAt(i) == 'C') {
						c = i;
						System.out.println(str.get(0).replace('C', '|'));
						break;
					}
				}
				if (c == 0) {
					c = str.get(0).indexOf('_');
					System.out.println(str.get(0).replace('_', '|'));
				}
			} else {
				for (int i = 0; i < str.get(t).length(); i++) {
					if (str.get(t).charAt(i) == 'C') {
						j = 1;
						if (c > i) {
							System.out.println(str.get(t).replace('C', '/'));
							c = i;
							break;
						} else if (c < i) {
							System.out.println(str.get(t).replace('C', '\\'));
							c = i;
							break;
						} else {
							System.out.println(str.get(t).replace('C', '|'));
							c = i;
							break;
						}
					}
				}
				if (j == 0) {
					int i = str.get(t).indexOf('_');
					if (c < i) {
						System.out.println(str.get(t).replace('_', '\\'));
						c = i;
					} else if (c > i) {
						System.out.println(str.get(t).replace('_', '/'));
						c = i;
					} else {
						System.out.println(str.get(t).replace('_', '|'));
						c = i;
					}
				}

			}

		}

	}
}
