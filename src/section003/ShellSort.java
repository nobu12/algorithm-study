package section003;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * シェルソート
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_2_D&lang=ja">ALDS1_2_D</a>
 */
public class ShellSort {

	private static List<Integer> g = new ArrayList<>();
	private static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		shellSort(a, n);

		System.out.println(g.size());
		for (int i = 0; i < g.size(); i++) {
			if (i == g.size() - 1) {
				System.out.print(g.get(i));
			} else {
				System.out.print(g.get(i) + " ");
			}
		}

		System.out.println();

		System.out.println(count);

		for (int i = 0; i < n; i++) {
			System.out.println(a[i]);
		}

		sc.close();
	}

	private static void shellSort(int[] a, int n) {
		for (int h = 1; ;) {
			if (h > n) break;
			g.add(0, h);
			h = 3 * h + 1;
		}

		for (int i = 0; i < g.size(); i++) {
			insertionSort(a, n, g.get(i));
		}
	}

	private static void insertionSort(int[] a, int n, int g) {
		for (int i = g; i < n; i++) {
			int v = a[i];
			int j = i - g;
			while (j >= 0 && a[j] > v) {
				a[j + g] = a[j];
				j -= g;
				count++;
			}
			a[j + g] = v;
		}
	}

}
