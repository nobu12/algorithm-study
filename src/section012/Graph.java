package section012;

import java.util.Arrays;
import java.util.Scanner;

/**
 * グラフの表現
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_11_A&lang=ja">ALDS1_11_A</a>
 */
public class Graph {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int g[][] = new int[n][n];

		for (int x[] : g) {
			Arrays.fill(x, 0);
		}

		for (int i = 0; i < n; i++) {
			int u = sc.nextInt();
			int k = sc.nextInt();
			for (int j = 0; j < k; j++) {
				int v = sc.nextInt();
				g[u - 1][v - 1] = 1;
			}
		}

		for (int x[] : g) {
			System.out.println(Arrays.toString(x).replace("[", "").replace("]", "").replace(",", ""));
		}

		sc.close();

	}

}
