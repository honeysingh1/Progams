package codeEval;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Fizz {

	public static void main(String[] args) throws IOException {
		Scanner scanner = null;
		// if (args.length > 0) {
		File file = new File("C://Users/Honey Singh/Desktop/test3.txt");

		try {
			scanner = new Scanner(file);
		} catch (Exception e) {
			System.err.println("File not found: " + e.toString());
			return;
		}
		// } else
		// System.out.println("Please provide a file path.");
		check(scanner);

	}

	private static void check(Scanner scanner) {
		// TODO Auto-generated method stub
		
	}

}
