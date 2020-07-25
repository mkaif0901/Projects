package com.aasim.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader= new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane = loader.load();
        controller= loader.getController();
        controller.createPlayground();

        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        Pane menuPane= (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().addAll(menuBar);

        Scene scene= new Scene(rootGridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    private MenuBar createMenu() {
        //File menu
        Menu fileMenu = new Menu("File");

        MenuItem newGame = new MenuItem("New Game");
        newGame.setOnAction(event -> controller.resetGame());

        MenuItem resetGame = new MenuItem("Reset Game");
        resetGame.setOnAction(event -> controller.resetGame());

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

        MenuItem exitGame = new MenuItem("Exit game");
        exitGame.setOnAction(event -> exitGame());
        fileMenu.getItems().addAll(newGame, resetGame,separatorMenuItem, exitGame);

        Menu helpMenu= new Menu("Help");
        MenuItem aboutGame= new MenuItem("About Connect4");
        aboutGame.setOnAction(event -> aboutConnect4());

        SeparatorMenuItem separatorMenuItem2 = new SeparatorMenuItem();
        MenuItem aboutMe= new MenuItem("About me");
        aboutMe.setOnAction(event -> aboutMe());

        helpMenu.getItems().addAll(aboutGame,separatorMenuItem2, aboutMe);

        MenuBar menuBar =  new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;
    }

    private void aboutMe() {
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About the Developer");
        alert.setHeaderText("Mohammad Aasim Kaif ");
        alert.setContentText("I hope you'd like this game. Share it with your loved ones. "+
                              "If you have any suggestions please contact me via my Email Id:" +
                              " mkaif0901@gmail.com\n\nTHANK YOU :)");
        alert.show();
    }

    private void aboutConnect4() {
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect4");
        alert.setHeaderText("How to play?");
        alert.setContentText("Connect Four is a two-player connection game in which the players"+
                             " first choose a color and then take turns dropping colored discs from the top into a "+
                             "seven-column, six-row vertically suspended grid. The pieces fall straight down, "+
                             "occupying the next available space within the column. " +
                             "The objective of the game is to be the first to form a horizontal, " +
                             "vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. "+
                             "The first player can always win by playing the right moves.\n\nALL THE BEST! :)");
        alert.show();

    }


    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }


    public static void main(String[] args) {

        launch(args);
    }
}
