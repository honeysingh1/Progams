package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//https://www.codeeval.com/open_challenges/140/

public class DataRec {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;

			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] wrd = line.split(";");
					String[] st = wrd[0].split("\\s");
					String[] pos = wrd[1].split("\\s");
					Map<Integer, String> map = new HashMap<Integer, String>();
					int size = pos.length;
					for (int i = 0; i < size; i++) {
						map.put(Integer.parseInt(pos[i]), st[i]);
					}
					for (int i = 1; i <= map.size()+1; i++) {
						if(map.get(i) == null)
						{
							System.out.print(st[st.length - 1]+" ");
							continue;
						}
							System.out.print(map.get(i) + " ");
					}
					System.out.println();
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}
}
