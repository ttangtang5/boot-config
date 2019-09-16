package com.example.tree;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/21 10:19
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addTreeNode(new Node(5));
        binaryTree.addTreeNode(new Node(4));
        binaryTree.addTreeNode(new Node(9));
        binaryTree.addTreeNode(new Node(2));
        binaryTree.addTreeNode(new Node(8));
        binaryTree.addTreeNode(new Node(6));
        binaryTree.addTreeNode(new Node(3));
        binaryTree.addTreeNode(new Node(7));
        binaryTree.toArray();
    }
}
