import java.util.Scanner;

public class p01_RectangleArea {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double a = Double.parseDouble(console.next());
        double b = Double.parseDouble(console.next());
        double area = a*b;
        System.out.printf("%.2f", area);
    }
}
