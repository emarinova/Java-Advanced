import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayDeque;

public class p07_ReverseNumbersWithAStack {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(String str:input){
            stack.push(Integer.parseInt(str));
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
