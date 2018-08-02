import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p12_LittleJohn {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int countBigArrows = 0;
        int countMediumArrows = 0;
        int countSmallArrows = 0;
        for(int i = 0; i < 4; i++){
            String input = reader.readLine();
            String bigArrows = ">>>----->>";
            String mediumArrows = ">>----->";
            String smallArrows = ">----->";
            while(input.contains(bigArrows)){
                countBigArrows++;
                input = input.replaceFirst(bigArrows,"");
            }
            while(input.contains(mediumArrows)){
                countMediumArrows++;
                input = input.replaceFirst(mediumArrows, "");
            }
            while(input.contains(smallArrows)){
                countSmallArrows++;
                input = input.replaceFirst(smallArrows, "");
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(countSmallArrows).append(countMediumArrows).append(countBigArrows);
        String toBinary = Integer.toBinaryString(Integer.parseInt(sb.toString()));
        sb.replace(0, sb.length(), toBinary);
        String finalNumberInBinary = sb.toString() + sb.reverse().toString();
        System.out.println(Integer.valueOf(finalNumberInBinary, 2));
    }
}
