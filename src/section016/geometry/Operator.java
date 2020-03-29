package section016.geometry;

import java.math.BigDecimal;

// 演算クラス
public class Operator {

	public static Point add(Point p1, Point p2) {
		BigDecimal p1x = new BigDecimal(Double.toString(p1.x));
		BigDecimal p1y = new BigDecimal(Double.toString(p1.y));
		BigDecimal p2x = new BigDecimal(Double.toString(p2.x));
		BigDecimal p2y = new BigDecimal(Double.toString(p2.y));

		return new Point(Double.valueOf(p1x.add(p2x).toPlainString()), Double.valueOf(p1y.add(p2y).toPlainString()));
	}

	public static Point sub(Point p1, Point p2) {
		BigDecimal p1x = new BigDecimal(Double.toString(p1.x));
		BigDecimal p1y = new BigDecimal(Double.toString(p1.y));
		BigDecimal p2x = new BigDecimal(Double.toString(p2.x));
		BigDecimal p2y = new BigDecimal(Double.toString(p2.y));

		return new Point(Double.valueOf(p1x.subtract(p2x).toPlainString()), Double.valueOf(p1y.subtract(p2y).toPlainString()));
	}

	public static Point multi(Point p1, double k) {
		BigDecimal _k = new BigDecimal(Double.toString(k));
		BigDecimal p1y = new BigDecimal(Double.toString(p1.y));
		return new Point(p1.x * k, Double.valueOf(p1y.multiply(_k).toPlainString()));
	}

	public static double norm(Point p) {
		BigDecimal px = new BigDecimal(Double.toString(p.x));
		BigDecimal py = new BigDecimal(Double.toString(p.y));

		return Double.valueOf(px.multiply(px).add(py.multiply(py)).toPlainString());
	}

	public static double abs(Point p) {
		return Math.sqrt(norm(p));
	}

}
