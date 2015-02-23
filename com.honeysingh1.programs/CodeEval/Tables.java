package CodeEval;


import java.io.*;

public class Tables {

	public static void main(String[] args) {
		try {
			File file = new File(args[0]);
			System.out.println(file.length());
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			int tot = 0;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					tot += Integer.parseInt(line);
				}
			}
			System.out.println(tot);
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}
}
