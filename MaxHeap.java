import java.util.ArrayList;
import java.util.Collections;

/*
* Structural property
* Ordering property
* Heap tree => Always complete binary tree
* Only go on next level if the first one is complete
* Left first then right
*
*
* Max Heap => Root is Max element (Parent > Child)
* Min Heap => Root is Min element (Parent < Child)
*
* */

public class MaxHeap<T extends Comparable<T>> {
    //-----------------------------------------------------------------//
    //------------- !!Do not change the following lines!! -------------//
    public String toString() {
        return heap_.toString();  // don't change because of backend
    }

    private ArrayList<T> heap_;  // or Vector


    public MaxHeap() {
        heap_ = new ArrayList<>();
    }


    public MaxHeap(T[] arr) {
        heap_ = new ArrayList<>();
        Collections.addAll(heap_, arr);
        System.out.println("Initial Array: " + heap_);
        buildHeap();
    }

    // converts heap array into max heap
    private void buildHeap() {
        // Index of Last Non-Leaf Node: The parent of the last leaf node,
        // which is (n - 1 - 1) / 2 or (n - 2) / 2

        int startIndex = (getSize() - 2) / 2;
        for (int i = startIndex; i >= 0; i--) {
            downHeap(i);
        }
    }

    public ArrayList<T> getHeap() {
        return heap_;
    }


    public int getSize() {
        return heap_.size();
    }


    public boolean isEmpty() {
        return heap_.isEmpty();
    }


    public void downHeap(int root) {
        int size = getSize();
        // loop continues as long as the current node (root) has at least one child
        while (root * 2 + 1 < size) {
            int leftChild = root * 2 + 1;
            int rightChild = root * 2 + 2;
            int largest = root;

            // check if left child exist & if > than The Largest node => update
            if (leftChild < size && heap_.get(leftChild).compareTo(heap_.get(largest)) > 0) {
                largest = leftChild;
            }
            // check if right child exist & if > than The Largest node => update
            if (rightChild < size && heap_.get(rightChild).compareTo(heap_.get(largest)) > 0) {
                largest = rightChild;
            }
            // if already root is the largest
            if (largest == root) {
                break;
            }
            // found largest => swap
            Collections.swap(heap_, root, largest);
            root = largest;
        }
    }


    public void insert(T obj) {
        heap_.add(obj);
        upHeap(getSize() - 1);
    }


    private void upHeap(int n) {
        while (n > 0) {
            // calculate the parent node at n
            int parent = (n - 1) / 2;
            // check if current node is <= it's parent
            if (heap_.get(n).compareTo(heap_.get(parent)) <= 0) {
                break;
            }
            Collections.swap(heap_, n, parent);
            n = parent;
        }
    }

    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.insert(4);
        maxHeap.insert(3);
        maxHeap.insert(6);
        maxHeap.insert(1);
        maxHeap.insert(5);
        maxHeap.insert(8);
        System.out.println(maxHeap);
        System.out.println("********* With DownHeap *******");
        String[] arr = {"4", "3", "6", "1", "5", "8"};
        MaxHeap<String> maxHeapArr = new MaxHeap<>(arr);
        System.out.println(maxHeapArr);
    }
}