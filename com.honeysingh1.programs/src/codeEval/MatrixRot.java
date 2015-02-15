package codeEval;
//https://www.codeeval.com/open_challenges/178/
import java.io.*;

public class MatrixRot {
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (!line.isEmpty()) {
				line = line.replaceAll("\\s", "");
				int len = line.length();
				int n = (int) Math.sqrt(len);
				int i = n;
				while(i > 0)
				{
					for(int j = len - i; j >= 0; j -= n)
					{
						if(j == n - 1)
							System.out.println(line.charAt(j));
						else
							System.out.print(line.charAt(j)+" ");
					}
					i--;
				}
			}
		}
		System.exit(0);
	}
}
