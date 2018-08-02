import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class p09_MaximumElement {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int maxElement = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++){
            String[] command = reader.readLine().split(" ");
            switch (command[0]){
                case "1":
                    int number = Integer.parseInt(command[1]);
                    stack.push(number);
                    if (number>maxElement) {
                        maxElement = number;
                    }
                    break;
                case "2":
                        if (stack.pop() == maxElement) {
                            maxElement = Integer.MIN_VALUE;
                        }
                    break;
                case "3":
                    if (maxElement==Integer.MIN_VALUE){
                        maxElement = Collections.max(stack);
                    }
                    sb.append(maxElement).append(System.lineSeparator());
                    break;
            }
        }
        System.out.println(sb);
    }
}
