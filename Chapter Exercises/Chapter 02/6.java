import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int num = input.nextInt();
        int sum = 0;

        sum = num % 10;
        num = num / 10;

        while(num > 0){
            sum = sum * (num % 10);
            num = num / 10;
        }

        System.out.println(sum);
    }
}
