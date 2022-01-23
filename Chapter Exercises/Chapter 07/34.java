import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String str = input.next();
        char [] arr = new char[str.length()];

        for(int i = 0; i < str.length(); i++){
            arr[i] = str.charAt(i);
        }

        Arrays.sort(arr);

        System.out.print("Sorted string is ");
        for(int i = 0; i < str.length(); i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
