package moderate;
//https://www.codeeval.com/open_challenges/2/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class LongestLines {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			Map<Integer, String> map = new HashMap<Integer, String>();
			int num = Integer.parseInt(in.readLine());
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					map.put(line.length(), line);
				}
			}
			Map<Integer, String> tmap = new TreeMap<Integer, String>(
					Collections.reverseOrder());
			tmap.putAll(map);
			for (Entry<Integer, String> entry : tmap.entrySet()) {
				if(num > 0)
				{
					System.out.println(entry.getValue());
					num--;
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}
}
