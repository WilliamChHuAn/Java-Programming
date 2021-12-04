import java.util.Scanner;

public class Main {

    public static class NumberFormatException extends Exception{
    }

    public static int bin2Dec(String binaryString) throws NumberFormatException{

        for(int i = 0; i < binaryString.length(); i++){
            if(!(binaryString.charAt(i) == '0' || binaryString.charAt(i) == '1')){
                throw new NumberFormatException();
            }
        }

        return Integer.parseInt(binaryString, 2);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while(input.hasNext()){

            String bin = input.next();
            try {
                System.out.println(bin2Dec(bin));
            }
            catch (NumberFormatException e){
                System.out.println("String no Binary");
                System.exit(1);
            }
        }
    }
}