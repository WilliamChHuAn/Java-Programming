import java.util.Scanner;

public class Main {

    public static class MyNumberFormatException extends Exception{

        String wrongMsg;

        // constructor
        public MyNumberFormatException(String wrongMsg){
            this.wrongMsg = wrongMsg;
        }
        // show wrong message
        public String getWrongMessage(){
            return wrongMsg;
        }
    }

    public static String dec2Hex(int dec){

        StringBuilder hex = new StringBuilder();

        // through bitwise operation to improve convert process efficient
        while(dec > 0){
            // because 0xF = 1111 = 15 -> remain least 4 bit
            if((dec & 0xF) >= 10){
                hex.append((char)(((dec & 0xF) - 10) + 'A'));
            }
            else{
                hex.append(dec & 0xF);
            }
            // because 4 bit = 1 hex = 2^4 = 16
            // dec >> 4 = dec / (2^4) = dec / 16
            dec = dec >> 4;
        }

        return hex.reverse().toString();
    }

    public static int hex2Dec(String hexString) throws MyNumberFormatException{

        int dec = 0;

        for(int i = 0; i < hexString.length(); i++){
            // also use bitwise operation to improve convert process efficient
            // like L32 -> left shift 4 digit = dec * (2^4) = dec * 16
            // (0 << 4) | A = 0 | A = A
            // (A << 4) | B = A0 | B = AB
            // (AB << 4) | C = AB0 | C = ABC
            if(hexString.charAt(i) >= '0' && hexString.charAt(i) <= '9' ){
                dec = (dec << 4) | (hexString.charAt(i) - '0');
            }
            else if(hexString.charAt(i) >= 'A' && hexString.charAt(i) <= 'F'){
                dec = (dec << 4) | (hexString.charAt(i) - 'A' + 10);
            }
            // nor digit neither alpha -> exception
            else{
                throw new MyNumberFormatException("String is no HEX");
            }
        }

        return dec;
        // convert hex to dec
        // return Integer.parseInt(hexString, 16);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int dec = input.nextInt();
        String hexString1 = input.next();
        String hexString2 = input.next();

        try {
            System.out.println(dec2Hex(dec));
            System.out.println(hex2Dec(hexString1));
            System.out.println(hex2Dec(hexString2));
        } catch (MyNumberFormatException ex) {
            System.out.println(ex.getWrongMessage());
            System.exit(1); // a nonzero status indicates abnormal termination
        }
    }
}