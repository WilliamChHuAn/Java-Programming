import java.util.Scanner;

//https://zh.wikipedia.org/wiki/克萊姆法則#例子

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double a, b, c, d, e, f;

        a = input.nextDouble();
        b = input.nextDouble();
        e = input.nextDouble();
        c = input.nextDouble();
        d = input.nextDouble();
        f = input.nextDouble();

        double x = (e * d - b * f) / (a * d - b * c);
        double y = (a * f - e * c) / (a * d - b * c);
        System.out.print(x + " " + y + "\n");
    }
}