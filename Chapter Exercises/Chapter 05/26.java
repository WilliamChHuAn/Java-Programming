import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input =  new Scanner(System.in);

        int n = input.nextInt();
        double e = 1;
        double item = 1;

        for(int i = 1; i <= n; i++){
            // item / i = item x (1 / i)
            item = item / i;
            e = e + item;
        }

        System.out.println(e);
    }
}
