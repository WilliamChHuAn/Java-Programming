import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String n = input.next();
        StringBuilder SB = new StringBuilder(n);
        String rev_n = SB.reverse().toString();

        if(n.equals(rev_n)){
            System.out.printf("%s is palindrome\n", n);
        }
        else{
            System.out.printf("%s is not palindrome\n", n);
        }
    }
}
