package moderate;
//https://www.codeeval.com/open_challenges/34/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NumberPairs {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					ArrayList<Integer> arr = new ArrayList<Integer>();
					String[] num = line.split(";");
					String[] li = num[0].split(",");
					for (int i = 0; i < li.length; i++) {
						for (int j = 0; j < li.length; j++) {
							if (Integer.parseInt(li[i])
									+ Integer.parseInt(li[j]) == Integer
										.parseInt(num[1]) && i != j) {
								arr.add(Integer.parseInt(li[i]));
								arr.add(Integer.parseInt(li[j]));
								break;
							}
						}
					}
					if (arr.isEmpty())
						System.out.println("NULL");
					else {
						for (int i = 0; i < arr.size() / 2; i++) {
							if(i == arr.size()/2 - 2)
							{
								System.out.print(arr.get(i)+",");
								System.out.println(arr.get(i+1));
								break;
							}
							else
							{
								System.out.print(arr.get(i)+",");
								System.out.print(arr.get(i+1)+";");
								i++;
							}
						}
					}
				}
			}

			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}
}
