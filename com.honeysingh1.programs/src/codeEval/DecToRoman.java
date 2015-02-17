package codeEval;

//https://www.codeeval.com/open_challenges/106/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class DecToRoman {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					int num = Integer.parseInt(line);
					LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
					roman_numerals.put("M", 1000);
					roman_numerals.put("CM", 900);
					roman_numerals.put("D", 500);
					roman_numerals.put("CD", 400);
					roman_numerals.put("C", 100);
					roman_numerals.put("XC", 90);
					roman_numerals.put("L", 50);
					roman_numerals.put("XL", 40);
					roman_numerals.put("X", 10);
					roman_numerals.put("IX", 9);
					roman_numerals.put("V", 5);
					roman_numerals.put("IV", 4);
					roman_numerals.put("I", 1);
					String res = "";
					for (Entry<String, Integer> entry : roman_numerals.entrySet()) {
						int matches = num / entry.getValue();
						res += call(entry.getKey(), matches);
						num = num % entry.getValue();
					}
					System.out.println(res);
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}

	private static String call(String key, int mat) {
		if(key == null) {
	        return null;
	    }
	    final StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < mat; i++) {
	        sb.append(key);
	    }
	    return sb.toString();
	}
}
