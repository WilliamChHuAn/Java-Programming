import java.util.Scanner;

public class Main {

    public static class QuadraticEquation{
        private final int a, b, c;    // coefficient
        public QuadraticEquation(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public int getDiscriminant(){
            return b * b - 4 * a * c;
        }
        public double getRoot1(){
            if(getDiscriminant() < 0){
                return 0;
            }
            return (-b + Math.sqrt(getDiscriminant())) / (2 * a);
        }
        public double getRoot2(){
            if(getDiscriminant() < 0){
                return 0;
            }
            return (-b - Math.sqrt(getDiscriminant())) / (2 * a);
        }
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        QuadraticEquation qe = new QuadraticEquation(a, b, c);

        if(qe.getDiscriminant() > 0){
            System.out.print("The roots are " + qe.getRoot1() + " and " + qe.getRoot2() + "\n");
        }
        else if(qe.getDiscriminant() == 0){
            System.out.print("The root is " + qe.getRoot1() + "\n");
        }
        else{
            System.out.println("The equation has no roots");
        }
    }
}