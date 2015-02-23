package CodeEval;

//https://www.codeeval.com/open_challenges/112/

import java.io.*;
public class Swap {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            if (!line.isEmpty()) {
                line = line.trim();
                String[] str = line.split(" : ");
                String[] nums = str[0].split("\\s");
                String[] pat = str[1].split(", ");
    
                for(int i = 0; i < pat.length; i++)
                {
                    String[] pos = pat[i].split("-");
                    String temp = nums[Integer.parseInt(pos[0])];
                    nums[Integer.parseInt(pos[0])] = nums[Integer.parseInt(pos[1])];
                    nums[Integer.parseInt(pos[1])] = temp;
                }
                for(int i = 0; i < nums.length; i++)
                {
                	if(i == nums.length -1)
                		System.out.println(nums[i]);
                	else
                		System.out.print(nums[i]+" ");
                }
                
            }
        }
        buffer.close();
        System.exit(0);
    }
}
