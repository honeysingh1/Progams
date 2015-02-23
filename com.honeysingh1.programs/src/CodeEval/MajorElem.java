package CodeEval;

//https://www.codeeval.com/open_challenges/132/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MajorElem {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					List<String> st = Arrays.asList(line.split(","));
					int size = st.size();
					int flag = 0;
					int v = 0;
					int[] num = new int[100];
					for (int i = 0; i < size; i++) {
						v = (num[Integer.parseInt(st.get(i))]++);
						if(v >= size/2)
						{
							System.out.println(st.get(i));
							flag = 1;
							break;
						}
					}
					if(flag == 0)
					{
						System.out.println("None");
					}
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}
}
