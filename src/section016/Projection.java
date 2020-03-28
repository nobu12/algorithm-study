package section016;

import java.util.Scanner;

import section016.geometry.Operator;
import section016.geometry.Point;
import section016.geometry.Segment;

/**
 * 射影
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=CGL_1_A&lang=ja">CGL_1_A</a>
 */
public class Projection {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Segment s = new Segment();
		s.p1 = new Point(sc.nextInt(), sc.nextInt());
		s.p2 = new Point(sc.nextInt(), sc.nextInt());

		int q = sc.nextInt();

		for (int i = 0; i < q; i++) {
			int px = sc.nextInt();
			int py = sc.nextInt();

			Point p = new Point(px, py);
			Point x = project(s, p);
			System.out.println(x.x + " " + x.y);
		}

		sc.close();
	}

	private static Point project(Segment s, Point p) {
		Point base = Operator.sub(s.p2, s.p1);
		double r = Point.dot(Operator.sub(p, s.p1), base) / Operator.norm(base);
		return Operator.multi(Operator.add(s.p1, base), r);
	}

}
