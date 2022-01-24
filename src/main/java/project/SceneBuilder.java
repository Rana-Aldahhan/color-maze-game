package project;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class SceneBuilder {
    public State currentState;

    public SceneBuilder(State currentState){
        this.currentState=currentState;
    }

    public ArrayList<Rectangle> buildScene(){
        ArrayList <Rectangle> rects= new ArrayList<>();
        for (int i = 0; i <this.currentState.currentBatch.height ; i++) { // on y axis
            int y = (i+1)*50;
            for (int j = 0; j <this.currentState.currentBatch.width ; j++) { // on x axis
                int x=(j+1)*50;
                Rectangle rect= new Rectangle();
                rect.setX(x);
                rect.setY(y);
                rect.setWidth(50);
                rect.setHeight(50);
                //System.out.println(currentState.currentBatch.batch[i][j]);
                char ch=currentState.currentBatch.batch[i][j];
                switch (ch){
                    case '|' : {rect.setFill(Color.rgb(70, 243, 70)); break;}
                    case '-' : {rect.setFill(Color.rgb(255, 255, 204)); break;}
                    case '*' :
                    case 'o' : {rect.setFill(Color.rgb(194, 214, 214)); break;}
                    default:break;
                }
                rect.setSmooth(true);
                rect.setStyle("-fx-stroke:  #5c8a8a; -fx-stroke-width: 1;");
                rects.add(rect);
            }
        }
        return rects;
    }

}
