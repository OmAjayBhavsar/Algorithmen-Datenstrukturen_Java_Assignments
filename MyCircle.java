
public class MyCircle<T> {

    //-----------------------------------------------------------------//
    //------------- !!Do not change the following lines!! -------------//
    //A Node is a single element int the ring
    class Node {
        int data = Integer.MAX_VALUE;
        T data_;
        Node next_ = null;
        Node prev_ = null;

        Node(T obj, Node prv, Node nxt) {
            data_ = obj;
            prev_ = prv;
            next_ = nxt;
        }

        public String toString() {
            return "[ " + this.data_ + " ]";
        }
    }

    //--- class members
    protected Node head_ = null;
    protected Node tail_ = null;

    //--- class methods
    public MyCircle() {
        head_ = null;
    }

    public T front() {
        return head_.data_;
    }

    public String toString() {
        if (empty())
            return "[]";
        String rv = "[";
        Node node = head_;
        do {
            rv += node.data_.toString();
            if (node.next_ != head_)
                rv += ",";
            node = node.next_;
        } while (node != head_);
        rv += "]";
        return rv;
    }

    //-----------------------------------------------------------------//
    //---------------- !!Insert your solution below!! -----------------//
    public int size() {
        int count = 0;
        if (head_ != null) {
            // node = current node
            // counterNode = next node
            Node node = this.head_;
            Node counterNode = node.next_;
            while (node != counterNode) {
                count++;
                counterNode = counterNode.next_;
            }
            return count + 1;
        } else {
            return 0;
        }
    }

    public boolean empty() {
        if (head_ == null) {
            return true;
        } else return false;
    }


    public void push_back(T obj) {
        Node tempNode = new Node(obj, null, null);
        if (this.empty()) {
            this.head_ = tempNode;
            this.head_.next_ = this.head_;
            this.head_.prev_ = this.head_;
        } else {
            tail_ = this.head_.prev_;

            Node newNode = new Node(obj, tail_, head_);

            this.head_.prev_ = newNode;

            tail_.next_ = newNode;
        }

    }

    public void pop_front() {

        if (this.size() > 1) {

            tail_ = this.head_.prev_;

            tail_.next_ = this.head_.next_;

            this.head_.next_.prev_ = tail_;

            this.head_ = this.head_.next_;
        } else {
            this.head_ = null;
        }

    }

    public Node find(int x) {

        int i = 0;
        while (x != (int) this.head_.data_ && i < this.size()) {
            this.head_ = this.head_.next_;
            i++;
        }
        return head_;
    }

    public static void main(String[] args) {
        MyCircle<Integer> x = new MyCircle<>();
        x.push_back(1);
        x.push_back(2);
        x.push_back(3);
        System.out.println(x.find(1));

    }
}