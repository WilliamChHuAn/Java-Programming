import java.util.Scanner;

public class Main {

    public static class BinaryFormatException extends Exception{
    }

    public static int bin2Dec(String binaryString) throws BinaryFormatException{

        for(int i = 0; i < binaryString.length(); i++){
            if(!(binaryString.charAt(i) == '0' || binaryString.charAt(i) == '1')){
                throw new BinaryFormatException();
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
            catch (BinaryFormatException e){
                System.out.println("String no Binary");
                System.exit(1);
            }
        }
    }
}