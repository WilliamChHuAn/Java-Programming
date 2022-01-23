import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while(input.hasNext()){

            String exp = input.nextLine();
            StringTokenizer st = new StringTokenizer(exp, " ");
            String ans = "";
            while(st.hasMoreTokens()){
                ans = ans + st.nextToken();
            }

            StringTokenizer st_op = new StringTokenizer(ans, "+-*/", true);
            int num1 = Integer.parseInt(st_op.nextToken());
            String op = st_op.nextToken();
            int num2 = Integer.parseInt(st_op.nextToken());

            System.out.print(num1 + " " + op + " " + num2 + " = ");
            if(op.equals("+")){
                num1 = num1 + num2;
            }
            else if(op.equals("-")){
                num1 = num1 - num2;
            }
            else if(op.equals("*")){
                num1 = num1 * num2;
            }
            else if(op.equals("/")){
                num1 = num1 / num2;
            }
            System.out.println(num1);
        }
    }
}