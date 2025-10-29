import aud.example.expr.ExpressionParser;
import aud.example.expr.ExpressionTree;
import aud.util.DotViewer;

public class ExampleExpression {
    public static void main(String[] args) {
        String input = "((2*2)/2)+6";
        System.out.println("input = " + input + "'");
        ExpressionParser p = new ExpressionParser();
        p.setVerbose(true); // detailed info about program's execution
        ExpressionTree tree = p.parse(input);
        System.out.println(tree);
        System.out.println("postorder = '" + tree.postorder().toString() + "'");
        System.out.println("inorder   = '" + tree.inorder().toString() + "'");
        System.out.println("preorder  = '" + tree.preorder().toString() + "'");
        DotViewer.displayWindow(tree, "ajsh").setExitOnClose();
    }
}



/*
* ExpressionParser is a class responsible for parsing
* arithmetic expressions and building expression trees.
*
* ExpressionTree is a data structure representing an
* arithmetic expression in the form of a tree.
*
*
* */