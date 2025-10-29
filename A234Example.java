import aud.A234Tree;
import aud.util.DotViewer;
import aud.util.SingleStepper;

import java.util.ArrayList;


public class A234Example {

    public static void main(String[] args) {

        SingleStepper stepper = new SingleStepper("SingleStepper");
        A234Tree<Integer> tree_top_bottom = new A234Tree<>();
        A234Tree<Integer> tree_bottom_Top = new A234Tree<>(false);
        DotViewer viewerBT = DotViewer.displayWindow(tree_top_bottom, "tree");
        DotViewer viewerTB = DotViewer.displayWindow(tree_bottom_Top, "tree");

        ArrayList<Integer> li = new ArrayList<>();
        li.add(3);
        li.add(5);
        li.add(7);
        li.add(9);
        li.add(11);
        li.add(13);
        li.add(15);
        li.add(17);
        li.add(19);
        li.add(21);
//         li.add(3);
//         li.add(7);
//        li.add(5);
//        li.add(15);
//        li.add(17);
//        li.add(9);
//        li.add(13);
//        li.add(21);
//        li.add(11);
//        li.add(19);
        
        int count = 0;
        while (li.size() > count) {
            tree_bottom_Top.insert(li.get(count++));
            viewerBT.display(tree_bottom_Top);
//            tree_top_bottom.insert(li.get(count++));
//            viewerTB.display(tree_top_bottom);
            stepper.halt();
        }
    }
}