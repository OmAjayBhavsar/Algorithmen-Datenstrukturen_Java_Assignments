import java.util.*;

public class TPalindrome {

    public static boolean isTPalindrome(String text) {

        text = text.replaceAll("[^a-zA-Z0-9()]", "");
        Stack<Character> stack = new Stack<>();
        String finalString = "";

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ')') {
                stack.push(text.charAt(i));
            } else {
                StringBuilder tempString = new StringBuilder();

                while (!stack.isEmpty() && stack.peek() != '(') {
                    tempString.append(stack.pop());
                }

                if (stack.isEmpty()) {
                    return false;
                }

                stack.pop();

                if (!isPalindrome(tempString.toString())) {
                    return false;
                } else {
                    stack.push('*');
                }
            }
        }

        while (!stack.isEmpty()) {
            finalString += stack.pop();
        }

        System.out.println("Final String: " + finalString);

        return isPalindrome(finalString);
    }

    public static boolean isPalindrome(String text) {
        text = text.toLowerCase();
        java.util.Stack<Character> tempText = new java.util.Stack<>();// Stack is created

        for (int i = 0; i < text.length(); i++) {
            tempText.push(text.charAt(i)); // each char is pushed into the stack(reversed)
        }
        for (int j = 0; j < text.length() / 2; j++) {
            if (tempText.pop() != text.charAt(j)) {
                // iterates to half the length
                // Compares temptext with j, if diff false
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isTPalindrome(" al(otto)la "));
    }
}
