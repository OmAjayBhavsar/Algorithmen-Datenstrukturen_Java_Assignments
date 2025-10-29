import aud.BinaryTree;
import aud.util.DotViewer;

public class BuildBinTree {
    public static void main(String[] args) {

        BinaryTree<String> a = new BinaryTree<>("S");
        BinaryTree<String> b = new BinaryTree<>("Y");
        BinaryTree<String> c = new BinaryTree<>("B");
        BinaryTree<String> d = new BinaryTree<>("K");
        BinaryTree<String> e = new BinaryTree<>("O");
        BinaryTree<String> f = new BinaryTree<>("M");
        BinaryTree<String> g = new BinaryTree<>("L");
        BinaryTree<String> h = new BinaryTree<>("I");

        a.setLeft(b);
        a.setRight(e);
        b.setLeft(c);
        b.setRight(d);
        e.setLeft(f);
        e.setRight(a);
        g.setLeft(h);
        f.setRight(h);
        e.setLeft(g);


        System.out.println("preorder: " + a.preorder().toString());
        // preorder : root -> left -> right
        System.out.println("inorder: " + a.inorder().toString());
        // inorder : left -> root -> right
        System.out.println("postorder: " + a.postorder().toString());
        // postorder : left -> right -> root
        System.out.println("level-order: " + a.levelorder().toString());
        // level order : level by level
        DotViewer.displayWindow(a, "Om");
    }
}