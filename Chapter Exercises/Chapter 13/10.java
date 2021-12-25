import java.util.Scanner;

/** (Enable Rectangle comparable) Rewrite the Rectangle class in Listing 13.3 to
 extend  GeometricObject  and  implement  the  Comparable  interface.  Override
 the equals()  method  in  the  Object  class.  Two  Rectangle  objects  are  equal
 if  their  areas  are  the  same.  Draw  the  UML  diagram  that  involves  Rectangle,
 GeometricObject, and Comparable. */

abstract class GeometricObject implements Comparable<GeometricObject>{

    /** Abstract method getArea */
    public abstract double getArea();
    /** Abstract method getPerimeter */
    public abstract double getPerimeter();

    @Override
    public int compareTo(GeometricObject o) {
        if(getArea() > o.getArea()){
            return 1;
        }
        else if(getArea() < o.getArea()){
            return  -1;
        }
        return 0;
    }
}
class Rectangle extends GeometricObject{

    private final double width;
    private final double height;

    public Rectangle (double width, double height){
        this.width = width;
        this.height = height;
    }
    @Override
    public double getArea() {
        return width * height;
    }
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
    /** o belong Rectangle && area are the same */
    @Override
    public boolean equals(Object o) {
        return o instanceof Rectangle && getArea() == ((Rectangle)o).getArea();
    }
}
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Rectangle r1 = new Rectangle(input.nextDouble(), input.nextDouble());
        Rectangle r2 = new Rectangle(input.nextDouble(), input.nextDouble());
        System.out.println(r1.equals(r2));
    }
}
