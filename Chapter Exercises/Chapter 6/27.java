public class Main {

    public static boolean palindrome(int x){
        String n = Integer.toString(x);
        return n.equals(Integer.toString(reverse(x)));
    }

    public static int reverse(int x){
        StringBuilder sb = new StringBuilder(Integer.toString(x));
        return Integer.parseInt(sb.reverse().toString());
    }

    public static boolean is_prime(int x){
        for(int j = 2; j * j <= x; j++){
            if(x % j == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int cnt = 0;

        for(int i = 13; i < Integer.MAX_VALUE; i++){
            if(is_prime(i) && is_prime(reverse(i)) && !palindrome(i)){
                cnt++;
                if(cnt % 10 == 1){
                    System.out.print(i);
                }
                else if(cnt % 10 == 0){
                    System.out.print(" " + i + "\n");
                }
                else{
                    System.out.print(" " + i);
                }
            }
            if(cnt == 120){
                break;
            }
        }
    }
}