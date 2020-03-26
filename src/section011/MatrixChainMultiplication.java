package section011;

import java.util.Scanner;

/**
 * 連鎖行列積
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_10_B&lang=ja">ALDS1_10_B</a>
 */
public class MatrixChainMultiplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p[] = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			p[i - 1] = sc.nextInt();
			p[i] = sc.nextInt();
		}

		int m[][] = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) m[i][i] = 0;
		// hはiとjの間隔
		for (int h = 2; h <= n; h++) {
			for (int i = 1; i <= n - h + 1; i++) {
				int j = i + h - 1;
				m[i][j] = Integer.MAX_VALUE;
				for (int k = i; k <= j - 1; k++) {
					m[i][j] = Math.min(m[i][j], m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j]);
				}
			}
		}

		System.out.println(m[1][n]);

		sc.close();
	}

}
