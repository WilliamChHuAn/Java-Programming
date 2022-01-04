import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean space = true;   // control the blank line
//        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Scanner input = new Scanner(System.in);

        while(input.hasNextInt()){

            int n = input.nextInt();

            if(n == -1){
                break;
            }
            else{
                char[][] mp = new char[n][n];

                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        mp[i][j] = input.next().charAt(0);
                    }
                }

                boolean flag = true;   // check each alpha occurring exactly once in each column or row

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
//                        if(mp[i][j] != alpha.charAt(j)){
//                            flag = false;
//                        }
                    }
                }

                if(!flag){
                    if(space){
                        space = false;
                    }
                    else{
                        System.out.println();
                    }
                    System.out.println("The input array is not a Latin square");
                }
                else{
                    if(space){
                        space = false;
                    }
                    else{
                        System.out.println();
                    }
                    System.out.println("The input array is a Latin square");
                }
            }
        }
    }
}