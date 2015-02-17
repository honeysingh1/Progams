package codeEval;

//https://www.codeeval.com/open_challenges/173/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WithoutRep {
	public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            if(!line.isEmpty())
            {
                int i = 0;
                StringBuilder st = new StringBuilder();
                while(i < line.length() - 1)
                {
                    if(line.charAt(i) != line.charAt(i + 1))
                    {
                        st.append(line.charAt(i));
                    }
                    i++;
                }
               
                    st.append(line.charAt(i));        
                
                System.out.println(st);
            }
        }
        buffer.close();
        System.exit(0);
    }
}
