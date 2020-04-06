package section017;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 0-1 ナップザック問題
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DPL_1_B&lang=ja">DPL_1_B</a>
 */
public class KnapsackProblem01 {
	private static int n, w;
	private static int c[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		w = sc.nextInt();
		Item item[] = new Item[n + 1];
		c = new int[n + 1][w + 1];

		for (int i = 0; i < n; i++) {
			Arrays.fill(c[i], 0);
		}

		for (int i = 1; i < n + 1; i++) {
			item[i] = new Item();
			item[i].value = sc.nextInt();
			item[i].weight = sc.nextInt();
		}

		knapsackProblem01(item);

		System.out.println(c[n][w]);

		sc.close();
	}

	private static void knapsackProblem01(Item item[]) {
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < w + 1; j++) {
				if (0 <= j - item[i].weight) {
					c[i][j] = Math.max(c[i - 1][j], c[i - 1][j - item[i].weight] + item[i].value);
				} else {
					c[i][j] = c[i - 1][j];
				}
			}
		}
	}

}

class Item {
	int value, weight;
}