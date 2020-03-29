package section005;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ハッシュ
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_4_C&lang=ja">ALDS1_4_C</a>
 */
public class Dictionary {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			String command = sc.next();
			String str = sc.next();
			if ("insert".equals(command)) {
				if (!map.containsKey(str)) {
					map.put(str, 1);
				}
			} else {
				if (map.containsKey(str)) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
			}
		}

		sc.close();
	}

}
