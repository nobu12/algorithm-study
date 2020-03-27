package section016.geometry;

// 点クラス
public class Point {
	public double x, y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public static double dot(Point p1, Point p2) {
		return p1.x * p2.x + p1.y * p2.y;
	}

	public static double cross(Point p1, Point p2) {
		return p1.x * p2.y - p1.y * p2.x;
	}

}
