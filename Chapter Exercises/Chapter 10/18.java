import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        BigInteger n = new BigInteger("1000000");
        for(int i = 0; i < 10; i++){
            n = n.nextProbablePrime();
            System.out.println(n);
        }
    }
}
