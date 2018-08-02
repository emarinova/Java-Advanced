import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p12_BalancedParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isOk = true;
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i)=='[' || input.charAt(i)=='{' || input.charAt(i)=='('){
                stack.push(input.charAt(i));
            } else if (input.charAt(i)==']'){
                if(stack.isEmpty()){
                    isOk = false;
                    break;
                } else if (stack.peek() != '[') {
                    isOk = false;
                    break;
                } else stack.pop();
            } else if (input.charAt(i)=='}'){
                if(stack.isEmpty()){
                    isOk = false;
                    break;
                } else if (stack.peek() != '{') {
                    isOk = false;
                    break;
                } else stack.pop();
            } else if (input.charAt(i)==')'){
                if(stack.isEmpty()){
                    isOk = false;
                    break;
                } else if (stack.peek() != '(') {
                    isOk = false;
                    break;
                } else stack.pop();
            }
        }
        if (isOk) System.out.println("YES");
        else System.out.println("NO");
    }
}
