package section005;

import java.util.Scanner;

/**
 * 線形探索
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_4_A&lang=ja">ALDS1_4_A</a>
 */
public class LinearSearch {

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
			if (linearSearch2(s, t[i]) != -1) answer++;
		}

		System.out.println(answer);

		sc.close();
	}

	private static int linearSearch1(int x[], int key) {
		for (int i = 0; i < x.length; i++) {
			if (x[i] == key) return i;
		}
		return NOT_FOUND;
	}

	private static int linearSearch2(int x[], int key) {
		int y[] = new int[x.length + 1];

		for (int i = 0; i < x.length; i++) y[i] = x[i];
		y[x.length] = key;

		int i = 0;
		while (y[i] != key) {
			i++;
		}
		if (i == x.length) return NOT_FOUND;
		return i;
	}

}
