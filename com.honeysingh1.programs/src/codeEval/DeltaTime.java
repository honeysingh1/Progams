package codeEval;

//https://www.codeeval.com/open_challenges/166/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DeltaTime {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] str = line.split("\\s");
					String[] st1 = str[0].split(":");
					String[] st2 = str[1].split(":");
					int h1 = Integer.parseInt(st1[0]);
					int m1 = Integer.parseInt(st1[1]);
					int s1 = Integer.parseInt(st1[2]);
					int h2 = Integer.parseInt(st2[0]);
					int m2 = Integer.parseInt(st2[1]);
					int s2 = Integer.parseInt(st2[2]);
					int sec1 = h1 * 60 * 60 + m1 * 60 + s1;
					int sec2 = h2 * 60 * 60 + m2 * 60 + s2;
					int diff = Math.abs(sec1 - sec2);
					int hd = diff / 3600;
					int md = (diff - (hd * 3600)) / 60;
					int sd = diff - (md * 60) - (hd*3600);
					System.out.printf("%02d:%02d:%02d",hd,md,sd);
					System.out.println();
					
				}
			}
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}
}
