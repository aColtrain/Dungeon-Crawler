package view;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Inventory {
    private int width;
    private int height;

    private Group dungeon;

    private Button shop;
    private Label healthPotion;
    private Label attackPotion;
    private Label sword;
    private Label axe;
    private Label shield;
    private Label torch;
    private Label bowAndArrow;
    private int healthPotionNum;
    private int attackPotionNum;
    private int swordNum;
    private int axeNum;
    private int shieldNum;
    private int torchNum;
    private int bowAndArrowNum;
    private Button back;
    private Button selectSword;
    private Button selectAxe;
    private Button selectShield;
    private Button selectTorch;
    private Button selectBowAndArrow;
    private String weapon;


    public Inventory(int width, int height) {
        this.width = width;
        this.height = height;
        shop = new Button("Shop");
        healthPotion = new Label("Health Potion: " + healthPotionNum);
        attackPotion = new Label("Attack Potion: " + attackPotionNum);
        sword = new Label("Swords: " + swordNum);
        axe = new Label("Axes: " + axeNum);
        shield = new Label("Shields: " + shieldNum);
        torch = new Label("Torches: " + torchNum);
        bowAndArrow = new Label("Bow and Arrows: " + bowAndArrowNum);
        back = new Button("Back");
        selectSword = new Button("Select Weapon");
        selectAxe = new Button("Select Weapon");
        selectShield = new Button("Select Weapon");
        selectTorch = new Button("Select Weapon");
        selectBowAndArrow = new Button("Select Weapon");
    }

    public Scene getScene() {
        HBox potions = new HBox(healthPotion, attackPotion);
        potions.setSpacing(20);
        HBox weapons = new HBox(sword, axe, shield, torch, bowAndArrow);
        weapons.setSpacing(52);
        HBox select = new HBox(selectSword, selectAxe,
                selectShield, selectTorch, selectBowAndArrow);
        select.setSpacing(6);
        BorderPane border = new BorderPane();
        VBox root = new VBox(potions, weapons, select);
        border.setTop(root);
        border.setLeft(back);
        BorderPane.setAlignment(back, Pos.CENTER_LEFT);
        border.setCenter(shop);
        BorderPane.setAlignment(shop, Pos.CENTER);
        root.setSpacing(8);

        Scene scene = new Scene(border, width, height);
        return scene;
    }
    public Button getSelectSword() {
        return selectSword;
    }

    public Button getSelectAxe() {
        return selectAxe;
    }

    public Button getSelectShield() {
        return selectShield;
    }

    public Button getSelectTorch() {
        return selectTorch;
    }

    public Button getSelectBowAndArrow() {
        return selectBowAndArrow;
    }
    public Button getBack() {
        return back;
    }
    public Button getShop() {
        return shop;
    }
    public void setHealthPotionNum(int num) {
        healthPotionNum = healthPotionNum + num;
        healthPotion = new Label("Health Potions: " + healthPotionNum);
    }
    public void setAttackPotionNum(int num) {
        attackPotionNum = attackPotionNum + num;
        attackPotion = new Label("Attack Potions: " + attackPotionNum);
    }
    public void setAxeNum(int num) {
        axeNum = axeNum + num;
        axe = new Label("Axes: " + axeNum);
    }
    public void setTorchNum(int num) {
        torchNum = torchNum + num;
        torch = new Label("Torches: " + torchNum);
    }
    public void setShieldNum(int num) {
        shieldNum = shieldNum + num;
        shield = new Label("Shields: " + shieldNum);
    }
    public void setBowAndArrowNum(int num) {
        bowAndArrowNum = bowAndArrowNum + num;
        bowAndArrow = new Label("Bow and Arrows: " + bowAndArrowNum);
    }
    public void setSwordNum(int num) {
        swordNum = swordNum + num;
        sword = new Label("Swords: " + swordNum);

    }
    public int getHealthPotionNum() {
        return healthPotionNum;
    }
    public int getAttackPotionNum() {
        return  attackPotionNum;
    }
    public int getSwordNum() {
        return swordNum;
    }
    public int getAxeNum() {
        return axeNum;
    }
    public int getShieldNum() {
        return shieldNum;
    }
    public int getTorchNum() {
        return torchNum;
    }
    public int getBowAndArrowNum() {
        return bowAndArrowNum;
    }

}