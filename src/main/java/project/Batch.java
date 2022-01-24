package project;

public class Batch {
    public int width;
    public int height;
    public char[][] batch;
    //public Position ballPos;

    //constructor
    public Batch(int w , int h,  char [][] b){
        this.height=h;
        this.width=w;
        this.batch=b;
    }
    public int unColoredSquaresNumber(){
        int number=0;
        for (int i = 0; i <this.height ; i++) {
            for (int j = 0; j <this.width ; j++) {
                if(batch[i][j]=='-')
                    number++;
            }
        }
        return number;
    }

    public void  printBatch(){
        for (int i = 0; i <this.height ; i++) {
            for (int j = 0; j <this.width ; j++) {
                System.out.print(this.batch[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
