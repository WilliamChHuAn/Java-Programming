import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while(input.hasNext()){

            int odd = 0;
            int even = 0;
            String num = input.next();

            for(int i = num.length() - 1; i >= 0; i = i - 2){
                odd = odd + (num.charAt(i) - '0');
            }

            for(int i = num.length() - 2; i >= 0; i = i - 2){
                even = even + (num.charAt(i) - '0');
            }

            System.out.printf("%d %d\n", odd, even);

            if((odd - even) % 11 == 0){
                System.out.printf("%s is a multiple of 11.\n", num);
            }
            else{
                System.out.printf("%s is not a multiple of 11.\n", num);
            }
        }
    }
}