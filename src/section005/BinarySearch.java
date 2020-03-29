package section005;

import java.util.Scanner;

/**
 * 二分探索
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_4_B&lang=ja">ALDS1_4_B</a>
 */
public class BinarySearch {

	private static final int NOT_FOUND = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s[] = new int[n];
		for (int i = 0; i < n; i++) {
			s[i] = sc.nextInt();
		}

		int q = sc.nextInt();
		int t[] = new int[q];
		for (int i = 0; i < q; i++) {
			t[i] = sc.nextInt();
		}

		int answer = 0;
		for (int i = 0; i < q; i++) {
			if (binarySearch(s, t[i]) != -1) answer++;
		}

		System.out.println(answer);

		sc.close();
	}

	private static int binarySearch(int x[], int key) {
		int left = 0;
		int right = x.length;
		int mid;

		while (left < right) {
			mid = (left + right) / 2;
			if (x[mid] == key) return mid;
			if (key < x[mid]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return NOT_FOUND;
	}

}
