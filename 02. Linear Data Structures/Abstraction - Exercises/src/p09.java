import java.util.Scanner;

public class p09 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        boolean isFound = true;
        int foundAt = -1;
        int length = 0;
        int power = 0;

        while (isFound) {
            isFound = false;
            for (int i = 0; i < input.length(); i++) {
                if(input.charAt(i)=='|'){
                    if (isFound==false){
                        isFound = true;
                        foundAt = i;
                        length = 1;
                    } else {
                        length++;
                        break;
                    }

                } else {
                    if (isFound==true){
                        power+= (char)input.charAt(i);
                        length++;

                    }
                }

            }
            power = power % 10;


            input = bombOff(input, foundAt - power, foundAt + length + power);
            power = 0;
        }
        System.out.println(input);
    }

    public static String bombOff(String input, int begining, int end){
        StringBuilder sb = new StringBuilder();

        if (begining < 0) {
            begining = 0;
        }
        if (end > input.length()){
            end = input.length();
        }

        for (int i = 0; i < begining; i++){
            sb.append(input.charAt(i));
        }
        for (int i = begining; i < end; i++) {
            sb.append('.');
        }
        for (int i = end; i < input.length(); i++){
            sb.append(input.charAt(i));
        }

        return sb.toString();
    }
}
