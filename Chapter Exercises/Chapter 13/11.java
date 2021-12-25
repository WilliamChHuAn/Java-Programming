abstract class GeometricObject implements Comparable<GeometricObject>{

    /** Abstract method getArea */
    public abstract double getArea();
    /** Abstract method getPerimeter */
    public abstract double getPerimeter();

    @Override
    public int compareTo(GeometricObject o) {
        if(getPerimeter() > o.getPerimeter()){
            return 1;
        }
        else if(getPerimeter() < o.getPerimeter()){
            return  -1;
        }
        return 0;
    }
}

class Octagon extends GeometricObject implements Cloneable{

    private final double side;

    public Octagon(double side){
        this.side = side;
    }
    @Override
    public double getArea() {
        return (2 + (4 / Math.sqrt(2))) * side * side;
    }
    @Override
    public double getPerimeter() {
        return side * 8;
    }
    // https://www.geeksforgeeks.org/cloneable-interface-in-java/
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        Octagon oct = new Octagon(5);
        Octagon octClone = (Octagon) oct.clone();
        System.out.println("Area is " + oct.getArea());
        System.out.println("Perimeter is " + oct.getPerimeter());
        System.out.println("Compare the methods " + oct.compareTo(octClone));
    }
}