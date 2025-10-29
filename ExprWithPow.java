import aud.example.expr.*;
import aud.util.DotViewer;

public class ExprWithPow extends ExpressionParser {

    protected ExpressionTree sum(int level) {
        ExpressionTree left = product(level + 1);
        ExpressionTree right;
        Boolean test = true;
        while (test) {
            if (lookahead() == Tokenizer.PLUS) {
                nextToken();
                right = product(level + 1);
                left = new ExpressionTree(new Plus(), left, right);
            } else if (lookahead() == Tokenizer.MINUS) {
                nextToken();
                right = product(level + 1);
                left = new ExpressionTree(new Minus(), left, right);
            } else test = false;
        }
        return left;
    }

    protected ExpressionTree product(int level) {
        ExpressionTree left = this.pow(level + 1);
        ExpressionTree right;
        if (this.lookahead() == Tokenizer.TIMES) {
            this.nextToken();
            right = this.product(level + 1);
            return new ExpressionTree(new Times(), left, right);
        } else if (this.lookahead() == Tokenizer.DIVIDE) {
            this.nextToken();
            right = this.product(level + 1);
            return new ExpressionTree(new Divide(), left, right);
        } else {
            return left;
        }
    }

    public ExpressionTree pow(int level) {
        ExpressionTree left = factor(level + 1);
        ExpressionTree right;
        if (lookahead() == 94) {
            nextToken();
            right = pow(level + 1);
            return new ExpressionTree(new Power(), left, right);
        } else {
            return left;
        }
    }

    public static void main(String[] args) {
        ExprWithPow m = new ExprWithPow();
        String str = "1-2-3";
        System.out.println(m.parse(str).getValue());
        ExpressionTree tree = m.parse(str);
        DotViewer.displayWindow(tree, "powTree").setExitOnClose();

    }
}