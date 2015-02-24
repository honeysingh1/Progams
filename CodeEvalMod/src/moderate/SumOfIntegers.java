package moderate;

//https://www.codeeval.com/open_challenges/17/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SumOfIntegers {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] nums = line.split(",");
					System.out.println(maxSum(nums));
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}

	private static int maxSum(String[] nums) {
		int m = 0;
		int sum = 0;
		int n = 0;
		int c = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += Integer.parseInt(nums[i]);
			if (m < sum)
				m = sum;
			else if (sum < 0)
			{
				if(sum < n && c==0)
				{
					n = sum;
					c++;
				}
				if(n < sum)
					n = sum;
				sum = 0;
			}
		}
		if(m == 0)
			return n;
		return m;
	}
}
