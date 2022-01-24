package project;

import java.util.ArrayList;
import java.util.Stack;

public class dfsSolution {
   public State initialState;

    //constructor
    public dfsSolution(State initialState){
        this.initialState=initialState;
    }

    public State startDFS(){
        ArrayList <State> visitedList=new ArrayList<>();
        Stack <State> openedList=new Stack<>();
        openedList.push(this.initialState);
        while (!openedList.empty()){
            State tempState=openedList.pop();
            if(tempState.isFinal()){
                return tempState;
            }
            visitedList.add(tempState);
            ArrayList <State> children=new ArrayList<>();
            children=tempState.getStateChildren();
            for (int i = 0; i <children.size() ; i++) {
                //check if a child is visited :
                boolean visited=false;
                for (int j = 0; j <visitedList.size() ; j++) {
                    if(visitedList.get(j).sameState(children.get(i)))
                        visited=true;
                }
                if (!visited)
                {
                    openedList.push(children.get(i));
                }
            }
        }
        return null;
    }
    public State dfsAll(){
        ArrayList<State> solutions=new ArrayList<>();

        ArrayList <State> visitedList=new ArrayList<>();
        Stack <State> openedList=new Stack<>();
        openedList.push(this.initialState);
        while (!openedList.empty()){
            if (solutions.size()>45)
                break;
            State tempState=openedList.pop();
            if(tempState.isFinal()){
                solutions.add(tempState);
            }
            visitedList.add(tempState);
            ArrayList <State> children=new ArrayList<>();
            children=tempState.getStateChildren();
            for (int i = 0; i <children.size() ; i++) {
                //check if a child is visited :
                boolean visited=false;
                for (int j = 0; j <visitedList.size() ; j++) {
                    if(visitedList.get(j).sameState(children.get(i)))
                        visited=true;
                }
                if (!visited)
                {
                    openedList.push(children.get(i));
                }
            }
        }
        int minCost=Integer.MAX_VALUE;
        State best=null;
        for (int i = 0; i <solutions.size() ; i++) {
            if(solutions.get(i).getTrackStates().size()<minCost)
            {
                minCost=solutions.get(i).getTrackStates().size();
                best=solutions.get(i);
            }
        }
        return best;
    }
}
