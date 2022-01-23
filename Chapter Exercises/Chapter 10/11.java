public class Main {

    public static class Circle2D{

        private double x;
        private double y;
        private double radius;

        public Circle2D(){
            x = y = 0;
            radius = 1;
        }
        public double getX(){
            return x;
        }
        public double getY(){
            return y;
        }
        public double getRadius(){
            return radius;
        }
        public Circle2D(double x, double y, double radius){
            this.x = x;
            this.y = y;
            this.radius = radius;
        }
        public double getArea(){
            return Math.PI * radius * radius;
        }
        public double getPerimeter(){
            return 2 * Math.PI * radius;
        }
        public boolean contains(double x, double y){
            return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y)) < radius;
        }
        public boolean contains(Circle2D circle){
            return Math.sqrt((this.x - circle.getX()) * (this.x - circle.getX()) + (this.y - circle.getY()) * (this.y - circle.getY())) + circle.getRadius() < radius;
        }
        public boolean overlaps(Circle2D circle){
            return Math.sqrt((this.x - circle.getX()) * (this.x - circle.getX()) + (this.y - circle.getY()) * (this.y - circle.getY())) < radius + circle.getRadius();
        }
    }
    public static void main(String[] args) {

        Circle2D c1 = new Circle2D(2, 2, 5.5);

        System.out.println("Area is " + c1.getArea());
        System.out.println("Perimeter is " + c1.getPerimeter());
        System.out.println("c1 contains point (3, 3)? " + c1.contains(3, 3));
        System.out.println("c1 contains circle Circle2D(4, 5, 10.5)? " + c1.contains(new Circle2D(4, 5, 10.5)));
        System.out.println("c1 overlaps circle Circle2D(3, 5, 2.3)? " + c1.contains(new Circle2D(3, 5, 2.3)));
        System.out.println();
    }
}
