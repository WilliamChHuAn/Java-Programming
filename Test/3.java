import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        boolean flag = true;
        boolean space = true;

        for (int i = 2; i < N; i++) {
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = false;
                }
            }
            if (flag) {
                if(space){
                    System.out.printf("%d", i);
                    space = false;
                }
                else{
                    System.out.printf(" %d", i);
                }
            }
            flag = true;
        }
        System.out.println();
    }
}
