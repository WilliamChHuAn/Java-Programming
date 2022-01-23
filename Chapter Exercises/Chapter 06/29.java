import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> prime = new ArrayList<>();
        boolean [] sieve = new boolean[1001];

        for(int i = 2; i < 1001; i++){
            if(!sieve[i]){
                prime.add(i);
            }

            for(Integer j: prime){
                if(i * j >= 1000){
                    break;
                }
                else{
                    sieve[i * j] = true;
                    if(i % j == 0){
                        break;
                    }
                }
            }
        }

        for(int i = 1; i < prime.size(); i++){
            if(prime.get(i) - prime.get(i - 1) == 2){
                System.out.printf("(%d, %d)\n", prime.get(i - 1), prime.get(i));
            }
        }
    }
}
