package HW3;

public class RedBlackTree {
    Node root;

    public boolean add(int value) {
        if (root == null) {
            root = new Node(value);
            root.color = Color.BLACK;
            return true;
        }
        root = addNode(root, value);
        root.color = Color.BLACK; 
        return true;
    }
     // Метод добавления
    private Node addNode(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

       
        if (node.value > value) {
            node.left = addNode(node.left, value);
        } else if (node.value < value) {
            node.right = addNode(node.right, value);
        } else {
        
            return node;
        }

        // Балансировка 
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    private boolean isRed(Node node) {
        return node != null && node.color == Color.RED;
    }

    private Node rotateLeft(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = Color.RED;
        return x;
    }

    private Node rotateRight(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = Color.RED;
        return x;
    }

    private void flipColors(Node node) {
        node.color = Color.RED;
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
    }

    public boolean contains(int value) {
        return containsNode(root, value);
    }

    private boolean containsNode(Node node, int value) {
        if (node == null) {
            return false;
        }

        if (node.value == value) {
            return true;
        } else if (node.value > value) {
            return containsNode(node.left, value);
        } else {
            return containsNode(node.right, value);
        }
    }

    private class Node {
        int value;
        Node left;
        Node right;
        Color color;

        Node(int value) {
            this.value = value;
            this.color = Color.RED;
        }
    }

    enum Color {
        RED,
        BLACK
    }
}