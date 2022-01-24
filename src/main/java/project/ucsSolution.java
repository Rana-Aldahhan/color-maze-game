package project;

import java.util.*;

public class ucsSolution {
    public State initialState;

    //constructor
    public ucsSolution(State initialState){
        this.initialState=initialState;
    }

    public State startUCS(){
        ArrayList<State> visitedList=new ArrayList<>();
        Queue<State> openedList=new PriorityQueue<>();
        openedList.add(this.initialState);
        while (!openedList.isEmpty()){
            State tempState=openedList.poll();
            if(tempState.isFinal()){
                return tempState;
            }
            visitedList.add(tempState);
            ArrayList <State> children=new ArrayList<>();
            children=tempState.getStateChildren();
            for (State child : children) {
                //check if a child is visited :
                boolean visited = false;
                for (State state : visitedList) {
                    if (state.sameState(child)) {
                        visited = true;
                    }
                }
                //check if a child is not in opened list
                boolean opened = false;
                for (State temp : openedList) {
                    if (temp.sameState(child)) {
                        opened = true;
                        if (temp.cost > child.cost) {
                            openedList.remove(temp);
                            openedList.add(child);
                            break;
                        }
                    }
                }
                if (!visited && !opened) {
                    openedList.add(child);
                }
            }
        }
        return null;
    }
}
