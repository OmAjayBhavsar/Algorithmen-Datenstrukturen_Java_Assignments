import aud.AVLTree;
import aud.util.DotViewer;
import aud.util.SingleStepper;

import java.util.ArrayList;

public class AVLExample {
    public static void main(String[] args) {

        SingleStepper stepper = new SingleStepper("Stepper");
        AVLTree<Integer, Integer> avl = new AVLTree<>();
        DotViewer viewer = DotViewer.displayWindow(avl, "Tree");
        ArrayList<Integer> li = new ArrayList<>();
        li.add(6);
        li.add(7);
        li.add(3);
        li.add(4);
        li.add(2);
        li.add(1);
        int count = 0;
        while (count < li.size()) {
            avl.insert(li.get(count), count);
            count++;
            viewer.display(avl);
            stepper.halt();
        }
    }
}