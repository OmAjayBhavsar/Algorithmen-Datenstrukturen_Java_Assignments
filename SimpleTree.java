public class SimpleTree<T extends Comparable<T>> {
    public class Node {
        String str = "";
        Node left;
        Node right;
        T data;
        Node parent;

        public Node(T data, Node parent) {
            this.left = null;
            this.right = null;
            this.data = data;
            this.parent = parent;
        }

        public String toString() {
            toString_(root_);
            return str;
        }

        public void toString_(Node node) {
            if (node != null) {
                toString_(node.left);
                str = node.data + " " + str;
                toString_(node.right);
            }


        }

    }

    private Node root_;

    public SimpleTree() {

    }


    public void add(T obj) {
        if (root_ == null) {
            root_ = new Node(obj, null);
        } else {
            Node tmpNode = root_;
            Node prvRoot = null;
            while (tmpNode != null) {
                prvRoot = tmpNode;
                if (tmpNode.data.compareTo(obj) < 0) {
                    tmpNode = tmpNode.left;
                } else if (tmpNode.data.compareTo(obj) > 0) {
                    tmpNode = tmpNode.right;
                } else return;
            }
            if (prvRoot.data.compareTo(obj) < 0) {
                prvRoot.left = new Node(obj, prvRoot);
            } else prvRoot.right = new Node(obj, prvRoot);
        }
    }

    public boolean contains(T obj) {

        Node tmp = root_;
        while (tmp != null) {
            if (tmp.data.compareTo(obj) == 0) {
                return true;
            } else if (tmp.data.compareTo(obj) > 0) tmp = tmp.right;
            else tmp = tmp.left;
        }
        return false;
    }

    public String toString() {

        if (root_ != null)
            return root_.toString();
        else
            return null;
    }

    public static void main(String[] args) {
        // TODO: test your code with appropriate examples
        SimpleTree<Integer> tree = new SimpleTree<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);

        System.out.println(tree.toString());
        System.out.println(tree.contains(5));
    }

}