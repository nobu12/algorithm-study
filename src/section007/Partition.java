package section007;

import java.util.Scanner;

/**
 * パーティション
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_6_B&lang=ja">ALDS1_6_B</a>
 */
public class Partition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		int q = partition(a, 0, n);

		for (int i = 0; i < n; i++) {
			if (0 < i) System.out.print(" ");
			if (i == q) System.out.print("[");
			System.out.print(a[i]);
			if (i == q) System.out.print("]");
		}
		System.out.println();

		sc.close();
	}

	private static int partition(int a[], int p, int r) {
		int j = p - 1;
		int x = a[r - 1];
		for (int i = p; i < r; i++) {
			if (a[i] <= x) {
				j++;
				int tmp = a[j];
				a[j] = a[i];
				a[i] = tmp;
			}
		}
		int tmp = a[r - 1];
		a[j] = x;
		a[r - 1] = tmp;

		return j;
	}

}
