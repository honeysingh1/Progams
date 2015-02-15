package codeEval;

//checks if integers in one list are available in other
// both lists in ascending order
//https://www.codeeval.com/open_challenges/30/

import java.io.*;

public class Unique {

	public static void main(String[] args) {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] nums = line.split(";");
					String[] asc = nums[0].split(",");
					String[] list = nums[1].split(",");
					StringBuilder st = new StringBuilder();
					int flag = 0;
					for(int i = 0; i < asc.length && flag == 0; i++) {
						for(int j = 0;j < list.length && flag == 0; j++) {
							if(asc[i].equals(list[j])) {
								while(asc[i].equals(list[j]))
								{
									st.append(asc[i]);
									st.append(",");
									if(i < asc.length - 1)
										i++; 
									if(j < list.length - 1)
										j++;
								}
								flag = 1;
							}
						}
					}
					if(st.length() > 0)
					System.out.println(st.deleteCharAt(st.length() - 1));
					else
						System.out.println();
				}
			}
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);

	}
}
