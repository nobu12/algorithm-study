package section004;

import java.util.Scanner;

/**
 * キュー
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_3_B&lang=ja">ALDS1_3_B</a>
 */
public class Queue {

	private static final int LEN = 100005;
	private static int head, tail;
	private static P Q[] = new P[LEN];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();

		for (int i = 0; i < LEN; i++) {
			Q[i] = new P();
		}

		for (int i = 1; i <= n; i++) {
			Q[i].name = sc.next();
			Q[i].t = sc.nextInt();
		}

		head = 1;
		tail = n + 1;

		P u;
		int elapse = 0;
		while (head != tail) {
			u = dequeue();
			int c = Math.min(q, u.t);
			u.t -= c;
			elapse += c;
			if (0 < u.t) {
				enqueue(u);
			} else {
				System.out.println(u.name + " " + elapse);
			}
		}

		sc.close();
	}

	private static void enqueue(P x) {
		Q[tail] = x;
		tail = (tail + 1) % LEN;
	}

	private static P dequeue() {
		P x = Q[head];
		head = (head + 1) % LEN;
		return x;
	}

}

class P {
	String name;;
	int t;
}