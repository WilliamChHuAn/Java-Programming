import java.awt.geom.Point2D;
import java.util.Scanner;

public class Main {

    public static class Triangle{

        private final double a, b, c, s;

        public Triangle(Point2D.Double p1, Point2D.Double p2, Point2D.Double p3){
            a = p1.distance(p2);    // length of side1
            b = p1.distance(p3);    // length of side2
            c = p2.distance(p3);    // length of side3
            s = (a + b + c) / 2;
        }
        public double getArea(){
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));  // using Heron's formula to calculate area of triangle
        }
    }

    public static class ConvexPolygon{

        private final Triangle [] t;

        public ConvexPolygon(double [][] xy){

            Point2D.Double[] p = new Point2D.Double[xy.length]; // length of p is number of x-coordinate(y-coordinate)
            t = new Triangle[p.length - 2]; // N points can be computed using the areas of N − 2 triangles

            for(int i = 0; i < xy.length; i++){
                p[i] = new Point2D.Double(xy[i][0], xy[i][1]);  // using Point2D class to store points
            }
            // https://web.ntnu.edu.tw/~algo/ConvexHull.html#3
            // using Graham's Scan to solve Convex Hull
            for(int i = 0; i < t.length; i++){
                t[i] = new Triangle(p[0], p[i + 1], p[i + 2]);  // generate triangles and store into t object
            }
        }
        public double getArea(){

            double sum = 0;

            for (Triangle triangle : t) {
                sum = sum + triangle.getArea(); // area of convex polygon can be accumulated by triangles
            }

            return sum;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean flag = false;   // control the blank line between cases
        while (input.hasNextInt()){

            if(flag){
                System.out.println();   // if the output not the first, then print a blank line
            }
            else{
                flag = true;    // open the switch
            }

            int N = input.nextInt();
            double [][] point = new double[N][2];

            for(int i = 0; i < N; i++){ // input data and store into point array which
                point[i][0] = input.nextDouble();   // [i][0] is x-coordinate
                point[i][1] = input.nextDouble();   // [i][1] is y-coordinate
            }

            ConvexPolygon g = new ConvexPolygon(point); // create an object which is a convex polygon means any side by two vertex is inside
            System.out.printf("%.3f\n", g.getArea());   // print the area of convex polygon
        }
    }
}