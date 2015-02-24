package moderate;
//https://www.codeeval.com/open_challenges/41/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ArrayAbsurdity {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] wrd = line.split(";");
					String[] ch = wrd[1].split(",");
					int[] n = new int[ch.length];
					for (int i = 0; i < ch.length; i++) {
						if (++n[Integer.parseInt(ch[i])] > 1) {
							System.out.println(Integer.parseInt(ch[i]));
							break;
						}
					}
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}
}
