import java.util.Scanner;

public class Main {

    public static abstract class GeometricObject{

        protected String color;
        protected boolean filled;

        protected GeometricObject(){
        }
        protected GeometricObject(String color, boolean filled){
            this.color = color;
            this.filled = filled;
        }

        protected String getColor(){
            return color;
        }
        protected boolean getFilled(){
            return filled;
        }
    }
    public static class Triangle extends GeometricObject{

        private final double side1;
        private final double side2;
        private final double side3;

        public Triangle(){
            this.side1 = this.side2 = this.side3 = 1;
        }
        public Triangle(double side1, double side2, double side3, String color, boolean filled) {
            super(color, filled);
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }
        public double getSide1(){
            return side1;
        }
        public double getSide2(){
            return side2;
        }
        public double getSide3() {
            return side3;
        }

        public double getArea(){
            double s = (side1 + side2 + side3) / 2;
            return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        }
        public double getPerimeter(){
            return side1 + side2 + side3;
        }
        public String toString(){
            return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
        }
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Triangle t = new Triangle(input.nextDouble(), input.nextDouble(), input.nextDouble(), input.next(), input.nextBoolean());
        System.out.printf("%.3f %.3f %s ", t.getArea(), t.getPerimeter(), t.getColor());
        System.out.println(t.getFilled());
    }
}
