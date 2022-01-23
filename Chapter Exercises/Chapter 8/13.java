import java.util.Scanner;

public class Main {

    public static int[] locateSmallest(double[][] a){
        int [] pos = new int[2];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                if(a[i][j] < a[pos[0]][pos[1]]){
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }
        return pos;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int m = input.nextInt();
        int n = input.nextInt();
        double [][] a = new double[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = input.nextDouble();
            }
        }

        int [] pos = locateSmallest(a);
        System.out.printf("The location of the smallest element is at (%d, %d)\n", pos[0], pos[1]);
    }
}