import java.util.Scanner;

public class Main {

    private static final int Upper_Bound = Integer.MAX_VALUE;

    public static int palindromic_prime(String str){

        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String rev_str = sb.reverse().toString();

        return str.compareTo(rev_str);
    }

    public static int[] check_prime(){

        int size = 1;               // size of pp
        boolean flag = true;        // is prime or not
        int[] pp = new int[101];    // Palindromic Prime

        for(int i = 2; i < Upper_Bound && size <= 100; i++){
            for(int j = 2; flag && j * j <= i; j++){
                if(i % j == 0){
                    flag = false;
                }
            }
            if(flag){
                if(palindromic_prime(Integer.toString(i)) == 0){
                    pp[size++] = i;
                }
            }
            else{
                flag = true;
            }
        }
        return pp;
    }
    public static void main(String[] args) {

        int[] pp = check_prime();

        Scanner input = new Scanner(System.in);

        while(input.hasNextInt()){

            int N = input.nextInt();

            if(N == 0){
                System.out.println();
            }
            else{
                for(int i = 1; i <= N; i++){
                    if(i % 10 == 1) {
                        System.out.print(pp[i]);
                    }
                    else if(i % 10 == 0) {
                        System.out.println(" " +pp[i]);
                    }
                    else{
                        System.out.print(" " + pp[i]);
                    }
                }

                if(N % 10 != 0){
                    System.out.println();
                }
            }
        }
    }
}