package section006;

import java.util.Scanner;

/**
 * コッホ曲線
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_5_C&lang=ja">ALDS1_5_C</a>
 */
public class KochCurve {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		Point a = new Point();
		Point b = new Point();

		a.x = 0;
		a.y = 0;
		b.x = 100;
		b.y = 0;

		System.out.println(a.x + " " + a.y);
		koch(n, a, b);
		System.out.println(b.x + " " + b.y);


		sc.close();
	}

	private static void koch(int n, Point a, Point b) {
		if (n == 0) return;

		Point s = new Point();
		Point t = new Point();
		Point u = new Point();

		// 度からラジアンへ単位を変換
		double th = Math.PI * 60.0 / 180.0;

		s.x = (2.0 * a.x + 1.0 * b.x) / 3.0;
		s.y = (2.0 * a.y + 1.0 * b.y) / 3.0;
		t.x = (1.0 * a.x + 2.0 * b.x) / 3.0;
		t.y = (1.0 * a.y + 2.0 * b.y) / 3.0;
		u.x = (t.x - s.x) * Math.cos(th) - (t.y - s.y)* Math.sin(th) + s.x;
		u.y = (t.x - s.x) * Math.sin(th) + (t.y - s.y)* Math.cos(th) + s.y;

		koch(n - 1, a, s);
		System.out.println(s.x + " " + s.y);
		koch(n - 1, s, u);
		System.out.println(u.x + " " + u.y);
		koch(n - 1, u, t);
		System.out.println(t.x + " " + t.y);
		koch(n - 1, t, b);

	}

}

class Point {
	double x, y;
}
