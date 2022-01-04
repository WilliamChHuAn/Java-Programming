import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static int gcd(int a, int b){
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }
    public static class Rational{

        private int Molecular;
        private int Denominator;

        // constructor
        public Rational(int a, int b){
            this.Molecular = a;
            this.Denominator = b;
        }

        // get Molecular & Denominator
        public int getMolecular(){
            return this.Molecular;
        }
        public int getDenominator(){
            return this.Denominator;
        }

        // set Molecular & Denominator
        public void setMolecular(int a){
            this.Molecular = a;
        }
        public void setDenominator(int b){
            this.Denominator = b;
        }

        // calculate
        public Rational add(Rational val){
            int a = this.Molecular * val.getDenominator() + this.Denominator * val.getMolecular();
            int b = this.Denominator * val.getDenominator();
            return new Rational(a / gcd(a, b), b / gcd(a, b));
        }
        public Rational subtract(Rational val){
            int a = this.Molecular * val.getDenominator() - this.Denominator * val.getMolecular();
            int b = this.Denominator * val.getDenominator();
            return new Rational(a / gcd(a, b), b / gcd(a, b));
        }
        public Rational multiply(Rational val){
            int a = this.Molecular * val.getMolecular();
            int b = this.Denominator * val.getDenominator();
            return new Rational(a / gcd(a, b), b / gcd(a, b));
        }
        public Rational divide(Rational val){
            int a = this.Molecular * val.Denominator;
            int b = this.Denominator * val.getMolecular();
            return new Rational(a / gcd(a, b), b / gcd(a, b));
        }

        // get String of Rational
        public String getRational(){
            if(this.Molecular == 0){
                return "0";
            }
            else if(this.Molecular % this.Denominator == 0){
                return Integer.toString(this.Molecular / this.Denominator);
            }
            else if(this.Denominator < 0){
                return "(" + -(this.Molecular / gcd(this.Molecular, this.Denominator)) + "/ " + -(this.Denominator / gcd(this.Molecular, this.Denominator)) + ")";
            }
            return "(" + (this.Molecular / gcd(this.Molecular, this.Denominator)) + "/ " + (this.Denominator / gcd(this.Molecular, this.Denominator)) + ")";
        }
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String operator;
        String exp1, exp2;
        int a, b;

        while(input.hasNext()){

            operator = input.nextLine();
            exp1 = input.nextLine();
            exp2 = input.nextLine();

            StringTokenizer st1 = new StringTokenizer(exp1, "()/ ");
            StringTokenizer st2 = new StringTokenizer(exp2, "()/ ");
            a = Integer.parseInt(st1.nextToken());
            b = Integer.parseInt(st1.nextToken());
            Rational num1 = new Rational(a, b);
            a = Integer.parseInt(st2.nextToken());
            b = Integer.parseInt(st2.nextToken());
            Rational num2 = new Rational(a, b);

            if(operator.equals("+")){
                Rational ans = num1.add(num2);
                System.out.println(num1.getRational() + " " + operator + " " + num2.getRational() + " = " + ans.getRational());
            }
            else if(operator.equals("-")){
                Rational ans = num1.subtract(num2);
                System.out.println(num1.getRational() + " " + operator + " " + num2.getRational() + " = " + ans.getRational());
            }
            else if(operator.equals("*")){
                Rational ans = num1.multiply(num2);
                System.out.println(num1.getRational() + " " + operator + " " + num2.getRational() + " = " + ans.getRational());
            }
            else if(operator.equals("/")){
                Rational ans = num1.divide(num2);
                System.out.println(num1.getRational() + " " + operator + " " + num2.getRational() + " = " + ans.getRational());
            }
        }
    }
}