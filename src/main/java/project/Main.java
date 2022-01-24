package project;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        // batch symbols :
        // | for a block square
        // o for the ball
        // * for colored square
        // - for uncolored square
        /*char [][] batch= {
                {'|','|','|','|','|','|','|','|'},
                {'|','-','-','-','-','-','-','|'},
               {'|' , '-' ,'|','|','|','|', '-','|'},
                {'|' , '-','-','|','|','|','-','|'},
                {'|','|','|','|','|','|','-','|'},
                {'|' , '-' ,'|','|','|','|', '-','|'},
                {'|','-','-','-','-','-','-','|'},
                {'|','|','|','|','|','|','|','|'}
        };

         */
        char [][] batch2= {
                {'|','-','-','-'},
                {'|','-','|','-'},
                {'|','-','-','-'},
                {'|','|','-','-'}
        };
        project.Batch initialBatch = new project.Batch(4,4,batch2);
        State initialState=new State(new Position(0,2),initialBatch,null);
        initialState.currentBatch.printBatch();
        UserGame game= new UserGame(initialState);
        game.startGame();


        /*
        //DFS solution
        dfsSolution solution=new dfsSolution(initialState);
        State solutionState=solution.startDFS();
        ArrayList<State> path= solutionState.getTrackStates();
        for (int i = 0; i <path.size() ; i++) {
            System.out.println("step : " + (i+1));
            path.get(i).currentBatch.printBatch();
            System.out.println();

        }
        System.out.println("the cost of this path is : " + solutionState.cost);
        */
        //BFS solution
        /*
        bfsSolution solution=new bfsSolution(initialState);
        State solutionState=solution.startBFS();
        ArrayList<State> path= solutionState.getTrackStates();
        for (int i = 0; i <path.size() ; i++) {
            System.out.println("BFS step : " + (i+1));
            path.get(i).currentBatch.printBatch();
            System.out.println();

        }
        */
        /*
        //UCS solution
        ucsSolution solution= new ucsSolution(initialState);
        State solutionState=solution.startUCS();
        ArrayList<State> path= solutionState.getTrackStates();
        for (int i = 0; i <path.size() ; i++) {
            System.out.println("UCS step : " + (i+1));
            path.get(i).currentBatch.printBatch();
            System.out.println();

        }
        */
        //Astar solution
        AStar solution= new AStar(initialState);
        State solutionState=solution.startAStar();
        ArrayList<State> path= solutionState.getTrackStates();
        for (int i = 0; i <path.size() ; i++) {
            System.out.println("UCS step : " + (i+1));
            path.get(i).currentBatch.printBatch();
            System.out.println();

        }





    }
}
