package com.greatlearning.bst;

import java.util.ArrayList;
import java.util.Scanner;

import com.greatlearning.nodes.Node;

public class BinarySearchTree {

	ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		Node root = null;
		Node nn = null;
		System.out.println("Enter the no of nodes you want to have in the Binary Search Tree");
		int size = sc.nextInt();

		for (int i = 1; i <= size; i++) {
			System.out.println("Enter data of the Node");
			int item = sc.nextInt();
			nn = new Node(item);
			if (root == null)
				root = nn;
			else {
				bst.insertNode(root, nn);
			}
		}
		System.out.println("\nINORDER TRAVERSAL");
		bst.inOrderTraversal(root);
		System.out.println(bst.list);

		System.out.println("Enter the no. to find pair");
		int search = sc.nextInt();
		int flag = 0;
		for (int j = 0; j < bst.list.size(); j++) {
			int n1 = bst.list.get(j);
			int n2 = search - n1;

			// Test Cases
			if (n1 == search) {
				System.out.println("Element Found!!!");
				System.out.println(n1+ " & Null");
				flag=1;
				break;
			}
			if (search < n1) {
				System.out.println("Please enter a valid no. to search");
				break;
			}
			if (search > n1) {

				if (bst.list.contains(n2)) {
					System.out.println("Found the elements");
					System.out.println("The pair of the searched element is: " + "(" + n1 + " , " + n2 + ")");
					flag = 1;
					break;
				}
			}
		}
		if (flag == 0) {
			System.out.println("Sorry, Couldn't find the pair!!!");
		}
	}

	private void insertNode(Node root, Node nn) {

		if (nn.key < root.key) {
			if (root.left == null)
				root.left = nn;
			else
				insertNode(root.left, nn);
		}
		if (nn.key > root.key) {
			if (root.right == null)
				root.right = nn;
			else
				insertNode(root.right, nn);
		}
	}

	private void inOrderTraversal(Node root) {

		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		list.add(root.key);
		inOrderTraversal(root.right);
	}
}
