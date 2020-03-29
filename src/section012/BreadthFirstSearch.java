package section012;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * 幅優先探索
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_11_C&lang=ja">ALDS1_11_C</a>
 */
public class BreadthFirstSearch {

	private static final int N = 100;
	private static int n;
	private static int M[][] = new int[N][N];
	private static Deque<Integer> q = new ArrayDeque<>();
	private static int d[] = new int[N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		for (int x[] : M) {
			Arrays.fill(x, -1);
		}

		Arrays.fill(d, -1);

		for (int i = 0; i < n; i++) {
			int u = sc.nextInt();
			int k = sc.nextInt();
			for (int j = 0; j < k; j++) {
				M[u - 1][sc.nextInt() - 1] = 1;
			}
		}

		breadthFirstSearch(0);

		for (int i = 0; i < n; i++) {
			System.out.println((i + 1) + " " + d[i]);
		}

		sc.close();
	}

	private static void breadthFirstSearch(int s) {
		q.add(s);
		d[s] = 0;
		while (!q.isEmpty()) {
			int u = q.poll();
			for (int i = 0; i < n; i++) {
				if (M[u][i] == -1) continue;
				if (d[i] != -1) continue;
				d[i] = d[u] + 1;
				q.add(i);
			}
		}
	}

}
