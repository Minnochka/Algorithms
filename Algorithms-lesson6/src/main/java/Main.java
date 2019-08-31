import Tree.*;

import java.util.Random;

public class Main {
    public static void main(String[] args){
       int  TreeNum = 20, min = -20, max = 20, ElNum = 20, isBalanced = 0;

       Tree[] trees =  new MyTree[TreeNum];

       for(int t = 0; t < TreeNum; t++){
            trees[t] = new MyTree<Integer>(4);
            for(int i = 0; i < ElNum; i++){
                trees[t].add(rnd(min, max));
            }
            if(trees[t].isBalanced()){
                isBalanced++;
            }
            trees[t].display();

       }

       System.out.println("Count of Balanced Trees is " + isBalanced + "/" + TreeNum);


        // testTree();

        /*Tree<Integer> tree = new MyTree<Integer>();
        tree.add(60);
        tree.add(25);
        tree.add(66);
        tree.add(15);
        tree.add(5);
        tree.add(20);
        tree.add(45);
        tree.add(30);
        tree.add(55);
        tree.add(32);

        tree.display();
        tree.remove(60);
        tree.display();*/

        /*Tree<Integer> tree = new MyTree<Integer>(4);
        tree.add(60);
        /*tree.add(61);
        tree.add(62);
        tree.add(63);
        tree.add(64);
        tree.add(65);

        tree.add(50);
        tree.add(70);
        tree.add(80);
        //tree.add(90);

        tree.display();
        System.out.println(tree.isBalanced());
        /*tree.remove(60);
        tree.display();*/
    }

    private static void testTree(){
        Tree<Integer> tree = new MyTree<Integer>();
        tree.add(66);
        tree.add(64);
        tree.add(81);
        tree.add(45);
        tree.add(31);
        tree.add(15);
        tree.add(93);
        tree.add(78);
        tree.add(9);
        tree.add(166);

        System.out.println("Root is 66: " + tree.find(66));
        System.out.println("Find 70: " + tree.find(70));
        System.out.println("Find 166: " + tree.find(166));
        System.out.println("Find 9: " + tree.find(9));

        tree.traverse(Tree.TraverseMode.PRE_ORDER);
    }

    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
