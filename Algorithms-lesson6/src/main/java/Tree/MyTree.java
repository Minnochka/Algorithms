package Tree;

import java.util.Stack;

public class MyTree<V extends Comparable<? super V>> implements Tree<V> {
    private Node<V> root;
    private int size;
    private int maxLevel;

    public MyTree(){
        this.maxLevel = 0;
    }

    public  MyTree(int maxLevel){
        this.maxLevel = maxLevel;
    }

    public boolean find(V value) {
        return doFind(value).node != null;
    }

    public boolean add(V value) {
        Node<V> current = root;
        Node<V> previous = null;
        Node<V> node = new Node<V>(value);
        if(isEmpty()){
            root = node;
            size++;
            return true;
        }

        NodeAndParent nodeAndParent = doFind(value);
        if(nodeAndParent.node != null){
            return false;
        }

        if (nodeAndParent.level <= maxLevel || maxLevel == 0) {
            previous = nodeAndParent.parent;

            if (previous.shouldBeLeft(value)) {
                previous.setLeftChild(node);
            } else {
                previous.setRightChild(node);
            }
            size++;
            return true;
        }
        else{
            return false;
        }
    }


    private void inOrder(Node<V> node) {
        if(node == null){
            return;
        }
        inOrder(node.getLeftChild());
        System.out.println(node.getValue());
        inOrder(node.getRightChild());
    }

    private void preOrder(Node<V> node) {
        if(node == null){
            return;
        }
        System.out.println(node.getValue());
        inOrder(node.getLeftChild());
        inOrder(node.getRightChild());
    }

    private void postOrder(Node<V> node) {
        if(node == null){
            return;
        }
        inOrder(node.getLeftChild());
        inOrder(node.getRightChild());
        System.out.println(node.getValue());
    }

    public boolean remove(V value) {
        NodeAndParent nodeAndParent = doFind(value);
        Node<V> removedNode = nodeAndParent.node;
        Node<V> parent = nodeAndParent.parent;

        if(removedNode == null){
            return false;
        }

        if(removedNode.isLeaf()){
            removeLeafNode(parent, removedNode);
        }
        else if (removedNode.hasOnlySingleChild()){
            removeNodeWithSingleChild(parent, removedNode);
        }
        else{
            removeCommonNode(parent, removedNode);
        }

        size--;
        return true;
    }

    private void removeCommonNode(Node<V> parent, Node<V> removedNode) {
        Node<V> successor = getSuccessor(removedNode);
        if(removedNode == root){
            root = successor;
        }
        else if (parent.getLeftChild() == removedNode){
            parent.setLeftChild(successor);
        }
        else{
            parent.setRightChild(successor);
        }

        successor.setLeftChild(removedNode.getLeftChild());
    }

    private Node<V> getSuccessor(Node<V> removedNode) {
        Node<V> successor = removedNode;
        Node<V> successorParent = null;
        Node<V> current = removedNode.getRightChild();

        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if(successor != removedNode.getRightChild()){
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removedNode.getRightChild());
        }

        return  successor;
    }

    private void removeNodeWithSingleChild(Node<V> parent, Node<V> removedNode) {
        Node<V> child = removedNode.getLeftChild() != null ? removedNode.getLeftChild() : removedNode.getRightChild();

        if(removedNode == root){
            root = child;
        }
        else if(parent.getLeftChild() == removedNode){
            parent.setLeftChild(child);
        }
        else{
            parent.setRightChild(child);
        }
    }

    private void removeLeafNode(Node<V> parent, Node<V> removedNode){
        if(removedNode == root){
            root = null;
        }
        else if(parent.getLeftChild() == removedNode){
            parent.setLeftChild(null);
        }
        else{
            parent.setRightChild(null);
        }
    }
    public void display() {
        Stack<Node> globalStack = new Stack<Node>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<Node>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }

    public boolean isBalanced() {
        //double log = (Math.log(size) / Math.log(2));
        //double max = maxLength(root);
        //boolean res = isBalancedNode(root);
        //System.out.println("size = " + size + ", log_size = " + Math.log(size) + ", log_2 = " + Math.log(2) + ", log = " + log + ", max = " + max + ", res = " + res);

        //return res && max <= log;
        return isBalancedNode(root) && maxLength(root) <= (Math.log(size) / Math.log(2));
    }
    public boolean isBalancedNode(Node<V> node) {
        return (node == null) ||
                (isBalancedNode(node.getLeftChild()) &&
                        isBalancedNode(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1);
    }

    private int maxLength(Node<V> node){
        return Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    private  int height(Node<V> node) {
        //int res = node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
        //System.out.println(res);
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }


    public void traverse(TraverseMode mode){
        switch (mode){
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Unknown mode: " + mode);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean isFull() {
        return false;
    }

    private NodeAndParent doFind(V value){
        Node<V> current = root;
        Node<V> parent = null;
        Node<V> node = new Node<V>(value);
        int level = 1;

        while(current != null){
            if(current.getValue().equals(value)){
                return new NodeAndParent(current, parent, level);
            }
            parent = current;

            if(current.shouldBeLeft(value)){
                current = current.getLeftChild();
            }
            else{
                current = current.getRightChild();
            }
            level++;
        }
        return new NodeAndParent(null, parent, level);

    }

    private class NodeAndParent{
        Node<V> node;
        Node<V> parent;
        int level;

        public NodeAndParent(Node<V> node, Node<V> parent, int level){
            this.node = node;
            this.parent = parent;
            this.level = level;
        }
    }
}
