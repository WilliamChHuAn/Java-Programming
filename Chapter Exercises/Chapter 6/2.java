import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int product = N % 10;
        N = N / 10;

        while(N > 0){
            product = product * (N % 10);
            N = N / 10;
        }

        System.out.println(product);
    }
}
