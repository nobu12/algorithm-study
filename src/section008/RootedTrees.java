package section008;

import java.util.Scanner;

/**
 * 根付き木の表現
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_7_A&lang=en">ALDS1_7_A</a>
 */
public class RootedTrees {
	private static int d[] = new int[100005];
	private static Node t[] = new Node[100005];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			t[i] = new Node();
		}

		int l = 0;
		for (int i = 0; i < n; i++) {
			int id = sc.nextInt();
			int k = sc.nextInt();
			for (int j = 0; j < k; j++) {
				int c = sc.nextInt();
				if (j == 0) {
					t[id].left = c;
				} else {
					t[l].right = c;
				}
				l = c;
				t[c].parent = id;
			}
		}

		int r = 0;
		for (int i = 0; i < n; i++) {
			if (t[i].parent == -1) r = i;
		}

		for (int i = 0; i < n; i++) {
			d[i] = getDepth(i);
		}

//		rec(r, 0);

		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < n; i++) {
			ans.append("node ").append(Integer.toString(i)).append(": parent = ").append(Integer.toString(t[i].parent))
			.append( ", depth = ").append(Integer.toString(d[i])).append(", ");
			if (d[i] == 0) {
				ans.append("root, ");
			} else if (t[i].left == -1) {
				ans.append("leaf, ");
			} else {
				ans.append("internal node, ");
			}

			ans.append("[");
			int c = t[i].left;
			while (c != -1) {
				if (c != t[i].left) {
					ans.append(", ");
				}
				ans.append(Integer.toString(c));
				c = t[c].right;
			}
			ans.append("]\n");
		}

		System.out.print(ans.toString());

		sc.close();
	}

	private static int getDepth(int i) {
		int d = 0;
		while (t[i].parent != -1) {
			i = t[i].parent;
			d++;
		}
		return d;
	}

// スタックオーバーフローするようだ
//	private static void rec(int i, int p) {
//		d[i] = p;
//		if (t[i].left != -1) rec(t[i].left, p + 1);
//		if (t[i].right != -1) rec(t[i].right, p);
//	}

}

class Node {
	int parent;
	int left;
	int right;

	Node() {
		this.parent = -1;
		this.left = -1;
		this.right = -1;
	}
}