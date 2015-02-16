package codeEval;

//https://www.codeeval.com/open_challenges/149/

import java.io.*;

public class JugWZero {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            if(!line.isEmpty())
            {
                String[] str = line.split("\\s");
                StringBuilder st = new StringBuilder();
                for(int i = 0;  i < str.length; i+=2)
                {
                    if(str[i].equals("0"))
                    {
                        st.append(str[i+1]);   
                    }
                    else if (str[i].equals("00"))
                    {
                        str[i+1] = str[i+1].replaceAll("0","1");
                        st.append(str[i+1]);
                    }
                }
                int pos = st.toString().indexOf('1');
                if(pos != -1)
                {
                	String newst = st.substring(pos, st.length());
                	System.out.println(Long.parseLong(newst, 2));
                }
                else 
                	System.out.println(Long.parseLong(st.toString(), 2));
            
            }
        }
        System.exit(0);
    }
}
