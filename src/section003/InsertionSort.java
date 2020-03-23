package section003;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 挿入ソート
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_1_A&lang=ja">ALDS1_1_A</a>
 */
public class InsertionSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		insertionSort(a, n);

		sc.close();
	}

	private static void insertionSort(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			int v = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > v) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = v;
			System.out.println(Arrays.toString(a).replace("[", "").replace("]", "").replace(",", ""));
		}
	}

}
