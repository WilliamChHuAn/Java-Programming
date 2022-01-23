import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while(input.hasNextInt()){

            int N = input.nextInt();
            BigInteger [] PT = new BigInteger[N + 1];
            Arrays.fill(PT, BigInteger.ONE);
            PT[0] = BigInteger.ZERO;

            for(int i = 1; i <= N; i++){
                for(int j = 0; j < N - i; j++){
                    System.out.print(" ");
                }
                for(int j = i; j > 0; j--){
                    System.out.print(PT[j] + " ");
                    PT[j] = PT[j].add((PT[j - 1]));
                }
                System.out.println();
            }
        }
    }
}
