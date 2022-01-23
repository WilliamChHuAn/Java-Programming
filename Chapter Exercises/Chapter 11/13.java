import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //                      7 6 5 2 6 8 4 4 4 2 8 4 5 0 5 0 2 6 0 5
    // The same integers are: 6 5 2 6 8 4 4 4 2 8 4 5 0 5 0 2 6 0 5
    public static void removeDuplicate(ArrayList<Integer> list){

        for(int i = 0; i < list.size();){
            boolean flag = true;
            for(int j = 0; j < list.size(); j++){
                if(list.get(i).equals(list.get(j)) && i != j){
                    flag = false;
                    break;
                }
            }
            if(flag){
                list.remove(i);
            }
            else{
                i++;
            }
        }

        if(list.isEmpty()){
            System.out.print("The same integers are: ");
        }
        else{
            System.out.print("The same integers are:");
        }
        for (Integer integer : list) {
            System.out.print(" " + integer);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        while(input.hasNextInt()){
            list.add(input.nextInt());
        }

        removeDuplicate(list);
    }
}
