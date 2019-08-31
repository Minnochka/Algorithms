package Tree;

public class Node<V extends Comparable<? super V>> {

    private final V value;

    private Node<V> leftChild;
    private Node<V> rightChild;

    public Node(V value){
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public Node<V> getLeftChild() {
        return leftChild;
    }

    public Node<V> getRightChild() {
        return rightChild;
    }

    public void setLeftChild(Node<V> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node<V> rightChild) {
        this.rightChild = rightChild;
    }


    boolean shouldBeLeft(V value){
        return this.value.compareTo(value) > 0;
    }

    public boolean isLeaf(){
        return leftChild == null && rightChild == null;
    }

    public boolean hasOnlySingleChild(){
        return leftChild != null ^ rightChild != null;
    }
}
