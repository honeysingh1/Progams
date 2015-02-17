package codeEval;

//https://www.codeeval.com/open_challenges/83/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BeautS {
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (!line.isEmpty()) {
				line = line.toLowerCase();
				Map<Character, Integer> map = new HashMap<Character, Integer>();
				int len = line.length();
				int alp = 26;
				char ch;
				for (int i = 0; i < len; i++) {
					ch = line.charAt(i);
					if (Character.isLetter(ch)) {
						if (!map.containsKey(ch)) {
							map.put(ch, 1);
						} else {
							map.put(ch, map.get(ch) + 1);
						}
					}
				}
				ArrayList<Integer> arr = new ArrayList<Integer>();
				for (Entry<Character, Integer> entry : map.entrySet())
				     arr.add(entry.getValue());
				Collections.sort(arr);
				Collections.reverse(arr);
				int tot = 0;
				for (int i = 0; i < arr.size();i++)
				{
				    tot += arr.get(i)*alp--;
				}
				System.out.println(tot);
			}
		}
		buffer.close();
		System.exit(0);
	}
}
