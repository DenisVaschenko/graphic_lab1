package com.example;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        scene = new Scene(root, 1280, 720);
        
        List<Node> nodes = new ArrayList<>();
        Rectangle backGround = new Rectangle(0,0,1280,720);
        nodes.add(backGround);
        backGround.setFill(Color.LIMEGREEN);
        Rectangle body = new Rectangle(240,120,800,480);
        body.setFill(Color.ORANGE);
        nodes.add(body);
        Rectangle display = new Rectangle(280,160,600,400);
        display.setFill(Color.GREY);
        display.setArcHeight(40);
        display.setArcWidth(40);
        nodes.add(display);
        Line antennaLeft = new Line(560,40,640,120);
        Line antennaRight = new Line(720, 40, 640,120);
        nodes.add(antennaLeft); nodes.add(antennaRight);
        for (int i = 360; i <= 540; i+=80){
            nodes.add( new Circle(965,i,15));
        }
        root.getChildren().addAll(nodes);
        stage.setTitle("TV");
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}