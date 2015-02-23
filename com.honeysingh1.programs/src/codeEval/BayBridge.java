package codeEval;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class BayBridge {
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		Map<Integer, String> map = new HashMap<Integer, String>();
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (!line.isEmpty()) {
				String[] vals = line.split(":");
				map.put(Integer.parseInt(vals[0]), vals[1].trim());
			}
		}
		find(map);
		buffer.close();
		System.exit(0);
	}

	private static void find(Map<Integer, String> map) {
		int len = map.size();
		int i = 1;
		Map<Integer, Double> lat1 = new HashMap<Integer, Double>();
		Map<Integer, Double> lon1 = new HashMap<Integer, Double>();
		Map<Integer, Double> lat2 = new HashMap<Integer, Double>();
		Map<Integer, Double> lon2 = new HashMap<Integer, Double>();
		Map<Integer, Integer> val = new HashMap<Integer, Integer>();
		ArrayList<Integer> rep = new ArrayList<Integer>();
		while (i <= len) {
			String[] st = map.get(i).replaceAll(" ", "").split("],\\[");
			st[0] = st[0].replaceAll("\\(\\[", "");
			st[1] = st[1].replaceAll("\\]\\)", "");
			String[] pt1 = st[0].split(",");
			lat1.put(i, Double.parseDouble(pt1[0]));
			lon1.put(i, -1 * Double.parseDouble(pt1[1]));
			String[] pt2 = st[1].split(",");
			lat2.put(i, Double.parseDouble(pt2[0]));
			lon2.put(i, -1 * Double.parseDouble(pt2[1]));
			i++;
		}
		for (int j = 0; j < len; j++) {
			int temp = 0;
			int pos = 0;
			val = check(lat1, lat2, lon1, lon2, rep);
			for (Entry<Integer, Integer> entry : val.entrySet()) {
				if (temp < entry.getValue()) {
					temp = entry.getValue();
					pos = entry.getKey();
				}
			}
			System.out.println(val);
			if(pos == 0)
			{
				break;
			}
			else
			{
			lat1.remove(pos);
			lat2.remove(pos);
			lon1.remove(pos);
			lon2.remove(pos);
			val.remove(pos);
			rep.add(pos);
			}
		}
		Map<Integer, Double> tmap = new TreeMap<Integer, Double>(lat2);
		for (Entry<Integer, Double> entry : tmap.entrySet()) {
			System.out.println(entry.getKey());
		}
	}

	private static Map<Integer, Integer> check(Map<Integer, Double> lat1,
			Map<Integer, Double> lat2, Map<Integer, Double> lon1,
			Map<Integer, Double> lon2, ArrayList<Integer> rep) {
		int len = lat1.size();
		int[] n = new int[len + 1];
		Map<Integer, Integer> val = new HashMap<Integer, Integer>();
		for (int i = 1; i <= len; i++) {
			if (!rep.contains(i)) {
				for (int j = 1; j <= len; j++) {
					if (i != j && !rep.contains(j)) {
						if (((lat1.get(i) > lat1.get(j) && (lon1.get(i) > lon1
								.get(j))) && (lat2.get(i) < lat2.get(j) && lon2
								.get(i) < lon2.get(j)))
								|| ((lat1.get(i) < lat1.get(j) && lon1.get(i) < lon1
										.get(j)) && (lat2.get(i) > lat2.get(j) && lon2
										.get(i) > lon2.get(j)))) {
							val.put(i, ++n[i]);
						}

					}
				}
			}
		}
		return val;
	}

}
