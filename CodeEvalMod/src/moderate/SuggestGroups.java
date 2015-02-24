package moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SuggestGroups {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			Map<String, List<String>> fr = new HashMap<String, List<String>>();
			Map<String, List<String>> gr = new HashMap<String, List<String>>();
			Map<String, List<String>> frnd = null;
			Map<String, List<String>> grp = null;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] wrd = line.split(":");
					List<String> friends = null;
					List<String> groups = null;
					if(!wrd[1].isEmpty())
					{
						friends = Arrays.asList(wrd[1].split(","));
					}
					if(wrd.length > 2)
					{
						groups =  Arrays.asList(wrd[2].split(","));
					}
					fr.put(wrd[0], friends);
					gr.put(wrd[0], groups);
					frnd= new TreeMap<String, List<String>>(fr);
					grp = new TreeMap<String, List<String>>(gr);
				}
			}
			find(frnd, grp);
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}

	private static void find(Map<String, List<String>> frnd,Map<String, List<String>> grp) {
		List<String> groups = null;
		for(Entry<String, List<String>> people: frnd.entrySet())
		{
			Map<String, Integer> cmngrp = new HashMap<String, Integer>();
			List<String> friends =  people.getValue();
			String name = people.getKey();
			int count = 1;
			for(int i = 0; i < friends.size(); i++)
			{
				groups = grp.get(friends.get(i));
				if(groups != null)
				{
					for(int j = 0; j < groups.size(); j++)
					{
						if(cmngrp.isEmpty())
						{
							cmngrp.put(groups.get(j), 1);
						}
						else
						{
							if(cmngrp.containsKey(groups.get(j)))
							{
								count = cmngrp.get(groups.get(j));
								cmngrp.put(groups.get(j), ++count);
							}
							else
							{
								cmngrp.put(groups.get(j), 1);
							}
						}
					}
				}
			}
			int time = 0;
			Map<String, Integer> tcmn = new TreeMap<String, Integer>(cmngrp);
			StringBuilder st = new StringBuilder();
			for(Entry<String, Integer> c : tcmn.entrySet())
			{
				String act = c.getKey();
				boolean f = false;
				if(grp.get(name) != null)
				{
					f = grp.get(name).contains(act);
				}
				if(c.getValue() >= Math.ceil(friends.size()/2.0) && !f)
				{
					if(time == 0)
					{
						st.append(name+":");
						st.append(c.getKey()+",");
						time++;
					}
					else
					{
						st.append(c.getKey()+",");
					}
				}
			}
			if(st.length() != 0)
			System.out.println(st.deleteCharAt(st.length()-1));
		}
	}

}
