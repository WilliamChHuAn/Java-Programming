import java.util.Scanner;

public class Main {

    public static class MyPoint{

        private double x, y;

        public MyPoint(){
            x = y = 0;
        }
        public MyPoint(double x, double y){
            this.x = x;
            this.y = y;
        }
        public double distance(MyPoint p){
            return Math.sqrt((x - p.getX()) * (x - p.getX()) + (y - p.getY()) * (y - p.getY()));
        }
        public double distance(double x, double y){
            return Math.sqrt((x - this.x) * (x - this.x) + (y - this.y) * (y - this.y));
        }
        public double distance(MyPoint a, MyPoint b){
            return Math.sqrt((a.getX() - b.getX()) * (a.getX() - b.getX()) + (a.getY() - b.getY()) * (a.getY() - b.getY()));
        }
        public double getX(){
            return x;
        }
        public double getY(){
            return y;
        }
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        MyPoint Mypoint1 = new MyPoint(input.nextDouble(), input.nextDouble());
        MyPoint Mypoint2 = new MyPoint(input.nextDouble(), input.nextDouble());
        double x = input.nextDouble();
        double y = input.nextDouble();

        System.out.println(Mypoint1.distance(Mypoint2));
        System.out.println(Mypoint1.distance(x, y));
    }
}
