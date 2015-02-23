package CodeEval;

import java.io.*;

public class Lower {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					int x = Integer.parseInt(line);
					if (x == 0 || x == 1)
						System.out.println(x);
					else {
						int a = 0;
						int b = 1;
						int tot = 0;
						int count = 1;
						while (count < x) {
							a = b;
							b = tot;
							tot = a + b;
							count++;
						}
						System.out.println(tot);
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