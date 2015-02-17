package codeEval;
//https://www.codeeval.com/open_challenges/87/
import java.io.*;

public class Matrix {
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		int[][] mat = new int[256][256];
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (!line.isEmpty()) {
				String[] str = line.split("\\s");
				int j = Integer.parseInt(str[1]);
				int x;
				int tot = 0;
				switch(str[0])
				{
				case "SetRow":
					x = Integer.parseInt(str[2]);
					for(int i = 0; i < 256; i++)
					{
						mat[j][i] = x; 
					}
					break;
				case "SetCol":
					x = Integer.parseInt(str[2]);
					for(int i = 0; i < 256; i++)
					{
						mat[i][j] = x; 
					}
					break;
				case "QueryRow":
					for(int i = 0; i < 256; i++)
					{
						tot += mat[j][i]; 
					}
					System.out.println(tot);
					break;
				case "QueryCol":
					for(int i = 0; i < 256; i++)
					{
						tot += mat[i][j]; 
					}
					System.out.println(tot);
				}
				
			}
		}
		buffer.close();
		System.exit(0);
	}
}

