public class SortedArray<T extends Object & Comparable<? super T>> extends MyArray<T> {

        @Override
        public void add(T value) {
            checkGrow();
            int index;

            for (index = 0; index < size; index++) {
                if (arr[index].compareTo(value) > 0)
                    break;
            }

            for (int i = size; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = value;
            size++;
        }

        @Override
        public int indexOf(T value) {
            int low = 0;
            int high = size - 1;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (arr[mid].equals(value)) {
                    return mid;
                }
                else if (arr[mid].compareTo(value) > 0) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }

            return -1;
        }
    }
