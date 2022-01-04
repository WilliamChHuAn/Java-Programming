import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while(input.hasNextBigInteger()){

            BigInteger M = input.nextBigInteger();
            BigInteger N = input.nextBigInteger();
            BigInteger G = M.gcd(N);
            BigInteger L = M.multiply(N).divide(G);

            System.out.print(G + " " + L + "\n");

            int cnt = 0;
            boolean space = true;
            BigInteger LB = L.add(BigInteger.ONE);

            for(BigInteger i = LB; cnt < 5; i = i.add(BigInteger.ONE)){
                if(i.isProbablePrime(1)){
                    cnt++;
                    if(space){
                        System.out.print(i);
                        space = false;
                    }
                    else{
                        System.out.print(" " + i);
                    }
                }
            }
            System.out.println();
        }
    }
}