import java.util.Scanner;
//http://kpeggy.blogspot.com/2013/07/javayou-can-say-11.html
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String N;

        while (input.hasNext()) {

            N = input.next();

            if (N.equals("0")) {
                break;
            }

            int ans = 0;

            for (int i = 0; i < N.length(); i++) {
                if (i % 2 == 0) {
                    ans = ans + (N.charAt(i) - '0');
                }
                else {
                    ans = ans - (N.charAt(i) - '0');
                }
            }

            if (ans % 11 == 0) {
                System.out.printf("%s is a multiple of 11.\n", N);
            }
            else {
                System.out.printf("%s is not a multiple of 11.\n", N);
            }
        }
    }
}