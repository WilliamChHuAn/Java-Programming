import java.util.Scanner;

public class Main {

    public static class LinearEquation{
        private final double a, b, c, d, e, f;
        public LinearEquation(double a, double b, double e, double c, double d, double f){
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
        }
        public boolean isSolvable(){
            return a * d - b * c != 0;
        }
        public double getX(){
            return (e * d - b * f) / (a * d - b * c);
        }
        public double getY(){
            return (a * f - e * c) / (a * d - b * c);
        }
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();
        double x4 = input.nextDouble();
        double y4 = input.nextDouble();
        LinearEquation le = new LinearEquation((y1 - y2), -(x1 - x2), ((y1 - y2) * x1 - (x1 - x2) * y1), (y3 - y4), -(x3 - x4), ((y3 - y4) * x3 - (x3 - x4) * y3));

        if(le.isSolvable()){
            System.out.print("The intersecting point is: (");
            if(le.getX() == -0.0){
                System.out.print("0.0");
            }
            else{
                System.out.print(le.getX());
            }
            if(le.getY() == -0.0){
                System.out.print(", 0.0)\n");
            }
            else{
                System.out.print(", " + le.getY() + ")\n");
            }
        }
    }
}