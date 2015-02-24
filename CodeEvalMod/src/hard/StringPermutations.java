package hard;
//https://www.codeeval.com/open_challenges/14/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class StringPermutations {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				ArrayList<String> arr = new ArrayList<String>();
				if (!line.isEmpty()) {
					arr = perm(line);
				}
				Collections.sort(arr);
				for (int i = 0; i < arr.size(); i++) {
					if (i != arr.size() - 1)
						System.out.print(arr.get(i) + ",");
					else
						System.out.println(arr.get(i));
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}

	private static ArrayList<String> perm(String st) {
		if (st == null)
			return null;
		ArrayList<String> arr = new ArrayList<String>();
		if (st.length() == 0) {
			arr.add("");
			return arr;
		}

		char frst = st.charAt(0);
		String rem = st.substring(1);
		ArrayList<String> wrd = perm(rem);
		for (String w : wrd) {
			for (int j = 0; j <= w.length(); j++) {
				String s = insert(w, frst, j);
				arr.add(s);
			}
		}
		return arr;
	}

	private static String insert(String w, char frst, int j) {
		String srt = w.substring(0, j);
		String end = w.substring(j);
		return srt + frst + end;
	}
}
