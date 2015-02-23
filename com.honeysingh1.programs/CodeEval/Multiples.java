package CodeEval;

//https://www.codeeval.com/open_challenges/18/
import java.io.*;

public class Multiples {

	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] num = line.split(",");
					calculate(num);
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}

	private static void calculate(String[] arr) {
		int x = Integer.parseInt(arr[0]);
		int n = Integer.parseInt(arr[1]);
		int i = 1;
		while (x > (n * i++)) {
		}
		System.out.println(n * --i);
	}
}
