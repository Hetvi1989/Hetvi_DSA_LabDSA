package com.lab3.assignment.question2;

import java.util.HashSet;

public class SumPairOfBST {

	static class Node {
		int data;
		Node left;
		Node right;
	}

	static Node newNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = null;
		temp.right = null;

		return temp;
	}

	static Node insert(Node root, int key) {
		if (root == null) {
			return newNode(key);
		}
		if (key < root.data) {
			root.left = insert(root.left, key);
		} else {
			root.right = insert(root.right, key);
		}
		return root;
	}

	static boolean sumOfPair(Node root, int sum, HashSet<Integer> set) {
		if (root == null)
			return false;

		if (sumOfPair(root.left, sum, set)) {
			return true;
		}
		if (set.contains(sum - root.data)) {
			System.out.println("Pair is (" + (sum - root.data) + ", " + root.data + ")");

			return true;
		} else {
			set.add(root.data);

			return sumOfPair(root.right, sum, set);
		}
	}

	static void findPair(Node root, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		if (!sumOfPair(root, sum, set))
			System.out.print("Pairs do not exit");
	}

	public static void main(String[] args) {
		Node root = null;
		root = insert(root, 40);
		root = insert(root, 20);
		root = insert(root, 60);
		root = insert(root, 10);
		root = insert(root, 30);
		root = insert(root, 50);
		root = insert(root, 70);

		int sum = 60;
		findPair(root, sum);
	}
}
