import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static boolean [] PrimeArray(long N){

        ArrayList<Integer> Prime = new ArrayList<>();
        boolean [] A = new boolean[(int)(N + 1)];
        Arrays.fill(A, true);   // where A[i] is true if index i is a prime number

        // Linear Sieve: O(N)
        for(long i = 2; i <= N; i++){
            if(A[(int)i]){
                Prime.add((int)i);
            }

            for(Integer j: Prime){
                // if out of bound, then break;
                if(i * j > N){
                    break;
                }
                else{
                    // sieve multiple of prime until minimum prime factor (second factor)
                    A[(int)i * j] = false;
                    if(i % j == 0){
                        break;
                    }
                }
            }
        }

        return A;
    }

    public static String PrimeFactorization(long N){

        boolean flag = true;
        String ans = "";

        for(int i = 2; N > 1; i++){
            if(N % i == 0){
                if(flag){
                    flag = false;
                }
                else{
                    ans = ans.concat(" * ");
                }

                int cnt = 1;
                ans = ans.concat(Integer.toString(i));  // prime factor
                N = N / i;

                while(N % i == 0){
                    cnt++;      // exponent of prime factor
                    N = N / i;
                }
                if(cnt >= 2){
                    ans = ans.concat("^").concat(Integer.toString(cnt));
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int [] N = new int[1000];
        N[0] = input.nextInt();
        int X = N[0];
        int i = 1;

        for(; input.hasNextInt(); i++){
            N[i] = input.nextInt();
            X = Math.max(X, N[i]);
        }

        boolean [] Prime = PrimeArray(X);
        System.out.print(X + " " + (int)Math.sqrt(X) + "\n");

        for(int j = 0; j < i; j++){
            if(Prime[N[j]]){
                System.out.println(N[j]);
            }
            else{
                System.out.println(PrimeFactorization(N[j]));
            }
        }
    }
}