package CodeEval;

// Calculates distance between two points
//https://www.codeeval.com/open_challenges/99/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Distance {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					line = line.replaceAll("\\(", "").replaceAll("\\)", "")
							.replaceAll(",", "");
					String[] pts = line.split("\\s");
					int dist = (int) Math.sqrt(Math.pow(
							(Integer.parseInt(pts[0]))
									- Integer.parseInt(pts[2]), 2)
							+ Math.pow(
									(Integer.parseInt(pts[1]))
											- Integer.parseInt(pts[3]), 2));
					System.out.println(dist);
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}
}
