import aud.BTree;
import aud.KTreeNode;

import java.util.Random;

public class MyBTree<Key extends Comparable<Key>> extends BTree<Key> {
    KTreeNode<Key> node = new KTreeNode<>();
    int height = 0;

    public MyBTree(int m) {
        super(m);
    }

    public int getHeight() {
        node = this.root(); // set node to root of the tree
        getHeight_(node);
        int x = height;
        height = 0;
        return x;
    }


    // recursive method
    public int getHeight_(KTreeNode<Key> node) {
        if (node == null) {
            return 0;
        } else {
            ++height;
            getHeight_(node.getChild(0));
            return height;
        }
    }


    public static void main(String[] args) {
//        BTree<Integer> bTree = new BTree<>(2);
//        SingleStepper stepper = new SingleStepper("Steps");
//        DotViewer viewer = DotViewer.displayWindow(bTree, "DotView");
//        ArrayList<Integer> li = new ArrayList<>();
//        li.add(6);
//        li.add(18);
//        li.add(22);
//        li.add(3);
//        li.add(11);
//        li.add(16);
//        li.add(7);
//        li.add(10);
//        li.add(1);
//        li.add(8);
//        li.add(12);
//        int count = 0;
//        while (li.size() > count) {
//            bTree.insert(li.get(count));
//            count++;
//            viewer.display(bTree);
//            stepper.halt();
//        }
        MyBTree<Integer> myTree = new MyBTree<>(1);
        Random ran = new Random();
        for (int i = 0; i < 100000; i++) {
            myTree.insert(ran.nextInt(10000));
        }
        System.out.println(myTree.getHeight());

    }
}