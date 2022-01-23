import java.util.Scanner;

public class Main {

    public static double deviation(double [] x){

        double m = mean(x);
        double d = 0;

        for(int i = 0; i < 10; i++){
            d = d + ((x[i] - m) * (x[i] - m));
        }

        return Math.sqrt(d / 9);
    }

    public static double mean(double [] x){

        double m = 0;

        for(int i = 0; i < 10; i++){
            m = m + x[i];
        }

        return m / 10;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double [] x = new double[10];

        for(int i = 0; i < 10; i++){
            x[i] = input.nextDouble();
        }

        System.out.print("The mean is " + mean(x) + "\n");
        System.out.print("The standard deviation is " + deviation(x) + "\n");
    }
}
