import java.util.Arrays;
import java.util.Objects;

public class MyArray<T extends Object & Comparable<? super T>> implements Array<T> {

        protected T[] arr;
        protected int size;

        public MyArray() {
            this(DEFAULT_CAPACITY);
        }

        @SuppressWarnings("unchecked")
        public MyArray(int capacity) {
            this.arr = (T[]) new Object[capacity];
        }

        @Override
        public void add(T value) {
            checkGrow();
            arr[size++] = value;
        }

        protected void checkGrow() {
            if (size == arr.length) {
                arr = Arrays.copyOf(arr, arr.length * 2);
            }
        }

        @Override
        public boolean remove(T value) {
            int index = indexOf(value);
            if (index != -1) {
                return removeByIndex(index) != null;
            }
            return false;
        }

        @Override
        public T removeByIndex(int index) {
            checkIndex(index);

            T result = arr[index];

            for (int i = index; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }

            arr[--size] = null;
            return result;
        }

        private void checkIndex(int index) {
            if (index >= 0 && index < size)
                return;

            throw new IndexOutOfBoundsException("Invalid index value: " + index + "; array size is "  + size);
        }

        @Override
        public boolean contains(T value) {
            return indexOf(value) != -1;
        }

        @Override
        public int indexOf(T value) {
            for (int i = 0; i < size; i++) {
                if (Objects.equals(value, arr[i])) {
                    return i;
                }
            }
            return -1;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        @Override
        public void display() {
            System.out.println("!!!!!!!!!!!!!!");
            for (int i = 0; i < size; i++) {
                System.out.println(arr[i]);
            }
            System.out.println("----------");
        }

        private void swap(int index1, int index2) {
            T el = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = el;
        }

        @Override
        public void sortBubble() {
            for (int i = 0; i < size - 1; i++) {
                for (int j = 0; j < size - 1 - i; j++) {
                    if (arr[j].compareTo(arr[j + 1]) > 0) {
                        swap(j, j + 1);
                    }
                }
            }
        }


        @Override
        public void sortSelect() {
            for (int i = 0; i < size - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < size; j++) {
                    if (arr[j].compareTo(arr[minIndex]) < 0) {
                        minIndex = j;
                    }
                }
                swap(minIndex, i);
            }
        }

        @Override
        public void sortInsert() {
            for (int i = 1; i < size; i++) {
                T temp = arr[i];
                int in = i;
                while (in > 0 && arr[in - 1].compareTo(temp) > 0) {
                    arr[in] = arr[in - 1];
                    in--;
                }
                arr[in] = temp;
            }
        }

        @Override
        public String toString() {
            return Arrays.toString(arr);
        }

        @Override
        public int length(){
            return arr.length;
        }
    }
