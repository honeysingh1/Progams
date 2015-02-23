package moderate;
//https://www.codeeval.com/open_challenges/12/

import java.io.*;

public class FirstNonRepeatedCh {
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (!line.isEmpty()) {
				for (int i = 0; i < line.length(); i++) {
					if (i == 0) {
						String f = line.substring(i+1);
						if (!f.contains(Character.toString(line.charAt(i)))) {
							System.out.println(line.charAt(i));
							break;
						}
					} else if (i == 1) {
						String f = line.substring(i+1);
						if (!f.contains(Character.toString(line.charAt(i)))
								&& line.charAt(0) != line.charAt(i)) {
							System.out.println(line.charAt(i));
							break;
						}
					} else {
						String f = line.substring(i+1);
						String l = line.substring(0, i);
						if(!f.contains(Character.toString(line.charAt(i))) && !l.contains(Character.toString(line.charAt(i)))) 
						{
							System.out.println(line.charAt(i));
							break;
						}
					}
				}
			}

		}
		buffer.close();
		System.exit(0);

	}
}
