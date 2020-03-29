package section012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * 連結成分
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_11_D&lang=ja">ALDS1_11_D</a>
 */
public class ConnectedComponents {

	private static int n, m;
	private static Map<Integer, List<Integer>> g = new HashMap<>();
	private static int color[] = new int[100000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 0; i < n; i++) {
			List<Integer> list = new ArrayList<>();
			g.put(i, list);
		}

		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int t = sc.nextInt();
			g.get(s).add(t);
			g.get(t).add(s);
		}

		assignColor();

		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			int s = sc.nextInt();
			int t = sc.nextInt();
			if (color[s] == color[t]) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}

		sc.close();
	}

	private static void assignColor() {
		int id = 1;
		Arrays.fill(color, -1);
		for (int i = 0; i < n; i++) {
			if (color[i] == -1) dfs(i, id++);
		}
	}

	private static void dfs(int r, int c) {
		Stack<Integer> s = new Stack<>();
		s.push(r);
		color[r] = c;
		while (!s.isEmpty()) {
			int u = s.pop();
			for (int v : g.get(u)) {
				if (color[v] == -1) {
					color[v] = c;
					s.push(v);
				}
			}
		}
	}

}
