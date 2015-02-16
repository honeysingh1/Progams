package codeEval;

//https://www.codeeval.com/open_challenges/163/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BigDigits {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;

			while ((line = in.readLine()) != null) {
				ArrayList<ArrayList<String>> str = new ArrayList<ArrayList<String>>();
				if (!line.isEmpty()) {
					for (int i = 0; i < line.length(); i++) {
						if (Character.isDigit(line.charAt(i))) {
							str.add(out(line.charAt(i)));
						}
					}
					int j = 0;
					while (j < 6) {
						for (int i = 0; i < str.size(); i++) {
							System.out.print(str.get(i).get(j));
						}
						j++;
						System.out.println();
					}
				}
			}
		} catch (IOException e) {
			System.out.print("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}

	private static ArrayList<String> out(char ch) {
		ArrayList<String> str = new ArrayList<String>();
		switch (ch) {
		case '0':
			str.add("-**--");
			str.add("*--*-");
			str.add("*--*-");
			str.add("*--*-");
			str.add("-**--");
			str.add("-----");
			return str;
		case '1':
			str.add("--*--");
			str.add("-**--");
			str.add("--*--");
			str.add("--*--");
			str.add("-***-");
			str.add("-----");
			return str;
		case '2':
			str.add("***--");
			str.add("---*-");
			str.add("-**--");
			str.add("*----");
			str.add("****-");
			str.add("-----");
			return str;
		case '3':
			str.add("***--");
			str.add("---*-");
			str.add("-**--");
			str.add("---*-");
			str.add("***--");
			str.add("-----");
			return str;
		case '4':
			str.add("-*---");
			str.add("*--*-");
			str.add("****-");
			str.add("---*-");
			str.add("---*-");
			str.add("-----");
			return str;
		case '5':
			str.add("****-");
			str.add("*----");
			str.add("***--");
			str.add("---*-");
			str.add("***--");
			str.add("-----");
			return str;
		case '6':
			str.add("-**--");
			str.add("*----");
			str.add("***--");
			str.add("*--*-");
			str.add("-**--");
			str.add("-----");
			return str;
		case '7':
			str.add("****-");
			str.add("---*-");
			str.add("--*--");
			str.add("-*---");
			str.add("-*---");
			str.add("-----");
			return str;
		case '8':
			str.add("-**--");
			str.add("*--*-");
			str.add("-**--");
			str.add("*--*-");
			str.add("-**--");
			str.add("-----");
			return str;
		case '9':

			str.add("-**--");
			str.add("*--*-");
			str.add("-***-");
			str.add("---*-");
			str.add("-**--");
			str.add("-----");
			return str;
		}
		return str;
	}
}