import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static class Point implements Comparable<Point>{

        int x, y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if((this.x * this.x) + (this.y * this.y) < (o.x * o.x) + (o.y * o.y)){
                return -1;
            }
            else if((this.x * this.x) + (this.y * this.y) == (o.x * o.x) + (o.y * o.y)){
                if(this.x < o.x){
                    return -1;
                }
                else if(this.x == o.x){
                    if(this.y < o.y){
                        return -1;
                    }
                    else if(this.y == o.y){
                        return 0;
                    }
                    return 1;
                }
                return 1;
            }
            return 1;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean flag = false;

        while(input.hasNextInt()){

            if(flag){
                System.out.println();
            }
            else{
                flag = true;
            }

            int N = input.nextInt();
            Point [] p = new Point[N];

            for(int i = 0; i < N; i++){
                p[i] = new Point(input.nextInt(), input.nextInt());
            }

            Arrays.sort(p);
            int maxNum = p[0].x + p[0].y;
            int maxPoint = 0;

            System.out.println("(" + p[0].x + "," + p[0].y + ")");
            for(int i = 1; i < N; i++){
                System.out.println("(" + p[i].x + "," + p[i].y + ")");
                if(p[i].x + p[i].y >= maxNum){
                    maxNum = p[i].x + p[i].y;
                    maxPoint = i;
                }
            }
            System.out.println("max num: " + maxNum);
            System.out.println("point: " + "(" + p[maxPoint].x + "," + p[maxPoint].y + ")");
        }
    }
}