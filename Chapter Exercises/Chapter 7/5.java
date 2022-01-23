import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int odd = 0;
        int even = 0;

        while(true){

            int N = input.nextInt();

            if(N == 0){
                break;
            }
            else{
                if((N & 1) == 0){
                    even++;
                }
                else{
                    odd++;
                }
            }
        }

        System.out.printf("The number of odd numbers:%d\n", odd);
        System.out.printf("The number of even numbers:%d\n", even);
    }
}