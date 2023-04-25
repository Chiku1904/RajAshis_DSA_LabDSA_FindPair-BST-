package com.greatlearning.nodes;

public class Node {

	public int key;
	public Node left;
	public Node right;
	
	public Node(int data) {
		this.key= data;
		this.left= null;
		this.right= null;
	}
}
