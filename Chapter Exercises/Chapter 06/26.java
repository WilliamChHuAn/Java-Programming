import java.util.Scanner;

public class Main {

    public static boolean palindrome(int x){

        String n = Integer.toString(x);
        StringBuilder sb = new StringBuilder(n);
        String rev_n = sb.reverse().toString();

        return n.equals(rev_n);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int cnt = 0;
        boolean flag;

        for(int i = 2; i < Integer.MAX_VALUE; i++){
            flag = true;
            for(int j = 2; j * j <= i; j++){
                if(i % j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                if(palindrome(i)){
                    cnt++;
                    if(cnt % 10 == 1){
                        System.out.print(i);
                    }
                    else if(cnt % 10 == 0){
                        System.out.print(" " + i + "\n");
                    }
                    else{
                        System.out.print(" " + i);
                    }
                }
            }
            if(cnt == N){
                break;
            }
        }
    }
}
