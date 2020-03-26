package section011;

import java.util.Arrays;
import java.util.Scanner;

/**
 * フィボナッチ数列
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_10_A&lang=ja">ALDS1_10_A</a>
 */
public class FibonacciNumber {
	private static int dp[] = new int[50];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		Arrays.fill(dp, -1);
		fibDp(n);
//		fibRf(n);

		System.out.println(dp[n]);

		sc.close();
	}

	// 動的計画法
	private static int fibDp(int n) {
		if (n == 1 || n == 0) return 1;
		if (dp[n] != -1) return dp[n];
		return dp[n] = fibDp(n - 1) + fibDp(n - 2);
	}

	// 漸化式
	private static void fibRf(int n) {
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
	}

}
