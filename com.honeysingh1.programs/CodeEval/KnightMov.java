package CodeEval;

//https://www.codeeval.com/open_challenges/180/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class KnightMov {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				ArrayList<String> arr = new ArrayList<String>();
				if (!line.isEmpty()) {
					int col = strTodig(line.charAt(0));
					int row = Integer.parseInt(Character.toString(line
							.charAt(1))) - 1;
					int[] r = { 1, 2, 2, 1, -1, -2, -2, -1 };
					int[] c = { 2, 1, -1, -2, -2, -1, 1, 2 };
					for (int i = 0; i < 8; i++) {
						if (col + c[i] >= 0 && row + r[i] >= 0 && col + c[i] <= 7 && row + r[i] <= 7) {
							String str = Character.toString(dig(col + c[i])) + Integer.toString(row+r[i]+1);
							arr.add(str);
						}
					}
					Collections.sort(arr);
					for(String it: arr)
						System.out.print(it+" ");
					System.out.println();
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}

	private static int strTodig(char ch) {
		switch (ch) {
		case 'a':
			return 0;
		case 'b':
			return 1;
		case 'c':
			return 2;
		case 'd':
			return 3;
		case 'e':
			return 4;
		case 'f':
			return 5;
		case 'g':
			return 6;
		case 'h':
			return 7;
		}
		return 0;
	}

	private static char dig(int ch) {
		switch (ch) {
		case 0:
			return 'a';
		case 1:
			return 'b';
		case 2:
			return 'c';
		case 3:
			return 'd';
		case 4:
			return 'e';
		case 5:
			return 'f';
		case 6:
			return 'g';
		case 7:
			return 'h';
		}
		return 0;
	}
}
