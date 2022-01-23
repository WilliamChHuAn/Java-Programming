import java.math.BigDecimal;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String exp = input.nextLine();      // input the expression
        String delimiter = "+-*/()%";
        StringTokenizer st = new StringTokenizer(exp, delimiter, true);
        String [] array = new String[st.countTokens()];  // a string array to store operators & operands
        BigDecimal sum = new BigDecimal("0");
        boolean space = true;               // control the output format
        int i = 0;                          // count how many tokens

        for(; st.hasMoreTokens(); i++) {
            array[i] = st.nextToken();      // store operator (i is even) & operand (i is odd)
        }

        // print operands & calculate sum
        for(int j = 0; j < i; j++){
            if(!delimiter.contains(array[j])){
                BigDecimal temp = new BigDecimal(array[j]);
                sum = sum.add(temp);
                if(space){
                    System.out.print(array[j]);
                    space = false;
                }
                else{
                    System.out.print(" " + array[j]);
                }
            }
        }
        space = true;
        System.out.println();

        // print operators
        for(int j = 0; j < i; j++){
            if(delimiter.contains(array[j])){
                if(space){
                    System.out.print(array[j]);
                    space = false;
                }
                else{
                    System.out.print(" " + array[j]);
                }
            }
        }
        System.out.println();
        System.out.printf("%.3f\n", sum);
    }
}