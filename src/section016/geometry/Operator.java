package section016.geometry;

// 演算クラス
public class Operator {

	public static Point add(Point p1, Point p2) {
		return new Point(p1.x + p2.x, p1.y + p2.y);
	}

	public static Point sub(Point p1, Point p2) {
		return new Point(p1.x - p2.x, p1.y - p2.y);
	}

	public static Point multi(Point p1, double k) {
		return new Point(p1.x * k, p1.y * k);
	}

	public static double norm(Point p) {
		return p.x * p.x + p.y * p.y;
	}

	public static double abs(Point p) {
		return Math.sqrt(norm(p));
	}

}
