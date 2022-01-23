import java.util.Scanner;
//https://liveexample.pearsoncmg.com/dsanimation/MergeSortNeweBook.html
public class Main {

    public static int[] merge(int[] list1, int[] list2){

        int l = 0, r = 0;
        int [] sorted = new int[list1.length + list2.length];

        for(int i = 0; i < sorted.length; i++){
            if(l < list1.length && list1[l] < list2[r]){
                sorted[i] = list1[l++];
            }
            else{
                sorted[i] = list2[r++];
            }
        }

        return sorted;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int [] list1 = new int[n];
        for(int i = 0; i < n; i++){
            list1[i] = input.nextInt();
        }

        n = input.nextInt();
        int [] list2 = new int[n];
        for(int i = 0; i < n; i++){
            list2[i] = input.nextInt();
        }

        int [] sorted = merge(list1, list2);
        System.out.print(sorted[0]);
        for(int i = 1; i < sorted.length; i++){
            System.out.print(" " + sorted[i]);
        }
        System.out.println();
    }
}