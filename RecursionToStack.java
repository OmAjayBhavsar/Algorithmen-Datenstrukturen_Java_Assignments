import aud.Stack;

public class RecursionToStack {
    public static int whatStack(int n) {

        Stack<Integer> stack = new Stack<>();
        while (n > 10) {

            stack.push(n % 10);
            n = n / 10;
        }
        stack.push(n);
        int sum = 0;
        while (!stack.is_empty()) {
            sum = sum + stack.pop();
        }
        return sum;
    }

    public static int whatRec(int n) {
        int sum = 0;
        while (n >= 10) {
            sum += n % 10;
            n /= 10;
        }
        return sum + n;
    }

    public static void main(String args[]) {
        System.out.println(whatStack(367));
        System.out.println(whatRec(997));
    }
}