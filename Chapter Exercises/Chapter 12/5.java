import java.util.Scanner;

public class Main {

    // https://ithelp.ithome.com.tw/articles/10185705
    public static class IllegalTriangleException extends Exception {
    }

    public static class Triangle{

        private final double side1, side2, side3;

        /** Construct a triangle with the specified sides */
        public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
            if(side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1){
                this.side1 = side1;
                this.side2 = side2;
                this.side3 = side3;
            }
            else{
                throw new IllegalTriangleException();
            }
        }
        public double getPerimeter(){
            return side1 + side2 + side3;
        }
        public double getArea(){
            double s = (side1 + side2 + side3) / 2;
            return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        }
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while(input.hasNext()){
            double side1 = input.nextDouble();
            double side2 = input.nextDouble();
            double side3 = input.nextDouble();
            try {
                Triangle t = new Triangle(side1, side2, side3);
                System.out.printf("%.3f %.3f\n", t.getPerimeter(), t.getArea());
            }
            catch (IllegalTriangleException e) {
                System.out.println("The sum of any two sides is greater than the other side");
                System.out.println("Side1: " + side1);
                System.out.println("Side2: " + side2);
                System.out.println("Side3: " + side3);
                System.exit(1);
            }
        }
    }
}