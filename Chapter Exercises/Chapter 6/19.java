import java.util.Scanner;

public class Main {

    public static boolean isValid(double side1, double side2, double side3){
        return side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1;
    }
    public static double area(double side1, double side2, double side3){
        double s = (side1 + side2 + side3) / 2.0;
        return Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();

        if(isValid(side1, side2, side3)){
            System.out.printf("The are of the triangle is %.1f\n", area(side1, side2, side3));
        }
        else{
            System.out.println("Input is invalid");
        }
    }
}
