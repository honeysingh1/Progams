package codeEval;
//https://www.codeeval.com/open_challenges/124/
import java.io.*;
import java.util.*;
public class DistToCity {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            if(!line.isEmpty())
            {
                ArrayList<Integer> dis = new ArrayList<Integer>();
                String[] st = line.split(";");
                for(int i = 0; i < st.length;i++)
                {
                    String[] city = st[i].split(",");
                    dis.add(Integer.parseInt(city[1]));
                }
                Collections.sort(dis);
                System.out.print(dis.get(0)+",");
                for(int i = 0; i< dis.size() - 1;i++)
                {
                	if(i == dis.size() - 2)
                		System.out.println(dis.get(i + 1) - dis.get(i));
                	else
                    System.out.print(dis.get(i + 1) - dis.get(i)+ ",");
                }
                
            }
        }
        buffer.close();
        System.exit(0);
    }
}
