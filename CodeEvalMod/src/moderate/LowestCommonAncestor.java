package moderate;

//https://www.codeeval.com/open_challenges/11/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LowestCommonAncestor {
	public static void main(String args[]) throws IOException {
        Node root = new Node(30);
        root.l = new Node(8);
        root.r = new Node(52);
        root.l.l = new Node(3);
        root.l.r = new Node(20);
        root.l.r.l = new Node(10);
        root.l.r.r = new Node(29);
        File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(!line.isEmpty())
			{
				String[] num = line.split("\\s");
				Node a = new Node(Integer.parseInt(num[0]));
				Node b = new Node(Integer.parseInt(num[1]));
				System.out.println(lca(root,a.val,b.val).val);
			}
		}
		in.close();
    }
     
    public static Node lca(Node root, int val, int val2) {
 
        Node l = null;
        Node r = null;
 
        if (root == null) {
            return null;
        }
        if (root.val == val || root.val == val2) {
            return root;
        }
        l = lca(root.l, val, val2);
        r = lca(root.r, val, val2);
 
        if (l != null && r != null) {
            return root;
        }
        return (l != null) ? l : r;
    }
}
class Node {
    Node l;
    Node r;
    int val;
     
    public Node(int val) {
        l = null;
        r = null;
        this.val = val;
    }
}
