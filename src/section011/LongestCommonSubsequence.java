package section011;

import java.util.Scanner;

/**
 * 最長共通部分列
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_10_C&lang=ja">ALDS1_10_C</a>
 */
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String X[] = sc.next().split("");
			String Y[] = sc.next().split("");
			System.out.println(lcs(X, Y));
		}

		sc.close();
	}

	private static int lcs(String X[], String Y[]) {
		int m = X.length;
		int n = Y.length;
		int c[][] = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) c[i][0] = 0;
		for (int i = 0; i <= n; i++) c[0][i] = 0;

		int maxl = 0;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (X[i - 1] .equals(Y[j - 1])) {
					c[i][j] = c[i - 1][j - 1] + 1;
				} else {
					c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
				}
				maxl = Math.max(maxl, c[i][j]);
			}
		}
		return maxl;
	}

}
