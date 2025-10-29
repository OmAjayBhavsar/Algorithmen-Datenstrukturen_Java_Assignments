import aud.BinaryTree;
import aud.Queue;
import aud.util.DotViewer;

public class MyBinTree<T> extends BinaryTree<T> {

    Queue<BinaryTree<T>> queue = new Queue<>();
    int queueSize = 1;


    // constructor method to initialize a binary tree node with data, left - right node
    public MyBinTree(T data) {
        super(data);
    }

    public MyBinTree(T data, MyBinTree<T> left, MyBinTree<T> right) {
        super(data, left, right);
    }

    public int maxWidth() {
        int maxWidth = 0;
        // if current node has no left and right children , only node, return 1
        if (this.getLeft() == null && this.getLeft() == null) return 1;

        // enqueue the root node into 'this' : level order traversal
        queue.enqueue(this);

        //calculate level size of that level using levelSize method
        while (!queue.is_empty()) {
            int lvlSize = levelSize(queueSize);
            maxWidth = Math.max(lvlSize, maxWidth);

        }
        return maxWidth;
    }

    // level order traversal
    // it iterates over each node at current lvl, dequeues them, enqueues their children
    public int levelSize(int lvlSize) {
        // until lvlSize becomes 0
        while (lvlSize > 0) {
            BinaryTree<T> node = queue.dequeue();
            queueSize--;

            // if dequeued node has left child, it is enqueued into the queue and queue size is incremented
            if (node.getLeft() != null) {
                queue.enqueue(node.getLeft());
                queueSize++;
            }
            //if dequeued node has right child, enqueued into the queue and queue size incremented by q
            if (node.getRight() != null) {
                queue.enqueue(node.getRight());
                queueSize++;
            }
            lvlSize--;
        }
        // once all the nodes in the same level is processed, method returns queueSize
        return queueSize;
    }

    public static void main(String[] args) {

        MyBinTree<Integer> val1 = new MyBinTree<>(1);
        MyBinTree<Integer> val2 = new MyBinTree<>(2);
        MyBinTree<Integer> val3 = new MyBinTree<>(3);
        MyBinTree<Integer> val4 = new MyBinTree<>(4);
        MyBinTree<Integer> val5 = new MyBinTree<>(5);
        MyBinTree<Integer> val6 = new MyBinTree<>(6);
        MyBinTree<Integer> val7 = new MyBinTree<>(7);
        MyBinTree<Integer> val8 = new MyBinTree<>(8);
        MyBinTree<Integer> val9 = new MyBinTree<>(-8);
        MyBinTree<Integer> val10 = new MyBinTree<>(-8);

        val1.setLeft(val2);
        val1.setRight(val3);
        val2.setLeft(val4);
        val2.setRight(val5);
        val4.setLeft(val6);
        val3.setLeft(val7);
        val3.setRight(val8);
        System.out.println(val1.maxWidth());
        DotViewer.displayWindow(val1, "Tree");
    }
}