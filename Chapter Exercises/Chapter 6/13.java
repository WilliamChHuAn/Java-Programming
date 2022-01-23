public class Main {

    public static void main(String[] args) {

        double m = 0;
        System.out.println("   i                m(i)");

        for(double i = 1; i <= 20; i++){
            m = m + (i / (i + 2));
            System.out.printf("%4d%20.4f\n", (int)i, m);
        }

    }
}