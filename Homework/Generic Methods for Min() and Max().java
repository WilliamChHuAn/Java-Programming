import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static <E extends Comparable<E>> E min(ArrayList<E> list){

        // default Min is list[0]
        E Min = list.get(0);

        // from 1 to end
        for (int i = 1; i < list.size(); i++) {
            // if a.compareTo(b) < 0 means a < b
            if (list.get(i).compareTo(Min) < 0) {
                Min = list.get(i);  // update Min
            }
        }

        return Min;
    }
    public static <E extends Comparable<E>> E max(ArrayList<E> list){

        // default Max is list[0]
        E Max = list.get(0);

        // from 1 to end
        for (int i = 1; i < list.size(); i++) {
            // if a.compareTo(b) > 0 means a > b
            if (list.get(i).compareTo(Max) > 0) {
                Max = list.get(i);  // update Max
            }
        }

        return Max;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String type = input.next(); // control the type of ArrayList

        switch (type) {
            case "Integer": {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    list.add(input.nextInt());  // add element
                }
                System.out.println(min(list));
                System.out.println(max(list));
                break;
            }
            case "Double": {
                ArrayList<Double> list = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    list.add(input.nextDouble());
                }
                System.out.printf("%.3f\n", min(list)); // to 3 decimal places
                System.out.printf("%.3f\n", max(list));
                break;
            }
            case "Character": {
                ArrayList<Character> list = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    list.add(input.next().charAt(0));   // get char by index 0 of string
                }
                System.out.println(min(list));
                System.out.println(max(list));
                break;
            }
            default: {
                ArrayList<String> list = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    list.add(input.next());
                }
                System.out.println(min(list));
                System.out.println(max(list));
                break;
            }
        }
    }
}