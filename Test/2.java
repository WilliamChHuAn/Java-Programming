public class Main {

    public static void main(String[] args) {
        for(int i = 1; i <= 9; i++){
            System.out.printf("%d * 1 = %2d", i, i);
            for(int j = 2; j <= 9; j++){
                System.out.printf(" %d * %d = %2d", i, j, i * j);
            }
            System.out.println();
        }
    }
}