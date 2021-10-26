//commit, ctl shift k to push

package controller;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.rules.Stopwatch;
import view.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javafx.stage.Popup;

public class Controller extends Application {
    private Stage mainWindow;
    private final int width = 500;
    private final int height = 500;
    private TextField playerName;
    private String playerNameString;
    private List<Integer> list;
    private RoomSuperclass randRoom;
    private InitGameScreen room1;
    private Room2 room2;
    private Room3 room3;
    private Room4 room4;
    private Room5 room5;
    private Room6 room6;
    private Room7 room7;
    private ExitRoom room8;
    private ChallengeRoom1 challengeRoom1;
    private ChallengeRoom2 challengeRoom2;
    private ActualChallengeRoom1 actualChallengeRoom1;
    private ActualChallengeRoom2 actualChallengeRoom2;
    private EndGameScreen endGameRoom;
    private int count;
    private int rndNum;
    private int playerHP;
    private int monster1HP;
    private int monster2HP;
    private int monster3HP;
    private int cm1HP;
    private int cm2HP;
    private int cm3HP;
    private int cm4HP;
    private int cm5HP;
    private int cm6HP;
    private int bossMonsterHP;
    private boolean monsterDefeated;
    private Popup winChallenge;
    private Button winChallengeButton;
    private Popup labels;
    private Popup shopMoney;
    private Popup toInventory;
    private Popup test;
    private Popup boss;
    private Popup challengePopup;
    private Popup challenge1Labels;
    private Popup challenge2Labels;
    private Label shopMoneyLabel;
    private Label weaponSelectedLabel;
    private Label playerLabel1;
    private Label playerLabel2;
    private Label playerLabel3;
    private Label monster1Label;
    private Label monster2Label;
    private Label monster3Label;
    private Label cm1Label;
    private Label cm2Label;
    private Label cm3Label;
    private Label cm4Label;
    private Label cm5Label;
    private Label cm6Label;
    private Label bossMonsterLabel;
    private boolean beenRoom2;
    private boolean beenRoom3;
    private boolean beenRoom4;
    private boolean beenRoom5;
    private boolean beenRoom6;
    private boolean beenRoom7;
    private boolean beenRoom8;
    private boolean beenCR1;
    private boolean beenCR2;
    private boolean beenACR1;
    private boolean beenACR2;
    private Inventory inventoryScreen;
    private Shop shopScreen;
    private Button toShop;
    private RoomSuperclass lastRoom;
    private int money;
    private String weaponSelected;
    private boolean attackSelected;
    private Label selectedLabel;
    private Popup selectedWeapon;
    private int totalMoney;
    private int totalDamage;
    private int monstersKilled;
    private boolean selectChallenge;
    private Button challengeButton;
    private Label testLabel;
    private ConfigScreen configScreen;
    private int count1;
    private int count2;


    @Override
    public void start(Stage primaryStage) throws Exception {
        //testLabel = new Label();
        configScreen = new ConfigScreen(width, height);
        selectChallenge = false;
        totalDamage = 0;
        monstersKilled = 0;
        winChallenge = new Popup();
        winChallengeButton = new Button("Challenge Won! Collect $60");
        labels = new Popup();
        challenge1Labels = new Popup();
        challenge2Labels = new Popup();
        toInventory = new Popup();
        test = new Popup();
        testLabel = new Label();
        test.setX(500);
        test.setY(100);
        shopMoney = new Popup();
        selectedWeapon = new Popup();
        boss = new Popup();
        challengePopup = new Popup();
        boss.setX(775);
        boss.setY(178);
        shopMoney.setX(810);
        shopMoney.setY(80);
        selectedWeapon.setX(392);
        selectedWeapon.setY(160);
        Button inventoryButton = new Button("Inventory");
        challengeButton = new Button("Play Challenge Room");
        challengePopup.getContent().add(challengeButton);
        challengePopup.setX(400);
        challengePopup.setY(80);
        toInventory.getContent().add(inventoryButton);
        inventoryButton.setOnAction(e -> goToInventory());
        test.getContent().add(testLabel);
        playerHP = 100;
        monster1HP = 100;
        monster2HP = 100;
        monster3HP = 100;
        cm1HP = 100;
        cm2HP = 100;
        cm3HP = 100;
        cm4HP = 100;
        cm5HP = 100;
        cm6HP = 100;
        bossMonsterHP = 100;
        mainWindow = primaryStage;
        mainWindow.setTitle("Dungeon Crawler");
        playerName = new TextField();
        list = new ArrayList<>(); //2,3,4,5,6,7,8,9
        for (int i = 0; i < 8; i++) {
            list.add(i + 2);
        }
        inventoryScreen = new Inventory(width, height);
        shopScreen = new Shop(width, height);
        room1 = new InitGameScreen(width, height);
        room2 = new Room2(width, height);
        room3 = new Room3(width, height);
        room4 = new Room4(width, height);
        room5 = new Room5(width, height);
        room6 = new Room6(width, height);
        room7 = new Room7(width, height);
        room8 = new ExitRoom(width, height);
        challengeRoom1 = new ChallengeRoom1(width, height);
        challengeRoom2 = new ChallengeRoom2(width, height);
        actualChallengeRoom1 = new ActualChallengeRoom1(width, height);
        actualChallengeRoom2 = new ActualChallengeRoom2(width, height);
        endGameRoom = new EndGameScreen(width, height);
        playerLabel1 = new Label("Player HP: " + playerHP);
        playerLabel2 = new Label("Player HP: " + playerHP);
        playerLabel3 = new Label("Player HP: " + playerHP);
        monster1Label = new Label("Monster 1 HP: " + monster1HP);
        monster2Label = new Label("Monster 2 HP: " + monster2HP);
        monster3Label = new Label("Monster 3 HP: " + monster3HP);
        cm1Label = new Label("Challenge Monster 1 HP: " + cm1HP);
        cm2Label = new Label("Challenge Monster 2 HP: " + cm2HP);
        cm3Label = new Label("Challenge Monster 3 HP: " + cm3HP);
        cm4Label = new Label("Challenge Monster 4 HP: " + cm4HP);
        cm5Label = new Label("Challenge Monster 5 HP: " + cm5HP);
        cm6Label = new Label("Challenge Monster 6 HP: " + cm6HP);
        bossMonsterLabel = new Label("Boss Monster HP: " + bossMonsterHP);
        boss.getContent().add(bossMonsterLabel);
        toShop = inventoryScreen.getShop();
        attackSelected = false;
        challengeRoom1.setNorthRoom(null);
        challengeRoom1.setSouthRoom(null);
        challengeRoom1.setWestRoom(null);
        challengeRoom1.setEastRoom(null);
        challengeRoom2.setNorthRoom(null);
        challengeRoom2.setSouthRoom(null);
        challengeRoom2.setWestRoom(null);
        challengeRoom2.setEastRoom(null);
        count = 0;
        count2 = 0;
        test.hide();
        initStartScreen();
    }

    private void setHPs(RoomSuperclass room) {
        room.setPlayerHPNum(playerHP);
        room.setMonster1HPNum(monster1HP);
        room.setMonster2HPNum(monster2HP);
        room.setMonster3HPNum(monster3HP);
        room8.setBossMonsterHPNum(bossMonsterHP);
    }

