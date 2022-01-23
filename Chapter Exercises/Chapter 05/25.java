import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int i = input.nextInt();
        double pi = 0;

        for(int j = 1; j <= i; j++){
            pi = pi + (Math.pow(-1, j + 1) / (2 * j - 1));
        }

        pi = pi * 4;
        System.out.println(pi);
    }
}
