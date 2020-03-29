package section018;

import java.util.Scanner;

/**
 * べき乗
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=NTL_1_B&lang=ja">NTL_1_B</a>
 */
public class Power {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();

		System.out.println(power(m, n));

		sc.close();
	}

	private static long power(long m, long n) {
		if (n == 0) return 1;
		long res = power(m, n / 2);
		if (n % 2 == 0) {
			return res * res % 1000000007;
		} else {
			return ((res * res % 1000000007) * m) % 1000000007;
		}
	}

}
