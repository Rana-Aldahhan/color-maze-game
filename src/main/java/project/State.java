package project;

import java.util.ArrayList;

public class State implements Comparable{
    //**********class members**********//
    project.Position ballPos;
    project.Batch currentBatch;
    State parentState;
    int cost;
    int estimate;

    //**********class constructor**********//
    public State (project.Position pos, project.Batch cur , State parent){
        if(parent == null)
        {
            this.cost=0;
        }
        this.currentBatch=cur;
        this.estimate=this.currentBatch.unColoredSquaresNumber();
        this.parentState=parent;
        this.ballPos=pos;
        this.currentBatch.batch[ballPos.i][ballPos.j]='o';
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    //**********class methods**********//

    //movement checkers
    public boolean canMoveRight(){
        return this.ballPos.j+1<this.currentBatch.width && this.currentBatch.batch[this.ballPos.i][this.ballPos.j + 1] != '|' ;
    }
    public boolean canMoveLeft(){
        return this.ballPos.j-1>0 && this.currentBatch.batch[this.ballPos.i][this.ballPos.j - 1] != '|' ;
    }
    public boolean canMoveUp(){
        return this.ballPos.i-1>=0 && this.currentBatch.batch[this.ballPos.i - 1][this.ballPos.j] != '|' ;
    }
    public boolean canMoveDown(){
        return this.ballPos.i+1<this.currentBatch.height && this.currentBatch.batch[this.ballPos.i + 1][this.ballPos.j] != '|';
    }
    //movement
    public State moveRight(){ // the i of the ball is increasing
        int newCost=this.cost;
        int newJ=this.ballPos.j;
        //clone the array
        char[][] newArray = new char[currentBatch.height][currentBatch.width];
        for (int i = 0; i < currentBatch.height; i++) {
            for (int j = 0; j <currentBatch.width ; j++) {
                newArray[i][j]=currentBatch.batch[i][j];
            }
        }
        project.Batch newBatch= new project.Batch(currentBatch.width,currentBatch.height,newArray);

        //calculate the new j for the ball
        for (int i = ballPos.j; i <this.currentBatch.width ; i++) {
            if(this.currentBatch.batch[this.ballPos.i][i] == '|' ) {
                newJ = i - 1;
                break;
            }
            else {
                newBatch.batch[this.ballPos.i][i]='*';
                newCost+=1;
            }
        }
        if(newJ == ballPos.j)
            newJ=this.currentBatch.width-1;
        project.Position newPos= new project.Position(this.ballPos.i,newJ);
        //new state
        State newState= new State(newPos,newBatch,this);
        newState.setCost(newCost);
        return newState;
    }
    public State moveLeft(){ // the i of the ball is decreasing
        int newCost=this.cost;
        int newJ=this.ballPos.j;
        //clone the array
        char[][] newArray = new char[currentBatch.height][currentBatch.width];
        for (int i = 0; i < currentBatch.height; i++) {
            for (int j = 0; j <currentBatch.width ; j++) {
                newArray[i][j]=currentBatch.batch[i][j];
            }
        }
        project.Batch newBatch= new project.Batch(currentBatch.width,currentBatch.height,newArray);

        //calculate the new j for the ball
        for (int i = ballPos.j; i >=0 ; i--) {
            if(this.currentBatch.batch[this.ballPos.i][i] == '|' ) {
                newJ = i + 1;
                break;
            }
            else {
                newBatch.batch[this.ballPos.i][i]='*';
                newCost+=1;
            }
        }
        if(newJ == ballPos.j)
            newJ=0;
        project.Position newPos= new project.Position(this.ballPos.i,newJ);
        //new state
        State newState= new State(newPos,newBatch,this);
        newState.setCost(newCost);
        return newState;
    }
    public State moveDown(){ // the i of the ball is increasing
        int newCost=this.cost;
        int newI=this.ballPos.i;
        //clone the array
        char[][] newArray = new char[currentBatch.height][currentBatch.width];
        for (int i = 0; i < currentBatch.height; i++) {
            for (int j = 0; j <currentBatch.width ; j++) {
                newArray[i][j]=currentBatch.batch[i][j];
            }
        }
        project.Batch newBatch= new project.Batch(currentBatch.width,currentBatch.height,newArray);

        //calculate the new j for the ball
        for (int i = ballPos.i; i <this.currentBatch.height; i++) {
            if(this.currentBatch.batch[i][this.ballPos.j] == '|' ) {
                newI = i - 1;
                break;
            }
            else {
                newBatch.batch[i][this.ballPos.j]='*';
                newCost+=1;
            }
        }
        if(newI == ballPos.i)
            newI=this.currentBatch.height-1;
        project.Position newPos= new project.Position(newI,this.ballPos.j);
        //new state
        State newState= new State(newPos,newBatch,this);
        newState.setCost(newCost);
        return newState;
    }
    public State moveUp(){ // the i of the ball is decreasing
        int newCost=this.cost;
        int newI=this.ballPos.i;
        //clone the array
        char[][] newArray = new char[currentBatch.height][currentBatch.width];
        for (int i = 0; i < currentBatch.height; i++) {
            for (int j = 0; j <currentBatch.width ; j++) {
                newArray[i][j]=currentBatch.batch[i][j];
            }
        }
        project.Batch newBatch= new project.Batch(currentBatch.width,currentBatch.height,newArray);

        //calculate the new j for the ball
        for (int i = ballPos.i; i >=0; i--) {
            if(this.currentBatch.batch[i][this.ballPos.j] == '|' ) {
                newI = i + 1;
                break;
            }
            else {
                newBatch.batch[i][this.ballPos.j]='*';
                newCost+=1;
            }
        }
        if(newI == ballPos.i)
            newI=0;
        project.Position newPos= new project.Position(newI,this.ballPos.j);
        //new state
        State newState= new State(newPos,newBatch,this);
        newState.setCost(newCost);
        return newState;
    }
    //winner check
    public boolean isFinal(){
        for (int i = 0; i <this.currentBatch.height ; i++) {
            for (int j = 0; j <this.currentBatch.width ; j++) {
                if(this.currentBatch.batch[i][j]=='-')
                    return false;
            }
        }
        return true;
    }
    //equality check
    public boolean sameState(State otherState){
        for (int i = 0; i <this.currentBatch.height ; i++) {
            for (int j = 0; j <this.currentBatch.width ; j++) {
                if (this.currentBatch.batch[i][j] != otherState.currentBatch.batch[i][j])
                    return false;
                }
            }
        return true;
    }
    //get children states
    public ArrayList<State>  getStateChildren() {
        ArrayList<State>  children= new ArrayList<>();
        if(this.canMoveRight())
            children.add(this.moveRight());
        if(this.canMoveLeft())
            children.add(this.moveLeft());
        if(this.canMoveUp())
            children.add(this.moveUp());
        if(this.canMoveDown())
            children.add(this.moveDown());
        return children;
    }
    //get track states
    public ArrayList<State> getTrackStates(){
        ArrayList<State> trackStates=new ArrayList<>();
        State temp=this;
        while (temp.parentState != null){
            trackStates.add(0,temp);
            temp=temp.parentState;
        }
        return trackStates;
    }

    @Override
    public int compareTo(Object o) {
        int thisValue= this.cost;
        int otherValue= ((State)o).cost ;
        return (Integer.compare(thisValue, otherValue));
    }
}
