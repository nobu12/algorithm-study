package section012;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 深さ優先探索(スタック)
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_11_B&lang=ja">ALDS1_11_B</a>
 */
public class DepthFirstSearchStack {

	private static final int N = 100;
	private static final int WHITE = 0;
	private static final int GRAY = 1;
	private static final int BLACK = 2;

	private static int n, tt;
	// 隣接行列
	private static int M[][] = new int[N][N];
	// 頂点の訪問状態
	private static int color[] = new int[N];
	// タイムスタンプ d[v]: v を最初に発見した発見時刻を記録
	private static int d[] = new int[N];
	// タイムスタンプ f[v]: v の隣接リストを調べ終えた完了時刻を記録
	private static int f[] = new int[N];
	// 各頂点の次に訪問する頂点のインデックスを記録
	private static int nt[] = new int[N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int x[] : M) {
			Arrays.fill(x, 0);
		}

		for (int i = 0; i < n; i++) {
			int u = sc.nextInt();
			int k = sc.nextInt();
			for (int j = 0; j < k; j++) {
				int v = sc.nextInt();
				M[u - 1][v - 1] = 1;
			}
		}

		dfsStack();

		sc.close();
	}

	private static int next(int u) {
		for (int i = nt[u]; i < n; i++) {
			// 次回本メソッドが呼ばれた時のために、nt[u]には次のインデックスを保存しておく
			nt[u] = i + 1;
			if (M[u][i] == 1) return i;
		}
		return -1;
	}

	private static void initColor() {
		for (int i = 0; i < n; i++) {
			color[i] = WHITE;
		}
	}

	private static void dfsStack() {
		initColor();

		for (int i = 0; i < n; i++) {
			// 未訪問の頂点を始点とする深さ優先探索
			if (color[i] == WHITE) dfsVisit(i);
		}

		for (int i = 0; i < n; i++) {
			System.out.println((i + 1) + " " + d[i] + " " + f[i]);
		}
	}

	private static void dfsVisit(int r) {
		for (int i = 0; i < n; i++) nt[i] = 0;

		Stack<Integer> s = new Stack<>();
		s.push(r);
		color[r] = GRAY;
		// 最初の訪問
		d[r] = ++tt;

		while (!s.empty()) {
			int u = s.lastElement();
			int v = next(u);
			if (v != -1) {
				if (color[v] == WHITE) {
					color[v] = GRAY;
					d[v] = ++tt;
					s.push(v);
				}
			} else {
				s.pop();
				color[u] = BLACK;
				f[u] = ++tt;
			}
		}
	}

}
