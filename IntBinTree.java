import aud.BinaryTree;
import aud.Queue;
import aud.util.DotViewer;

public class IntBinTree extends BinaryTree<Integer> {
    Queue<IntBinTree> queue;

    public IntBinTree(int data) {
        super(data);
        queue = new Queue<>();
    }

    public IntBinTree(int data, IntBinTree left, IntBinTree right) {
        super(data, left, right);
        queue = new Queue<>();
    }

    public int height() {

        IntBinTree tmp = this; // tmp : current node
        if (tmp.getRoot() == null) return 0;

        IntBinTree tmpLeft = (IntBinTree) this.getLeft(); // store left child in tmpleft
        IntBinTree tmpRight = (IntBinTree) this.getRight(); // store right child in tmpright

        if (tmpLeft == null && tmpRight == null) return 1; // if tmpleft & tmpright are null : hight 1
        if (tmpLeft == null) return tmpRight.height() + 1; // check if either one of them has child node , if yes add 1
        if (tmpRight == null) return tmpLeft.height() + 1;
        return Math.max(tmpRight.height(), tmpLeft.height()) + 1; // calculates the max height + 1 for current level
    }

    public int maxSum() {
        int sumL = addTree(this.getLeft());
        int sumR = addTree(this.getRight());
        return sumL > sumR ? sumL : sumR; // checks and returns the higher value among left subtree or right subtree
    }

    public int addTree(BinaryTree<Integer> node) {
        // recursively adds the values of nodes
        if (node == null) {
            return 0;
        }
        return node.getData() + addTree(node.getLeft()) + addTree(node.getRight());
    }


    //Iterates over the leaf nodes and calculates the sum of nodes along the path from each leaf to the root.
    public int maxPath() {
        leaves(this);
        int minValue = Integer.MIN_VALUE;
        // dequeues until the queue is empty
        while (!queue.is_empty()) {
            IntBinTree val = queue.dequeue();
            int sum = this.getData();
            // this loop traverses back from leaf till root node
            // starts from val.getData() leaf node till val == this
            while (val != this) {
                sum = sum + val.getData();
                val = (IntBinTree) val.getParent();
            }
            if (sum > minValue) minValue = sum;
            // during each iteration, the method compares sum with minValue
        }
        return minValue;

    }

    //Recursively traverses the tree and enqueues nodes that have no children.

    public void leaves(IntBinTree node) {
        // if the leaf nodes not null. it enqueues current node into queue
        if (node == null) return;
        if (node.getLeft() == null && node.getRight() == null) queue.enqueue(node);

        // it recursively calls left and right children of the current node
        leaves((IntBinTree) node.getRight());
        leaves((IntBinTree) node.getLeft());
    }


    public static void main(String[] args) {
        IntBinTree val1 = new IntBinTree(-8);
        IntBinTree val2 = new IntBinTree(4);
        IntBinTree val3 = new IntBinTree(1);
        IntBinTree val4 = new IntBinTree(6);
        IntBinTree val5 = new IntBinTree(-11);
        IntBinTree val6 = new IntBinTree(10);
        IntBinTree val8 = new IntBinTree(5);
        IntBinTree val9 = new IntBinTree(7);
        IntBinTree val10 = new IntBinTree(28);
        IntBinTree val11 = new IntBinTree(22);
        val1.setLeft(val2);
        val1.setRight(val3);
        val2.setLeft(val4);
        val2.setRight(val5);
        val4.setLeft(val6);
        val3.setLeft(val8);
        val3.setRight(val9);
        val4.setRight(val10);
        val10.setRight(val11);
        val1.leaves(val1);
        System.out.println(val1.height());
        System.out.println(val1.maxSum());
        System.out.println(val1.maxPath());
        DotViewer.displayWindow(val1, "Tree").setExitOnClose();
    }
}