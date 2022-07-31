package com.gl.transactions;

import com.gl.transactions.service.BSTToSkewedTreeService;


/**
 * 
 * @author Ranganath
 *
 * This is the main program needs to be run 
 * to pass the BST into BSTToSkewedTreeServiceImpl
 * which converts the BST into a Skewed Tree
 */
public class MainApplicationBSTToSkewedTree {
	
	public static class Node
	{
	    public int data;
	    public Node left, right;
	    
	    // Helper function that allocates a new node
	    // with the given data and NULL left and right
	    // pointers.
	    Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	}
	
	public static Node node;
    static Node headNode = null;
	

	public static void main(String[] args) {

		//MainApplication2 tree = new MainApplication2();
		
		node = new Node(50);
		node.left = new Node(30);
		node.right = new Node(60);
		node.left.left = new Node(10);
		node.right.left = new Node(55);

		BSTToSkewedTreeService serviceObject = new BSTToSkewedTreeServiceImpl();
		headNode = serviceObject.convertBSTToSkewed(node);
		serviceObject.traverseRightSkewed(headNode);
	}

}