    private void initStartScreen() {
        test.hide();
        selectedWeapon.hide();
        labels.hide();
        challenge1Labels.hide();
        challenge2Labels.hide();
        playerHP = 100;
        monster1HP = 100;
        monster2HP = 100;
        monster3HP = 100;
        bossMonsterHP = 100;
        StartScreen screen = new StartScreen(width, height);
        Button startButton = screen.getStartButton();
        startButton.setOnAction(e -> {
            goToConfigScreen();
        });
        Scene scene = screen.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    private void goToConfigScreen() {
        test.hide();
        toInventory.hide();
        labels.hide();
        challenge1Labels.hide();
        challenge2Labels.hide();
        ConfigScreen screen = new ConfigScreen(width, height);
        Button next = screen.getNext();
        playerName = screen.getPlayerName();
        next.setOnAction(e -> {
            playerNameString = playerName.getCharacters().toString();
            String levelDif = (String) screen.getLevelDif().getValue();
            String weapon = (String) screen.getWeapon().getValue();
            weaponSelected = weapon;
            weaponSelectedLabel = new Label("Weapon: " + weaponSelected);
            selectedWeapon.getContent().add(weaponSelectedLabel);
            //inventoryScreen.setSelectedWeapon(weaponSelected);
            boolean nameValid = true;
            if ((playerNameString.equals(null)) || (playerNameString.equals(""))
                    || (playerNameString.charAt(0) == ' ')) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText("Invalid Input");
                a.setContentText("Please enter a valid name.");
                a.showAndWait();
                playerName.clear();
                nameValid = false;
            } else if (screen.getLevelDif().getValue() == null) {
                Alert b = new Alert(Alert.AlertType.ERROR);
                b.setTitle("Error");
                b.setHeaderText("Incomplete");
                b.setContentText("Please select a difficulty.");
                b.showAndWait();
                screen.getLevelDif().getSelectionModel().clearSelection();
            } else if (screen.getWeapon().getValue() == null) {
                Alert c = new Alert(Alert.AlertType.ERROR);
                c.setTitle("Error");
                c.setHeaderText("Incomplete");
                c.setContentText("Please select a weapon.");
                c.showAndWait();
            }
            if (!(screen.getLevelDif().getValue() == null)) {
                room1.setLevelDif((String) screen.getLevelDif().getValue());
                //room1.setMoney(levelDif);
            }
            if ((nameValid) && !(screen.getLevelDif().getValue() == null)
                    && !(screen.getWeapon().getValue() == null)) {
                if (weapon.equals("Torch")) {
                    inventoryScreen.setTorchNum(1);
                } else if (weapon.equals("Axe")) {
                    inventoryScreen.setAxeNum(1);
                } else if (weapon.equals("Shield")) {
                    inventoryScreen.setShieldNum(1);
                }
                if (levelDif.equals("Easy")) {
                    money = 100;
                    totalMoney += 100;
                } else if (levelDif.equals("Medium")) {
                    money = 70;
                    totalMoney += 70;
                } else {
                    money = 40;
                    totalMoney += 40;
                }
                shopMoneyLabel = new Label("Money: $" + money);
                shopMoney.getContent().add(shopMoneyLabel);
                room1.setMoney(money);
                shopScreen.setMoney(money);
                goToInitGameScreen();
            }
        });
        goToInitGameScreen();
        Scene scene = screen.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
        labels.hide();
        challenge1Labels.hide();
        challenge2Labels.hide();
        toInventory.hide();
        test.hide();
    }

