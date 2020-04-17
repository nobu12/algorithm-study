package section010;

import java.util.Scanner;

/**
 * 完全二分木
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_9_A&lang=ja">ALDS1_9_A</a>
 */
public class CompleteBinaryTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append("node ").append(i).append(": key = ").append(a[i]).append(", ");
			if (parent(i) >= 1) sb.append("parent key = ").append(a[parent(i)]).append(", ");
			if (left(i) <= n) sb.append("left key = ").append(a[left(i)]).append(", ");
			if (right(i) <= n) sb.append("right key = ").append(a[right(i)]).append(", ");
			sb.append("\n");
		}

		System.out.print(sb.toString());

		sc.close();

	}

	private static int parent(int i) {
		return i / 2;
	}

	private static int left(int i) {
		return 2 * i;
	}

	private static int right(int i) {
		return 2 * i + 1;
	}

}
