package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ConfigScreen {
    private int width;
    private int height;
    private TextField playerName;
    private Label name;
    private ComboBox levelDif;
    private ComboBox weapon;
    private Button next;


    public ConfigScreen(int width, int height) {
        //super(width, height);
        this.width = width;
        this.height = height;
        playerName = new TextField();
        name = new Label("Please enter your name.");
        levelDif =  new ComboBox();
        weapon = new ComboBox();
        next = new Button("Next");
    }

    public Scene getScene() {
        playerName.setMaxWidth(70);
        levelDif.getItems().addAll("Easy", "Medium", "Difficult");
        levelDif.setPromptText("Choose level difficulty");
        weapon.getItems().addAll("Axe", "Shield", "Torch");
        weapon.setPromptText("Choose your weapon");
        VBox root = new VBox(name, playerName, levelDif, weapon, next);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        Scene scene = new Scene(root, width, height);
        return scene;
    }

    public TextField getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String name) {
        playerName.setText(name);
    }

    public Label getName() {
        return name;
    }

    public ComboBox getLevelDif() {
        return levelDif;
    }

    public ComboBox getWeapon() {
        return weapon;
    }

    public Button getNext() {
        return next;
    }
}
