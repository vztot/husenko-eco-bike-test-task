package com.ecobike.util.tree.impl;

import com.ecobike.util.tree.BinaryTree;

public class MyBinaryTreeImpl<T extends Comparable> implements BinaryTree {

    private Node root;

    @Override
    public void add(Object o) {
        root = addRecursive(root, (T) o);
    }

    private Node addRecursive(Node current, T value) {
        if (current == null) {
            return new Node(value);
        }
        if (value.compareTo(current.value) < 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    private class Node {
        private T value;
        private Node left;
        private Node right;

        Node(T value) {
            this.value = value;
            this.right = null;
            this.left = null;
        }
    }
}
