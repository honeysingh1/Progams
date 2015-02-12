package interviewprep;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Davyncy {
	static StringBuffer fin = new StringBuffer();

	public static void main(String[] args) throws IOException {
		Scanner scanner = null;
		// if (args.length > 0) {
		File file = new File("C://Users/Honey Singh/Desktop/test.txt");

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
		char[] st2;
		char[] st = null;
		int temp = 0;
		List<String> start = new ArrayList<String>();
		int pos = 0;
		int count = 0;
		int j = 0;
		while (scanner.hasNextLine()) {
			int flag = 0;
			List<String> stlist = Arrays.asList(scanner.nextLine().split(";"));
			if (stlist.isEmpty()) {
				System.out.println("No input found");
				return;
			} else {
				stlist = checkStart(stlist);
				}
			
			//System.out.println(stlist);
		}

	}

	private static List<String> checkStart(List<String> stlist) {
		int temp = 0;
		int len = 0;
		int pos = 0;
		Object tem = null;
		Iterator itr = stlist.iterator();
		while (itr.hasNext()) {
			Object element = itr.next();
			if (Character.isUpperCase(element.toString().charAt(0))) {
				len = element.toString().length();
				tem = element;
				itr.remove();
				System.out.println("in chk " + element);
				//itr.remove();
				if (temp < len) {
					temp = len;
					tem = element;
					//System.out.println(element);
				}
			}	
		}
		//stlist.add(tem.toString());
		System.out.println(stlist);
		return stlist;
	}

	private static int chkfor(char[] st, char[] st2) {
		int count = 0;

		int j = 0;
		int place = 0;

		for (int i = 0; i < st2.length - 1; i++) {
			if (st[0] == st2[i] && st[1] == st2[i + 1]) {
				place = i;
				while (place < st2.length && j < st.length
						&& (st[j++] == st2[place++])) {
					count++;
				}
			}
		}
		return count;

	}
}
