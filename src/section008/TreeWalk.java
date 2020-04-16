package section008;

import java.util.Scanner;

/**
 * 木の巡回
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_7_C&lang=ja">ALDS1_7_C</a>
 */
public class TreeWalk {

	private static Node t[] = new Node[100005];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			t[i] = new Node();
		}

		for (int i = 0; i < n; i++) {
			int id = sc.nextInt();
			t[id].left = sc.nextInt();
			t[id].right = sc.nextInt();
			if (t[id].left != -1) {
				t[t[id].left].parent = id;
			}
			if (t[id].right != -1) {
				t[t[id].right].parent = id;
			}
		}

		int root = 0;
		for (int i = 0; i < n; i++) {
			if (t[i].parent == -1) root = i;
		}

		System.out.println("Preorder");
		preParse(root);
		System.out.println();
		System.out.println("Inorder");
		inParse(root);
		System.out.println();
		System.out.println("Postorder");
		postParse(root);
		System.out.println();

		sc.close();
	}

	private static void preParse(int u) {
		if (u == -1) return;
		System.out.print(" " + u);
		preParse(t[u].left);
		preParse(t[u].right);
	}

	private static void inParse(int u) {
		if (u == -1) return;
		inParse(t[u].left);
		System.out.print(" " + u);
		inParse(t[u].right);
	}

	private static void postParse(int u) {
		if (u == -1) return;
		postParse(t[u].left);
		postParse(t[u].right);
		System.out.print(" " + u);
	}

}
