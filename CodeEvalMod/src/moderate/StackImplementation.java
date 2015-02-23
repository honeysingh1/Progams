package moderate;
//https://www.codeeval.com/open_challenges/9/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class StackImplementation {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] num = line.split("\\s");
					int size = num.length;
					Stack<Integer> st = new Stack<Integer>();
					for (int i = 0; i < size; i++) {
						push(st, Integer.parseInt(num[i]));
					}
					System.out.print(st.pop()+" ");
					for (int i = size - 1; i > 0; i -= 2) {
						pop(st);
						if(i - 1 > 0)
						{
							System.out.print(st.pop()+" ");
						}
					}
					System.out.println();
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		System.exit(0);
	}

	private static void pop(Stack<Integer> st) {
		st.pop();
	}

	private static void push(Stack<Integer> st, int i) {
		st.push(i);
	}
}