    private void goToInitGameScreen() {
        testLabel.setText("Room 1");
        //testLabel.setText("Room 1");
       // test.getContent().add(testLabel);
        challengePopup.hide();
        boss.hide();
        selectedWeapon.hide();
        shopMoney.hide();
        toInventory.show(mainWindow);
        test.show(mainWindow);
        VBox vbox = new VBox(playerLabel1, monster1Label, monster2Label, monster3Label);
        vbox.setSpacing(5);
        labels.getContent().add(vbox);
        labels.show(mainWindow);
        labels.setX(780);
        labels.setY(90);
        VBox vBoxChallenge1 = new VBox(playerLabel2, cm1Label, cm2Label, cm3Label);
        vBoxChallenge1.setSpacing(5);
        challenge1Labels.getContent().add(vBoxChallenge1);
        challenge1Labels.setX(710);
        challenge1Labels.setY(90);
        VBox vBoxChallenge2  =  new VBox(playerLabel3, cm4Label, cm5Label, cm6Label);
        vBoxChallenge2.setSpacing(5);
        challenge2Labels.getContent().add(vBoxChallenge2);

        challenge2Labels.setX(705);
        challenge2Labels.setY(90);

        setHPs(room1);
        Button northExit = room1.getNorthExit();
        Button southExit = room1.getSouthExit();
        Button westExit = room1.getWestExit();
        Button eastExit = room1.getEastExit();
        northExit.setOnAction(e -> {
            if ((room1.getNorthRoom() == null) && (room1.getSouthRoom() == null)
                    && (room1.getWestRoom() == null) && (room1.getEastRoom() == null)) {
                goToRndRoom(room1, "North");
            } else if (room1.getNorthRoom() != null) {
                if (room1.getNorthRoom().equals(room2)) {
                    goToRoom2();
                } else if (room1.getNorthRoom().equals(room3)) {
                    goToRoom3();
                } else if (room1.getNorthRoom().equals(room4)) {
                    goToRoom4();
                } else if (room1.getNorthRoom().equals(room5)) {
                    goToRoom5();
                } else if (room1.getNorthRoom().equals(room6)) {
                    goToRoom6();
                } else if (room1.getNorthRoom().equals(room7)) {
                    goToRoom7();
                }
            }
        });
        southExit.setOnAction(e -> {
            if ((room1.getNorthRoom() == null) && (room1.getSouthRoom() == null)
                    && (room1.getWestRoom() == null) && (room1.getEastRoom() == null)) {
                goToRndRoom(room1, "South");
            } else if (room1.getSouthRoom() != null) {
                if (room1.getSouthRoom().equals(room2)) {
                    goToRoom2();
                } else if (room1.getSouthRoom().equals(room3)) {
                    goToRoom3();
                } else if (room1.getSouthRoom().equals(room4)) {
                    goToRoom4();
                } else if (room1.getSouthRoom().equals(room5)) {
                    goToRoom5();
                } else if (room1.getSouthRoom().equals(room6)) {
                    goToRoom6();
                } else if (room1.getSouthRoom().equals(room7)) {
                    goToRoom7();
                }
            }
        });
        westExit.setOnAction(e -> {
            if ((room1.getNorthRoom() == null) && (room1.getSouthRoom() == null)
                    && (room1.getWestRoom() == null) && (room1.getEastRoom() == null)) {
                goToRndRoom(room1, "West");
            } else if (room1.getWestRoom() != null) {
                if (room1.getWestRoom().equals(room2)) {
                    goToRoom2();
                } else if (room1.getWestRoom().equals(room3)) {
                    goToRoom3();
                } else if (room1.getWestRoom().equals(room4)) {
                    goToRoom4();
                } else if (room1.getWestRoom().equals(room5)) {
                    goToRoom5();
                } else if (room1.getWestRoom().equals(room6)) {
                    goToRoom6();
                } else if (room1.getWestRoom().equals(room7)) {
                    goToRoom7();
                } else if (room1.getWestRoom().equals(room8)) {
                    goToExitRoom();
                }
            }
        });
        eastExit.setOnAction(e -> {
            if ((room1.getNorthRoom() == null) && (room1.getSouthRoom() == null)
                    && (room1.getWestRoom() == null) && (room1.getEastRoom() == null)) {
                goToRndRoom(room1, "East");
            } else if (room1.getEastRoom() != null) {
                if (room1.getEastRoom().equals(room2)) {
                    goToRoom2();
                } else if (room1.getEastRoom().equals(room3)) {
                    goToRoom3();
                } else if (room1.getEastRoom().equals(room4)) {
                    goToRoom4();
                } else if (room1.getEastRoom().equals(room5)) {
                    goToRoom5();
                } else if (room1.getEastRoom().equals(room6)) {
                    goToRoom6();
                } else if (room1.getEastRoom().equals(room7)) {
                    goToRoom7();
                } else if (room1.getEastRoom().equals(room8)) {
                    goToExitRoom();
                }
            }
        });
        lastRoom = room1;
        Scene scene = room1.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    public void setLabels() {
        playerLabel1.setText("Player HP: " + playerHP);
        playerLabel2.setText("Player HP: " + playerHP);
        playerLabel3.setText("Player HP: " + playerHP);
        monster1Label.setText("Monster 1 HP: " + monster1HP);
        monster2Label.setText("Monster 2 HP: " + monster2HP);
        monster3Label.setText("Monster 3 HP: " + monster3HP);
        cm1Label.setText("Challenge Monster 1 HP: " + cm1HP);
        cm2Label.setText("Challenge Monster 2 HP: " + cm2HP);
        cm3Label.setText("Challenge Monster 3 HP: " + cm3HP);
        cm4Label.setText("Challenge Monster 4 HP: " + cm4HP);
        cm5Label.setText("Challenge Monster 5 HP: " + cm5HP);
        cm6Label.setText("Challenge Monster 6 HP: " + cm6HP);
        bossMonsterLabel.setText("Boss Monster HP: " + bossMonsterHP);
    }

    public void goToInventory() {
        if ((cm1HP == 0) && (cm2HP == 0) && (cm3HP == 0) && (count1 == 0)) {
            money += 60;
            totalMoney += 60;
            shopMoneyLabel.setText("Money: $" + money);
            room1.setMoney(money);
            shopScreen.setMoney(money);
            count1++;
        }
        if ((cm4HP == 0) && (cm5HP == 0) && (cm6HP == 0) && (count2 == 0)) {
            money += 60;
            totalMoney += 60;
            shopMoneyLabel.setText("Money: $" + money);
            room1.setMoney(money);
            shopScreen.setMoney(money);
            count2++;
        }
        test.hide();
        boss.hide();
        shopMoney.hide();
        challenge1Labels.hide();
        challenge2Labels.hide();
        Button selectSword = inventoryScreen.getSelectSword();
        Button selectAxe = inventoryScreen.getSelectAxe();
        Button selectShield = inventoryScreen.getSelectShield();
        Button selectTorch = inventoryScreen.getSelectTorch();
        Button selectBowAndArrow = inventoryScreen.getSelectBowAndArrow();
        Button back = inventoryScreen.getBack();
        Label selectedWeaponLabel = new Label();
        selectedWeapon.getContent().add(selectedWeaponLabel);
        selectedWeapon.show(mainWindow);
        back.setOnAction(e -> {
            if (lastRoom == room1) {
                goToInitGameScreen();
            } else if (lastRoom == room2) {
                goToRoom2();
            } else if (lastRoom == room3) {
                goToRoom3();
            } else if (lastRoom == room4) {
                goToRoom4();
            } else if (lastRoom == room5) {
                goToRoom5();
            } else if (lastRoom == room6) {
                goToRoom6();
            } else if (lastRoom == room7) {
                goToRoom7();
            } else if (lastRoom == room8) {
                goToExitRoom();
            } else if (lastRoom == challengeRoom1) {
                goToChallengeRoom1();
            } else if (lastRoom == challengeRoom2) {
                goToChallengeRoom2();
            } else if (lastRoom == actualChallengeRoom1) {
                goToActualChallengeRoom1();
            } else if (lastRoom == actualChallengeRoom2) {
                goToActualChallengeRoom2();
            }
        });
        selectSword.setOnAction(e -> {
            if (inventoryScreen.getSwordNum() > 0) {
                weaponSelected = "Sword";
                //selectedLabel = new Label("Weapon: " + weaponSelected);
                weaponSelectedLabel.setText("Weapon: " + weaponSelected);
                //inventoryScreen.setSelectedWeapon(weaponSelected);
            }
        });
        selectAxe.setOnAction(e -> {
            if (inventoryScreen.getAxeNum() > 0) {
                weaponSelected = "Axe";
                weaponSelectedLabel.setText("Weapon: " + weaponSelected);

                //inventoryScreen.setSelectedWeapon(weaponSelected);
            }
        });
        selectShield.setOnAction(e -> {
            if (inventoryScreen.getShieldNum() > 0) {
                weaponSelected = "Shield";
                weaponSelectedLabel.setText("Weapon: " + weaponSelected);

                //inventoryScreen.setSelectedWeapon(weaponSelected);
            }
        });
        selectTorch.setOnAction(e -> {
            if (inventoryScreen.getTorchNum() > 0) {
                weaponSelected = "Torch";
                weaponSelectedLabel.setText("Weapon: " + weaponSelected);
            }
        });
        selectBowAndArrow.setOnAction(e -> {
            if (inventoryScreen.getBowAndArrowNum() > 0) {
                weaponSelected = "Bow and Arrow";
                weaponSelectedLabel.setText("Weapon: " + weaponSelected);
            }
        });
        toInventory.hide();
        labels.hide();
        Button button = inventoryScreen.getShop();
        button.setOnAction(e -> goToShop());
        Scene scene = inventoryScreen.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
    }
    public void goToShop() {
        test.hide();
        challenge1Labels.hide();
        challenge2Labels.hide();
        boss.hide();
        selectedWeapon.hide();
        shopMoney.show(mainWindow);
        Button buyHealth = shopScreen.getBuyHealth();
        Button buyAttack = shopScreen.getBuyAttack();
        Button buySword = shopScreen.getBuySword();
        Button buyAxe = shopScreen.getBuyAxe();
        Button buyShield = shopScreen.getBuyShield();
        Button buyTorch = shopScreen.getBuyTorch();
        Button buyBowAndArrow = shopScreen.getBuyBowAndArrow();
        labels.hide();
        buyHealth.setOnAction((e -> {
            if (money >= 30) {
                money -= 30;
                inventoryScreen.setHealthPotionNum(1);
                shopMoneyLabel.setText("Money: $" + money);
                room1.setMoney(money);
                shopScreen.setMoney(money);
            }
        }));
        buyAttack.setOnAction(e -> {
            if (money >= 30) {
                money -= 30;
                inventoryScreen.setAttackPotionNum(1);
                shopMoneyLabel.setText("Money: $" + money);
                room1.setMoney(money);
                shopScreen.setMoney(money);
            }
        });
        buySword.setOnAction(e -> {
            if (money >= 40) {
                money -= 40;
                inventoryScreen.setSwordNum(1);
                shopMoneyLabel.setText("Money: $" + money);
                room1.setMoney(money);
                shopScreen.setMoney(money);
            }
        });
        buyAxe.setOnAction(e -> {
            if (money >= 25) {
                money -= 25;
                inventoryScreen.setAxeNum(1);
                shopMoneyLabel.setText("Money: $" + money);
                room1.setMoney(money);
                shopScreen.setMoney(money);
            }
        });
        buyShield.setOnAction(e -> {
            if (money >= 15) {
                money -= 15;
                inventoryScreen.setShieldNum(1);
                shopMoneyLabel.setText("Money: $" + money);
                room1.setMoney(money);
                shopScreen.setMoney(money);
            }
        });
        buyTorch.setOnAction(e -> {
            if (money >= 15) {
                money -= 15;
                inventoryScreen.setTorchNum(1);
                shopMoneyLabel.setText("Money: $" + money);
                room1.setMoney(money);
                shopScreen.setMoney(money);
            }
        });
        buyBowAndArrow.setOnAction(e -> {
            if (money >= 35) {
                money -= 35;
                inventoryScreen.setBowAndArrowNum(1);
                shopMoneyLabel.setText("Money: $" + money);
                room1.setMoney(money);
                shopScreen.setMoney(money);
            }
        });

        toInventory.show(mainWindow);
        Scene scene = shopScreen.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    public void monster(RoomSuperclass room) {
        setLabels();
        if (!(room == actualChallengeRoom1 || room == actualChallengeRoom2)) {
            labels.show(mainWindow);
        }
        Node m1 = room.getM1();
        Node m2 = room.getM2();
        Node m3 = room.getM3();
        Node bossMonster = room8.getBossMonster();
        Node m4 = actualChallengeRoom1.getM4();
        Node m5 = actualChallengeRoom1.getM5();
        Node m6 = actualChallengeRoom1.getM6();
        Node m7 = actualChallengeRoom2.getM7();
        Node m8 = actualChallengeRoom2.getM8();
        Node m9 = actualChallengeRoom2.getM9();
        if (m1 != null) {
            m1.setOnMouseClicked(e -> monsterAttack(1, room));
        }
        if (m2 != null) {
            m2.setOnMouseClicked(e -> monsterAttack(2, room));
        }
        if (m3 != null) {
            m3.setOnMouseClicked(e -> monsterAttack(3, room));
        }
        if (m4 != null) {
            m4.setOnMouseClicked(e -> monsterAttack(4, room));
        }
        if (m5 != null) {
            m5.setOnMouseClicked(e -> monsterAttack(5, room));
        }
        if (m6 != null) {
            m6.setOnMouseClicked(e -> monsterAttack(6, room));
        }
        if (m7 != null) {
            m7.setOnMouseClicked(e -> monsterAttack(7, room));
        }
        if (m8 != null) {
            m8.setOnMouseClicked(e -> monsterAttack(8, room));
        }
        if (m9 != null) {
            m9.setOnMouseClicked(e -> monsterAttack(9, room));
        }
        if (bossMonster != null) {
            bossMonster.setOnMouseClicked(e -> monsterAttack(10, room));
        }
    }

    public void monsterAttack(int monster, RoomSuperclass room) {
        monsterDefeated = false;
        int damage = 20;
        if (playerHP >= 0) {
            if (monster == 1) {
                switch (weaponSelected) {
                    case "Sword":
                        damage = 100;
                        break;
                    case "Bow and Arrow":
                        damage = 70;
                        break;
                    case "Axe":
                        damage = 50;
                        break;
                    case "Shield":
                        damage = 40;
                        break;
                    case "Torch":
                        damage = 35;
                        break;
                    default:
                        damage = 0;
                }
            } else if (monster == 2) {
                switch (weaponSelected) {
                    case "Sword":
                        damage = 65;
                        break;
                    case "Bow and Arrow":
                        damage = 55;
                        break;
                    case "Axe":
                        damage = 35;
                        break;
                    case "Shield":
                        damage = 30;
                        break;
                    case "Torch":
                        damage = 25;
                        break;
                    default:
                        damage = 0;
                }
            } else if (monster == 3) {
                switch (weaponSelected) {
                    case "Sword":
                        damage = 40;
                        break;
                    case "Bow and Arrow":
                        damage = 35;
                        break;
                    case "Axe":
                        damage = 25;
                        break;
                    case "Shield":
                        damage = 20;
                        break;
                    case "Torch":
                        damage = 15;
                        break;
                    default:
                        damage = 0;
                }
            } else if (monster == 4) {
                switch (weaponSelected) {
                    case "Sword":
                        damage = 40;
                        break;
                    case "Bow and Arrow":
                        damage = 35;
                        break;
                    case "Axe":
                        damage = 25;
                        break;
                    case "Shield":
                        damage = 20;
                        break;
                    case "Torch":
                        damage = 15;
                        break;
                    default:
                        damage = 0;
                }
            } else if (monster == 5) {
                switch (weaponSelected) {
                    case "Sword":
                        damage = 40;
                        break;
                    case "Bow and Arrow":
                        damage = 35;
                        break;
                    case "Axe":
                        damage = 25;
                        break;
                    case "Shield":
                        damage = 20;
                        break;
                    case "Torch":
                        damage = 15;
                        break;
                    default:
                        damage = 0;
                }
            } else if (monster == 6) {
                switch (weaponSelected) {
                    case "Sword":
                        damage = 40;
                        break;
                    case "Bow and Arrow":
                        damage = 35;
                        break;
                    case "Axe":
                        damage = 25;
                        break;
                    case "Shield":
                        damage = 20;
                        break;
                    case "Torch":
                        damage = 15;
                        break;
                    default:
                        damage = 0;
                }
            } else if (monster == 7) {
                switch (weaponSelected) {
                    case "Sword":
                        damage = 40;
                        break;
                    case "Bow and Arrow":
                        damage = 35;
                        break;
                    case "Axe":
                        damage = 25;
                        break;
                    case "Shield":
                        damage = 20;
                        break;
                    case "Torch":
                        damage = 15;
                        break;
                    default:
                        damage = 0;
                }
            } else if (monster == 8) {
                switch (weaponSelected) {
                    case "Sword":
                        damage = 40;
                        break;
                    case "Bow and Arrow":
                        damage = 35;
                        break;
                    case "Axe":
                        damage = 25;
                        break;
                    case "Shield":
                        damage = 20;
                        break;
                    case "Torch":
                        damage = 15;
                        break;
                    default:
                        damage = 0;
                }
            } else if (monster == 9) {
                switch (weaponSelected) {
                    case "Sword":
                        damage = 40;
                        break;
                    case "Bow and Arrow":
                        damage = 35;
                        break;
                    case "Axe":
                        damage = 25;
                        break;
                    case "Shield":
                        damage = 20;
                        break;
                    case "Torch":
                        damage = 15;
                        break;
                    default:
                        damage = 0;
                }
            }
            if (attackSelected) {
                damage = damage * 2;
                attackSelected = false;
                inventoryScreen.setAttackPotionNum(-1);
            }
            if (monster == 1) {
                if ((monster1HP - damage) <= 0) {
                    monster1HP = 0;
                    monsterDefeated = true;
                    monstersKilled += 1;
                    room.setMonster1Defeated(true);
                    room.removeMonster(1);
                } else {
                    monster1HP = monster1HP - damage;
                    room.setMonster1HPNum(monster1HP);
                }
                totalDamage += damage;
                setLabels();
            } else if (monster == 2) {
                if ((monster2HP - damage) <= 0) {
                    monster2HP = 0;
                    monsterDefeated = true;
                    monstersKilled += 1;
                    room.setMonster2Defeated(true);
                    room.removeMonster(2);
                } else {
                    monster2HP = monster2HP - damage;
                    room.setMonster2HPNum(monster2HP);
                }
                setLabels();
                totalDamage += damage;
            } else if (monster == 3) {
                if ((monster3HP - damage) <= 0) {
                    monster3HP = 0;
                    monsterDefeated = true;
                    monstersKilled += 1;
                    room.setMonster3Defeated(true);
                    room.removeMonster(3);
                } else {
                    monster3HP = monster3HP - damage;
                    room.setMonster3HPNum(monster3HP);
                }
                totalDamage += damage;
                setLabels();
            } else if (monster == 4) {
                if ((cm1HP - damage) <= 0) {
                    cm1HP = 0;
                    monsterDefeated = true;
                    monstersKilled += 1;
                    actualChallengeRoom1.setCm1Defeated(true);
                    room.removeMonster(4);
                } else {
                    cm1HP = cm1HP - damage;
                    actualChallengeRoom1.setCm1HPNum(cm1HP);
                }
                totalDamage += damage;
                setLabels();
            } else if (monster == 5) {
                if ((cm2HP - damage) <= 0) {
                    cm2HP = 0;
                    monsterDefeated = true;
                    monstersKilled += 1;
                    actualChallengeRoom1.setCm2Defeated(true);
                    room.removeMonster(5);
                } else {
                    cm2HP = cm2HP - damage;
                    actualChallengeRoom1.setCm2HPNum(cm2HP);
                }
                totalDamage += damage;
                setLabels();
            } else if (monster == 6) {
                if ((cm3HP - damage) <= 0) {
                    cm3HP = 0;
                    monsterDefeated = true;
                    monstersKilled += 1;
                    actualChallengeRoom1.setCm3Defeated(true);
                    room.removeMonster(6);
                } else {
                    cm3HP = cm3HP - damage;
                    actualChallengeRoom1.setCm3HPNum(cm3HP);
                }
                totalDamage += damage;
                setLabels();
            } else if (monster == 7) {
                if ((cm4HP - damage) <= 0) {
                    cm4HP = 0;
                    monsterDefeated = true;
                    monstersKilled += 1;
                    actualChallengeRoom2.setCm1Defeated(true);
                    room.removeMonster(7);
                } else {
                    cm4HP = cm4HP - damage;
                    actualChallengeRoom2.setCm1HPNum(cm4HP);
                }
                totalDamage += damage;
                setLabels();
            } else if (monster == 8) {
                if ((cm5HP - damage) <= 0) {
                    cm5HP = 0;
                    monsterDefeated = true;
                    monstersKilled += 1;
                    actualChallengeRoom2.setCm2Defeated(true);
                    room.removeMonster(8);
                } else {
                    cm5HP = cm5HP - damage;
                    actualChallengeRoom2.setCm2HPNum(cm5HP);
                }
                totalDamage += damage;
                setLabels();
            } else if (monster == 9) {
                if ((cm6HP - damage) <= 0) {
                    cm6HP = 0;
                    monsterDefeated = true;
                    monstersKilled += 1;
                    actualChallengeRoom2.setCm3Defeated(true);
                    room.removeMonster(9);
                } else {
                    cm6HP = cm6HP - damage;
                    actualChallengeRoom2.setCm3HPNum(cm6HP);
                }
                totalDamage += damage;
                setLabels();
            } else if (monster == 10) {
                if ((bossMonsterHP - damage) <= 0) {
                    bossMonsterHP = 0;
                    monsterDefeated = true;
                    monstersKilled += 1;
                    room8.setBossMonsterDefeated(true);
                    room8.removeMonster(4);
                } else {
                    bossMonsterHP = bossMonsterHP - damage;
                    room8.setBossMonsterHPNum(bossMonsterHP);
                }
                totalDamage += damage;
                setLabels();
            }
            if ((playerHP - 5) <= 0) {
                playerHP = 0;
                endGameRoom.setResult("Defeated!");
                goToEndGameScreen();
            } else {
                playerHP = playerHP - 5;
            }
            setLabels();
        } else {
            endGameRoom.setResult("Defeated!");
            goToEndGameScreen();
        }
    }

    public void goToChallengeRoom1() {
        lastRoom = challengeRoom1;
        challenge1Labels.hide();
        challenge2Labels.hide();
        test.show(mainWindow);
        testLabel.setText("Room 9");

        if (!challengeRoom1.getBeenRoom()) {
            monster1HP = 100;
            monster2HP = 100;
            monster3HP = 100;
            challengeRoom1.setMonster1HPNum(100);
            challengeRoom1.setMonster2HPNum(100);
            challengeRoom1.setMonster3HPNum(100);
        }
        challengePopup.show(mainWindow);
        challengeButton.setOnAction(e -> {
            selectChallenge = true;
            challengeRoom1.setSelectChallenge(true);
            goToActualChallengeRoom1();
        });
        beenCR1 = true;
        challengeRoom1.setBeenRoom(true);
        Button northExit = challengeRoom1.getNorthExit();
        Button southExit = challengeRoom1.getSouthExit();
        Button westExit = challengeRoom1.getWestExit();
        Button eastExit = challengeRoom1.getEastExit();
        northExit.setOnAction(e -> {
            if (challengeRoom1.getNorthRoom() != null) {
                if (challengeRoom1.getNorthRoom().equals(room2)) {
                    goToRoom2();
                } else if (challengeRoom1.getNorthRoom().equals(room3)) {
                    goToRoom3();
                } else if (challengeRoom1.getNorthRoom().equals(room4)) {
                    goToRoom4();
                } else if (challengeRoom1.getNorthRoom().equals(room5)) {
                    goToRoom5();
                } else if (challengeRoom1.getNorthRoom().equals(room6)) {
                    goToRoom6();
                } else if (challengeRoom1.getNorthRoom().equals(room7)) {
                    goToRoom7();
                } else if (challengeRoom1.getNorthRoom().equals(room1)) {
                    goToInitGameScreen();
                } else if (challengeRoom1.getNorthRoom().equals(challengeRoom2)) {
                    goToChallengeRoom2();
                } else if (challengeRoom1.getNorthRoom().equals(room8)) {
                    goToExitRoom();
                }
            } else if (((challengeRoom1.getNorthRoom() == null) && (challengeRoom1.getSouthRoom() == null)
                    && (challengeRoom1.getWestRoom() == null)) || ((challengeRoom1.getNorthRoom() == null)
                    && (challengeRoom1.getSouthRoom() == null) && (challengeRoom1.getEastRoom() == null))
                    || ((challengeRoom1.getNorthRoom() == null) && (challengeRoom1.getWestRoom() == null)
                    && (challengeRoom1.getEastRoom() == null)) || ((challengeRoom1.getSouthRoom() == null)
                    && (challengeRoom1.getWestRoom() == null) && (challengeRoom1.getEastRoom() == null))) {
                goToRndRoom(challengeRoom1, "North");
            }
        });
        southExit.setOnAction(e -> {
            if (challengeRoom1.getSouthRoom() != null) {
                if (challengeRoom1.getSouthRoom().equals(room2)) {
                    goToRoom2();
                } else if (challengeRoom1.getSouthRoom().equals(room3)) {
                    goToRoom3();
                } else if (challengeRoom1.getSouthRoom().equals(room4)) {
                    goToRoom4();
                } else if (challengeRoom1.getSouthRoom().equals(room5)) {
                    goToRoom5();
                } else if (challengeRoom1.getSouthRoom().equals(room6)) {
                    goToRoom6();
                } else if (challengeRoom1.getSouthRoom().equals(room7)) {
                    goToRoom7();
                } else if (challengeRoom1.getSouthRoom().equals(room1)) {
                    goToInitGameScreen();
                } else if (challengeRoom1.getSouthRoom().equals(challengeRoom2)) {
                    goToChallengeRoom2();
                } else if (challengeRoom1.getSouthRoom().equals(room8)) {
                    goToExitRoom();
                }
            } else if (((challengeRoom1.getNorthRoom() == null) && (challengeRoom1.getSouthRoom() == null)
                    && (challengeRoom1.getWestRoom() == null)) || ((challengeRoom1.getNorthRoom() == null)
                    && (challengeRoom1.getSouthRoom() == null) && (challengeRoom1.getEastRoom() == null))
                    || ((challengeRoom1.getNorthRoom() == null) && (challengeRoom1.getWestRoom() == null)
                    && (challengeRoom1.getEastRoom() == null)) || ((challengeRoom1.getSouthRoom() == null)
                    && (challengeRoom1.getWestRoom() == null) && (challengeRoom1.getEastRoom() == null))) {
                goToRndRoom(challengeRoom1, "South");
            }
        });
        westExit.setOnAction(e -> {
            if (challengeRoom1.getWestRoom() != null) {
                if (challengeRoom1.getWestRoom().equals(room2)) {
                    goToRoom2();
                } else if (challengeRoom1.getWestRoom().equals(room3)) {
                    goToRoom3();
                } else if (challengeRoom1.getWestRoom().equals(room4)) {
                    goToRoom4();
                } else if (challengeRoom1.getWestRoom().equals(room5)) {
                    goToRoom5();
                } else if (challengeRoom1.getWestRoom().equals(room6)) {
                    goToRoom6();
                } else if (challengeRoom1.getWestRoom().equals(room7)) {
                    goToRoom7();
                } else if (challengeRoom1.getWestRoom().equals(room8)) {
                    goToExitRoom();
                } else if (challengeRoom1.getWestRoom().equals(room1)) {
                    goToInitGameScreen();
                } else if (challengeRoom1.getWestRoom().equals(challengeRoom2)) {
                    goToChallengeRoom2();
                }
            } else if (((challengeRoom1.getNorthRoom() == null) && (challengeRoom1.getSouthRoom() == null)
                    && (challengeRoom1.getWestRoom() == null)) || ((challengeRoom1.getNorthRoom() == null)
                    && (challengeRoom1.getSouthRoom() == null) && (challengeRoom1.getEastRoom() == null))
                    || ((challengeRoom1.getNorthRoom() == null) && (challengeRoom1.getWestRoom() == null)
                    && (challengeRoom1.getEastRoom() == null)) || ((challengeRoom1.getSouthRoom() == null)
                    && (challengeRoom1.getWestRoom() == null) && (challengeRoom1.getEastRoom() == null))) {
                goToRndRoom(challengeRoom1, "West");
            }
        });
        eastExit.setOnAction(e -> {
           if (challengeRoom1.getEastRoom() != null) {
                if (challengeRoom1.getEastRoom().equals(room2)) {
                    goToRoom2();
                } else if (challengeRoom1.getEastRoom().equals(room3)) {
                    goToRoom3();
                } else if (challengeRoom1.getEastRoom().equals(room4)) {
                    goToRoom4();
                } else if (challengeRoom1.getEastRoom().equals(room5)) {
                    goToRoom5();
                } else if (challengeRoom1.getEastRoom().equals(room6)) {
                    goToRoom6();
                } else if (challengeRoom1.getEastRoom().equals(room7)) {
                    goToRoom7();
                } else if (challengeRoom1.getEastRoom().equals(room8)) {
                    goToExitRoom();
                } else if (challengeRoom1.getEastRoom().equals(room1)) {
                    goToInitGameScreen();
                } else if (challengeRoom1.getEastRoom().equals(challengeRoom2)) {
                    goToChallengeRoom2();
                }
           } else if (((challengeRoom1.getNorthRoom() == null) && (challengeRoom1.getSouthRoom() == null)
                   && (challengeRoom1.getWestRoom() == null)) || ((challengeRoom1.getNorthRoom() == null)
                   && (challengeRoom1.getSouthRoom() == null) && (challengeRoom1.getEastRoom() == null))
                   || ((challengeRoom1.getNorthRoom() == null) && (challengeRoom1.getWestRoom() == null)
                   && (challengeRoom1.getEastRoom() == null)) || ((challengeRoom1.getSouthRoom() == null)
                   && (challengeRoom1.getWestRoom() == null) && (challengeRoom1.getEastRoom() == null))) {
               goToRndRoom(challengeRoom1, "East");
           }
           });
           Scene scene = challengeRoom1.getScene();
           mainWindow.setScene(scene);
           mainWindow.show();

    }
    public void goToActualChallengeRoom1() {
        test.show(mainWindow);
        testLabel.setText("Challenge Room 1");
        labels.hide();
        challenge2Labels.hide();
        challenge1Labels.show(mainWindow);
/**
        if (cm1HP == 0 && cm2HP == 0 && cm3HP == 0) {
            money += 60;
            totalMoney += 60;
            room1.setMoney(money);
            shopScreen.setMoney(money);
            winChallenge.show(mainWindow);
        } else {
            winChallenge.hide();
        }
        winChallengeButton.setOnAction(e -> {
            money += 60;
            totalMoney += 60;
            room1.setMoney(money);
            shopScreen.setMoney(money);
        });
**/
        actualChallengeRoom1.setBeenRoom(true);
        roomHelper(actualChallengeRoom1);

        //beenRoom2 = true;
        Scene scene = actualChallengeRoom1.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
        monster(actualChallengeRoom1);
        //room2.setBeenRoom(true);
        beenACR1 = true;
    }
    public void goToChallengeRoom2() {
        lastRoom = challengeRoom2;
        challenge1Labels.hide();
        challenge2Labels.hide();
        test.show(mainWindow);
        testLabel.setText("Room 10");

        if (!challengeRoom2.getBeenRoom()) {
            monster1HP = 100;
            monster2HP = 100;
            monster3HP = 100;
            challengeRoom2.setMonster1HPNum(100);
            challengeRoom2.setMonster2HPNum(100);
            challengeRoom2.setMonster3HPNum(100);
        }
        challengePopup.show(mainWindow);
        challengeButton.setOnAction(e -> {
            selectChallenge = true;
            challengeRoom2.setSelectChallenge(true);
            goToActualChallengeRoom2();
        });
        beenCR2 = true;
        challengeRoom2.setBeenRoom(true);

            Button northExit = challengeRoom2.getNorthExit();
            Button southExit = challengeRoom2.getSouthExit();
            Button westExit = challengeRoom2.getWestExit();
            Button eastExit = challengeRoom2.getEastExit();
            northExit.setOnAction(e -> {
                if (challengeRoom2.getNorthRoom() != null) {
                    if (challengeRoom2.getNorthRoom().equals(room2)) {
                        goToRoom2();
                    } else if (challengeRoom2.getNorthRoom().equals(room3)) {
                        goToRoom3();
                    } else if (challengeRoom2.getNorthRoom().equals(room4)) {
                        goToRoom4();
                    } else if (challengeRoom2.getNorthRoom().equals(room5)) {
                        goToRoom5();
                    } else if (challengeRoom2.getNorthRoom().equals(room6)) {
                        goToRoom6();
                    } else if (challengeRoom2.getNorthRoom().equals(room7)) {
                        goToRoom7();
                    } else if (challengeRoom2.getNorthRoom().equals(room1)) {
                        goToInitGameScreen();
                    } else if (challengeRoom2.getNorthRoom().equals(challengeRoom1)) {
                        goToChallengeRoom1();
                    } else if (challengeRoom2.getNorthRoom().equals(room8)) {
                        goToExitRoom();
                    }
                } else if (((challengeRoom2.getNorthRoom() == null) && (challengeRoom2.getSouthRoom() == null)
                        && (challengeRoom2.getWestRoom() == null)) || ((challengeRoom2.getNorthRoom() == null)
                        && (challengeRoom2.getSouthRoom() == null) && (challengeRoom2.getEastRoom() == null))
                        || ((challengeRoom2.getNorthRoom() == null) && (challengeRoom2.getWestRoom() == null)
                        && (challengeRoom2.getEastRoom() == null)) || ((challengeRoom2.getSouthRoom() == null)
                        && (challengeRoom2.getWestRoom() == null) && (challengeRoom2.getEastRoom() == null))) {
                    goToRndRoom(challengeRoom2, "North");
                }
            });
            southExit.setOnAction(e -> {
                if (challengeRoom2.getSouthRoom() != null) {
                    if (challengeRoom2.getSouthRoom().equals(room2)) {
                        goToRoom2();
                    } else if (challengeRoom2.getSouthRoom().equals(room3)) {
                        goToRoom3();
                    } else if (challengeRoom2.getSouthRoom().equals(room4)) {
                        goToRoom4();
                    } else if (challengeRoom2.getSouthRoom().equals(room5)) {
                        goToRoom5();
                    } else if (challengeRoom2.getSouthRoom().equals(room6)) {
                        goToRoom6();
                    } else if (challengeRoom2.getSouthRoom().equals(room7)) {
                        goToRoom7();
                    } else if (challengeRoom2.getSouthRoom().equals(room1)) {
                        goToInitGameScreen();
                    } else if (challengeRoom2.getSouthRoom().equals(challengeRoom1)) {
                        goToChallengeRoom1();
                    } else if (challengeRoom2.getSouthRoom().equals(room8)) {
                        goToExitRoom();
                    }
                } else if (((challengeRoom2.getNorthRoom() == null) && (challengeRoom2.getSouthRoom() == null)
                        && (challengeRoom2.getWestRoom() == null)) || ((challengeRoom2.getNorthRoom() == null)
                        && (challengeRoom2.getSouthRoom() == null) && (challengeRoom2.getEastRoom() == null))
                        || ((challengeRoom2.getNorthRoom() == null) && (challengeRoom2.getWestRoom() == null)
                        && (challengeRoom2.getEastRoom() == null)) || ((challengeRoom2.getSouthRoom() == null)
                        && (challengeRoom2.getWestRoom() == null) && (challengeRoom2.getEastRoom() == null))) {
                    goToRndRoom(challengeRoom2, "South");
                }
            });
            westExit.setOnAction(e -> {
                if (challengeRoom2.getWestRoom() != null) {
                    if (challengeRoom2.getWestRoom().equals(room2)) {
                        goToRoom2();
                    } else if (challengeRoom2.getWestRoom().equals(room3)) {
                        goToRoom3();
                    } else if (challengeRoom2.getWestRoom().equals(room4)) {
                        goToRoom4();
                    } else if (challengeRoom2.getWestRoom().equals(room5)) {
                        goToRoom5();
                    } else if (challengeRoom2.getWestRoom().equals(room6)) {
                        goToRoom6();
                    } else if (challengeRoom2.getWestRoom().equals(room7)) {
                        goToRoom7();
                    } else if (challengeRoom2.getWestRoom().equals(room8)) {
                        goToExitRoom();
                    } else if (challengeRoom2.getWestRoom().equals(room1)) {
                        goToInitGameScreen();
                    } else if (challengeRoom2.getWestRoom().equals(challengeRoom1)) {
                        goToChallengeRoom1();
                    }
                } else if (((challengeRoom2.getNorthRoom() == null) && (challengeRoom2.getSouthRoom() == null)
                        && (challengeRoom2.getWestRoom() == null)) || ((challengeRoom2.getNorthRoom() == null)
                        && (challengeRoom2.getSouthRoom() == null) && (challengeRoom2.getEastRoom() == null))
                        || ((challengeRoom2.getNorthRoom() == null) && (challengeRoom2.getWestRoom() == null)
                        && (challengeRoom2.getEastRoom() == null)) || ((challengeRoom2.getSouthRoom() == null)
                        && (challengeRoom2.getWestRoom() == null) && (challengeRoom2.getEastRoom() == null))) {
                    goToRndRoom(challengeRoom2, "West");
                }
            });
            eastExit.setOnAction(e -> {
                if (challengeRoom2.getEastRoom() != null) {
                    if (challengeRoom2.getEastRoom().equals(room2)) {
                        goToRoom2();
                    } else if (challengeRoom2.getEastRoom().equals(room3)) {
                        goToRoom3();
                    } else if (challengeRoom2.getEastRoom().equals(room4)) {
                        goToRoom4();
                    } else if (challengeRoom2.getEastRoom().equals(room5)) {
                        goToRoom5();
                    } else if (challengeRoom2.getEastRoom().equals(room6)) {
                        goToRoom6();
                    } else if (challengeRoom2.getEastRoom().equals(room7)) {
                        goToRoom7();
                    } else if (challengeRoom2.getEastRoom().equals(room8)) {
                        goToExitRoom();
                    } else if (challengeRoom2.getEastRoom().equals(room1)) {
                        goToInitGameScreen();
                    } else if (challengeRoom2.getEastRoom().equals(challengeRoom1)) {
                        goToChallengeRoom1();
                    }
                } else if (((challengeRoom2.getNorthRoom() == null) && (challengeRoom2.getSouthRoom() == null)
                        && (challengeRoom2.getWestRoom() == null)) || ((challengeRoom2.getNorthRoom() == null)
                        && (challengeRoom2.getSouthRoom() == null) && (challengeRoom2.getEastRoom() == null))
                        || ((challengeRoom2.getNorthRoom() == null) && (challengeRoom2.getWestRoom() == null)
                        && (challengeRoom2.getEastRoom() == null)) || ((challengeRoom2.getSouthRoom() == null)
                        && (challengeRoom2.getWestRoom() == null) && (challengeRoom2.getEastRoom() == null))) {
                    goToRndRoom(challengeRoom2, "East");
                }
            });
            Scene scene = challengeRoom2.getScene();
            mainWindow.setScene(scene);
            mainWindow.show();



        //roomHelper(room2);

    }
    public void goToActualChallengeRoom2() {
        test.show(mainWindow);
        testLabel.setText("Challenge Room 2");
        labels.hide();
        challenge1Labels.hide();
        challenge2Labels.show(mainWindow);
/**
        if (cm4HP == 0 && cm5HP == 0 && cm6HP == 0) {
            winChallenge.show(mainWindow);
        } else {
            winChallenge.hide();
        }
        winChallengeButton.setOnAction(e -> {
            money += 60;
            totalMoney += 60;
        });
**/
        actualChallengeRoom2.setBeenRoom(true);
        roomHelper(actualChallengeRoom2);
        //beenRoom2 = true;
        Scene scene = actualChallengeRoom2.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
        monster(actualChallengeRoom2);
        //room2.setBeenRoom(true);
        beenACR2 = true;

    }

    public void roomHelper(RoomSuperclass room) {
        if (room == actualChallengeRoom1 || room == actualChallengeRoom2) {
            labels.hide();
        }
        challengePopup.hide();
        boss.hide();
        selectedWeapon.hide();
        shopMoney.hide();
        toInventory.show(mainWindow);
        lastRoom = room;
        if (!room.getBeenRoom()) {
            monster1HP = 100;
            monster2HP = 100;
            monster3HP = 100;
            room.setMonster1HPNum(100);
            room.setMonster2HPNum(100);
            room.setMonster3HPNum(100);
        }
        setHPs(room);
        Button northExit = room.getNorthExit();
        Button southExit = room.getSouthExit();
        Button westExit = room.getWestExit();
        Button eastExit = room.getEastExit();
        Button healthPotion = room.getHealthPotion();
        healthPotion.setOnAction(e -> {
            if ((playerHP <= 50) && (inventoryScreen.getHealthPotionNum() >= 1)) {
                playerHP = playerHP + 50;
                room.setPlayerHPNum(playerHP);
                inventoryScreen.setHealthPotionNum(-1);
                setLabels();
            }
        });
        Button attackPotion = room.getAttackPotion();
        attackPotion.setOnAction(e -> {
            if (inventoryScreen.getAttackPotionNum() > 0) {
                attackSelected = true;
            }
        });
        northExit.setOnAction(e -> northExit(room));
        southExit.setOnAction(e -> southExit(room));
        westExit.setOnAction(e -> westExit(room));
        eastExit.setOnAction(e -> eastExit(room));

    }

    public void goToRoom2() {
        challenge1Labels.hide();
        challenge2Labels.hide();
        testLabel.setText("Room 2");

        roomHelper(room2);
        beenRoom2 = true;
        Scene scene = room2.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
        monster(room2);
        room2.setBeenRoom(true);
    }


    public void goToRoom3() {
        challenge1Labels.hide();
        challenge2Labels.hide();
        test.show(mainWindow);
        testLabel.setText("Room 3");

        Node sword = room3.getSword();
        sword.setOnMouseClicked(e -> {
            inventoryScreen.setSwordNum(1);
            room3.removeWeapon();
            room3.setWeaponCollected(true);
        });
        roomHelper(room3);
        beenRoom3 = true;
        Scene scene = room3.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
        monster(room3);
        room3.setBeenRoom(true);
    }

    public void goToRoom4() {
        challenge1Labels.hide();
        challenge2Labels.hide();
        test.show(mainWindow);
        testLabel.setText("Room 4");

        Node sword = room4.getTorch();
        sword.setOnMouseClicked(e -> {
            inventoryScreen.setTorchNum(1);
            room4.removeWeapon();
            room4.setWeaponCollected(true);
        });
        roomHelper(room4);
        beenRoom4 = true;
        Scene scene = room4.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
        monster(room4);
        room4.setBeenRoom(true);
    }

    public void goToRoom5() {
        challenge1Labels.hide();
        challenge2Labels.hide();
        test.show(mainWindow);
        testLabel.setText("Room 5");

        Node axe = room5.getAxe();
        axe.setOnMouseClicked(e -> {
            inventoryScreen.setAxeNum(1);
            room5.removeWeapon();
            room5.setWeaponCollected(true);
        });
        roomHelper(room5);
        beenRoom5 = true;
        Scene scene = room5.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
        monster(room5);
        room5.setBeenRoom(true);
    }

    public void goToRoom6() {
        challenge1Labels.hide();
        challenge2Labels.hide();
        test.show(mainWindow);
        testLabel.setText("Room 6");

        Node bowAndArrow = room6.getBowAndArrow();
        bowAndArrow.setOnMouseClicked(e -> {
            inventoryScreen.setBowAndArrowNum(1);
            room6.removeWeapon();
            room6.setWeaponCollected(true);
        });
        roomHelper(room6);
        beenRoom6 = true;
        Scene scene = room6.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
        monster(room6);
        room6.setBeenRoom(true);
    }

    public void goToRoom7() {
        challenge1Labels.hide();
        challenge2Labels.hide();
        test.show(mainWindow);
        testLabel.setText("Room 7");

        Node shield = room7.getShield();
        shield.setOnMouseClicked(e -> {
            inventoryScreen.setShieldNum(1);
            room7.removeWeapon();
            room7.setWeaponCollected(true);
        });
        roomHelper(room7);
        beenRoom7 = true;
        Scene scene = room7.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
        monster(room7);
        room7.setBeenRoom(true);
    }

    public void goToExitRoom() {
        challenge1Labels.hide();
        challenge2Labels.hide();
        test.show(mainWindow);
        testLabel.setText("Room 8");

        roomHelper(room8);
        boss.show(mainWindow);
        beenRoom8 = true;
        Scene scene = room8.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
        monster(room8);
        room8.setBeenRoom(true);
    }

    public void goToEndGameScreen() {
        test.hide();
        challenge1Labels.hide();
        challenge2Labels.hide();
        boss.hide();
        labels.hide();
        toInventory.hide();
        endGameRoom.setElapsedTime(totalMoney);
        endGameRoom.setTotalDamage(totalDamage);
        endGameRoom.setMonstersKilled(monstersKilled);
        Button restart = endGameRoom.getRestart();
        Button quit = endGameRoom.getQuit();
        restart.setOnAction(e -> initStartScreen());
        quit.setOnAction(e -> Platform.exit());
        Scene scene = endGameRoom.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    public void monsterHelper(RoomSuperclass room, String direction) {
        if (room.hasMonsters() == 1) {
            if (monster1HP <= 0) {
                exitHelper(room, direction);
            }
        } else if (room.hasMonsters() == 2) {
            if (monster2HP <= 0) {
                exitHelper(room, direction);
            }
        } else if (room.hasMonsters() == 3) {
            if (monster3HP <= 0) {
                exitHelper(room, direction);
            }
        } else if (room.hasMonsters() == 4) {
            if ((monster1HP <= 0) && (monster2HP <= 0)) {
                exitHelper(room, direction);
            }
        } else if (room.hasMonsters() == 5) {
            if ((monster1HP <= 0) && (monster3HP <= 0)) {
                exitHelper(room, direction);
            }
        } else if (room.hasMonsters() == 6) {
            if ((monster2HP <= 0) && (monster3HP <= 0)) {
                exitHelper(room, direction);
            }
        } else if (room.hasMonsters() == 7) {
            if ((monster2HP <= 0) && (monster3HP <= 0) && (bossMonsterHP <= 0)) {
                exitHelper(room, direction);
            }
        } else if (room.hasMonsters() == 8) {
            if ((cm1HP <= 0) && (cm2HP <= 0) && (cm3HP <= 0)) {
                exitHelper(room, direction);
            }
        } else if (room.hasMonsters() == 9) {
            if ((cm4HP <= 0) && (cm5HP <= 0) && (cm6HP <= 0)) {
                exitHelper(room, direction);
            }
        }
    }

    public void exitHelper(RoomSuperclass room, String direction) {
        if (((room.getNorthRoom() == null) && (room.getSouthRoom() == null)
                && (room.getWestRoom() == null)) || ((room.getNorthRoom() == null)
                && (room.getSouthRoom() == null) && (room.getEastRoom() == null))
                || ((room.getNorthRoom() == null) && (room.getWestRoom() == null)
                && (room.getEastRoom() == null)) || ((room.getSouthRoom() == null)
                && (room.getWestRoom() == null) && (room.getEastRoom() == null))) {
            goToRndRoom(room, direction);
        }
    }

    public void northExit(RoomSuperclass room) {
        if (room.getNorthRoom() != null) {
            if (room.getNorthRoom().equals(room1)) {
                goToInitGameScreen();
            } else if (room.getNorthRoom().equals(room2)) {
                goToRoom2();
            } else if (room.getNorthRoom().equals(room3)) {
                goToRoom3();
            } else if (room.getNorthRoom().equals(room4)) {
                goToRoom4();
            } else if (room.getNorthRoom().equals(room5)) {
                goToRoom5();
            } else if (room.getNorthRoom().equals(room6)) {
                goToRoom6();
            } else if (room.getNorthRoom().equals(room7)) {
                goToRoom7();
            } else if (room.getNorthRoom().equals(room8)) {
                goToExitRoom();
            } else if (room.getNorthRoom().equals(challengeRoom1)) {
                goToChallengeRoom1();
            } else if (room.getNorthRoom().equals(challengeRoom2)) {
                goToChallengeRoom2();
            }
        } else {
            monsterHelper(room, "North");
        }

    }

    public void southExit(RoomSuperclass room) {
        if (room.getSouthRoom() != null) {
            if (room.getSouthRoom().equals(room1)) {
                goToInitGameScreen();
            } else if (room.getSouthRoom().equals(room2)) {
                goToRoom2();
            } else if (room.getSouthRoom().equals(room3)) {
                goToRoom3();
            } else if (room.getSouthRoom().equals(room4)) {
                goToRoom4();
            } else if (room.getSouthRoom().equals(room5)) {
                goToRoom5();
            } else if (room.getSouthRoom().equals(room6)) {
                goToRoom6();
            } else if (room.getSouthRoom().equals(room7)) {
                goToRoom7();
            } else if (room.getSouthRoom().equals(room8)) {
                goToExitRoom();
            } else if (room.getSouthRoom().equals(challengeRoom1)) {
                goToChallengeRoom1();
            } else if (room.getSouthRoom().equals(challengeRoom2)) {
                goToChallengeRoom2();
            }
        } else {
            monsterHelper(room, "South");
        }

    }

    public void westExit(RoomSuperclass room) {
        if (room.getWestRoom() != null) {
            if (room.getWestRoom().equals(room1)) {
                goToInitGameScreen();
            } else if (room.getWestRoom().equals(room2)) {
                goToRoom2();
            } else if (room.getWestRoom().equals(room3)) {
                goToRoom3();
            } else if (room.getWestRoom().equals(room4)) {
                goToRoom4();
            } else if (room.getWestRoom().equals(room5)) {
                goToRoom5();
            } else if (room.getWestRoom().equals(room6)) {
                goToRoom6();
            } else if (room.getWestRoom().equals(room7)) {
                goToRoom7();
            } else if (room.getWestRoom().equals(room8)) {
                goToExitRoom();
            } else if (room.getWestRoom().equals(challengeRoom1)) {
                goToChallengeRoom1();
            } else if (room.getWestRoom().equals(challengeRoom2)) {
                goToChallengeRoom2();
            }
        } else {
            monsterHelper(room, "West");
        }

    }

    public void eastExit(RoomSuperclass room) {
        if (room.getEastRoom() != null) {
            if (room.getEastRoom().equals(room1)) {
                goToInitGameScreen();
            } else if (room.getEastRoom().equals(room2)) {
                goToRoom2();
            } else if (room.getEastRoom().equals(room3)) {
                goToRoom3();
            } else if (room.getEastRoom().equals(room4)) {
                goToRoom4();
            } else if (room.getEastRoom().equals(room5)) {
                goToRoom5();
            } else if (room.getEastRoom().equals(room6)) {
                goToRoom6();
            } else if (room.getEastRoom().equals(room7)) {
                goToRoom7();
            } else if (room.getEastRoom().equals(room8)) {
                goToExitRoom();
            } else if (room.getEastRoom().equals(challengeRoom1)) {
                goToChallengeRoom1();
            } else if (room.getEastRoom().equals(challengeRoom2)) {
                goToChallengeRoom2();
            }
        } else {
            monsterHelper(room, "East");
        }

    }

    public static int getRandom(List<Integer> list) {
        Random rand = new Random();
        int randElement = rand.nextInt(list.size());
        return randElement;
    }

    public void goToRndRoom(RoomSuperclass room, String roomDirection) {
        if ((list.size() < 1) && (count == 0)) {
            count++;
            list.add(10);
        }
        if (room == room8) {
            endGameRoom.setResult("Congratulations!");
            goToEndGameScreen();
        } else {
            rndNum = getRandom(list);
            if (list.get(rndNum) == 10) {
                randRoom = room8;
                list.remove(rndNum);
                rndRoomHelper(room, room8, roomDirection);
                goToExitRoom();
            } else if (list.get(rndNum) == 2) {
                randRoom = room2;
                list.remove(rndNum);
                rndRoomHelper(room, room2, roomDirection);
                goToRoom2();
            } else if (list.get(rndNum) == 3) {
                randRoom = room3;
                list.remove(rndNum);
                rndRoomHelper(room, room3, roomDirection);
                goToRoom3();
            } else if (list.get(rndNum) == 4) {
                randRoom = room4;
                list.remove(rndNum);
                rndRoomHelper(room, room4, roomDirection);
                goToRoom4();
            } else if (list.get(rndNum) == 5) {
                randRoom = room5;
                list.remove(rndNum);
                rndRoomHelper(room, room5, roomDirection);
                goToRoom5();
            } else if (list.get(rndNum) == 6) {
                randRoom = room6;
                list.remove(rndNum);
                rndRoomHelper(room, room6, roomDirection);
                goToRoom6();
            } else if (list.get(rndNum) == 7) {
                randRoom = room7;
                list.remove(rndNum);
                rndRoomHelper(room, room7, roomDirection);
                goToRoom7();
            } else if (list.get(rndNum) == 8) {
                randRoom = challengeRoom1;
                list.remove(rndNum);
                rndRoomHelper(room, challengeRoom1, roomDirection);
                goToChallengeRoom1();
            } else if (list.get(rndNum) == 9) {
                randRoom = challengeRoom2;
                list.remove(rndNum);
                rndRoomHelper(room, challengeRoom2, roomDirection);
                goToChallengeRoom2();
            }
        }
    }

    public void rndRoomHelper(RoomSuperclass roomStart, RoomSuperclass roomEnd, String direction) {
        if (direction.equals("North")) {
            roomStart.setNorthRoom(roomEnd);
            roomEnd.setSouthRoom(roomStart);
        } else if (direction.equals("South")) {
            roomStart.setSouthRoom(roomEnd);
            roomEnd.setNorthRoom(roomStart);
        } else if (direction.equals("West")) {
            roomStart.setWestRoom(roomEnd);
            roomEnd.setEastRoom(roomStart);
        } else if (direction.equals("East")) {
            roomStart.setEastRoom(roomEnd);
            roomEnd.setWestRoom(roomStart);
        }
    }

    public boolean getMonsterDefeated() {
        return monsterDefeated;
    }

    public int getTotalDamage() {
        return totalDamage;
    }
    public int getMonstersKilled() {
        return  monstersKilled;
    }


    public static void main(String[] args) {
        launch(args);
    }
}