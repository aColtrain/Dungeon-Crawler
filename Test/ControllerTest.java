import controller.Controller;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import static org.testfx.api.FxAssert.verifyThat;

public class ControllerTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        Controller controller = new Controller();
        controller.start(stage);
    }

    @Test
    public void testStartGame() {
        clickOn("Start Game");
        verifyThat("Please enter your name.", NodeMatchers.isNotNull());
        verifyThat("Choose level difficulty", NodeMatchers.isNotNull());
        verifyThat("Choose your weapon", NodeMatchers.isNotNull());
        verifyThat("Next", NodeMatchers.isNotNull());

    }

    @Test
    public void testNameEmpty() {
        clickOn("Start Game");
        clickOn("Next");
        verifyThat("Please enter a valid name.", NodeMatchers.isEnabled());
    }

    @Test
    public void testNameEmptySpaces() {
        clickOn("Start Game");
        write("    ");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Sword");
        clickOn("Next");
        clickOn("Next");
        verifyThat("Please enter a valid name.", NodeMatchers.isEnabled());
    }

    @Test
    public void testLevelDif() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose your weapon");
        clickOn("Axe");
        clickOn("Next");
        verifyThat("Please select a difficulty.", NodeMatchers.isEnabled());
    }

    @Test
    public void testWeapons() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Next");
        verifyThat("Please select a weapon.", NodeMatchers.isEnabled());
    }

    @Test
    public void testInitGameScreen() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        verifyThat("North Exit", NodeMatchers.isNotNull());
    }

    @Test
    public void testEasyMoney() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Sword");
        clickOn("Next");
        verifyThat("Money: $100", NodeMatchers.isNotNull());
    }

    @Test
    public void testMediumMoney() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Medium");
        clickOn("Choose your weapon");
        clickOn("Sword");
        clickOn("Next");
        verifyThat("Money: $50", NodeMatchers.isNotNull());
    }

    @Test
    public void testDifficultMoney() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Difficult");
        clickOn("Choose your weapon");
        clickOn("Sword");
        clickOn("Next");
        verifyThat("Money: $25", NodeMatchers.isNotNull());
    }

    @Test
    public void testNorthExit() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Difficult");
        clickOn("Choose your weapon");
        clickOn("Sword");
        clickOn("Next");
        verifyThat("North Exit", NodeMatchers.isNotNull());
        verifyThat("South Exit", NodeMatchers.isNotNull());
        verifyThat("West Exit", NodeMatchers.isNotNull());
        verifyThat("East Exit", NodeMatchers.isNotNull());
    }




}
