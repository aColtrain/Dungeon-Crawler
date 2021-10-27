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
import javafx.scene.layout.VBox;

public class ExitRoom extends RoomSuperclass {
    private Label roomLabel;
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
    private int bossMonsterHPNum;
    private Node hero;
    private Image heroImage;
    private static final String HERO_IMAGE_LOC =
            "http://icons.iconarchive.com/icons/raindropmemory/legendora/64/Hero-icon.png";
    private Node monster1;
    private Image monster1Image;
    private static final String MONSTER1_IMAGE =
            "https://i.pinimg.com/originals/c5/e0/3a/c5e03a15a08d595e0125b6f0d65908b2.gif";
    private Node monster2;
    private Image monster2Image;
    private static final String MONSTER2_IMAGE =
            "https://i.pinimg.com/originals/e1/ee/7f/e1ee7f0c504f30de0054cd6eed1a2581.gif";
    private Node monster3;
    private Image monster3Image;
    private static final String MONSTER3_IMAGE =
            "https://i.pinimg.com/originals/db/9f/54/db9f5454d9253c360e83a01180a9762e.gif";
    private Node bossMonster;
    private Image bossMonsterImage;
    private static final String BOSS_MONSTER_IMAGE =
            "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/3ea00e79-4daa-4952-b8d5-5509dff65226/d3bbzyg-a4912435-566a-4011-8fd4-3d39d3619a80.gif?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3sicGF0aCI6IlwvZlwvM2VhMDBlNzktNGRhYS00OTUyLWI4ZDUtNTUwOWRmZjY1MjI2XC9kM2JienlnLWE0OTEyNDM1LTU2NmEtNDAxMS04ZmQ0LTNkMzlkMzYxOWE4MC5naWYifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6ZmlsZS5kb3dubG9hZCJdfQ.XfXgRvPJsuy_kmGkSMl4WWkFY6jz8bvW73rFVDh-elo";
    private Label playerHP;
    private Label monster1HP;
    private Label monster2HP;
    private Label monster3HP;
    private Label bossMonsterHP;
    private boolean beenRoom;
    private boolean monster1Defeated;
    private boolean monster2Defeated;
    private boolean monster3Defeated;
    private boolean bossMonsterDefeated;
    private Button healthPotion;
    private Button attackPotion;

    public ExitRoom(int width, int height) {
        super(width, height);
        monster1Defeated = false;
        monster2Defeated = false;
        monster3Defeated = false;
        northExit = new Button("North Exit");
        southExit = new Button("South Exit");
        westExit = new Button("West Exit");
        eastExit = new Button("East Exit");
        roomLabel = new Label("Exit Room");
        heroImage = new Image(HERO_IMAGE_LOC);
        hero = new ImageView(heroImage);
        monster1Image = new Image(MONSTER1_IMAGE);
        monster1 = new ImageView(monster1Image);
        monster1.setScaleX(.5);
        monster1.setScaleY(.5);
        monster2Image = new Image(MONSTER2_IMAGE);
        monster2 = new ImageView(monster2Image);
        monster2.setScaleX(.5);
        monster2.setScaleY(.5);
        monster3Image = new Image(MONSTER3_IMAGE);
        monster3 = new ImageView(monster3Image);
        monster3.setScaleX(.3);
        monster3.setScaleY(.3);
        bossMonsterImage = new Image(BOSS_MONSTER_IMAGE);
        bossMonster = new ImageView(bossMonsterImage);
        bossMonster.setScaleX(1.1);
        bossMonster.setScaleY(1.1);
        healthPotion = new Button("Health Potion");
        attackPotion = new Button("Attack Potion");
    }

    public Scene getScene() {
        if (monster2Defeated && monster3Defeated && bossMonsterDefeated) {
            dungeon = new Group(hero);
        } else if (!monster2Defeated && !monster3Defeated && bossMonsterDefeated) {
            dungeon = new Group(hero, monster2, monster3);
        } else if (monster2Defeated && !monster3Defeated && !bossMonsterDefeated) {
            dungeon = new Group(hero, monster3, bossMonster);
        } else if (!monster2Defeated && monster3Defeated && !bossMonsterDefeated) {
            dungeon = new Group(hero, monster2, bossMonster);
        } else if (!monster2Defeated && monster3Defeated && bossMonsterDefeated) {
            dungeon = new Group(hero, monster2);
        } else if (monster2Defeated && !monster3Defeated && bossMonsterDefeated) {
            dungeon = new Group(hero, monster3);
        } else if (monster2Defeated && monster3Defeated && !bossMonsterDefeated) {
            dungeon = new Group(hero, bossMonster);
        } else {
            dungeon = new Group(hero, monster2, monster3, bossMonster);
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
    public Node getM1() {
        return monster1;
    }
    public Node getM2() {
        return monster2;
    }
    public Node getM3() {
        return monster3;
    }

    public Node getBossMonster() {
        return bossMonster;
    }

    public Button getHealthPotion() {
        return healthPotion;
    }
    public Button getAttackPotion() {
        return attackPotion;
    }

    public boolean monstersDead() {
        return isMonster1Defeated() && isMonster2Defeated() && isMonster3Defeated();
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
    public boolean isBossMonsterDefeated() {
        return bossMonsterDefeated;
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

    public void setBossMonsterDefeated(boolean bossMonsterDefeated) {
        this.bossMonsterDefeated = bossMonsterDefeated;
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

    public void setBossMonsterHPNum(int num) {
        bossMonsterHPNum = num;
        bossMonsterHP = new Label("Boss Monster HP: " + num);
    }

    public void removeMonster(int monster) {
        if (monster == 1) {
            dungeon.getChildren().remove(monster1);
        } else if (monster == 2) {
            dungeon.getChildren().remove(monster2);
        } else if (monster == 3) {
            dungeon.getChildren().remove(monster3);
        } else if (monster == 4) {
            dungeon.getChildren().remove(bossMonster);
        }
    }

    public void addMonster(int monster) {
        if (monster == 1) {
            dungeon.getChildren().add(monster1);
        } else if (monster == 2) {
            dungeon.getChildren().add(monster2);
        } else if (monster == 3) {
            dungeon.getChildren().add(monster3);
        }
    }

    public int hasMonsters() {
        return 7;
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