package moderate;

//https://www.codeeval.com/open_challenges/63/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CountingPrimes {
	public static void main(String[] args) {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] ch = line.split(",");
					int count = 0;
					int str = Integer.parseInt(ch[0]);
					int end = Integer.parseInt(ch[1]);
					for (int i = str; i <= end; i++) {
						if (i == 2)
							count++;
						else {
							if (i % 2 != 0) {
								if (chkprime(i)) {
									count++;
								}
							}
						}
					}
					System.out.println(count);
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}

	private static boolean chkprime(int j) {
		for (int i = 3; i <= Math.sqrt(j); i++) {
			if (j % i == 0)
				return false;
		}
		return true;
	}
}
