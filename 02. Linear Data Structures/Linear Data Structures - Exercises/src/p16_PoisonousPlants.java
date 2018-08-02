import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p16_PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Integer> plants = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int deadplants = 3;
        int days = 0;
        while (deadplants>0) {
            days++;
            deadplants=0;
            boolean[] plantsToRemove = new boolean[plants.size()];
            for(int i = 0; i < plants.size()-1; i++){
                if(plants.get(i)<plants.get(i+1)){
                    plantsToRemove[i+1]=true;
                }
            }
            for(int i = 0 ; i < plantsToRemove.length; i++){
                if(plantsToRemove[i]){
                    plants.remove(i-deadplants);
                    deadplants++;
                }
            }
        }
        System.out.println(days-1);
    }
}
