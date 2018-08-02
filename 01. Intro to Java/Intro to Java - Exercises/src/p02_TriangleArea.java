import java.util.Scanner;

public class p02_TriangleArea {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int ax = console.nextInt();
        int ay = console.nextInt();
        int bx = console.nextInt();
        int by = console.nextInt();
        int cx = console.nextInt();
        int cy = console.nextInt();

        //double ar = (ax*(by-cy)+bx*(cy-ay)+cx*(ay-by))/2;
        int area = Math.abs(Math.round((ax*(by-cy)+bx*(cy-ay)+cx*(ay-by))/2));
        //String drbug = "";
        System.out.println(area);
    }
}
