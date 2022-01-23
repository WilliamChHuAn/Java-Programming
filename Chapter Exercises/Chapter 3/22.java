import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double x = input.nextDouble();
        double y = input.nextDouble();
        double Distance = Math.pow((x * x + y * y), 0.5);

        if(Distance <= 10) {
            System.out.printf("(%.1f,%.1f) is in the circle\n", x, y);
        }
        else{
            System.out.printf("(%.1f,%.1f) is not in the circle\n", x, y);
        }
    }
}
