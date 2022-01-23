import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int Year;

        while(true){

            Year = input.nextInt();
            if(Year == -1){
                break;
            }

            if(Year % 400 == 0 || (Year % 4 == 0 && Year % 100 != 0)){
                System.out.println("It is leap year.");
            }
            else{
                System.out.println("It is not leap year.");
            }
        }
    }
}
