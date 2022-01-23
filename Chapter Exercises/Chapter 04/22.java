import java.util.Scanner;

//https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html#contains(java.lang.CharSequence)

public class Main {

    public static void main(String[] args) {

        Scanner intput = new Scanner(System.in);

        String Str = intput.next();
        String sub_Str = intput.next();

        if(Str.contains(sub_Str)){
            System.out.printf("%s is a substring of %s\n", sub_Str, Str);
        }
        else{
            System.out.printf("%s is not a substring of %s\n", sub_Str, Str);
        }
    }
}
