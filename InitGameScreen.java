package view;


import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;


import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class InitGameScreen extends RoomSuperclass {
    private String levelDif;
    private Text moneyLabel;
    private int money;
    private Button northExit;
    private Button southExit;
    private Button westExit;
    private Button eastExit;
    private RoomSuperclass northRoom;
    private RoomSuperclass southRoom;
    private RoomSuperclass westRoom;
    private RoomSuperclass eastRoom;
    private Group dungeon;
    private int playerHPNum;
    private int monster1HPNum;
    private int monster2HPNum;
    private int monster3HPNum;

    private Node hero;
    private Image heroImage;
    private static final String HERO_IMAGE_LOC =
            "http://icons.iconarchive.com/icons/raindropmemory/legendora/64/Hero-icon.png";
    private Label playerHP;
    private Label monster1HP;
    private Label monster2HP;
    private Label monster3HP;
    private boolean beenRoom;
    private boolean monster1Defeated;
    private boolean monster2Defeated;
    private boolean monster3Defeated;
    private Button healthPotion;

    public InitGameScreen(int width, int height) {
        super(width, height);
        moneyLabel = new Text();

        northExit = new Button("North Exit");
        southExit =  new Button("South Exit");
        westExit = new Button("West Exit");
        eastExit = new Button("East Exit");
        healthPotion = new Button("Health Potion");

        heroImage = new Image(HERO_IMAGE_LOC);
        hero = new ImageView(heroImage);
    }

    public void setMoney(int money) {
        this.money = money;
        moneyLabel = new Text("Money: $" + money);
    }

    public Scene getScene() {
        VBox leftBox = new VBox(moneyLabel, westExit);
        leftBox.setSpacing(198);
        VBox hpBox = new VBox(playerHP, monster1HP, monster2HP, monster3HP);
        hpBox.setSpacing(2);
        HBox topBox = new HBox(hpBox, northExit);
        topBox.setSpacing(30);
        dungeon = new Group(hero);
        BorderPane border = new BorderPane();
        border.setTop(northExit);
        border.setBottom(southExit);
        border.setLeft(leftBox);
        border.setRight(eastExit);
        border.setCenter(dungeon);
        BorderPane.setAlignment(northExit, Pos.TOP_CENTER);
        BorderPane.setAlignment(southExit, Pos.BOTTOM_CENTER);
        BorderPane.setAlignment(leftBox, Pos.CENTER_LEFT);
        BorderPane.setAlignment(eastExit, Pos.CENTER_RIGHT);
        Scene scene = new Scene(border, super.getWidth(), super.getHeight());
        return scene;
    }
    public Node getM1() {
        return null;
    }
    public Node getM2() {
        return null;
    }
    public Node getM3() {
        return null;
    }
    public Button getAttackPotion() {
        Button attackPotion = null;
        return attackPotion;
    }
    public Button getHealthPotion() {
        return healthPotion;
    }
    public boolean isMonster1Defeated() {
        return monster1Defeated;
    }
    public boolean isMonster2Defeated() {
        return monster2Defeated;
    }
    public boolean isMonster3Defeated() {
        return monster3Defeated;
    }
    public void setMonster1Defeated(boolean monster1Defeated) {
        this.monster1Defeated = monster1Defeated;
    }
    public void setMonster2Defeated(boolean monster2Defeated) {
        this.monster2Defeated = monster2Defeated;
    }
    public void setMonster3Defeated(boolean monster3Defeated) {
        this.monster3Defeated = monster3Defeated;
    }
    public void setPlayerHPNum(int num) {
        playerHPNum = num;
        playerHP = new Label("Player HP: " + num);
    }
    public void setMonster1HPNum(int num) {
        monster1HPNum = num;
        monster1HP = new Label("Monster 1 HP: " + num);
    }
    public void setMonster2HPNum(int num) {
        monster2HPNum = num;
        monster2HP = new Label("Monster 2 HP: " + num);
    }
    public void setMonster3HPNum(int num) {
        monster3HPNum = num;
        monster3HP = new Label("Monster 3 HP: " + num);
    }
    public void removeMonster(int monster) {
        int x = 0;
    }
    public int hasMonsters() {
        return 0;
    }
    public void setLevelDif(String levelDif) {
        this.levelDif = levelDif;
    }
    public Button getNorthExit() {
        return northExit;
    }
    public Button getSouthExit() {
        return southExit;
    }
    public Button getWestExit() {
        return westExit;
    }
    public Button getEastExit() {
        return eastExit;
    }
    public RoomSuperclass getNorthRoom() {
        return northRoom;
    }
    public RoomSuperclass getSouthRoom() {
        return southRoom;
    }
    public RoomSuperclass getWestRoom() {
        return westRoom;
    }
    public RoomSuperclass getEastRoom() {
        return eastRoom;
    }
    public void setNorthRoom(RoomSuperclass northRoom) {
        this.northRoom = northRoom;
    }
    public void setSouthRoom(RoomSuperclass southRoom) {
        this.southRoom = southRoom;
    }
    public void setWestRoom(RoomSuperclass westRoom) {
        this.westRoom = westRoom;
    }
    public void setEastRoom(RoomSuperclass eastRoom) {
        this.eastRoom = eastRoom;
    }
    public boolean getBeenRoom() {
        return beenRoom;
    }

}