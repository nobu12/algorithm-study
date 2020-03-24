package section003;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 挿入ソート
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_2_A&lang=ja">ALDS1_2_A</a>
 */
public class BubbleSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		int count = bubbleSort(a, n);

		System.out.println(Arrays.toString(a).replace("[", "").replace("]", "").replace(",", ""));
		System.out.println(count);

		sc.close();
	}

	private static int bubbleSort(int[] a, int n) {
		int count = 0;
		boolean flg = true;
		while (flg) {
			flg = false;
			for (int i = n - 1; 0 < i; i--) {
				if (a[i] < a[i - 1]) {
					int tmp = a[i - 1];
					a[i - 1] = a[i];
					a[i] = tmp;
					flg = true;
					count++;
				}
			}
		}
		return count;
	}

}
