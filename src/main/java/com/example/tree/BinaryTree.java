package com.example.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/21 9:45
 * @Version 1.0
 **/
public class BinaryTree {

    private Node root;

    private List<Node> nodeInfo = new ArrayList<>();

    public void addTreeNode(Node node) {
        if (this.root == null) {
            this.root = node;
        } else {
            this.root.addNode(node);
        }
    }

    public void toArray() {
        firstOrder(this.root);

        for (Node i : nodeInfo) {
            System.out.println(i.getData());
        }
    }

    public void firstOrder(Node node) {
        if (node != null) {
            this.nodeInfo.add(node);
            firstOrder(node.getLeft());
            firstOrder(node.getRight());
        }
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.getLeft());
            this.nodeInfo.add(node);
            inOrder(node.getRight());
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            this.nodeInfo.add(node);
        }
    }
}
