package section017;

import java.util.Arrays;
import java.util.Scanner;

/**
 * コイン問題
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DPL_1_A&lang=ja">DPL_1_A</a>
 */
public class CoinChangingProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int c[] = new int[m];
		int t[] = new int[50001];

		for (int i = 0; i < m; i++) {
			c[i] = sc.nextInt();
		}

		Arrays.fill(t, Integer.MAX_VALUE);
		t[0] = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j + c[i] <= n; j++) {
				t[j + c[i]] = Math.min(t[j] + 1, t[j + c[i]]);
			}
		}

		System.out.println(t[n]);

	}

}
