import java.util.Stack;

public class Palindrome {
    public static boolean isPalindrome(String text) {
        text = text.replaceAll("\\s|[^a-zA-Z0-9]", "");// removes spaces and special characters
        text = text.toLowerCase();
        // Stack data structure (only remove/add from top)
        Stack<Character> temporaryText = new Stack<>();
        for (int i = 0; i < text.length(); i++) {
            temporaryText.push(text.charAt(i));
        }
        for (int i = 0; i < text.length(); i++) {
            if (!((temporaryText.pop()).equals(text.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("saippuakivikauppias"));
    }
}

