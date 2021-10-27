package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DefeatScreen {
    private int width;
    private int height;
    private Label defeated;
    private Label won;
    private Button restart;
    private Button quit;
    private Label stats;

    public DefeatScreen(int width, int height) {
        this.width = width;
        this.height = height;
        won = new Label("Congratulations");
        defeated = new Label("Defeated!");
        restart = new Button("Restart Game");
        quit = new Button("Quit Game");
    }

    public Scene getScene() {
        VBox v = new VBox(defeated);
        HBox h = new HBox(restart, quit);
        v.setAlignment(Pos.CENTER);
        h.setAlignment(Pos.CENTER);
        h.setSpacing(10);
        VBox root = new VBox(v, h);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        Scene scene = new Scene(root, width, height);
        return scene;
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
