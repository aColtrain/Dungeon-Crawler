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

public class ActualChallengeRoom2 extends RoomSuperclass {
    private Button northExit;
    private Button southExit;
    private Button westExit;
    private Button eastExit;
    private Label roomLabel;
    private RoomSuperclass northRoom;
    private RoomSuperclass southRoom;
    private RoomSuperclass westRoom;
    private RoomSuperclass eastRoom;
    private Group dungeon;
    private boolean monsterDefeated;
    private int playerHPNum;
    private int cm1HPNum;
    private int cm2HPNum;
    private int cm3HPNum;
    private Node hero;
    private Image heroImage;
    private static final String HERO_IMAGE_LOC =
            "http://icons.iconarchive.com/icons/raindropmemory/legendora/64/Hero-icon.png";
    private Node cm1;
    private Image cm1Image;
    private static final String CM1_IMAGE = //little green snake guy
            "https://camo.envatousercontent.com/d3b67095b452042609e91dc8bac4373d33ef0869/687474703a2f2f692e696d6775722e636f6d2f424f34343469782e676966";
    private Node cm2;
    private Image cm2Image;
    private static final String CM2_IMAGE = //big green knife guy
            "https://i.pinimg.com/originals/ed/9b/02/ed9b028e89e25f2c7dcc3854a53c4692.gif";
    private Node cm3;
    private Image cm3Image;
    private static final String CM3_IMAGE = //purple sorcerer guy
            "http://www.astronomicgames.com/images/assets/GIF%20Magus%20Attack%20Combo.gif";
    private Label playerHP;
    private Label cm1HP;
    private Label cm22HP;
    private Label cm33HP;
    private boolean beenRoom;
    private boolean cm1Defeated;
    private boolean cm2Defeated;
    private boolean cm3Defeated;
    private Button healthPotion;
    private Button attackPotion;
    private boolean weaponCollected;
    private VBox weaponBox;
    private Button challenge;
    private boolean selectChallenge;

    public ActualChallengeRoom2(int width, int height) {
        super(width, height);
        cm1Defeated = false;
        cm2Defeated = false;
        cm3Defeated = false;
        northExit = new Button("North Exit");
        southExit =  new Button("South Exit");
        westExit = new Button("West Exit");
        eastExit = new Button("East Exit");
        roomLabel = new Label("Room 7");
        heroImage = new Image(HERO_IMAGE_LOC);
        hero = new ImageView(heroImage);
        cm1Image = new Image(CM1_IMAGE);
        cm1 = new ImageView(cm1Image);
        cm1.setScaleX(1);
        cm1.setScaleY(1);
        cm2Image = new Image(CM2_IMAGE);
        cm2 = new ImageView(cm2Image);
        cm2.setScaleX(.5);
        cm2.setScaleY(.5);
        cm3Image = new Image(CM3_IMAGE);
        cm3 = new ImageView(cm3Image);
        cm3.setScaleX(1);
        cm3.setScaleY(1);
        healthPotion = new Button("Health Potion");
        attackPotion = new Button("Attack Potion");
        challenge = new Button("Play Challenge Room");
    }

    @Override
    public void setMonster1Defeated(boolean monster1Defeated) {

    }

    @Override
    public void setMonster2Defeated(boolean monster2Defeated) {

    }

    @Override
    public void setMonster3Defeated(boolean monster3Defeated) {

    }

    @Override
    public boolean isMonster1Defeated() {
        return false;
    }

    @Override
    public boolean isMonster2Defeated() {
        return false;
    }

    @Override
    public boolean isMonster3Defeated() {
        return false;
    }

