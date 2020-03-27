package section016;

import java.util.Scanner;

import section016.geometry.Operator;
import section016.geometry.Point;
import section016.geometry.Segment;

/**
 * 直線の直交・平行判定
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=CGL_2_A&lang=ja">CGL_2_A</a>
 */
public class ParallelOrthogonal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p[][][] = new int[n][4][2];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 2; k++) {
					p[i][j][k] = sc.nextInt();
				}
			}
		}

		for (int i = 0; i < n; i++) {
			Point p0 = new Point(p[i][0][0], p[i][0][1]);
			Point p1 = new Point(p[i][1][0], p[i][1][1]);
			Point p2 = new Point(p[i][2][0], p[i][2][1]);
			Point p3 = new Point(p[i][3][0], p[i][3][1]);

			if (isParallel(p0, p1, p2, p3)) {
				System.out.println(2);
			} else if (isOrthogonal(p0, p1, p2, p3)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}

		sc.close();
	}

	// 平行判定
	private static boolean isParallel(Point a, Point b) {
		return Point.cross(a, b) == 0.0;
	}

	private static boolean isParallel(Point a1, Point a2, Point b1, Point b2) {
		return isParallel(Operator.sub(a1, a2), Operator.sub(b1, b2));
	}

	private static boolean isParallel(Segment s1, Segment s2) {
		return Point.dot(Operator.sub(s1.p2, s1.p1), Operator.sub(s2.p2, s2.p1)) == 0.0;
	}

	// 直交判定
	private static boolean isOrthogonal(Point a, Point b) {
		return Point.dot(a, b) == 0.0;
	}

	private static boolean isOrthogonal(Point a1, Point a2, Point b1, Point b2) {
		return isOrthogonal(Operator.sub(a1, a2), Operator.sub(b1, b2));
	}

	private static boolean isOrthogonal(Segment s1, Segment s2) {
		return Point.dot(Operator.sub(s1.p2, s1.p1), Operator.sub(s2.p2, s2.p1)) == 0.0;
	}

}
