import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        ArrayDeque<Integer> stones = new ArrayDeque<>();
        for (String token : tokens) {
            stones.offer(Integer.parseInt(token));
        }
        Integer storage = 0;
        String[] commandLine = reader.readLine().split(" ");
        while(!"Revision".equals(commandLine[0])){
            String command = commandLine[0] + " " + commandLine[1];
            Integer parameter = Integer.parseInt(commandLine[2]);
            if (command.equals("Apply acid")){
                for (int i = 0; i < parameter; i++) {
                    if(!stones.isEmpty()) {
                        Integer stone = stones.poll();
                        stone--;
                        if (stone == 0) {
                            storage++;
                        } else {
                            stones.offer(stone);
                        }
                    }
                }
            } else if (command.equals("Air leak")){
                if (storage>0){
                    storage--;
                    stones.offer(parameter);
                }
            }
            commandLine = reader.readLine().split(" ");
        }
        while(!stones.isEmpty()){
            System.out.print(stones.poll() + " ");
        }
        System.out.println();
        System.out.println(storage);
    }
}
