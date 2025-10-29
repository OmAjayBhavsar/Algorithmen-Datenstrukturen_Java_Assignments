import aud.RedBlackTree;
import aud.util.DotViewer;
import aud.util.SingleStepper;

import java.util.ArrayList;

public class RedBlackExample {

    public static void main(String[] args) {

        SingleStepper stepper = new SingleStepper("Stepper");
        RedBlackTree<Integer, Integer> rbt = new RedBlackTree<>();
        DotViewer viewer = DotViewer.displayWindow(rbt, "Tree");
        ArrayList<Integer> li = new ArrayList<>();
        li.add(6);
        li.add(7);
        li.add(3);
        li.add(4);
        li.add(2);
        li.add(1);
        int count = 0;
        while (count < li.size()) {
            rbt.insert(li.get(count), count);
            count++;
            viewer.display(rbt);
            stepper.halt();
        }
    }
}