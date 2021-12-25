import java.math.BigInteger;
import java.util.Scanner;

class Rational implements Comparable<Rational> {

    // Data fields for numerator and denominator
    private BigInteger numerator = BigInteger.ZERO;
    private BigInteger denominator = BigInteger.ONE;

    /** Construct a rational with default properties */
    public Rational() {
    }

    /** Construct a rational with specified numerator and denominator */
    public Rational(BigInteger numerator, BigInteger denominator) {

        BigInteger gcd = gcd(numerator, denominator);

        this.numerator = numerator.divide(gcd);
        if(denominator.compareTo(BigInteger.ZERO) <= 0){
            this.numerator = this.numerator.multiply(new BigInteger("-1"));
        }
        this.denominator = denominator.abs().divide(gcd);
    }

    /** Find GCD of two numbers */
    private static BigInteger gcd(BigInteger n, BigInteger d) {

        BigInteger n1 = n.abs();
        BigInteger n2 = d.abs();
        BigInteger gcd = BigInteger.ONE;

        for(BigInteger k = BigInteger.ONE; k.compareTo(n1) <= 0 && k.compareTo(n2) <= 0; k = k.add(BigInteger.ONE)){
            if(n1.mod(k).compareTo(BigInteger.ZERO) == 0 && n2.mod(k).compareTo(BigInteger.ZERO) == 0 ){
                gcd = k;
            }
        }

        return gcd;
    }

    /** Return numerator */
    public BigInteger getNumerator() {
        return numerator;
    }

    /** Return denominator */
    public BigInteger getDenominator() {
        return denominator;
    }

    /** Add a rational number to this rational */
    public Rational add(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator()).add(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /** Subtract a rational number from this rational */
    public Rational subtract(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator()).subtract(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /** Multiply a rational number by this rational */
    public Rational multiply(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /** Divide a rational number by this rational */
    public Rational divide(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator());
        BigInteger d = denominator.multiply(secondRational.getNumerator());
        return new Rational(n, d);
    }

    @Override
    public String toString() {
        if(denominator.compareTo(BigInteger.ONE) == 0) {
            return numerator.toString();
        }
        else{
            return numerator.toString() + "/" + denominator.toString();
        }
    }

    @Override // Override the equals() method in the Object class
    public boolean equals(Object other) {
        return (this.subtract((Rational) (other))).getNumerator().compareTo(BigInteger.ZERO) == 0;
    }

    @Override // Implement the compareTo method in Comparable
    public int compareTo(Rational o) {
        if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) > 0){
            return 1;
        }
        else if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) < 0){
            return -1;
        }
        return 0;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Rational r1 = new Rational(new BigInteger(input.next()), new BigInteger(input.next()));
        Rational r2 = new Rational(new BigInteger(input.next()), new BigInteger(input.next()));
        System.out.println(r1 + " + " + r2  + " = " + r1.add(r2).toString());
        System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2).toString());
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2).toString());
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2).toString());
    }
}