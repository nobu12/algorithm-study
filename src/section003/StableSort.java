package section003;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 安定なソート
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_2_C&lang=ja">ALDS1_2_C</a>
 */
public class StableSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String a[] = new String[n];
		String b[] = new String[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.next();
		}

		System.arraycopy(a, 0, b, 0, a.length);

		bubbleSort(a, n);
		System.out.println(Arrays.toString(a).replace("[", "").replace("]", "").replace(",", ""));
		System.out.println("Stable");

		selectionSort(b, n);
		System.out.println(Arrays.toString(b).replace("[", "").replace("]", "").replace(",", ""));
		if (Arrays.equals(a, b)) {
			System.out.println("Stable");
		} else {
			System.out.println("Not stable");
		}

		sc.close();
	}

	private static void bubbleSort(String[] a, int n) {
		boolean flg = true;
		while (flg) {
			flg = false;
			for (int i = n - 1; 0 < i; i--) {
				if (a[i].charAt(1) < a[i - 1].charAt(1)) {
					String tmp = a[i - 1];
					a[i - 1] = a[i];
					a[i] = tmp;
					flg = true;
				}
			}
		}
	}

	private static void selectionSort(String[] a, int n) {
		for (int i = 0; i < n; i++) {
			int minj = i;
			for (int j = i; j < n; j++) {
				if (a[j].charAt(1) < a[minj].charAt(1)) {
					minj = j;
				}
			}
			String tmp = a[minj];
			a[minj] = a[i];
			a[i] = tmp;
		}
	}

}
