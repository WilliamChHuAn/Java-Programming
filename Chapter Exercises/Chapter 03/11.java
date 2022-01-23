import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int Month = input.nextInt();
        int Year = input.nextInt();
        int Month_Day[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String Month_Name[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        if(Month == 2 && (Year % 400 == 0 || (Year % 4 == 0 && Year % 100 != 0))){
            System.out.printf("%s %d had 29 Days\n", Month_Name[Month - 1], Year);
        }
        else{
            System.out.printf("%s %d had %d Days\n", Month_Name[Month - 1], Year, Month_Day[Month - 1]);
        }
    }
}
