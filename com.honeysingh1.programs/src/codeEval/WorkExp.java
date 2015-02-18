package codeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public class WorkExp {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					SimpleDateFormat myFormat = new SimpleDateFormat("MMM yyyy");
					SimpleDateFormat myFor = new SimpleDateFormat("dd MMM yyyy");
					String[] str = line.split("; ");
					Map<Date, Date> map = new HashMap<Date, Date>();
					for (int i = 0; i < str.length; i++) {
						String[] mon = str[i].split("-");
						try {
							map.put((myFormat.parse(mon[0])), myFor.parse(30 + " " + mon[1]));
						} catch (ParseException e) {
						}
					}
					Map<Date,Date> tmap = new TreeMap<Date, Date>(map);
					ArrayList<Date> arr = new ArrayList<Date>();
					for(Entry<Date, Date> entry : tmap.entrySet()){
						arr.add(entry.getKey());
						arr.add(entry.getValue());
					}
					long diff = 0;
					int flag = 0;
					for(int i = 0; i< arr.size()-1;i+=2)
					{
						if(flag == 1 && arr.get(i).before(arr.get(i - 1)) && arr.get(i+1).before(arr.get(i - 1)))
						{
							/*if(arr.get(i).before(arr.get(i - 2)) && arr.get(i+1).before(arr.get(i - 2)))
							{	
								diff += arr.get(i).getTime()-arr.get(i + 1).getTime();
							}
							else if(arr.get(i).before(arr.get(i - 2)) && arr.get(i+1).after(arr.get(i - 2)))
							{
								diff += arr.get(i).getTime()-arr.get(i - 2).getTime();
							}*/
						}
						else if(flag == 1 && arr.get(i).before(arr.get(i - 1)) && arr.get(i+1).after(arr.get(i - 1)))
						{
							diff +=  arr.get(i).getTime() - arr.get(i+1).getTime();
						}
						else
						{
							diff +=  arr.get(i).getTime() - arr.get(i + 1).getTime();
							flag = 1;
						}
					
					}
					System.out.println(-1*(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)/365)); 
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}
}
