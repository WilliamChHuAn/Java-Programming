import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while(input.hasNext()){

            int Dec = 0;
            String Bin = input.next();

            for(int i = 0; i < Bin.length(); i++){
                if(Bin.charAt(i) == '1'){
                    Dec = Dec + (1 << (Bin.length() - 1 - i));
                }
            }

            System.out.println(Dec);
        }
    }
}
