package project;

import java.util.*;

public class bfsSolution {
    public State initialState;

    //constructor
    public bfsSolution(State initialState){
        this.initialState=initialState;
    }

    public State startBFS(){
        ArrayList<State> visitedList=new ArrayList<>();
        Queue<State> openedList=new LinkedList<>();
        openedList.add(this.initialState);
        while (!openedList.isEmpty()){
            State tempState=openedList.remove();
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

                //check if a child is not in opened list
                boolean opened=false;
                Iterator <State> it=openedList.iterator();
                while (it.hasNext()){
                    if(it.next().sameState(children.get(i)))
                        opened=true;
                }

                if (!visited && !opened)
                {
                    openedList.add(children.get(i));
                }

            }
        }
        return null;
    }
}
