/**MySList represents a single linked list, which holds elements of type
 integer.*/
public class MySList implements Iterable<Integer> {

    //-----------------------------------------------------------------//
    //------------- !!Do not change the following lines!! -------------//
    public String toString() {
        if (empty())
            return "[]";
        String rv = "[";
        Node node = head_;
        do {
            rv += node.data_;
            if (node.next_ != null)
                rv += ",";
            node = node.next_;
        } while (node != null);
        rv += "]";
        return rv;
    }

    private boolean empty() {
        if (head_ == null) {
            return true;
        }
        return false;
    }

    //-----------------------------------------------------------------//
    //---------------- !!Insert your solution below!! -----------------//

    /**
     * Node represents a single element in the list.
     */
    class Node {
        int data_;                         //!! Do not change this line !!
        Node next_ = null;

        public Node(int data_, Node next_) {
            this.data_ = data_;
            this.next_ = next_;
        }

        public String toString() {
            return "[" + this.data_ + "]";
        }
    }

    Node head_ = null;

    // sets the head_ to null for testing
    public void test() {
        this.head_ = null;
    }
    // sets the head_ to null for testing
    public MySList() {
        this.head_ = null;
    }

    // Adds a new node with data obj at the end of the list.
    public void push_back(int obj) {
        if (head_ == null) {
            // if empty, creates new node
            this.head_ = new Node(obj, null);
        } else {
            MySList.Node node;
            // iterates through the list by moving node to next node
            for (node = this.head_; node.next_ != null; node = node.next_) {
            }

            // loop exits, set last node to null
            node.next_ = new Node(obj, null);
        }
    }

    /**
     * Iterator is used to traverse odd elements in a list.
     */

    // traverse odd elements
    public static class Iterator implements java.util.Iterator<Integer> {
        Node current;
        MySList tempList;

        public Iterator(Node current) {
            tempList = new MySList();
            this.current = current;
            while (current != null) {
                if (current.data_ % 2 != 0) {
                    // if data is odd, add the data to tempList
                    tempList.push_back(current.data_);
                }
                current = current.next_;
            }
            // current is set to head of tempList to start iterating again
            this.current = tempList.head_;
        }

        // checks if there are more elements to iterate over
        @Override
        public boolean hasNext() {
            return current != null;
        }

        // gives the value of next node
        @Override
        public Integer next() {
            if (this.current != null) {
                int val = current.data_;
                current = current.next_;
                return val;
            } else return null;
        }
    }

    public Iterator iterator() {
        return new Iterator(head_);
    }

    public static void main(String[] args) {
        MySList li = new MySList();
        li.push_back(1);
        li.push_back(2);
        li.push_back(3);
        li.push_back(5);
        li.push_back(7);
        li.push_back(8);
        li.push_back(9);
        for (int val : li) {
            System.out.println(val);
        }

    }
}