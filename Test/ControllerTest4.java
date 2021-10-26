import controller.Controller;
import javafx.stage.Stage;
import org.junit.Test;
import org.junit.Assert;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;


import java.util.ArrayList;
import java.util.List;
import static org.testfx.api.FxAssert.verifyThat;

public class ControllerTest4 extends ApplicationTest {
    @Override
    public void start(Stage stage) throws Exception {
        Controller controller = new Controller();
        controller.start(stage);
    }
    @Test
    public void testMonster1StartHP() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        verifyThat("Monster 1 HP: 100", NodeMatchers.isEnabled());
    }
    @Test
    public void testMonster2StartHP() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        verifyThat("Monster 2 HP: 100", NodeMatchers.isEnabled());
    }
    @Test
    public void testMonster3StartHP() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        verifyThat("Monster 3 HP: 100", NodeMatchers.isEnabled());
    }
    @Test
    public void testPlayerStartHP() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        verifyThat("Player HP: 100", NodeMatchers.isEnabled());
    }
    @Test
    public void testPlayerHPDecrease() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        clickOn("West Exit");
        clickOn("Attack!");
        verifyThat("Player HP: 99", NodeMatchers.isEnabled());
        clickOn("Attack!");
        verifyThat("Player HP: 98", NodeMatchers.isEnabled());
    }
    @Test
    public void testAttackExists() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        clickOn("West Exit");
        clickOn("Attack!");
        verifyThat("Attack!", NodeMatchers.isEnabled());
    }
    @Test
    public void testRoom2AttackMonster() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        clickOn("North Exit");
        if (roomNumHelper() == 2) {
            clickOn("Attack!");
            verifyThat("Monster 1 HP: 60", NodeMatchers.isEnabled());
            verifyThat("Player HP: 99", NodeMatchers.isEnabled());
        } else {
        verifyThat("Player HP: 100", NodeMatchers.isEnabled());
        }
    }
    @Test
    public void testRoom3AttackMonster() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        clickOn("North Exit");
        if (roomNumHelper() == 3) {
            clickOn("Attack!");
            verifyThat("Monster 2 HP: 70", NodeMatchers.isEnabled());
            verifyThat("Player HP: 99", NodeMatchers.isNotNull());
        } else {
            verifyThat("Player HP: 100", NodeMatchers.isNotNull());
        }
    }
    @Test
    public void testRoom4AttackMonster() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        clickOn("North Exit");
        if (roomNumHelper() == 4) {
            clickOn("Attack!");
            verifyThat("Monster 3 HP: 80", NodeMatchers.isEnabled());
            verifyThat("Player HP: 99", NodeMatchers.isNotNull());
        } else {
            verifyThat("Player HP: 100", NodeMatchers.isNotNull());
        }
    }
    @Test
    public void testRoom5AttackMonster() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        clickOn("North Exit");

        if (roomNumHelper() == 5) {
            clickOn("Attack!");
            verifyThat("Monster 1 HP: 60", NodeMatchers.isEnabled());
            verifyThat("Player HP: 99", NodeMatchers.isNotNull());
        } else {
            verifyThat("Player HP: 100", NodeMatchers.isNotNull());
        }
    }
    @Test
    public void testRoom6AttackMonster() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        clickOn("North Exit");
        if (roomNumHelper() == 6) {
            clickOn("Attack!");
            verifyThat("Monster 1 HP: 60", NodeMatchers.isEnabled());
            verifyThat("Player HP: 99", NodeMatchers.isNotNull());
        } else {
            verifyThat("Player HP: 100", NodeMatchers.isNotNull());
        }
    }
    @Test
    public void testRoom7AttackMonster() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        clickOn("North Exit");
        if (roomNumHelper() == 7) {
            clickOn("Attack!");
            verifyThat("Monster 2 HP: 70", NodeMatchers.isEnabled());
            verifyThat("Player HP: 99", NodeMatchers.isNotNull());
        } else {
            verifyThat("Player HP: 100", NodeMatchers.isNotNull());
        }
    }

    public int roomNumHelper() {
        int x = 0;
        for (int i = 0; i < 6; i++) {
            try {
                verifyThat("Room 2", NodeMatchers.isNotNull());
                break;
            } catch (Exception e) {
                x++;
            }
            try {
                verifyThat("Room 3", NodeMatchers.isNotNull());
                break;
            } catch (Exception e) {
                x++;
            }
            try {
                verifyThat("Room 4", NodeMatchers.isNotNull());
                break;
            } catch (Exception e) {
                x++;
            }
            try {
                verifyThat("Room 5", NodeMatchers.isNotNull());
                break;
            } catch (Exception e) {
                x++;
            }
            try {
                verifyThat("Room 6", NodeMatchers.isNotNull());
                break;
            } catch (Exception e) {
                x++;
            }
            try {
                verifyThat("Room 7", NodeMatchers.isNotNull());
                break;
            } catch (Exception e) {
                x++;
            }
        }
        int roomNum = 0;
        if (x == 0) {
            roomNum = 2;
        } else if (x == 1) {
            roomNum = 3;
        } else if (x == 2) {
            roomNum = 4;
        } else if (x == 3) {
            roomNum = 5;
        } else if (x == 4) {
            roomNum = 6;
        } else if (x == 5) {
            roomNum = 7;
        }
        return roomNum;
    }
}





