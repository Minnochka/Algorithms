package Tree;

import ICollection.*;

public interface Tree<V> extends ICollection {

    boolean find(V value);

    boolean add(V value);

    boolean remove(V value);

    void display();

    boolean isBalanced();

    void traverse(TraverseMode mode);

    enum TraverseMode{
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }

}
