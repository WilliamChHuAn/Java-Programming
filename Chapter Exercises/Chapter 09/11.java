import java.util.Scanner;

public class Main {

    public static class LinearEquation{
        private final double a, b, c, d, e, f;
        public LinearEquation(double a, double b, double c, double d, double e, double f){
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

        double a = input.nextInt();
        double b = input.nextInt();
        double c = input.nextInt();
        double d = input.nextInt();
        double e = input.nextInt();
        double f = input.nextInt();
        LinearEquation le = new LinearEquation(a, b, c, d, e, f);

        if(le.isSolvable()){
            System.out.print("x is " + le.getX() + " and y is " + le.getY() + "\n");
        }
        else{
            System.out.println("The equation has no solution");
        }
    }
}
