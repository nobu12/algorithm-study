package section009;

import java.util.Scanner;

/**
 * 二分探索木：探索
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_8_B&lang=ja">ALDS1_8_B</a>
 */
public class BinarySearchTreeII {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		String command;
		Tree tree = new Tree();
		for (int i = 0; i < n; i++) {
			command = sc.next();
			if ("insert".equals(command)) {
				int key = sc.nextInt();
				tree.insert(new Node(key));
			} else if ("find".equals(command)) {
				int key = sc.nextInt();
				System.out.println(tree.exists(key) ? "yes" : "no");
			} else if ("print".equals(command)) {
				tree.print(Tree.Order.InOrder);
				tree.print(Tree.Order.PreOrder);
			}
		}

		sc.close();
	}

}
