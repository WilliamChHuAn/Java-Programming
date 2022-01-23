import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

class Calculate{

    public static String [] Infix_Tok(String s){

        StringTokenizer str_tok = new StringTokenizer(s, "+-*/()%", true);
        String [] Infix = new String[str_tok.countTokens()]; // a string array to store operators & operands

        for(int i = 0; str_tok.hasMoreTokens(); i++) {
            Infix[i] = str_tok.nextToken();  // store operator & operand
        }

        return Infix;
    }

    public static String [] Postfix_Tok(String s){

        // get the infix array
        String [] Infix = Infix_Tok(s);
        String [] Postfix = new String[Infix.length];
        Stack<String> st = new Stack<>();
        int j = 0;

        // System.out.print("Infix Length: " + Infix.length + "\n");

        for(int i = 0; i < Infix.length && Infix[i] != null; i++) {
            switch (Infix[i]){
                case "*":
                case "/":
                case "%":
                    // while priority of array[i] = top of stack, then pop + store top of stack
                    while(!st.empty() && (st.peek().equals("*") || st.peek().equals("/") || st.peek().equals("%"))){
                        Postfix[j++] = st.pop();
                    }
                    // finally, push new operator
                    st.push(Infix[i]);
                    break;
                case "+":
                case "-":
                    // if priority of array[i] >= top of stack, then pop + store top of stack
                    if(!st.empty() && (st.peek().equals("*") || st.peek().equals("/") || st.peek().equals("%") || st.peek().equals("+") || st.peek().equals("-"))){
                        while(!st.empty() && !st.peek().equals("(")){
                            Postfix[j++] = st.pop();
                        }
                    }
                    // finally, push new operator
                    st.push(Infix[i]);
                    break;
                case "(":
                    st.push(Infix[i]);
                    break;
                case ")":
                    // pop elements until (
                    while(!st.empty() && !st.peek().equals("(")){
                        Postfix[j++] = st.pop();
                    }
                    // pop "("
                    st.pop();
                    break;
                default:
                    // store alpha
                    Postfix[j++] = Infix[i];
                    break;
            }
        }
        while(!st.empty() && !st.peek().equals("(")){
            Postfix[j++] = st.pop();
        }

        return Postfix;
    }

    public static BigDecimal BigDecimal_Calculate(String s){

        BigDecimal a;
        BigDecimal b;
        // get the postfix array
        String [] Postfix = Postfix_Tok(s);
        Stack<String> st = new Stack<>();

        // System.out.print("Infix Length: " + Postfix.length + "\n");

        for(int i = 0; i < Postfix.length && Postfix[i] != null; i++){
            // if Postfix[i] is operator, then calculate two numbers in top of stack and push the result
            switch (Postfix[i]){
                case "+":
                    a = new BigDecimal(st.pop());
                    b = new BigDecimal(st.pop());
                    st.push(a.add(b).toString());
                    break;
                case  "-":
                    a = new BigDecimal(st.pop());
                    b = new BigDecimal(st.pop());
                    st.push(b.subtract(a).toString());
                    break;
                case  "*":
                    a = new BigDecimal(st.pop());
                    b = new BigDecimal(st.pop());
                    st.push(a.multiply(b).toString());
                    break;
                case "/":
                    a = new BigDecimal(st.pop());
                    b = new BigDecimal(st.pop());
                    st.push(b.divide(a).toString());
                    break;
                case "%":
                    a = new BigDecimal(st.pop());
                    b = new BigDecimal(st.pop());
                    st.push(b.remainder(a).toString());
                    break;
                default:
                    st.push(Postfix[i]);
                    break;
            }
        }

        // return the result and cast String to BigDecimal
        return new BigDecimal(st.pop());
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String exp = input.nextLine();  // input the expression
        System.out.printf("%.2f\n", Calculate.BigDecimal_Calculate(exp));
    }
}