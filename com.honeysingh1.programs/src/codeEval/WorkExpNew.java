package codeEval;

//https://www.codeeval.com/open_challenges/139/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WorkExpNew {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				Map<Integer, Integer> map = new HashMap<Integer, Integer>();
				if (!line.isEmpty()) {
					String[] wrd = line.split("; ");
					int size = wrd.length;
					for(int i = 0; i < size; i++)
					{
						String[] d = wrd[i].split("-");
						String[] start = d[0].split("\\s");
						String[] end = d[1].split("\\s");
						int star = monthToDig(start[0]);
						int en = monthToDig(end[0]);
						int stary = Integer.parseInt(start[1]);
						int eny = Integer.parseInt(end[1]);
						if(stary == eny)
						{
							for(int j = star; j <= en; j++)
							{
								map.put(j*stary*12, 1);
							}
						}
						else
						{
							int year = stary;
							for(int j = star; j <= star+(((((eny - stary)*12)+12)-star)-(12-en)); j++)
							{
								if(j%12 == 0)
								{
									map.put(12*year*12, 1);
									year++;
								}
								else
								{
									map.put((j%12)*year*12, 1);
								}
							}
						}
						
					}
					System.out.println(map.entrySet().size()/12);
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}

	private static int monthToDig(String str) {
		switch(str)
		{
		case "Jan":
			return 1;
		case "Feb": 
			return 2;
		case "Mar": 
			return 3;
		case "Apr": 
			return 4;
		case "May": 
			return 5;
		case "Jun": 
			return 6;
		case "Jul": 
			return 7;
		case "Aug": 
			return 8;
		case "Sep": 
			return 9;
		case "Oct": 
			return 10;
		case "Nov": 
			return 11;
		case "Dec": 
			return 12;
		}
		return 0;
	}
}

