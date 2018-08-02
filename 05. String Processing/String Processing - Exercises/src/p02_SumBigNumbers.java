import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02_SumBigNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstNumber = reader.readLine();
        String secondNumber = reader.readLine();
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int left = 0;
        while (firstNumber.length()-i >=0 || secondNumber.length()-i >=0){
            int firstNumDigit = 0;
            int secondNumDigit = 0;
            if (firstNumber.length()-i>=0) {
                firstNumDigit = firstNumber.charAt(firstNumber.length()-i) - '0';
            }
            if (secondNumber.length()-i>=0){
                secondNumDigit = secondNumber.charAt(secondNumber.length()-i) - '0';
            }
            int sumOfDigits = firstNumDigit+secondNumDigit+left;
            int newDigit = sumOfDigits%10;
            sb.append(newDigit);
            left = sumOfDigits/10;
            i++;
        }
        if(left!=0){
            sb.append(left);
        }
        sb.reverse();

        for (int j = 0; j < sb.length(); j++) {
            if (sb.charAt(j) == '0') {
                sb.deleteCharAt(j);
                j--;
            } else {
                break;
            }
        }
        System.out.println(sb);

    }
}
