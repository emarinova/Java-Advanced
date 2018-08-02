import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p08_BasicStackOprations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nsx = reader.readLine().split("\\s+");
        String[] numbers = reader.readLine().split("\\s+");
        int n = Integer.parseInt(nsx[0]);
        int s = Integer.parseInt(nsx[1]);
        int x = Integer.parseInt(nsx[2]);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n-s; i++){
            stack.push(Integer.parseInt(numbers[i]));
        }
        if(stack.contains(x)){
            System.out.println("true");
        } else if(!stack.isEmpty()){
            int smallest = stack.pop();
            while(!stack.isEmpty()){
                int popped = stack.pop();
                if(smallest>popped){
                    smallest = popped;
                }
            }
            System.out.println(smallest);
        } else {
            System.out.println(0);
        }
    }
}
