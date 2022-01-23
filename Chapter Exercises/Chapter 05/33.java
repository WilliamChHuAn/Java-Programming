public class Main {

    public static void main(String[] args) {

        for(int i = 2; i <= 10000; i++){
            int sum = 1;
            for(int j = 2; j * j <= i; j++){
                if(j * j == i){
                    sum = sum + j;
                }
                else if(i % j == 0){
                    sum = sum + j + i / j;
                }
            }
            if(i == sum){
                System.out.println(i);
            }
        }
    }
}