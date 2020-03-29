package section012;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 深さ優先探索(再帰)
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_11_B&lang=ja">ALDS1_11_B</a>
 */
public class DepthFirstSearchRecursion {

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

		initColor();
		for (int i = 0; i < n; i++) {
			if (color[i] == WHITE) dfsRecursion(i);
		}

		for (int i = 0; i < n; i++) {
			System.out.println((i + 1) + " " + d[i] + " " + f[i]);
		}

		sc.close();
	}

	private static void initColor() {
		for (int i = 0; i < n; i++) {
			color[i] = WHITE;
		}
	}

	private static void dfsRecursion(int u) {
		color[u] = GRAY;
		d[u] = ++tt;
		for (int i = 0; i < n; i++) {
			if (M[u][i] == 1 && color[i] == WHITE) {
				dfsRecursion(i);
			}
		}
		color[u] = BLACK;
		f[u] = ++tt;
	}

}
