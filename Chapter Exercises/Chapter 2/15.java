import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        System.out.println(Math.pow((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1), 0.5));
    }
}