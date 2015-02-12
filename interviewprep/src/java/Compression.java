package java;

import java.io.*;
import java.util.*;

public class Compression {
	static Scanner scanner;

	public static void main(String[] args) throws IOException {
		System.out.println("Enter:");
		setScanner(new Scanner(System.in));
		System.out.println(isUniqueChars(scanner.next()));
	}	
	
	public static String isUniqueChars(String str) {
		if (str.length() < 1)
			return "";
		char[] s_array = str.toCharArray();
		char c = s_array[0];
		int count = 1;
		StringBuffer s = new StringBuffer();
		for (int i = 1; i < s_array.length; i++) {
			if(c == s_array[i])
				count++;
			else
			{
				s.append(c);
				s.append(count);
				count = 1;
				c = s_array[i];
			}
		}
		s.append(c);
		s.append(count);
		if (s.length() >= str.length())
		{	
			return str;
		}
		else
			return s.toString();	
	}

	public static Scanner getScanner() {
		return scanner;
	}

	public static void setScanner(Scanner scanner) {
		Compression.scanner = scanner;
	}
} 
