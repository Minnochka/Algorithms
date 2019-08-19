
public interface Array<T> {

    int DEFAULT_CAPACITY = 100_000;

    void add(T value);

    boolean remove(T value);
    T removeByIndex(int index);

    boolean contains(T value);
    int indexOf(T value);

    int size();

    boolean isEmpty();

    void display();

    void sortBubble();

    void sortSelect();

    void sortInsert();

    int length();

    default void addAll(T... values) {
        for (T value : values) {
            add(value);
        }
    }
}
