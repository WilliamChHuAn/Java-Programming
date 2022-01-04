import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        input.nextLine();

        while(N-- > 0){
            String str = input.nextLine();
            String org_str = input.nextLine();
            String new_str = input.nextLine();
            StringBuilder sb = new StringBuilder(str);

            if(sb.indexOf(org_str) != -1){
                do{
                    sb.replace(sb.indexOf(org_str), sb.indexOf(org_str) + org_str.length(), new_str);
                }while(sb.indexOf(org_str) != -1 && !sb.toString().equals(str));
            }

            System.out.println(sb.reverse());
        }
    }
}