import controller.Controller;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.testfx.api.FxAssert.verifyThat;

public class ControllerTest2 extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        Controller controller = new Controller();
        controller.start(stage);
    }
    /**
     Test ideas:
     check that there are 8 rooms
     exit is 6 rooms away
     win screen works
     maze layout changes
     maze layout is fixed
     **/

    @Test
    public void testNumOfRooms() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        for (int x = 0; x < 7; x++) {
            clickOn("East Exit");
        }
        verifyThat("Exit Room", NodeMatchers.isNotNull());
    }

    @Test
    public void testWinScreenExit1() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        for (int x = 0; x < 8; x++) {
            clickOn("East Exit");
        }
        verifyThat("Congratulations!", NodeMatchers.isNotNull());
    }

    @Test
    public void testWinScreenExit2() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        for (int x = 0; x < 8; x++) {
            clickOn("West Exit");
        }
        verifyThat("Congratulations!", NodeMatchers.isNotNull());
    }

    @Test
    public void testWinScreenExit3() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        for (int x = 0; x < 8; x++) {
            clickOn("North Exit");
        }
        verifyThat("Congratulations!", NodeMatchers.isNotNull());
    }

    @Test
    public void testWinScreenExit4() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        for (int x = 0; x < 8; x++) {
            clickOn("South Exit");
        }
        verifyThat("Congratulations!", NodeMatchers.isNotNull());
    }

    @Test
    public void startExitsBlocked() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        clickOn("East Exit");
        clickOn("West Exit");
        clickOn("North Exit");
        verifyThat("Money: $100", NodeMatchers.isNotNull());
        clickOn("South Exit");
        verifyThat("Money: $100", NodeMatchers.isNotNull());
        clickOn("West Exit");
        verifyThat("Money: $100", NodeMatchers.isNotNull());
    }

    @Test
    public void startNorthExit() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        clickOn("North Exit");
        int roomNum = roomNumHelper();
        verifyThat("Room " + roomNum, NodeMatchers.isNotNull());
    }

    @Test
    public void startSouthExit() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        clickOn("South Exit");
        int roomNum = roomNumHelper();
        verifyThat("Room " + roomNum, NodeMatchers.isNotNull());
    }

    @Test
    public void startWestExit() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        clickOn("West Exit");
        int roomNum = roomNumHelper();
        verifyThat("Room " + roomNum, NodeMatchers.isNotNull());
    }

    @Test
    public void northSouthExitsBlocked() {
        int roomNum;
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        clickOn("East Exit");
        for (int i = 0; i < 6; i++) {
            roomNum = roomNumHelper();
            clickOn("East Exit");
            clickOn("West Exit");
            clickOn("North Exit");
            verifyThat("Room " + roomNum, NodeMatchers.isNotNull());
            clickOn("South Exit");
            verifyThat("Room " + roomNum, NodeMatchers.isNotNull());
            clickOn("East Exit");
        }
    }

    @Test
    public void eastWestExitsBlocked() {
        int roomNum;
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        clickOn("North Exit");
        for (int i = 0; i < 6; i++) {
            roomNum = roomNumHelper();
            clickOn("North Exit");
            clickOn("South Exit");
            clickOn("East Exit");
            verifyThat("Room " + roomNum, NodeMatchers.isNotNull());
            clickOn("West Exit");
            verifyThat("Room " + roomNum, NodeMatchers.isNotNull());
            clickOn("North Exit");
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

    @Test
    public void randomization1() {
        int roomNum;
        List<Integer> run1 = new ArrayList<>();

        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        for (int x = 0; x < 6; x++) {
            clickOn("East Exit");
            roomNum = roomNumHelper();
            run1.add(roomNum);
        }
        System.out.println(run1);
    }

    @Test
    public void randomization2() {
        int roomNum;
        List<Integer> run2 = new ArrayList<>();

        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        for (int x = 0; x < 6; x++) {
            clickOn("East Exit");
            roomNum = roomNumHelper();
            run2.add(roomNum);
        }
        System.out.println(run2);

    }

    @Test
    public void mazeLayoutFixed() {
        int room1;
        int room2;
        int room3;
        int room4;
        int room5;
        int room6;
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        clickOn("North Exit");
        room1 = roomNumHelper();
        clickOn("East Exit");
        room2 = roomNumHelper();
        clickOn("North Exit");
        room3 = roomNumHelper();
        clickOn("East Exit");
        room4 = roomNumHelper();
        clickOn("South Exit");
        room5 = roomNumHelper();
        clickOn("West Exit");
        room6 = roomNumHelper();
        clickOn("South Exit");
        clickOn("North Exit");
        verifyThat("Room " + room6, NodeMatchers.isNotNull());
        clickOn("East Exit");
        verifyThat("Room " + room5, NodeMatchers.isNotNull());
        clickOn("North Exit");
        verifyThat("Room " + room4, NodeMatchers.isNotNull());
        clickOn("West Exit");
        verifyThat("Room " + room3, NodeMatchers.isNotNull());
        clickOn("South Exit");
        verifyThat("Room " + room2, NodeMatchers.isNotNull());
        clickOn("West Exit");
        verifyThat("Room " + room1, NodeMatchers.isNotNull());
        clickOn("South Exit");
        verifyThat("Money: $100", NodeMatchers.isNotNull());
    }





}