import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tests {
    MyArray<Integer> arr;

    @Before
    public void Start(){
        this.arr = new MyArray<Integer>();
    }

    @Test
    public void addTest(){
        arr.add(4);
        arr.add(73486583);
        arr.add(-27462);
    }

    @Test
    public void isEmptyTest(){
        boolean res = arr.isEmpty();
        Assert.assertTrue(res);
    }

    @Test
    public void removeTest(){
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.display();
        arr.remove(3);
        arr.removeByIndex(3);
        System.out.println("!!!!!!!!!!!!!!!!!!!");
        arr.display();
    }

    @Test
    public void containsTest(){
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        boolean res = arr.contains(6);
        Assert.assertFalse(res);
        res = arr.contains(2);
        Assert.assertTrue(res);
        arr.remove(2);
        res = arr.contains(2);
        Assert.assertFalse(res);
    }

    @Test
    public void sortBubbleTest(){
        arr.add(12);
        arr.add(2);
        arr.add(33);
        arr.add(41);
        arr.add(15);
        arr.sortBubble();
        arr.display();
    }

    @Test
    public void sortSelectTest(){
        arr.add(12);
        arr.add(2);
        arr.add(33);
        arr.add(41);
        arr.add(15);
        arr.sortSelect();
        arr.display();
    }

    @Test
    public void sortInsertTest(){
        arr.add(12);
        arr.add(2);
        arr.add(33);
        arr.add(41);
        arr.add(15);
        arr.sortInsert();
        arr.display();
    }

    @After
    public void finish(){
        System.out.println("The end!");
    }
}
