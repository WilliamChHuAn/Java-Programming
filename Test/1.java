import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        for(int i = 1; i <= N; i++){
            for(int j = N - 1 - i; j >= 0; j--){
                System.out.print(" ");
            }
            for(int j = 0; j < (2 * i) - 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}