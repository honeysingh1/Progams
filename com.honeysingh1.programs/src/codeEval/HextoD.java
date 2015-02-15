package codeEval;

import java.io.*;
public class HextoD {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            int len = line.length() - 1;
            line = line.toUpperCase();
            int tot = 0;
            int count = 26;
            while(len > 0)
            {
            	if(Character.isLetter(line.charAt(len)))
            	{
            		tot += count ;
            	}
            	len--;
            }
            System.out.println(tot);
        }
        System.exit(0);
    }
}
