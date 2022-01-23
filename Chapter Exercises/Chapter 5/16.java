import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int _N = N;
        boolean flag = true;
        int pf = 2; // prime factor

        if(N == 1){
            System.out.printf("1 1");
        }
        else{
            while(N > 1){
                if(N % pf == 0){
                    if(flag){
                        if(pf == _N){
                            System.out.printf("1 %d", N);
                        }
                        else{
                            System.out.printf("%d", pf);
                        }
                        flag = false;
                    }
                    else{
                        System.out.printf(" %d", pf);
                    }
                    N = N / pf;
                }
                else{
                    pf++;
                }
            }
        }
        System.out.println();
    }
}
