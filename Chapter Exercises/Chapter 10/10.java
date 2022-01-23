public class Main {

    public static class Queue{

        private int [] elements;
        private int size;

        public Queue(){
            this.elements = new int[8];
            this.size = 0;
        }
        public void enqueue(int v){
            if(this.size == elements.length){
                int [] temp = this.elements;
                this.elements = new int[this.size * 2];
                for(int i = 0; i < size; i++){
                    this.elements[i] = temp[i];
                }
            }
            this.elements[this.size] = v;
            this.size++;
        }
        public int dequeue(){
            int ans = this.elements[0];
            this.size--;
            for(int i = 0; i < size; i++){
                this.elements[i] = this.elements[i + 1];
            }
            return ans;
        }
        public boolean empty(){
            return size == 0;
        }
        public int getSize(){
            return this.size;
        }
    }

    public static void main(String[] args) {

        Queue q = new Queue();

        for(int i = 1; i <= 20; i++){
            q.enqueue(i);
        }

        System.out.print(0);
        while(!q.empty()){
            System.out.print(" " + q.dequeue());
        }
        System.out.println();
    }
}