package com.lab3.assignment.question1;

import java.util.Scanner;
import java.util.Stack;

public class BracketBalancing {

	static String input;

	private static boolean balancedBracketMethod(String input) {

		Stack stack = new Stack();

		char[] charArray = input.toCharArray();

		for (int i = 0; i < charArray.length; i++) {

			char pointer = charArray[i];

			if (pointer == '{' || pointer == '[' || pointer == '(') {

				stack.push(pointer);
				continue;
			}

			if (stack.isEmpty()) {
				return false;
			}

			char popBracket;

			switch (pointer) {

			case ')':
				popBracket = (char) stack.pop();
				if (popBracket == '{' || popBracket == '[')
					return false;
				break;

			case '}':
				popBracket = (char) stack.pop();
				if (popBracket == '(' || popBracket == '[')
					return false;
				break;

			case ']':
				popBracket = (char) stack.pop();
				if (popBracket == '(' || popBracket == '{')
					return false;
				break;

			default:
				return false;
			}
		}
		return (stack.isEmpty());
	}

	public static void main(String[] args) {

		String input;

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the brackets to check balance of brackests.");
		input = sc.nextLine();

		if (balancedBracketMethod(input)) {
			System.out.println("The entered string has balanced brackets.");
		} else {
			System.out.println("The entered string do not contain balanced brackets.");
		}
	}
}
