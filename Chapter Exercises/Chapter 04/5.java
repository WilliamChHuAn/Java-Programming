import java.util.Scanner;

public class Main {

//https://zh.wikipedia.org/wiki/正多边形#面积

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();            // Number of sides
        double len = input.nextDouble();    // Side Length

        System.out.println(N * len * len / (4 * Math.tan(Math.PI / N)));
//        System.out.println(Math.PI);
//        System.out.println(N * len * len * Math.tan(((N - 2) * (Math.PI / 2)) / N) / 4);
//        System.out.println((N * len * len * Math.sin(Math.PI * 2 / N)) / (4 - 4 * Math.cos(Math.PI * 2 / N)));
    }
}
