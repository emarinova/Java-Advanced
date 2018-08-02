import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p04_CalculateExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        double first = Double.parseDouble(input[0]);
        double second = Double.parseDouble(input[1]);
        double third = Double.parseDouble(input[2]);


        double f1 = Math.pow((first*first + second*second)/(first*first - second*second), (first+second+third)/Math.sqrt(third));
        double f2 = Math.pow((first*first + second*second - third*third*third), (first-second));

        double diff = Math.abs((first+second+third)/3 - (f1+f2)/2);

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1, f2, diff);
    }
}