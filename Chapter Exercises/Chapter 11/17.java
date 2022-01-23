import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

         int m = input.nextInt();
        // System.out.println(m * m);

        int temp = m;
        ArrayList<Integer> f = new ArrayList<>();

        for(int i = 2; temp > 1; i++){
            while(temp % i == 0){
                f.add(i);
                temp = temp / i;
            }
        }

        int n = 1;
        int cnt = 1;
        f.add(0);
        for(int i = 0; i < f.size() - 1; i++){
            if(f.get(i).equals(f.get(i + 1))){
                cnt++;
            }
            else{
                if(cnt % 2 == 1){
                    n = n * f.get(i);
                }
                cnt = 1;
            }
        }

        System.out.println(m * n);
    }
}