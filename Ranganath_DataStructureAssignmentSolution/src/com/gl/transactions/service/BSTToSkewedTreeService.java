package com.gl.transactions.service;

import com.gl.transactions.MainApplicationBSTToSkewedTree.Node;

/*
 * 
 * @author Ranganath
 *
 *         This is BSTToSkewedTreeService interface contains abstract methods to
 *         modify the existing BST and display the node values present in ascending order.
*/
public interface BSTToSkewedTreeService {

	public Node convertBSTToSkewed(Node node);

	public void traverseRightSkewed(Node node);

}
