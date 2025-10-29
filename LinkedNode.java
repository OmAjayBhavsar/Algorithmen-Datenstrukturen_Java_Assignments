
public class LinkedNode<T> {

    T data_ = null;

    LinkedNode<T> next_ = null;


    public LinkedNode(T data_, LinkedNode<T> next_) {
        this.data_ = data_;
        this.next_ = next_;
    }


    public LinkedNode<T> getNext_() {
        return next_;
    }

    public T getData_() {
        return data_;
    }

    public void setData_(T data_) {
        this.data_ = data_;
    }

    public void setNext_(LinkedNode<T> next_) {
        this.next_ = next_;
    }


    @Override
    public String toString() {
        String string = "";
        while (this.next_ != null) {
            string = string + " " + this.getNext_().getData_();

            this.setData_(this.next_.getData_());
            this.setNext_(this.next_.getNext_());
        }
        return string;
    }

    public static void main(String[] args) {
        LinkedNode<String> link1 = new LinkedNode<>("Freitag", null);
        LinkedNode<String> link2 = new LinkedNode<>("Donnerstag", link1);
        LinkedNode<String> link3 = new LinkedNode<>("Mittwoch", link2);
        LinkedNode<String> link4 = new LinkedNode<>("Montag", link3);
        LinkedNode<String> link5 = new LinkedNode<>("Mensa gehen", link4);
        LinkedNode<String> link6 = new LinkedNode<>("Vorlesung besuchen", link5);
        LinkedNode<String> link7 = new LinkedNode<>(null, link6);
        System.out.println(link7);
    }
}
