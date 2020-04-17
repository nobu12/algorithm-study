package section010;

import java.util.Scanner;

/**
 * 最大・最小ヒープ
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_9_B&lang=ja">ALDS1_9_B</a>
 */
public class MaximumHeap {
	private static int n;
	private static int a[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}

		for (int i = n / 2; 1 <= i; i--) maxHeapify(i);

		for (int i = 1; i <= n; i++) System.out.print(" " + a[i]);
		System.out.println();

		sc.close();
	}

	private static void maxHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int largest = Integer.MIN_VALUE;
		if (l <= n && a[l] > a[i]) largest = l;
		else largest = i;
		if (r <= n && a[r] > a[largest]) largest = r;

		if (largest != i) {
			int tmp = a[largest];
			a[largest] = a[i];
			a[i] = tmp;
			maxHeapify(largest);
		}
	}

	private static int left(int i) {
		return 2 * i;
	}

	private static int right(int i) {
		return 2 * i + 1;
	}

}
