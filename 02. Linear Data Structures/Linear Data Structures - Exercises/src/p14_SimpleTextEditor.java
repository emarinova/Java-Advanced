import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p14_SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("");
        for (int i = 0; i < n; i++){
            String[] command = reader.readLine().split("\\s+");
            switch (command[0]){
                case "1":
                    StringBuilder sb = new StringBuilder();
                    sb.append(stack.peek());
                    sb.append(command[1]);
                    stack.push(sb.toString());
                    break;
                case "2":
                    int charsToRemove = Integer.parseInt(command[1]);
                    String lastElement = stack.peek();
                    lastElement = lastElement.substring(0, lastElement.length()-charsToRemove);
                    stack.push(lastElement);
                    break;
                case "3":
                    int index = Integer.parseInt(command[1]);
                    System.out.println(stack.peek().charAt(index-1));
                    break;
                case "4":
                    stack.pop();
                    break;
            }
        }
    }
}
