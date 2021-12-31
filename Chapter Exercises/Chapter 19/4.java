import java.util.Scanner;

public class Main {

    public static <E extends Comparable<E>> int linearSearch(E[] list, E key){

        for(int i = 0; i < list.length; i++){
            if(list[0].compareTo(key) == 0){
                return i + 1;
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

            Integer key = input.nextInt();
            int index = linearSearch(list, key);

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

            Double key = input.nextDouble();
            int index = linearSearch(list, key);

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

            char key = input.next().charAt(0);
            int index = linearSearch(list, key);

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

            String key = input.next();
            int index = linearSearch(list, key);

            if(index == -1){
                System.out.println("Not found");
            }
            else{
                System.out.println(key + " is found in the " + index + "'th place.");
            }
        }
    }
}