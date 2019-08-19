import java.util.Random;

public class Main {

    public static void main(String[] args){
        Random random = new Random();

        MyArray<Integer> arr1 = new MyArray<>();
        MyArray<Integer> arr2 = new MyArray<>();
        MyArray<Integer> arr3 = new MyArray<>();

        for(int i = 0; i < arr1.length(); i++){
            int el = random.nextInt();
            arr1.add(el);
            arr2.add(el);
            arr3.add(el);
        }

        long startTime = System.currentTimeMillis();
        arr1.sortBubble();
        System.out.println("SortBubble: " + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        arr2.sortSelect();
        System.out.println("SortSelect: " + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        arr3.sortInsert();
        System.out.println("SortInsert: " + (System.currentTimeMillis() - startTime));
    }
}
