import java.util.Scanner;

public class Main {

    public static boolean isConsecutiveFour(int[][] values){

        for(int i = 0; i < values.length; i++){
            for(int j = 0; j < values[i].length; j++){
                if(j + 3 < values[i].length){   // row
                    if(values[i][j] == values[i][j + 1] && values[i][j] == values[i][j + 2] && values[i][j] == values[i][j + 3]){
                        return true;
                    }
                }
                if(i + 3 < values.length){   // column
                    if(values[i][j] == values[i + 1][j] && values[i][j] == values[i + 2][j] && values[i][j] == values[i + 3][j]){
                        return true;
                    }
                }
                if(i + 3 < values.length && j + 3 < values[i].length){  // right bottom
                    if(values[i][j] == values[i + 1][j + 1] && values[i][j] == values[i + 2][j + 2] && values[i][j] == values[i + 3][j + 3]){
                        return true;
                    }
                }
                if(i + 3 < values.length && j - 3 >= 0){  // left bottom
                    if(values[i][j] == values[i + 1][j - 1] && values[i][j] == values[i + 2][j - 2] && values[i][j] == values[i + 3][j - 3]){
                        return true;
                    }
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int m = input.nextInt();
        int n = input.nextInt();
        int [][] values = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                values[i][j] = input.nextInt();
            }
        }

        System.out.println(isConsecutiveFour(values));
    }
}