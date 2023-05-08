package com.example.pazzleah;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("select_level.fxml"));
        Scene sceneMainMenu = new Scene(fxmlLoader1.load(), 1920, 1080);
        Scene sceneSelectLevel = new Scene(fxmlLoader2.load(), 1920, 1080);
        Pane pane = new Pane();
        pane.setBackground(Background.fill(Color.web("#F2F2AC", 1.0)));
        Scene sceneLvl = new Scene(pane, 1920, 1080);
        /*Scene sceneLvl2 = new Scene(pane, 1920, 1080);
        Scene sceneLvl3 = new Scene(pane, 1920, 1080);
        Scene sceneLvl4 = new Scene(pane, 1920, 1080);
        Scene sceneLvl5 = new Scene(pane, 1920, 1080);*/
        Button btnPlay = (Button) sceneMainMenu.lookup("#play");
        Button btnLvl1 = (Button) sceneSelectLevel.lookup("#lvl1");
        Button btnLvl2 = (Button) sceneSelectLevel.lookup("#lvl2");
        Button btnLvl3 = (Button) sceneSelectLevel.lookup("#lvl3");
        Button btnLvl4 = (Button) sceneSelectLevel.lookup("#lvl4");
        Button btnLvl5 = (Button) sceneSelectLevel.lookup("#lvl5");
        Button btnBackMain = (Button) sceneSelectLevel.lookup("#backMain");
        Button btnExit = (Button) sceneMainMenu.lookup("#exit");
       /* Lock lock1 = new Lock(
                new ArrayList<>(Arrays.asList(0,6 , 3, 2, 11, 6, 7, 8)),
                new ArrayList<>(Arrays.asList(1,0 , 3, 2, 11, 6, 7, 8)),
                sceneLvl, pane, sceneSelectLevel, stage);*/

        btnPlay.setOnMouseClicked(mouseEvent -> {
            stage.setScene(sceneSelectLevel);
        });

        btnLvl1.setOnMouseClicked(mouseEvent -> {
            stage.setScene(sceneLvl);
            Lock lockLvl1 = new Lock(2,0,0, sceneLvl, pane, sceneSelectLevel, stage);

        });
        btnLvl2.setOnMouseClicked(mouseEvent -> {
            stage.setScene(sceneLvl);
        });
        btnLvl3.setOnMouseClicked(mouseEvent -> {
            stage.setScene(sceneLvl);
        });
        btnLvl4.setOnMouseClicked(mouseEvent -> {
            stage.setScene(sceneLvl);
        });

        btnBackMain.setOnMouseClicked(mouseEvent -> {
            stage.setScene(sceneMainMenu);
        });
        btnExit.setOnMouseClicked(mouseEvent -> {
            stage.close();
        });
        stage.setScene(sceneMainMenu);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}