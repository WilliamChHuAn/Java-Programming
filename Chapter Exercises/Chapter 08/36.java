import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        char [][] mp = new char[n][n];
        int result = 0;
        boolean flag = true;

        for(int i = 0; flag && i < n; i++){
            for(int j = 0; input.hasNext() && j < n; j++){
                mp[i][j] = input.next().charAt(0);
            }
            for(int j = 0; flag && j < n; j++){
                if(mp[i][j] - 'A' >= n){
                    result = 1; // the letters not from A to 'A + n'
                    flag = false;
                }
                if(mp[i][j] == 0){
                    result = 2; // enter less than n letters
                    flag = false;
                }
            }
        }

        // check each column
        for(int i = 0; flag && i < n; i++){             // iterate each column
            for(int j = 0; flag && j < n; j++){         // iterate each row
                for(int k = j + 1; flag && k < n; k++){ // iterate next rows
                    if(mp[j][i] == mp[k][i]){
                        flag = false;
                    }
                }
            }
        }

        // check the characters are the first n characters starting from 'A' and each row
        for(int i = 0; flag && i < n; i++){
            Arrays.sort(mp[i]);
        }
        for(int i = 0; flag && i < n; i++){
            for(int j = 0; flag && j < n; j++){
                if(mp[0][i] != mp[j][i]){
                    flag = false;
                }
            }
        }

        if(flag){
            System.out.println("The input array is a Latin square");
        }
        else{
            if(result == 0){
                System.out.println("The input array is not a Latin square");
            }
            else if(result == 1){
                System.out.print("Wrong input: the letters must be from A to " + (char)('A' + n - 1) + "\n");
            }
            else {
                System.out.print("Wrong input: you need to enter exactly " + n + " letters\n");
            }
        }
    }
}