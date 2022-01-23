public class Main {

    public static class RegularPolygon{
        private int n;          // number of sides
        private double side;    // length of the side
        private double x, y;    // x-coordinate & y-coordinate of the polygon's center
        public RegularPolygon(){
            // default value
            n = 3;
            side = 1;
            x = y = 0;
        }
        public RegularPolygon(int n, double side){
            this.n = n;
            this.side = side;
            x = y = 0;
        }
        public RegularPolygon(int n, double side, double x, double y){
            this.n = n;
            this.side = side;
            this.x = x;
            this.y = y;
        }
        public double getPerimeter(){
            return side * n;
        }
        public double getArea(){
            return (n * side * side) / (4 * Math.tan(Math.PI / n));
        }
    }
    public static void main(String[] args) {
        RegularPolygon Polygon1 = new RegularPolygon();
        RegularPolygon Polygon2 = new RegularPolygon(6, 4);
        RegularPolygon Polygon3 = new RegularPolygon(10, 4, 5.6, 7.8);
        System.out.print("Polygon 1 perimeter: " + Polygon1.getPerimeter() + "\n");
        System.out.print("Polygon 1 area: " + Polygon1.getArea() + "\n");
        System.out.print("Polygon 2 perimeter: " + Polygon2.getPerimeter() + "\n");
        System.out.print("Polygon 2 area: " + Polygon2.getArea() + "\n");
        System.out.print("Polygon 3 perimeter: " + Polygon3.getPerimeter() + "\n");
        System.out.print("Polygon 3 area: " + Polygon3.getArea() + "\n");
    }
}
