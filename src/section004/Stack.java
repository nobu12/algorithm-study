package section004;

import java.util.Scanner;

/**
 * スタック
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_3_A&lang=ja">ALDS1_3_A</a>
 */
public class Stack {

	private static int top = 0;
	private static int s[] = new int[1000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input[] = new String[1000];
		input = sc.nextLine().split(" ");

		for (int i = 0; i < input.length; i++) {
			int a, b;
			if ("+".equals(input[i])) {
				a = pop();
				b = pop();
				push(a + b);
			} else if ("-".equals(input[i])) {
				a = pop();
				b = pop();
				push(b - a);
			} else if ("*".equals(input[i])) {
				a = pop();
				b = pop();
				push(a * b);
			} else {
				push(Integer.valueOf(input[i]));
			}
		}

		System.out.println(pop());

		sc.close();
	}

	private static void push(int x) {
		s[++top] = x;
	}

	private static int pop() {
		top--;
		return s[top+1];
	}

}
