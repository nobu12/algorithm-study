package section008;

import java.util.Scanner;

/**
 * 二分木の表現
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_7_B&lang=ja">ALDS1_7_B</a>
 */
public class BinaryTrees {
	private static int sibling[] = new int[100005];
	private static int degree[] = new int[100005];
	private static int depth[] = new int[100005];
	private static int height[] = new int[100005];
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

		for (int i = 0; i < n; i++) {
			sibling[i] = getSibling(i);
			degree[i] = getDegree(i);
			depth[i] = getDepth(i);
			setHeight(i);
		}

		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < n; i++) {
			ans.append("node ").append(Integer.toString(i)).append(": parent = ").append(Integer.toString(t[i].parent))
				.append( ", sibling = ").append(Integer.toString(sibling[i]))
				.append(", degree = ").append(Integer.toString(degree[i]))
				.append(", depth = ").append(Integer.toString(depth[i]))
				.append(", height = ").append(Integer.toString(height[i]));
			if (depth[i] == 0) {
				ans.append(", root");
			} else if (t[i].left == -1 && t[i].right == -1) {
				ans.append(", leaf");
			} else {
				ans.append(", internal node");
			}
			ans.append("\n");
		}

		System.out.print(ans.toString());

		sc.close();
	}

	private static int getSibling(int i) {
		if (t[i].parent == -1) return -1;
		int p = t[i].parent;
		return t[p].left + t[p].right - i;
	}

	private static int getDegree(int i) {
		int count = 0;
		if (t[i].left != -1) count++;
		if (t[i].right != -1) count++;
		return count;
	}

	private static int getDepth(int i) {
		int d = 0;
		while (t[i].parent != -1) {
			i = t[i].parent;
			d++;
		}
		return d;
	}

	private static void setHeight(int i) {
		if (t[i].left != -1) return;
		if (t[i].right != -1) return;
		int p = t[i].parent;
		int h = 0;
		while (p != -1) {
			height[p] = Math.max(height[p], ++h);
			p = t[p].parent;
		}
	}

}
