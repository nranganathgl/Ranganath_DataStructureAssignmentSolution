package com.gl.transactions;

import com.gl.transactions.service.BSTToSkewedTreeService;
import com.gl.transactions.MainApplicationBSTToSkewedTree.Node;

/**
 * 
 * @author Ranganath
 *
 *         Business requirement is where the BST should not contain any left
 *         node. You are required to modify the existing BST and display the
 *         node values present in ascending order.
 * 
 *         Method convertBSTToSkewed converts the BST to Skewed Tree Method
 *         traverseRightSkewed traverse through the Skewed Tree
 */
public class BSTToSkewedTreeServiceImpl implements BSTToSkewedTreeService {

	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	@Override
	public Node convertBSTToSkewed(Node root) {

		// Base Case
		if (root == null) {
			return root;
		}

		convertBSTToSkewed(root.left);
		Node rightNode = root.right;
		// Node leftNode = root.left;

// Condition to check if the root Node
// of the skewed tree is not defined
		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

// Similarly recurse for the left / right
// subtree on the basis of the order required

		convertBSTToSkewed(rightNode);
		return headNode;
	}

// Function to traverse the right
// skewed tree using recursion
	@Override
	public void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		traverseRightSkewed(root.right);
	}

}
