import java.util.Stack;

/**
 * ForwardList represents a list with single linked nodes, that do have
 * a next-pointer.
 */
public class ForwardList<T> implements Iterable<T> {
    //-----------------------------------------------------------------//
    //------------- !!Do not change the following lines!! -------------//
    public String toString() {
        if (is_empty())
            return "[]";
        String rv = "[";
        Node node = head_;
        do {
            rv += node.data_.toString();
            if (node.next_ != head_)
                rv += ",";
            node = node.next_;
        } while (node != null);
        rv += "]";
        return rv;
    }

    //-----------------------------------------------------------------//
    //---------------- !!Insert your solution below!! -----------------//
    //A Node is a single element int the ring
    public class Node {
        //---------------------------------------------------------------//
        //    !!! Do not change the existing lines in class Node!!!      //
        //            !!! It is allowed to add new content !!!           //
        //       !!! It is not allowed to add a previous pointer !!!     //
        //---------------------------------------------------------------//
        public T data_;
        public Node next_;

        public Node(T data, Node next) {
            data_ = data;
            next_ = next;
        }
    }

    // holds reference to the first node
    public Node head_ = null;

    // constructor, initialize empty list
    public ForwardList() {
    }


    public void push_front(T obj) {
        if (head_ == null) {
            this.head_ = new Node(obj, null);
            // if list empty, create new node and set as head
        } else {
            Node front = head_;
            this.head_ = new Node(obj, null);
            this.head_.next_ = front;
            // creates new node, makes it new head.
            // point next to previous head
        }
    }

    public boolean is_empty() {
        return head_ == null;
    }

    public void backTraverse() {
        this.backTraverse_(head_);

    }

    // Recursively traverse the list backwards & print data of each node
    public void backTraverse_(Node head) {
        if (head != null) {
            this.backTraverse_(head.next_);
        } else {
            return;
        }
        System.out.println(head.data_);

    }

    //implement iterator interface, iterates the list backwards
    public class BackIterator implements java.util.Iterator<T> {
        Stack<T> tempStack;
        Node current;

        // create stack to store the elements in backwards order
        public BackIterator(Node curr) {
            tempStack = new Stack<>();
            current = curr;
            // traverse head to tail, push each element onto the stack
            while (current != null) {
                tempStack.push(current.data_);
                current = current.next_;
            }
        }

        // checks if more elements in the stack
        @Override
        public boolean hasNext() {
            return !tempStack.isEmpty();
        }

        //returns the next element from stack
        @Override
        public T next() {
            return tempStack.pop();
        }

    }

    // returns new instance of backiterator initialized with the head of the list
    public BackIterator iterator() {
        return new BackIterator(head_);
    }

    public static void main(String[] args) {
        ForwardList<Integer> list = new ForwardList<>();
        list.push_front(1);
        list.push_front(2);
        list.push_front(3);
        list.push_front(4);
        System.out.println(list);
        list.backTraverse();
        System.out.println("_______________");
        for (int val : list) System.out.println(val);

    }
}