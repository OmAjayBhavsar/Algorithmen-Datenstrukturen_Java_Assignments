import aud.BinaryTree;
import aud.example.expr.Number;
import aud.example.expr.*;
import aud.util.DotViewer;


public class Differentiation {

    public static ExpressionTree differentiate(BinaryTree<AtomicExpression> t, String var) {
        ExpressionTree tree = new ExpressionTree(t.getData().clone());
        // check if t is addition or subtraction
        if (t.getData().getType() == AtomicExpression.Type.OpPlus || t.getData().getType() == AtomicExpression.Type.OpMinus) {

            // if left child of t is a leaf node
            if (t.getLeft().isLeaf()) {
                if (t.getLeft().toString() == var) {
                    // if left leaf is var => left child = 1
                    tree.setLeft(new ExpressionTree(new Number(1)));
                } else {
                    tree.setLeft(new ExpressionTree(new Number(0)));
                }
            } else {
                tree.setLeft(differentiate(t.getLeft(), var));
            }
            // if right child of t is a leaf node
            if (t.getRight().isLeaf()) {
                if (t.getRight().toString() == var) {
                    // if right leaf is var => left child = 1
                    tree.setRight(new ExpressionTree(new Number(1)));
                } else {
                    tree.setRight(new ExpressionTree(new Number(0)));
                }
            } else tree.setRight(differentiate(t.getRight(), var));
        } else if (t.getData().getType() == AtomicExpression.Type.OpTimes) {

            tree.setData(new Plus());
            tree.setLeft(new ExpressionTree(new Times(), differentiate(t.getRight(), var), (ExpressionTree) t.getLeft()));
            tree.setRight(new ExpressionTree(new Times(), differentiate(t.getLeft(), var), (ExpressionTree) t.getRight()));
        } else if (t.getData().getType() == AtomicExpression.Type.TSymbol) {
            if (t.getData().toString() == var) {
                tree.setData(new Number(1.0));
            } else
                tree.setData(new Number(0.0));
        }
        return tree;
    }

    public static void main(String[] args) {
        ExpressionTree v1 = new ExpressionTree(new Symbol("x"));
        ExpressionTree v2 = new ExpressionTree(new Symbol("y"));
        ExpressionTree v4 = new ExpressionTree(new Times(), v1, v2);
        DotViewer.displayWindow(differentiate(v4, "x"), "tree");
    }
}
