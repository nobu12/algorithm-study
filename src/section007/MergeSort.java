package section007;

import java.util.Arrays;
import java.util.Scanner;

/**
 * マージソート
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_5_B&lang=ja">ALDS1_5_B</a>
 */
public class MergeSort {

	private static int count = 0;
	private static int l[] = new int[1000000];
	private static int r[] = new int[1000000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		Arrays.fill(l, Integer.MAX_VALUE);
		Arrays.fill(r, Integer.MAX_VALUE);

		mergeSort(a, n, 0, n);

		System.out.println(Arrays.toString(a).replace("[", "").replace("]", "").replace(",", ""));
		System.out.println(count);

		sc.close();

	}

	private static void mergeSort(int a[], int n, int left, int right) {
		if (left + 1 < right) {
			int mid = (left + right) / 2;
			mergeSort(a, n, left, mid);
			mergeSort(a, n, mid, right);
			merge(a, n, left, mid, right);
		}
	}

	private static void merge(int a[], int n, int left, int mid, int right) {
		for (int i = 0; i < mid - left; i++) l[i] = a[left + i];
		for (int i = 0; i < right - mid; i++) r[i] = a[mid + i];

		l[mid - left] = r[right - mid] = Integer.MAX_VALUE;

		int j = 0, k = 0;
		for (int i = left; i < right; i++) {
			count++;
			if (l[j] <= r[k]) {
				a[i] = l[j++];
			} else {
				a[i] = r[k++];
			}
		}
	}

}
