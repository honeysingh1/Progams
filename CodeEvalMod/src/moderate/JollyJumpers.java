package moderate;

//https://www.codeeval.com/open_challenges/43/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class JollyJumpers {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] wrd = line.split("\\s");
					int size = wrd.length;
					StringBuilder num = new StringBuilder();
					StringBuilder nu = new StringBuilder();
					ArrayList<Integer> n = new ArrayList<Integer>();
					for(int i = 1; i < size; i++)
					{
						num.append(i);
					}
					for(int i = 1; i < size; i++)
					{
						int pos = Math.abs(Integer.parseInt(wrd[i])- Integer.parseInt(wrd[i-1]));
						n.add(pos);
					}
					Collections.sort(n);
					for(int i = 0; i < n.size(); i++)
					{
						nu.append(n.get(i));
					}
					if(num.toString().equals(nu.toString()))
						System.out.println("Jolly");
					else
						System.out.println("Not jolly");
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}
}
