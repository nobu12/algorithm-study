package section002;

import java.util.Scanner;

// http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_1_D&lang=ja
public class MaxProfit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r[] = new int[n];

		for (int i = 0; i < n; i++) {
			r[i] = sc.nextInt();
		}

		int maxv = r[1] - r[0];
		int minv = r[0];

		for (int i = 1; i < n; i++) {
			maxv = Math.max(maxv, r[i] - minv);
			minv = Math.min(minv, r[i]);
		}

		System.out.println(maxv);

		sc.close();
	}

}
