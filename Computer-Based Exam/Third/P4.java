import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean flag = false;

        while(input.hasNext()){

            if(flag){
                System.out.println();
            }
            else{
                flag = true;
            }

            String Exp = input.nextLine();
            StringTokenizer Tok_num = new StringTokenizer(Exp, "+-*/% ");
            StringTokenizer Tok_op = new StringTokenizer(Exp, ".0123456789 ");
            String [] num = new String[Tok_num.countTokens()];
            String [] op = new String[Tok_op.countTokens()];
            BigDecimal result = BigDecimal.ZERO;
            BigDecimal a;
            BigDecimal b;
            BigDecimal c;

            // print operand & operator tokens
            for(int i = 0; i < num.length; i++){
                num[i] = Tok_num.nextToken();
                if(i == 0){
                    System.out.print(num[i]);
                }
                else{
                    System.out.print(" " + num[i]);
                }
            }
            for(int i = 0; i < op.length; i++){
                op[i] = Tok_op.nextToken();
                System.out.print(" " + op[i]);
            }
            System.out.println();

            int cnt = num.length + op.length;
            if(cnt == 1){
                result = new BigDecimal(num[0]);
            }
            else if(cnt == 2){
                result = new BigDecimal(num[0]).multiply(new BigDecimal("-1"));
            }
            else if(cnt == 3){
                a = new BigDecimal(num[0]);
                b = new BigDecimal(num[1]);
                if(op[0].equals("+")){
                    result = a.add(b);
                }
                else if(op[0].equals("-")){
                    result = a.subtract(b);
                }
                else if(op[0].equals("*")){
                    result = a.multiply(b);
                }
                else if(op[0].equals("/")){
                    result = a.divide(b, 2, RoundingMode.HALF_UP);
                }
                else if(op[0].equals("%")){
                    result = a.remainder(b);
                }
            }
            else{
                a = new BigDecimal(num[0]);
                b = new BigDecimal(num[1]);
                c = new BigDecimal(num[2]);
                if(op[0].equals("+")){
                    if(op[1].equals("+")){
                        result = a.add(b).add(c);
                    }
                    else if(op[1].equals("-")){
                        result = a.add(b).subtract(c);
                    }
                    else if(op[1].equals("*")){
                        result = b.multiply(c).add(a);
                    }
                    else if(op[1].equals("/")){
                        result = b.divide(c, 2, RoundingMode.HALF_UP).add(a);
                    }
                    else if(op[1].equals("%")){
                        result = b.remainder(c).add(a);
                    }
                }
                else if(op[0].equals("-")){
                    if(op[1].equals("+")){
                        result = a.subtract(b).add(c);
                    }
                    else if(op[1].equals("-")){
                        result = a.subtract(b).subtract(c);
                    }
                    else if(op[1].equals("*")){
                        result = a.subtract(b.multiply(c));
                    }
                    else if(op[1].equals("/")){
                        result = a.subtract(b.divide(c, 2, RoundingMode.HALF_UP));
                    }
                    else if(op[1].equals("%")){
                        result = a.subtract(b.remainder(c));
                    }
                }
                else if(op[0].equals("*")){
                    if(op[1].equals("+")){
                        result = a.multiply(b).add(c);
                    }
                    else if(op[1].equals("-")){
                        result = a.multiply(b).subtract(c);
                    }
                    else if(op[1].equals("*")){
                        result = a.multiply(b).multiply(c);
                    }
                    else if(op[1].equals("/")){
                        result = a.multiply(b).divide(c, 2, RoundingMode.HALF_UP);
                    }
                    else if(op[1].equals("%")){
                        result = a.multiply(b).remainder(c);
                    }
                }
                else if(op[0].equals("/")){
                    if(op[1].equals("+")){
                        result = a.divide(b, 2, RoundingMode.HALF_UP).add(c);
                    }
                    else if(op[1].equals("-")){
                        result = a.divide(b, 2, RoundingMode.HALF_UP).subtract(c);
                    }
                    else if(op[1].equals("*")){
                        result = a.divide(b, 2, RoundingMode.HALF_UP).multiply(c);
                    }
                    else if(op[1].equals("/")){
                        result = a.divide(b, 2, RoundingMode.HALF_UP).divide(c, 2, RoundingMode.HALF_UP);
                    }
                    else if(op[1].equals("%")){
                        result = a.divide(b, 2, RoundingMode.HALF_UP).remainder(c);
                    }
                }
                else if(op[0].equals("%")){
                    if(op[1].equals("+")){
                        result = a.remainder(b).add(c);
                    }
                    else if(op[1].equals("-")){
                        result = a.remainder(b).subtract(c);
                    }
                    else if(op[1].equals("*")){
                        result = a.remainder(b).multiply(c);
                    }
                    else if(op[1].equals("/")){
                        result = a.remainder(b).divide(c, 2, RoundingMode.HALF_UP);
                    }
                    else if(op[1].equals("%")){
                        result = a.remainder(b).remainder(c);
                    }
                }
            }
            if(result.compareTo(BigDecimal.ZERO) == 0){
                System.out.println("0.00");
            }
            else if(result.compareTo(BigDecimal.ZERO) < 0){
                System.out.printf("%.2f\n", result);
            }
            else{
                System.out.printf("+%.2f\n", result);
            }
        }
    }
}