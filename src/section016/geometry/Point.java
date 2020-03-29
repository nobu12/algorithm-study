package section016.geometry;

import java.math.BigDecimal;

// 点クラス
public class Point {
	public double x, y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public static double dot(Point p1, Point p2) {
		BigDecimal p1x = new BigDecimal(Double.toString(p1.x));
		BigDecimal p1y = new BigDecimal(Double.toString(p1.y));
		BigDecimal p2x = new BigDecimal(Double.toString(p2.x));
		BigDecimal p2y = new BigDecimal(Double.toString(p2.y));

		return Double.valueOf(p1x.multiply(p2x).add(p1y.multiply(p2y)).toPlainString());
	}

	public static double cross(Point p1, Point p2) {
		BigDecimal p1x = new BigDecimal(Double.toString(p1.x));
		BigDecimal p1y = new BigDecimal(Double.toString(p1.y));
		BigDecimal p2x = new BigDecimal(Double.toString(p2.x));
		BigDecimal p2y = new BigDecimal(Double.toString(p2.y));

		return Double.valueOf(p1x.multiply(p2y).subtract(p1y.multiply(p2x)).toPlainString());
	}

}
