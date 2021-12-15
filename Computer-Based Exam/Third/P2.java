import java.util.Scanner;

public class Main {

    public static class Complex implements Cloneable{

        double a, b;

        public Complex(){
            this.a = 0;
            this.b = 0;
        }
        public Complex(double a, double b){
            this.a = a;
            this.b = b;
        }

        // Operation
        public Complex add(Complex o){
            return new Complex(this.a + o.a, this.b + o.b);
        }
        public Complex subtract(Complex o){
            return new Complex(this.a - o.a, this.b - o.b);
        }
        public Complex multiply(Complex o){
            return new Complex(this.a * o.a - this.b * o.b, this.b * o.a + this.a * o.b);
        }
        public Complex divide(Complex o){
            return new Complex((this.a * o.a + this.b * o.b) / (o.a * o.a + o.b * o.b), (this.b * o.a - this.a * o.b) / (o.a * o.a + o.b * o.b));
        }
        public Complex abs(){
            return new Complex(Math.sqrt(a * a + b * b), 0);
        }

        // implement Cloneable
        public Complex clone(){
            return new Complex(a, b);
        }

        // Override
        public String toString(){
            double A = (int)(this.a * 10000) / 10000.;
            double B = (int)(this.b * 10000) / 10000.;
            if(A != 0 && B == 0){
                return Double.toString(A);
            }
            else if(A == 0 && B != 0){
                return B + "i";
            }
            else if(A == 0){
                return "0";
            }
            else{
                if(B > 0){
                    return A + " + " + B + "i";
                }
                else{
                    return A + " - " + (-B) + "i";
                }
            }
        }
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean flag = false;

        while(input.hasNext()){

            if(flag){
                System.out.println();
            }
            else{
                flag = true;
            }

            double a = input.nextDouble();
            double b = input.nextDouble();
            double c = input.nextDouble();
            double d = input.nextDouble();

            Complex cpx1 = new Complex(a, b);
            Complex cpx2 = new Complex(c, d);
            System.out.println("(" + cpx1 + ") + (" + cpx2 + ") = " + cpx1.add(cpx2).toString());
            System.out.println("(" + cpx1 + ") - (" + cpx2 + ") = " + cpx1.subtract(cpx2).toString());
            System.out.println("(" + cpx1 + ") * (" + cpx2 + ") = " + cpx1.multiply(cpx2).toString());
            System.out.println("(" + cpx1 + ") / (" + cpx2 + ") = " + cpx1.divide(cpx2).toString());
            System.out.println("|" + cpx1 + "| = " + cpx1.abs().toString());
        }
    }
}