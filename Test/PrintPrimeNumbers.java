import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int Cnt = 1;
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
                    Cnt++;
                }
                else {
                    if(Cnt == 10) {
                        System.out.printf(" %d\n", i);
                        space = true;
                        Cnt = 1;
                    }
                    else {
                        System.out.printf(" %d", i);
                        Cnt++;
                    }
                }
            }
            flag = true;
        }
        if(!space){
            System.out.println();
        }
    }
}