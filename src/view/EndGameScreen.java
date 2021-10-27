package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EndGameScreen {
    private int width;
    private int height;
    private Label congrats;
    private Label defeated;
    private Button restart;
    private Button quit;
    private long elapsedTime;
    private int totalDamage;
    private int monstersKilled;
    private boolean win;
    private Label timeLabel;
    private Label damageLabel;
    private Label monstersLabel;
    private Label result;

    public EndGameScreen(int width, int height) {
        this.width = width;
        this.height = height;
        congrats = new Label("Congratulations!");
        defeated = new Label("Defeated!");
        restart = new Button("Restart Game");
        quit = new Button("Quit Game");
        //timeLabel = new Label("Time Taken: " + elapsedTime);
        //damageLabel = new Label("Total Damage: " + totalDamage);
        //monstersLabel = new Label("Total Monsters Killed: " + monstersKilled);
    }

    public Scene getScene() {
        VBox stats = new VBox(timeLabel, damageLabel, monstersLabel);
        HBox h = new HBox(restart, quit);
        h.setAlignment(Pos.CENTER);
        h.setSpacing(10);
        VBox root = new VBox(result, stats, h);
        /**
        if (win) {
            VBox win = new VBox(congrats);
            win.setAlignment(Pos.CENTER);
            root.getChildren().addAll(win, stats, h);
        } else {
            VBox lose = new VBox(defeated);
            lose.setAlignment(Pos.CENTER);
            root.getChildren().addAll(lose, stats, h);
        }
         **/
        //result.setAlignment(Pos.CENTER);
        //root.getChildren().addAll(result, stats, h);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        Scene scene = new Scene(root, width, height);
        return scene;
    }

    public void setResult(String s) {
        result = new Label("" + s);
    }

    public void setWin(boolean win) {
        this.win = win;
    }
    public void setElapsedTime(long elapsedTime) {
        timeLabel = new Label("Total Money: " + elapsedTime);
    }
    public void setTotalDamage(int totalDamage) {
        damageLabel = new Label("Total Damage: " + totalDamage);
    }
    public void setMonstersKilled(int monstersKilled) {
        monstersLabel = new Label("Total Monsters Killed: " + monstersKilled);
    }
    public Label getDefeated() {
        return defeated;
    }

    public Button getRestart() {
        return restart;
    }

    public Button getQuit() {
        return quit;
    }
}

