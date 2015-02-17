package codeEval;

//https://www.codeeval.com/open_challenges/91/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Sort {
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			ArrayList<Double> in = new ArrayList<Double>();
			if (!line.isEmpty()) {
				String[] st = line.split("\\s");
				int len = st.length;
				int i = 0;
				while (i < len) {
					in.add(Double.parseDouble(st[i]));
					i++;
				}
				Collections.sort(in);
			}
			int i = 0;
			int s = in.size();
			while(i < s)
			{
				if(i == s - 1)
					System.out.printf("%3.3f", in.get(i));
				else
					System.out.printf("%3.3f ", in.get(i));
				i++;
			}
			System.out.println();
		}
		buffer.close();
		System.exit(0);
	}
}
