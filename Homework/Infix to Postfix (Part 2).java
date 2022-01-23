import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String exp = input.nextLine();  // input the expression
        StringTokenizer str_tok = new StringTokenizer(exp, "+-*/()%", true);
        String [] array = new String[str_tok.countTokens()]; // a string array to store operators & operands
        int tok_len = str_tok.countTokens();    // token length

        for(int i = 0; str_tok.hasMoreTokens(); i++) {
            array[i] = str_tok.nextToken();  // store operator & operand
        }

        Stack<String> st = new Stack<>();

        for(int i = 0; i < tok_len; i++) {
            switch (array[i]){
                case "*":
                case "/":
                case "%":
                    // while priority of array[i] = top of stack, then pop + print top of stack
                    if(!st.empty()){
                        while(!st.empty() && (st.peek().equals("*") || st.peek().equals("/") || st.peek().equals("%"))){
                                System.out.print(st.pop() + " ");
                        }
                    }
                    // finally, push new operator
                    st.push(array[i]);
                    break;
                case "+":
                case "-":
                    // if priority of array[i] >= top of stack, then pop + print top of stack
                    if(!st.empty()){
                        if(st.peek().equals("*") || st.peek().equals("/") || st.peek().equals("%") || st.peek().equals("+") || st.peek().equals("-")){
                            while(!st.empty() && !st.peek().equals("(")){
                                System.out.print(st.pop() + " ");
                            }
                        }
                    }
                    // finally, push new operator
                    st.push(array[i]);
                    break;
                case "(":
                    st.push(array[i]);
                    break;
                case ")":
                    // pop elements until (
                    if(!st.empty()){
                        while(!st.peek().equals("(")){
                            System.out.print(st.pop() + " ");
                        }
                        // pop "("
                        st.pop();
                    }
                    break;
                default:
                    // print alpha
                    System.out.print(array[i] + " ");
                    break;
            }
        }
        while(!st.empty()){
            if(!st.peek().equals("(")){
                System.out.print(st.pop() + " ");
            }
        }
        System.out.println();
    }
}