package section009;

import java.util.Scanner;

/**
 * 二分探索木：挿入
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_8_A&lang=ja">ALDS1_8_A</a>
 */
public class BinarySearchTreeI {

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
			} else if ("print".equals(command)) {
				tree.print(Tree.Order.InOrder);
				tree.print(Tree.Order.PreOrder);
			}
		}

		sc.close();
	}

}
