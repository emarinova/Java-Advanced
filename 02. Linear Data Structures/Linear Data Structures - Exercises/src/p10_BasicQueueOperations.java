import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class p10_BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nsx = reader.readLine().split("\\s+");
        int n = Integer.parseInt(nsx[0]);
        int s = Integer.parseInt(nsx[1]);
        int x = Integer.parseInt(nsx[2]);
        String[] numbers = reader.readLine().split("\\s+");
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0 ; i < n ; i++){
            queue.add(Integer.parseInt(numbers[i]));
        }
        for (int i = 0; i < s; i++){
            if(queue.isEmpty()){
                break;
            }
            queue.remove();
        }
        if(queue.isEmpty()){
            System.out.println(0);
        } else if (queue.contains(x)){
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
