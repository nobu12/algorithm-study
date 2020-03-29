package section018;

import java.util.Scanner;

/**
 * 最大公約数
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_1_B&lang=ja">ALDS1_1_B</a>
 */
public class GreatestCommonDivisor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();

		System.out.println(gcd(x, y));

		sc.close();
	}

	private static int gcd(int x, int y) {
		if (x < y) {
			int tmp = x;
			x = y;
			y = tmp;
		}

		while (0 < y) {
			int r = x % y;
			x = y;
			y = r;
		}

		return x;
	}

}
