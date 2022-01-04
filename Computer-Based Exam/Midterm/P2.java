import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static class Point{
        Point2D.Double p1, p2, p3;
        public Point(double x1, double y1, double x2, double y2, double x3, double y3){
            this.p1 = new Point2D.Double(x1, y1);
            this.p2 = new Point2D.Double(x2, y2);
            this.p3 = new Point2D.Double(x3, y3);
        }
    }
    public static class Triangle{
        double a, b, c;
        double s;
        public Triangle(Point2D.Double p1, Point2D.Double p2, Point2D.Double p3){
            this.a = p1.distance(p2);
            this.b = p1.distance(p3);
            this.c = p2.distance(p3);
            this.s = (a + b + c) / 2;
        }
        public boolean isTriangle(){
            return (a + b) > c && (a + c) > b && (b + c) > a;
        }
        public double area(){
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }
        public double [] getSide(){
            double [] side = {a, b, c};
            Arrays.sort(side);
            return side;
        }
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        for(int i = 0; i < N; i++){
            double x1 = input.nextDouble();
            double y1 = input.nextDouble();
            double x2 = input.nextDouble();
            double y2 = input.nextDouble();
            double x3 = input.nextDouble();
            double y3 = input.nextDouble();
            Point p = new Point(x1, y1, x2, y2, x3, y3);
            Triangle t = new Triangle(p.p1, p.p2, p.p3);
            if(t.isTriangle()){
                double [] side = t.getSide();
                System.out.printf("%.3f %.3f %.3f %.3f\n", side[0], side[1], side[2], t.area());
            }
            else{
                System.out.println("Just Line!");
            }
        }
    }
}