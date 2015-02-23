package moderate;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GuessTheNumber {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] wrd = line.split("\\s");
					int b = Integer.parseInt(wrd[0]);
					int i = 0;
					int up = b;
					int low = 0;
					int mid = 0;
					while(!wrd[i].equals("Yay!"))
					{
						if(wrd[i].equals("Lower"))
						{
							mid = (low + up)/2;
							low = low;
							up = mid/2;
						}
						else if(wrd[i].equals("Higher"))
						{
							mid = (low + up)/2;
							low = mid;
							up = mid + mid/2;
						}
						i++;
					}
					System.out.println(mid);
				}
				
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}
}
