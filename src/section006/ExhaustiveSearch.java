package section006;

import java.util.Scanner;

/**
 * 全探索
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_5_A&lang=ja">ALDS1_5_A</a>
 */
public class ExhaustiveSearch {

	private static int n;
	private static int a[] = new int[100];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			if (canSolve(0, sc.nextInt())) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}

		sc.close();
	}

	private static boolean canSolve(int i, int m) {
		if (m == 0) return true;
		if (i >= n) return false;
		return canSolve(i + 1, m) || canSolve(i + 1, m - a[i]);
	}

}
