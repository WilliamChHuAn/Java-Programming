import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static <E extends Comparable<E>> int binarySearch(E[] list, E key){

        int l = 0;
        int r = list.length - 1;

        while(l <= r) {
            int m = (l + r) >> 1;
            if (list[m].compareTo(key) == 0) {
                return m + 1;
            }
            else if(list[m].compareTo(key) < 0){
                r = m - 1;
            }
            else{
                l = m + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String type = input.next();

        if(type.equals("Integer")){

            int N = input.nextInt();
            Integer[] list = new Integer[N];

            for(int i = 0; i < N; i++){
                list[i] = input.nextInt();
            }

            Arrays.sort(list);
            Integer key = input.nextInt();
            int index = binarySearch(list, key);

            if(index == -1){
                System.out.println("Not found");
            }
            else{
                System.out.println(key + " is found in the " + index + "'th place.");
            }
        }
        else if(type.equals("Double")){

            int N = input.nextInt();
            Double[] list = new Double[N];

            for(int i = 0; i < N; i++){
                list[i] = input.nextDouble();
            }

            Arrays.sort(list);
            Double key = input.nextDouble();
            int index = binarySearch(list, key);

            if(index == -1){
                System.out.println("Not found");
            }
            else{
                System.out.printf("%.3f is found in the %d'th place.\n", key, index);
            }
        }
        else if(type.equals("Character")){

            int N = input.nextInt();
            Character[] list = new Character[N];

            for(int i = 0; i < N; i++){
                list[i] = input.next().charAt(0);
            }

            Arrays.sort(list);
            char key = input.next().charAt(0);
            int index = binarySearch(list, key);

            if(index == -1){
                System.out.println("Not found");
            }
            else{
                System.out.println(key + " is found in the " + index + "'th place.");
            }
        }
        else if(type.equals("String")){

            int N = input.nextInt();
            String[] list = new String[N];

            for(int i = 0; i < N; i++){
                list[i] = input.next();
            }

            Arrays.sort(list);
            String key = input.next();
            int index = binarySearch(list, key);

            if(index == -1){
                System.out.println("Not found");
            }
            else{
                System.out.println(key + " is found in the " + index + "'th place.");
            }
        }
    }
}