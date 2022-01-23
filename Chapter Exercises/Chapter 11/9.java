import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int [][] matrix = new int[n][n];
        ArrayList<Integer> r = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = input.nextInt();
            }
        }

        int r_max = 0;
        int c_max = 0;

        for(int i = 0; i < n; i++){
            int r_cnt = 0;
            int c_cnt = 0;
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    r_cnt++;
                }
                if(matrix[j][i] == 0){
                    c_cnt++;
                }
            }
            if(r_cnt > r_max){
                r.clear();
                r.add(i);
                r_max = r_cnt;
            }
            else if(r_cnt == r_max){
                r.add(i);
            }
            if(c_cnt > c_max){
                c.clear();
                c.add(i);
                c_max = c_cnt;
            }
            else if(c_cnt == c_max){
                c.add(i);
            }
        }

        System.out.print("The most 0s row index: " + r.get(0));
        for (int i = 1; i < r.size(); i++) {
            System.out.print(", " + r.get(i));
        }
        System.out.print("\nThe most 0s column index: " + c.get(0));
        for (int i = 1; i < c.size(); i++) {
            System.out.print(", " + c.get(i));
        }
        System.out.println();
    }
}
