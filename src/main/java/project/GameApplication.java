package project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GameApplication extends Application {
    static ArrayList<char [][]> levelBatches=new ArrayList<>();
    static  ArrayList<Position> initialBallPositions=new ArrayList<>();
    char [][] level1= {
            {'|','|','|','|','|','|','|','|'},
            {'|','-','-','-','-','-','-','|'},
            {'|' , '-' ,'|','|','|','|', '-','|'},
            {'|' , '-','-','|','|','|','-','|'},
            {'|','|','|','|','|','|','-','|'},
            {'|' , '-' ,'|','|','|','|', '-','|'},
            {'|','-','-','-','-','-','-','|'},
            {'|','|','|','|','|','|','|','|'}
    };
    char [][] level2={
            {'|','|','|','|','|','|','|','|','|'},
            {'|','-','|','|','|','-','-','-','|'},
            {'|','-','|','|','|','-','|','-','|'},
            {'|','-','-','-','-','-','-','-','|'},
            {'|','-','|','|','|','-','|','|','|'},
            {'|','-','|','|','|','-','-','-','|'},
            {'|','-','|','|','|','|','|','-','|'},
            {'|','|','|','|','|','|','|','|','|'},

    };
    char [][] level3={
            {'|','|','|','|','|','|','|','|','|'},
            {'|','-','-','-','-','-','-','-','|'},
            {'|','-','-','-','|','|','|','-','|'},
            {'|','-','-','-','|','|','|','-','|'},
            {'|','-','-','-','|','|','|','-','|'},
            {'|','|','-','-','|','|','|','-','|'},
            {'|','|','-','-','-','-','-','-','|'},
            {'|','|','|','|','|','|','|','|','|'},

    };
    char [][] level4={
            {'|','|','|','|','|','|','|','|','|','|'},
            {'|','|','-','-','-','-','-','-','-','|'},
            {'|','-','-','-','-','-','-','-','-','|'},
            {'|','-','|','|','|','|','|','|','-','|'},
            {'|','-','-','-','|','|','|','|','-','|'},
            {'|','-','|','-','|','|','|','|','-','|'},
            {'|','-','|','-','-','-','-','-','-','|'},
            {'|','|','-','-','-','-','-','-','|','|'},
            {'|','|','|','|','|','|','|','|','|','|'},
    };
    char [][] level5={
            {'|','|','|','|','|','|','|','|'},
            {'|','-','|','|','-','-','-','|'},
            {'|','-','|','|','-','-','-','|'},
            {'|','-','-','-','-','-','|','|'},
            {'|','|','|','-','-','-','-','|'},
            {'|','-','-','|','-','-','-','|'},
            {'|','-','-','-','-','-','-','|'},
            {'|','|','|','|','|','-','-','|'},
            {'|','-','-','-','-','-','-','|'},
            {'|','-','-','|','-','-','-','|'},
            {'|','|','|','|','|','|','|','|'},
    };
    char [][] level6={
            {'|','|','|','|','|','|','|','|','|','|'},
            {'|','|','-','-','-','-','-','|','|','|'},
            {'|','|','-','-','-','-','-','-','|','|'},
            {'|','|','-','|','-','|','|','-','|','|'},
            {'|','|','-','|','-','|','|','-','|','|'},
            {'|','-','-','|','-','-','-','-','-','|'},
            {'|','-','-','|','-','|','|','-','-','|'},
            {'|','-','-','|','-','|','|','-','-','|'},
            {'|','-','-','-','-','|','|','-','-','|'},
            {'|','|','|','|','|','|','|','|','|','|'},
    };
    char [][] level7={
            {'|','|','|','|','|','|','|','|','|','|'},
            {'|','|','|','|','|','|','|','-','-','|'},
            {'|','-','-','-','|','|','|','-','|','|'},
            {'|','-','-','-','-','-','-','-','|','|'},
            {'|','-','|','|','|','|','|','-','-','|'},
            {'|','-','|','|','|','|','|','-','-','|'},
            {'|','-','|','|','|','|','|','|','-','|'},
            {'|','-','-','-','-','-','|','|','-','|'},
            {'|','-','|','|','-','|','|','|','-','|'},
            {'|','-','|','|','-','-','-','-','-','|'},
            {'|','|','|','|','|','|','|','|','|','|'},
    };
    char [][] level8={
            {'|','|','|','|','|','|','|','|','|','|'},
            {'|','-','-','|','|','-','-','-','-','|'},
            {'|','-','|','|','|','-','|','-','-','|'},
            {'|','-','-','-','-','-','-','-','-','|'},
            {'|','-','|','|','|','-','|','-','|','|'},
            {'|','-','|','|','|','-','-','-','|','|'},
            {'|','-','|','|','|','-','-','-','-','|'},
            {'|','-','-','-','-','-','-','-','-','|'},
            {'|','-','-','-','|','|','-','-','-','|'},
            {'|','|','|','|','|','|','|','|','|','|'},
    };
    char [][] level9={
            {'|','|','|','|','|','|','|','|','|','|'},
            {'|','-','|','|','|','-','-','-','-','|'},
            {'|','-','-','-','-','-','-','|','-','|'},
            {'|','-','-','-','-','-','-','|','-','|'},
            {'|','|','-','-','-','-','-','-','-','|'},
            {'|','-','-','-','-','-','-','-','-','|'},
            {'|','|','|','-','-','-','-','-','-','|'},
            {'|','-','-','-','-','|','|','-','-','|'},
            {'|','-','-','-','-','-','|','-','-','|'},
            {'|','|','|','|','|','|','|','|','|','|'},
    };
    char [][] level10={
            {'|','|','|','|','|','|','|','|','|','|'},
            {'|','|','-','-','-','-','|','-','-','|'},
            {'|','-','-','-','-','-','-','-','-','|'},
            {'|','-','-','|','-','-','|','-','|','|'},
            {'|','-','-','-','-','-','-','-','-','|'},
            {'|','-','-','|','-','-','|','-','-','|'},
            {'|','|','|','-','-','-','-','-','-','|'},
            {'|','|','-','-','-','|','-','-','-','|'},
            {'|','|','-','-','-','-','-','-','|','|'},
            {'|','|','|','|','|','|','|','|','|','|'},
    };
    char [][] level11={
            {'|','|','|','|','|','|','|','|','|','|','|'},
            {'|','-','-','-','|','-','-','-','|','|','|'},
            {'|','-','-','-','-','-','-','|','-','-','|'},
            {'|','-','-','-','-','-','-','-','-','-','|'},
            {'|','-','|','-','-','-','-','-','-','|','|'},
            {'|','-','-','-','-','|','-','-','-','|','|'},
            {'|','|','|','-','-','-','-','-','-','-','|'},
            {'|','|','-','-','-','-','-','-','|','-','|'},
            {'|','-','-','-','-','|','|','-','|','-','|'},
            {'|','-','-','-','-','-','-','-','-','-','|'},
            {'|','|','|','|','|','|','|','|','|','|','|'},
    };
    char [][] level12={
            {'|','|','|','|','|','|','|','|','|','|','|'},
            {'|','-','-','-','-','-','|','-','-','-','|'},
            {'|','|','|','-','-','-','-','-','|','|','|'},
            {'|','-','-','-','-','-','-','-','|','-','|'},
            {'|','-','|','-','|','|','-','-','-','-','|'},
            {'|','-','|','-','|','-','-','-','-','-','|'},
            {'|','-','-','-','-','-','-','-','-','|','|'},
            {'|','-','-','-','-','-','-','-','-','|','|'},
            {'|','-','|','|','-','-','-','-','-','-','|'},
            {'|','-','-','-','-','-','-','-','-','-','|'},
            {'|','|','|','|','|','|','|','|','|','|','|'},
    };
    static int currentLevel=1;
    static int steps=0;
    static int [] bestScores=new int[13];
    public GameApplication()
    {   //first batch and ball pos is null
        levelBatches.add(null);
        initialBallPositions.add(null);
        //add levels with their initial ball positions
        levelBatches.add(level1);
        initialBallPositions.add(new Position(6,1));
        levelBatches.add(level2);
        initialBallPositions.add(new Position(6,7));
        levelBatches.add(level3);
        initialBallPositions.add(new Position(6,2));
        levelBatches.add(level4);
        initialBallPositions.add(new Position(7,7));
        levelBatches.add(level5);
        initialBallPositions.add(new Position(9,1));
        levelBatches.add(level6);
        initialBallPositions.add(new Position(8,1));
        levelBatches.add(level7);
        initialBallPositions.add(new Position(9,1));
        levelBatches.add(level8);
        initialBallPositions.add(new Position(8,8));
        levelBatches.add(level9);
        initialBallPositions.add(new Position(8,5));
        levelBatches.add(level10);
        initialBallPositions.add(new Position(8,7));
        levelBatches.add(level11);
        initialBallPositions.add(new Position(9,9));
        levelBatches.add(level12);
        initialBallPositions.add(new Position(9,9));
        this.initializeBestScores();

    }
    void initializeBestScores(){
        //store the best score by using A* algorithm
        //uncomment this if you want to see how the algorithm finds the best score.
        /*
        for (int i = 1; i <=12 ; i++) {
                char[][] currentBatch = levelBatches.get(i);
                Position initialBallPos = initialBallPositions.get(i);
                project.Batch initialBatch = new project.Batch(currentBatch[0].length, currentBatch.length, currentBatch);
                State initialState = new State(initialBallPos, initialBatch, null);
                bestScores[i] = new AStar(initialState).startAStar().getTrackStates().size();
            System.out.println("best score for level " + i + " : " + bestScores[i]);
        }
         */

        //best score is calculated previously using A* algorithm
        bestScores[1]=7;
        bestScores[2]=8;
        bestScores[3]=9;
        bestScores[4]=12;
        bestScores[5]=24;
        bestScores[6]=15;
        bestScores[7]=16;
        bestScores[8]=19;
        bestScores[9]=21;
        bestScores[10]=21;
        //these two scores were not calculated by A*,it took so much computing time wih no result
        bestScores[11]=46;
        bestScores[12]=51;
    }
    @Override
    public void start(Stage primaryStage){
        this.welcome(primaryStage);
        primaryStage.getIcons().add(new Image("color.PNG"));
        primaryStage.show();
    }
    public void welcome(Stage primaryStage){
        primaryStage.setHeight ( 500);
        primaryStage.setWidth( 525 );
        Text text = new Text();
        text.setText("Color Maze Puzzle");
        text.setY(primaryStage.getHeight()/3);
        text.setX(primaryStage.getWidth()/6);
        text.setFill(Color.GHOSTWHITE);
        text.setFont(new Font("Press Start 2P Regular",20));
        Button startGameButton=new Button("▶ Start Game");
        startGameButton.setFont(new Font("Press Start 2P Regular",13));
        startGameButton.setTextFill(Color.rgb(152,75,177));
        startGameButton.setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));
        startGameButton.setTranslateX(175);
        startGameButton.setTranslateY(250);
        startGameButton.setScaleY(1.5);
        startGameButton.setScaleX(1.5);
        startGameButton.setOnAction(arg0 -> {
            selectLevel(primaryStage);
        });
        Group groupNew= new Group();
        groupNew.getChildren().addAll(text);
        groupNew.getChildren().addAll(startGameButton);
        Scene newScene= new Scene(groupNew,500,525,
                Color.rgb(0, 0, 0));
        primaryStage.setScene(newScene);
    }
    public void selectLevel(Stage primaryStage){
        primaryStage.setHeight ( 500);
        primaryStage.setWidth( 525 );
        //header
        Text text = new Text();
        text.setText("Select Level");
        text.setY(primaryStage.getHeight()/7);
        text.setX(primaryStage.getWidth()/4);
        text.setFill(Color.GHOSTWHITE);
        text.setFont(new Font("Press Start 2P Regular",20));
        Hyperlink link1 = new Hyperlink("go back");
        link1.setOnAction(e -> {
            welcome(primaryStage);
        });
        link1.setFont(new Font("Press Start 2P Regular",10));
        //Grid
        Line leftCol=new Line(166,100,166,450);
        leftCol.setStroke(Color.GHOSTWHITE);
        Line rightCol=new Line(332,100,332,450);
        rightCol.setStroke(Color.GHOSTWHITE);
        Line firstRow=new Line(50,175,450,175);
        firstRow.setStroke(Color.GHOSTWHITE);
        Line secondRow=new Line(50,275,450,275);
        secondRow.setStroke(Color.GHOSTWHITE);
        Line thirdRow=new Line(50,375,450,375);
        thirdRow.setStroke(Color.GHOSTWHITE);
        //levels
        Text level1=new Text(40,150,"Level 1");
        level1.setFont(new Font("Press Start 2P Regular",15));
        level1.setFill(Color.rgb(152,75,177));
        level1.setOnMouseClicked(
                e->{
                    playLevel(primaryStage,1);
                }
        );
        Text level2=new Text(200,150,"Level 2");
        level2.setFont(new Font("Press Start 2P Regular",15));
        if(currentLevel>=2)
            level2.setFill(Color.rgb(152,75,177));
        else level2.setFill(Color.GRAY);
        level2.setOnMouseClicked(
                e->{
                    if(currentLevel>=2)
                        playLevel(primaryStage,2);
                }
        );
        Text level3=new Text(360,150,"Level 3");
        level3.setFont(new Font("Press Start 2P Regular",15));
        if(currentLevel>=3)
            level3.setFill(Color.rgb(152,75,177));
        else level3.setFill(Color.GRAY);
        level3.setOnMouseClicked(
                e->{
                    if(currentLevel>=3)
                        playLevel(primaryStage,3);
                }
        );
        Text level4=new Text(40,230,"Level 4");
        level4.setFont(new Font("Press Start 2P Regular",15));
        if(currentLevel>=4)
            level4.setFill(Color.rgb(152,75,177));
        else level4.setFill(Color.GRAY);
        level4.setOnMouseClicked(
                e->{
                    if(currentLevel>=4)
                        playLevel(primaryStage,4);
                }
        );
        Text level5=new Text(200,230,"Level 5");
        level5.setFont(new Font("Press Start 2P Regular",15));
        if(currentLevel>=5)
            level5.setFill(Color.rgb(152,75,177));
        else level5.setFill(Color.GRAY);
        level5.setOnMouseClicked(
                e->{
                    if(currentLevel>=5)
                        playLevel(primaryStage,5);
                }
        );
        Text level6=new Text(360,230,"Level 6");
        level6.setFont(new Font("Press Start 2P Regular",15));
        if(currentLevel>=6)
            level6.setFill(Color.rgb(152,75,177));
        else level6.setFill(Color.GRAY);
        level6.setOnMouseClicked(
                e->{
                    if(currentLevel>=6)
                        playLevel(primaryStage,6);
                }
        );
        Text level7=new Text(40,330,"Level 7");
        level7.setFont(new Font("Press Start 2P Regular",15));
        if(currentLevel>=7)
            level7.setFill(Color.rgb(152,75,177));
        else level7.setFill(Color.GRAY);
        level7.setOnMouseClicked(
                e->{
                    if(currentLevel>=7)
                         playLevel(primaryStage,7);
                }
        );
        Text level8=new Text(200,330,"Level 8");
        level8.setFont(new Font("Press Start 2P Regular",15));
        if(currentLevel>=8)
            level8.setFill(Color.rgb(152,75,177));
        else level8.setFill(Color.GRAY);
        level8.setOnMouseClicked(
                e->{
                    if(currentLevel>=8)
                        playLevel(primaryStage,8);
                }
        );
        Text level9=new Text(360,330,"Level 9");
        level9.setFont(new Font("Press Start 2P Regular",15));
        if(currentLevel>=9)
            level9.setFill(Color.rgb(152,75,177));
        else level9.setFill(Color.GRAY);
        level9.setOnMouseClicked(
                e->{
                    if(currentLevel>=9)
                         playLevel(primaryStage,9);
                }
        );
        Text level10=new Text(40,410,"Level 10");
        level10.setFont(new Font("Press Start 2P Regular",15));
        if(currentLevel>=10)
            level10.setFill(Color.rgb(152,75,177));
        else level10.setFill(Color.GRAY);
        level10.setOnMouseClicked(
                e->{
                    if(currentLevel>=10)
                         playLevel(primaryStage,10);
                }
        );
        Text level11=new Text(200,410,"Level 11");
        level11.setFont(new Font("Press Start 2P Regular",15));
        if(currentLevel>=11)
            level11.setFill(Color.rgb(152,75,177));
        else level11.setFill(Color.GRAY);
        level11.setOnMouseClicked(
                e->{
                    if(currentLevel>=11)
                     playLevel(primaryStage,11);
                }
        );
        Text level12=new Text(360,410,"Level 12");
        level12.setFont(new Font("Press Start 2P Regular",15));
        if(currentLevel>=12)
            level12.setFill(Color.rgb(152,75,177));
        else level12.setFill(Color.GRAY);
        level12.setOnMouseClicked(
                e->{
                    if(currentLevel>=12)
                        playLevel(primaryStage,12);
                }
        );

        Group groupNew= new Group();
        groupNew.getChildren().addAll(text,leftCol,rightCol,firstRow,secondRow,thirdRow,link1);
        groupNew.getChildren().addAll(level1,level2,level3,level4,level5,level6,
                                        level7,level8,level9,level10,level11,level12);
        Scene newScene= new Scene(groupNew,500,500,
                Color.rgb(0, 0, 0));
        primaryStage.setScene(newScene);
    }
    public void playLevel(Stage primaryStage,int level){
        currentLevel=level;
        steps=0;
        char[][] currentBatch=levelBatches.get(level);
        Position initialBallPos=initialBallPositions.get(level);
        project.Batch initialBatch = new project.Batch(currentBatch[0].length,currentBatch.length,currentBatch);
        State initialState=new State(initialBallPos,initialBatch,null);
        State curArr[] = new State[1];
        curArr[0]=initialState;
        State currentState=curArr[0];
        primaryStage.setTitle("Color Maze");
        primaryStage.setHeight ( (initialBatch.height*50 ) + 100 );
        primaryStage.setWidth( (initialBatch.width*50 ) + 100 );
        Group group = new Group(); //creating Group
        //level header
        Rectangle rect= new Rectangle();
        rect.setX(0);
        rect.setY(0);
        rect.setWidth(primaryStage.getWidth());
        rect.setHeight(primaryStage.getHeight());
        rect.setFill(Color.BLACK);
        Text text = new Text();
        text.setText("Level "+level);
        text.setY(40);
        text.setX(primaryStage.getWidth()/3);
        text.setFill(Color.GHOSTWHITE);
        text.setFont(new Font("Press Start 2P Regular",25));
        group.getChildren().addAll(rect,text);
        //level body
        ArrayList <Rectangle> batchRects=new SceneBuilder(initialState).buildScene();//setting rectangles with colors and positions
        group.getChildren().addAll(batchRects);


        Scene scene = new Scene(group, (initialBatch.height*50 ) + 100,(initialBatch.width*50 ) + 100, Color.WHITESMOKE);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                selectLevel(primaryStage);
            }
            if (e.getCode() == KeyCode.RIGHT) {
                if (curArr[0].canMoveRight())
                {
                    steps++;
                    curArr[0]= curArr[0].moveRight();
                    group.getChildren().addAll(new SceneBuilder(curArr[0]).buildScene());
                    Sphere s = new Sphere();

                    //setting the properties for the sphere object
                    s.setRadius(15);
                    s.setTranslateX(50 + 50*curArr[0].ballPos.j + 25);
                    s.setTranslateY(50 + 50*curArr[0].ballPos.i +25);
                    s.setCullFace(CullFace.BACK);

                    PhongMaterial mat4 = new PhongMaterial();
                    mat4.setDiffuseColor(Color.rgb(152,75,177));

                    s.setMaterial(mat4);
                    group.getChildren().addAll(s);

                    if(curArr[0].isFinal()){
                        win(primaryStage,initialBatch);
                    }
                }
            }
            if (e.getCode() == KeyCode.LEFT) {
                if (curArr[0].canMoveLeft())
                {
                    steps++;
                    curArr[0]= curArr[0].moveLeft();
                    group.getChildren().addAll(new SceneBuilder(curArr[0]).buildScene());
                    Sphere s = new Sphere();

                    //setting the properties for the sphere object
                    s.setRadius(15);
                    s.setTranslateX(50 + 50*curArr[0].ballPos.j + 25);
                    s.setTranslateY(50 + 50*curArr[0].ballPos.i +25);
                    s.setCullFace(CullFace.BACK);

                    PhongMaterial mat4 = new PhongMaterial();
                    mat4.setDiffuseColor(Color.rgb(152,75,177));

                    s.setMaterial(mat4);
                    group.getChildren().addAll(s);
                    if(curArr[0].isFinal()){
                        win(primaryStage,initialBatch);
                    }
                }
            }
            if (e.getCode() == KeyCode.UP) {
                if (curArr[0].canMoveUp())
                {
                    steps++;
                    curArr[0]= curArr[0].moveUp();
                    group.getChildren().addAll(new SceneBuilder(curArr[0]).buildScene());
                    Sphere s = new Sphere();

                    //setting the properties for the sphere object
                    s.setRadius(15);
                    s.setTranslateX(50 + 50*curArr[0].ballPos.j + 25);
                    s.setTranslateY(50 + 50*curArr[0].ballPos.i +25);
                    s.setCullFace(CullFace.BACK);

                    PhongMaterial mat4 = new PhongMaterial();
                    mat4.setDiffuseColor(Color.rgb(152,75,177));

                    s.setMaterial(mat4);
                    group.getChildren().addAll(s);
                    if(curArr[0].isFinal()){
                        win(primaryStage,initialBatch);
                    }
                }
            }
            if (e.getCode() == KeyCode.DOWN) {
                if (curArr[0].canMoveDown())
                {
                    steps++;
                    curArr[0]= curArr[0].moveDown();
                    group.getChildren().addAll(new SceneBuilder(curArr[0]).buildScene());
                    Sphere s = new Sphere();

                    //setting the properties for the sphere object
                    s.setRadius(15);
                    s.setTranslateX(50 + 50*curArr[0].ballPos.j + 25);
                    s.setTranslateY(50 + 50*curArr[0].ballPos.i +25);
                    s.setCullFace(CullFace.BACK);

                    PhongMaterial mat4 = new PhongMaterial();
                    mat4.setDiffuseColor(Color.rgb(152,75,177));

                    s.setMaterial(mat4);
                    group.getChildren().addAll(s);
                    if(curArr[0].isFinal()){
                        win(primaryStage,initialBatch);
                    }
                }
            }
        });

        Sphere s = new Sphere();
        //setting the properties for the sphere object
        s.setRadius(15);
        s.setTranslateX(50 + 50*curArr[0].ballPos.j + 25);
        s.setTranslateY(50 + 50*curArr[0].ballPos.i +25);
        s.setCullFace(CullFace.BACK);
        PhongMaterial mat4 = new PhongMaterial();
        mat4.setDiffuseColor(Color.rgb(152,75,177));
        s.setMaterial(mat4);

        group.getChildren().addAll(s);
        primaryStage.setScene(scene);
    }
    public void win(Stage primaryStage,Batch initialBatch){
        currentLevel++;
        primaryStage.setHeight (500);
        primaryStage.setWidth( 525 );
        Group groupNew= new Group();
        Hyperlink link1 = new Hyperlink("go back");
        link1.setOnAction(e -> {
            selectLevel(primaryStage);
        });
        link1.setFont(new Font("Press Start 2P Regular",10));
        Text text = new Text();
        if(steps<=bestScores[currentLevel-1])
            text.setText("You have completed level "+(currentLevel-1) +"\n\n"+ "with "+steps+" steps"+"\n\n"+"it is the best solution BRAVO!");
        else
            text.setText("You have completed level "+(currentLevel-1) +"\n\n"+ "with "+steps+" steps"+"\n\n"+"it can be done with "+bestScores[currentLevel-1] +" steps only..."
                    +"\n\n"+"try harder!");
        text.setY(primaryStage.getHeight()/4);
        text.setX(primaryStage.getWidth()/12);
        text.setFill(Color.GHOSTWHITE);
        text.setFont(new Font("Press Start 2P Regular",13));
        if(currentLevel<=12) {
            //next level button
            Button nextLevelButton = new Button("▶ next level");
            nextLevelButton.setFont(new Font("Press Start 2P Regular", 13));
            nextLevelButton.setTextFill(Color.rgb(152, 75, 177));
            nextLevelButton.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
            nextLevelButton.setTranslateX(175);
            nextLevelButton.setTranslateY(250);
            nextLevelButton.setScaleY(1.5);
            nextLevelButton.setScaleX(1.5);
            nextLevelButton.setOnAction(arg0 -> {
                playLevel(primaryStage, currentLevel);
            });
            groupNew.getChildren().addAll(nextLevelButton);
        }
        else {
            text.setText(text.getText()+"\n\n\n\n"+
                    "You have completed all the levels "+"\n\n\t\t"+"*_*");
        }
        groupNew.getChildren().addAll(text,link1);
        Scene newScene= new Scene(groupNew,500,525 ,
                Color.rgb(0, 0, 0));
        primaryStage.setScene(newScene);
    }

    public static void main(String[] args) {
        launch();
    }
}