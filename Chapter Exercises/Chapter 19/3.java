import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){

        ArrayList<E> newList = new ArrayList<>();

        for(E i : list) {
            if(!newList.contains(i)){
                newList.add(i);
            }
        }

        return newList;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String type = input.next();

        if(type.equals("Integer")){

            ArrayList<Integer> list = new ArrayList<>();

            while(input.hasNext()){
                list.add(input.nextInt());
            }

            list = removeDuplicates(list);

            System.out.print(list.get(0));
            for(int i = 1; i < list.size(); i++){
                System.out.print(" " + list.get(i));
            }
            System.out.println();
        }
        else if(type.equals("Double")){

            ArrayList<Double> list = new ArrayList<>();

            while(input.hasNext()){
                list.add(input.nextDouble());
            }

            list = removeDuplicates(list);

            System.out.printf("%.3f", list.get(0));
            for(int i = 1; i < list.size(); i++){
                System.out.printf(" %.3f", list.get(i));
            }
            System.out.println();
        }
        else if(type.equals("Character")){

            ArrayList<Character> list = new ArrayList<>();

            while(input.hasNext()){
                list.add(input.next().charAt(0));
            }

            list = removeDuplicates(list);

            System.out.print(list.get(0));
            for(int i = 1; i < list.size(); i++){
                System.out.print(" " + list.get(i));
            }
            System.out.println();
        }
        else if(type.equals("String")){

            ArrayList<String> list = new ArrayList<>();

            while(input.hasNext()){
                list.add(input.next());
            }

            list = removeDuplicates(list);

            System.out.print(list.get(0));
            for(int i = 1; i < list.size(); i++){
                System.out.print(" " + list.get(i));
            }
            System.out.println();
        }
    }
}