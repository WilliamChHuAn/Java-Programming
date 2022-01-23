import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N;
        int Cnt = 0;
        int Max = Integer.MIN_VALUE;

        while(input.hasNextInt()){
            N = input.nextInt();
            if(N > Max){
                Max = N;
                Cnt = 1;
            }
            else if(N == Max){
                Cnt++;
            }
        }

        System.out.printf("%d %d\n", Max, Cnt);
    }
}