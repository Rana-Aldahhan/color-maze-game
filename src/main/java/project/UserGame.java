package project;

import java.util.ArrayList;
import java.util.Scanner;

public class UserGame {
    public project.State initialState;
    public project.State currentSate;
    ArrayList <project.State> states = new ArrayList<>();

    public UserGame (project.State init){
        this.initialState=init;
        this.currentSate=init;
        states.add(initialState);
    }

    public ArrayList<project.State> startGame(){
        Scanner scan= new Scanner(System.in);
        while(! currentSate.isFinal()){
            System.out.println("what direction you want to move ? a for left , d for right /n" +
                    "w for up , s for down");
            char input=scan.next().charAt(0);
            switch (input){
                case 'a' : {
                    if(currentSate.canMoveLeft())
                    {
                        currentSate = currentSate.moveLeft();
                        currentSate.currentBatch.printBatch();
                        states.add(currentSate);
                    }
                    break;
                }
                case 'd' : {
                    if(currentSate.canMoveRight())
                    {
                        currentSate = currentSate.moveRight();
                        currentSate.currentBatch.printBatch();
                        states.add(currentSate);
                    }
                    break;
                }
                case 'w' : {
                    if(currentSate.canMoveUp())
                    {
                        currentSate = currentSate.moveUp();
                        currentSate.currentBatch.printBatch();
                        states.add(currentSate);
                    }
                    break;
                }
                case 's' : {
                    if(currentSate.canMoveDown())
                    {
                        currentSate = currentSate.moveDown();
                        currentSate.currentBatch.printBatch();
                        states.add(currentSate);
                    }
                    break;
                }
                default:break;
            }
        }
        if (currentSate.isFinal()){
            System.out.println("you have completed the level! do you want to print all the steps you have done?" +
                    " y for yes , n for no");
            char input=scan.next().charAt(0);
            if (input == 'y') {
                /*System.out.println("Total steps : " + this.states.size());
                for (int i = 0; i < this.states.size(); i++) {
                    System.out.println("step :" + (i + 1));
                    this.states.get(i).currentBatch.printBatch();
                    }*/
                ArrayList<State> track=this.currentSate.getTrackStates();
                System.out.println("Total steps : " + track.size());
                for (int i = 0; i < track.size(); i++) {
                    System.out.println("step :" + (i + 1));
                    track.get(i).currentBatch.printBatch();
                }
                return track;
            }
        }
        return this.states;
    }

}
