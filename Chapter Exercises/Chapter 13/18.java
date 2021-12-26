import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    public static class Rational extends Number implements Comparable<Rational> {

        private BigInteger numerator = BigInteger.ZERO;
        private BigInteger denominator = BigInteger.ONE;

        /** Construct a rational with default properties */
        public Rational() {
        }

        /** Construct a rational with specified numerator and denominator */
        public Rational(BigInteger numerator, BigInteger denominator) {

            BigInteger gcd = numerator.gcd(denominator);

            if (denominator.compareTo(BigInteger.ZERO) < 0) {
                numerator = numerator.negate();
            }

            this.numerator = numerator.divide(gcd);
            this.denominator = denominator.divide(gcd);
        }

        /** Return numerator */
        public BigInteger getNumerator() {
            return this.numerator;
        }

        /** Return denominator */
        public BigInteger getDenominator() {
            return denominator;
        }

        /** Add a rational number to this rational */
        public Rational add(Rational secondRational) {
            BigInteger n = this.numerator.multiply(secondRational.getDenominator()).add(this.denominator.multiply(secondRational.getNumerator()));
            BigInteger d = this.denominator.multiply(secondRational.getDenominator());
            BigInteger gcd = n.gcd(d);
            return new Rational(n.divide(gcd), d.divide(gcd));
        }

        /** Subtract a rational number from this rational */
        public Rational subtract(Rational secondRational) {
            BigInteger n = this.numerator.multiply(secondRational.getDenominator()).subtract(this.denominator.multiply(secondRational.getNumerator()));
            BigInteger d = this.denominator.multiply(secondRational.getDenominator());
            BigInteger gcd = n.gcd(d);
            return new Rational(n.divide(gcd), d.divide(gcd));
        }

        /** Multiply a rational number by this rational */
        public Rational multiply(Rational secondRational) {
            BigInteger n = this.numerator.multiply(secondRational.getNumerator());
            BigInteger d = this.denominator.multiply(secondRational.getDenominator());
            return new Rational(n, d);
        }

        /** Divide a rational number by this rational */
        public Rational divide(Rational secondRational) {
            BigInteger n = this.numerator.multiply(secondRational.getDenominator());
            BigInteger d = this.denominator.multiply(secondRational.getNumerator());
            return new Rational(n, d);
        }

        @Override
        public String toString() {
            if (denominator.equals(BigInteger.ONE)){
                return numerator + "";
            }
            return numerator + "/" + denominator;
        }

        @Override
        public boolean equals(Object other) {
            return (this.subtract((Rational) (other))).getNumerator().equals(BigInteger.ZERO);
        }

        @Override
        public int intValue() {
            return (int) doubleValue();
        }

        @Override
        public float floatValue() {
            return (float) doubleValue();
        }

        @Override
        public double doubleValue() {
            BigDecimal u = new BigDecimal(this.numerator.toString());
            BigDecimal l = new BigDecimal(this.denominator.toString());
            return u.divide(l, 15, RoundingMode.HALF_UP).doubleValue();
        }

        @Override
        public long longValue() {
            return (long) this.doubleValue();
        }

        @Override
        public int compareTo(Rational o) {
            return Integer.compare(this.subtract(o).getNumerator().compareTo(BigInteger.ZERO), 0);
        }
    }

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        Rational r = new Rational();

        for (int i = 1; i < n; i += 2) {
            BigInteger j = new BigInteger(String.valueOf(i));
            r = r.add(new Rational(j, j.add(BigInteger.ONE)));
        }

        System.out.println(r.doubleValue());
    }
}