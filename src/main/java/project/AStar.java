package project;

import java.util.*;

public class AStar {
    public State initialState;

    //constructor
    public AStar(State initialState){

        this.initialState=initialState;
    }

    public State startAStar() {
        ArrayList<State> visitedList=new ArrayList<>();
        Queue<State> openedList=new PriorityQueue<>(1, Comparator.comparingInt(a -> ((State) a).cost + ((State) a).estimate));
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
                if (child.isFinal()) {
                    return child;
                }
                //check if a child is visited :
                boolean visited = false;
                for (int j = 0; j < visitedList.size(); j++) {
                    if (visitedList.get(j).sameState(child)) {
                        visited = true;
                        if (child.cost + child.estimate < visitedList.get(j).cost + visitedList.get(j).estimate) {
                            visitedList.remove(j);
                            j--;
                            openedList.add(child);
                        }
                    }
                }
                //check if a child is not in opened list
                boolean opened = false;
                boolean visitedButLowerCost = false;
                for (State temp : openedList) {
                    if (temp.sameState(child)) {
                        opened = true;
                        if (temp.cost + temp.estimate > child.cost + child.estimate) {
                            openedList.remove(temp);
                            visitedButLowerCost = true;
                            break;
                        }
                    }
                }
                if (visitedButLowerCost)//case visited but lower in cost
                    openedList.add(child);
                if (!visited && !opened) {
                    openedList.add(child);
                }

            }
        }
       return null;
    }
}
