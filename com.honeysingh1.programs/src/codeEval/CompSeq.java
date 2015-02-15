package codeEval;

// Prints the times a number appears and the number itself.
//https://www.codeeval.com/open_challenges/128/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class CompSeq {
	public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            if(!line.isEmpty())
            {

                String[] st = line.split("\\s");
                StringBuilder str = new StringBuilder();
                int[] num = new int[100];
                
                for(int i = 0; i < st.length - 1;i++)
                {
                	num[Integer.parseInt(st[i])]++;
                    if(Integer.parseInt(st[i]) != Integer.parseInt(st[i+1]))
                    {
                        str.append(num[Integer.parseInt(st[i])]+" "+Integer.parseInt(st[i])+" ");
                        num[Integer.parseInt(st[i])] = 0;
                    }
             
                }
                num[Integer.parseInt(st[st.length - 1])]++;
                str.append(num[Integer.parseInt(st[st.length - 1])]+" "+Integer.parseInt(st[st.length - 1]));
                System.out.println(str);
            }
        }
        System.exit(0);
    }
}
