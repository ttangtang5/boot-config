package com.example.tree;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/21 9:46
 * @Version 1.0
 **/
public class Node {

    private int data;

    private Node left;

    private Node right;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public Node setData(int data) {
        this.data = data;
        return this;
    }

    public Node getLeft() {
        return left;
    }

    public Node setLeft(Node left) {
        if (this.left == null) {
            this.left = left;
        } else {
            this.getLeft().addNode(left);
        }
        return this;
    }

    public Node getRight() {
        return right;
    }

    public Node setRight(Node right) {
        if (this.right == null) {
            this.right = right;
        } else {
            this.getRight().addNode(right);
        }
        return this;
    }

    public void addNode(Node node) {
        if (this.getData() > node.getData()) {
            this.setLeft(node);
        } else {
            this.setRight(node);
        }
    }
}
