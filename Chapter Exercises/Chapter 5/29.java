import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int year = input.nextInt();
        int first_day = input.nextInt();
        int [] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String [] month = {" ", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        for(int i = 1; i <= 12; i++){
            System.out.printf("          %s %d\n", month[i], year);
            System.out.println("-----------------------------");
            System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
            for(int j = 0; j < first_day; j++){
                System.out.print("    ");
            }
            for(int j = 1; j <= day[i]; j++){
                System.out.printf("%4d", j);
                if(j % 7 + first_day == 7 || (j % 7 == 0 && first_day == 0) || j == day[i]){
                    System.out.println();
                }
            }
            first_day = (first_day + day[i]) % 7;
            if(i < 12){
                System.out.println();
            }
        }
    }
}
