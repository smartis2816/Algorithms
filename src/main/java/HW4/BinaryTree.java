package HW4;

public class BinaryTree {
    Node root;

    private class Node {
        private int value;
        private Node left;
        private Node right;
        private Color color;
    }

    private enum Color {
        RED, BLACK
    }

    public void add(int value) {
        Node node = new Node();
        node.value = value;
        node.color = Color.RED;

        if (root == null) {
            root = node;
            root.color = Color.BLACK;
        } else {
            Node current = root;
            while (current != null) {
                if (value < current.value) {
                    if (current.left == null) {
                        current.left = node;
                        break;
                    }
                    current = current.left;
                } else {
                    if (current.right == null) {
                        current.right = node;
                        break;
                    }
                    current = current.right;
                }
            }
            balancing(root);
            root.color = Color.BLACK;
        }
    }

    private void balancing(Node node) {
        boolean needBalancing;
        do {
            needBalancing = false;
            if (node.right != null
                    && node.right.color == Color.RED
                    && (node.left == null || node.left.color == Color.BLACK)) {
                needBalancing = true;
                swapRight(node);
            }
            if (node.left != null
                    && node.left.color == Color.RED
                    && node.left.left != null
                    && node.left.left.color == Color.RED) {
                needBalancing = true;
                swapLeft(node);
            }
            if (node.left != null
                    && node.left.color == Color.RED
                    && node.right != null
                    && node.right.color == Color.RED) {
                needBalancing = true;
                swapColor(node);
            }
        } while (needBalancing);
    }

    private void swapColor(Node node) {
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }

    private Node swapRight(Node node) {
        Node rightChild = node.right;
        Node betweenChild = rightChild.left;
        rightChild.left = node;
        node.right = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private Node swapLeft(Node node) {
        Node leftChild = node.left;
        Node betweenChild = leftChild.right;
        leftChild.right = node;
        node.left = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }
}
