package codeEval;

// Check if number is happy or not
//https://www.codeeval.com/open_challenges/39/

import java.io.*;
import java.util.ArrayList;

public class Happy {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					if(line.equals("1"))
						System.out.println("1");
					else
						check(Integer.parseInt(line));
				}
			}
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}

	private static void check(int x) {
		ArrayList<Integer> hap = new ArrayList<Integer>();
		int total = 0;
		do
		{
			hap.add(total);
			total = 0;
			while(x > 0)
			{
				total += Math.pow(x % 10, 2);
				x /= 10;	
			}
			x = total;
		}while(!hap.contains(total) && total != 1);
		if(total == 1)
			System.out.println("1");
		else
			System.out.println("0");
	}
}
