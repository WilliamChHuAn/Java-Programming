import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean flag = false;

        while(input.hasNextInt()){

            if(flag){
                System.out.println();
            }
            else{
                flag = true;
            }

            int n = input.nextInt();
            int m = input.nextInt();
            int [] w = new int[m];

            for(int i = 0; i < m; i++){
                w[i] = input.nextInt();
            }

            int k = 0;
            int [] c = new int[m];
            int [] sum = new int[m];    // each sum of containers
            for(int i = 0; i < m; i++){
                for(int j = 0; j < m; j++){
                    if(sum[j] + w[i] <= n){
                        c[i] = j + 1;
                        if(sum[j] == 0){
                            k++;
                        }
                        sum[j] = sum[j] + w[i];
                        break;
                    }
                }
            }

            System.out.println(k);
            for(int i = 1; i <= k; i++){
                System.out.print("Container " + i + " contains objects with weight");
                for(int j = 0; j < m; j++){
                    if(c[j] == i){
                        System.out.print(" " + w[j]);
                    }
                }
                System.out.println();
            }
        }
    }
}