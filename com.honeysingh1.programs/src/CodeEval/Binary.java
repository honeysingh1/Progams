package CodeEval;

import java.io.*;

public class Binary {

	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] nums = line.split(",");
					calculate(nums);
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		
		System.exit(0);
	}

	private static void calculate(String[] arr) {
		String ch = Integer.toBinaryString(Integer.parseInt(arr[0]));
		int p1 = ch.length() - Integer.parseInt(arr[1]);
		int p2 = ch.length() - Integer.parseInt(arr[2]);
		if(ch.charAt(p1) == ch.charAt(p2))
			System.out.println("true");
		else
			System.out.println("false");
	}

}