    public Scene getScene() {
        if (cm1Defeated && cm2Defeated && cm3Defeated) {
            dungeon = new Group(hero);
        } else if (!cm1Defeated && !cm2Defeated && cm3Defeated) {
            dungeon = new Group(hero, cm1, cm2);
        }else if (cm1Defeated && !cm2Defeated && !cm3Defeated) {
            dungeon = new Group(hero, cm2, cm3);
        } else if (!cm1Defeated && cm2Defeated && !cm3Defeated) {
            dungeon = new Group(hero, cm1, cm3);
        } else if (cm1Defeated && !cm2Defeated && cm3Defeated) {
            dungeon = new Group(hero, cm2);
        } else if (!cm1Defeated && cm2Defeated && cm3Defeated) {
            dungeon = new Group(hero, cm1);
        } else if (cm1Defeated && cm2Defeated && !cm3Defeated) {
            dungeon = new Group(hero, cm3);
        } else if (!cm1Defeated && !cm2Defeated && !cm3Defeated) {
            dungeon = new Group(hero, cm1, cm2, cm3);
        }
        VBox vbox = new VBox(healthPotion, attackPotion, westExit);
        vbox.setSpacing(20);
        BorderPane border = new BorderPane();
        border.setTop(northExit);
        border.setBottom(southExit);
        border.setLeft(vbox);
        border.setRight(eastExit);
        border.setCenter(dungeon);
        BorderPane.setAlignment(northExit, Pos.TOP_CENTER);
        BorderPane.setAlignment(southExit, Pos.BOTTOM_CENTER);
        BorderPane.setAlignment(vbox, Pos.CENTER_LEFT);
        BorderPane.setAlignment(eastExit, Pos.CENTER_RIGHT);
        Scene scene = new Scene(border, super.getWidth(), super.getHeight());
        return scene;
    }
    public Node getM7() {
        return cm1;
    }
    public Node getM8() {
        return cm2;
    }
    public Node getM9() {
        return cm3;
    }
    public Button getChallenge() {
        return challenge;
    }
    public void setSelectChallenge(boolean selectChallenge) {
        this.selectChallenge = selectChallenge;
    }
    public Node getCm1() {
        return cm1;
    }
    public Node getCm2() {
        return cm2;
    }
    public Node getCm3() {
        return cm3;
    }
    public Button getHealthPotion() {
        return healthPotion;
    }
    public Button getAttackPotion() {
        return attackPotion;
    }

    @Override
    public Node getM1() {
        return null;
    }

    @Override
    public Node getM2() {
        return null;
    }

    @Override
    public Node getM3() {
        return null;
    }

    public boolean monstersDead() {
        return isCm1Defeated() && isCm2Defeated() && isCm3Defeated();
    }
    public boolean isCm1Defeated() {
        return cm1Defeated;
    }
    public boolean isCm2Defeated() {
        return cm2Defeated;
    }
    public boolean isCm3Defeated() {
        return cm3Defeated;
    }
    public void setCm1Defeated(boolean cm1Defeated) {
        this.cm1Defeated = cm1Defeated;
    }
    public void setCm2Defeated(boolean cm2Defeated) {
        this.cm2Defeated = cm2Defeated;
    }
    public void setCm3Defeated(boolean cm3Defeated) {
        this.cm3Defeated = cm3Defeated;
    }
    public void setBeenRoom(boolean beenRoom) {
        this.beenRoom = beenRoom;
    }
    public boolean getBeenRoom() {
        return beenRoom;
    }
    public void setPlayerHPNum(int num) {
        playerHPNum = num;
        playerHP = new Label("Player HP: " + num);
    }

    @Override
    public void setMonster1HPNum(int monster1HP) {

    }

    public void setCm1HPNum(int num) {
        cm1HPNum = num;
        cm1HP = new Label("Challenge Monster 4 HP: " + num);
    }
    public void setCm2HPNum(int num) {
        cm2HPNum = num;
        cm22HP = new Label("Challenge Monster 5 HP: " + num);
    }
    public void setCm3HPNum(int num) {
        cm3HPNum = num;
        cm33HP = new Label("Challenge Monster 6 HP: " + num);
    }
    public void setMonster2HPNum(int num) {
        cm2HPNum = num;
        cm22HP = new Label("Challenge Monster 2 HP: " + num);
    }
    public void setMonster3HPNum(int num) {
        cm3HPNum = num;
        cm33HP = new Label("Challenge Monster 3 HP: " + num);
    }
    public void removeMonster(int cm) {
        if (cm == 7) {
            dungeon.getChildren().remove(cm1);
        } else if (cm == 8) {
            dungeon.getChildren().remove(cm2);
        } else if (cm == 9) {
            dungeon.getChildren().remove(cm3);
        }
    }
    public void addMonster() {
        int x = 0;
    }
    public int hasMonsters() {
        return 9;
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
}
