import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static BigDecimal calculate(String exp){

        StringTokenizer Tok_num = new StringTokenizer(exp, "+-*/% ");
        StringTokenizer Tok_op = new StringTokenizer(exp, ".0123456789 ");
        String [] num = new String[Tok_num.countTokens()];
        String [] op = new String[Tok_op.countTokens()];
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal a;
        BigDecimal b;
        BigDecimal c;

        for(int i = 0; i < num.length; i++){
            num[i] = Tok_num.nextToken();
        }
        for(int i = 0; i < op.length; i++){
            op[i] = Tok_op.nextToken();
        }

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
                result = a.divide(b, 1, RoundingMode.FLOOR);
            }
            else if(op[0].equals("%")){
                result = a.remainder(b);
            }
            System.out.printf("%s %s %s = ", a, op[0], b);
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
                    result = b.divide(c, 1, RoundingMode.FLOOR).add(a);
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
                    result = a.subtract(b.divide(c, 1, RoundingMode.FLOOR));
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
                    result = a.multiply(b).divide(c, 1, RoundingMode.FLOOR);
                }
                else if(op[1].equals("%")){
                    result = a.multiply(b).remainder(c);
                }
            }
            else if(op[0].equals("/")){
                if(op[1].equals("+")){
                    result = a.divide(b, 1, RoundingMode.FLOOR).add(c);
                }
                else if(op[1].equals("-")){
                    result = a.divide(b, 1, RoundingMode.FLOOR).subtract(c);
                }
                else if(op[1].equals("*")){
                    result = a.divide(b, 1, RoundingMode.FLOOR).multiply(c);
                }
                else if(op[1].equals("/")){
                    result = a.divide(b, 1, RoundingMode.FLOOR).divide(c, 1, RoundingMode.FLOOR);
                }
                else if(op[1].equals("%")){
                    result = a.divide(b, 1, RoundingMode.FLOOR).remainder(c);
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
                    result = a.remainder(b).divide(c, 1, RoundingMode.FLOOR);
                }
                else if(op[1].equals("%")){
                    result = a.remainder(b).remainder(c);
                }
            }
            System.out.printf("%s %s %s %s %s = ", a, op[0], b, op[1], c);
        }
        return result;
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while(input.hasNext()){
            String Exp = input.nextLine();
            System.out.printf("%.1f\n", calculate(Exp));
        }
    }
}