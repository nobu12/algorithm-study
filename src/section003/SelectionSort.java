package section003;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 選択ソート
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_2_B&lang=ja">ALDS1_2_B</a>
 */
public class SelectionSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		int count = selectionSort(a, n);

		System.out.println(Arrays.toString(a).replace("[", "").replace("]", "").replace(",", ""));
		System.out.println(count);

		sc.close();
	}

	private static int selectionSort(int[] a, int n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			int minj = i;
			for (int j = i; j < n; j++) {
				if (a[j] < a[minj]) {
					minj = j;
				}
			}
			int tmp = a[minj];
			a[minj] = a[i];
			a[i] = tmp;
			if (i != minj) count++;
		}
		return count;
	}

}
