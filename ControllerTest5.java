import controller.Controller;
import javafx.stage.Stage;
import org.junit.Test;
import org.junit.Assert;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import org.w3c.dom.Node;


import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import static org.testfx.api.FxAssert.verifyThat;

public class ControllerTest5 extends ApplicationTest {
    @Override
    public void start(Stage stage) throws Exception {
        Controller controller = new Controller();
        controller.start(stage);
    }
    @Test
    public void inventoryButtonTest() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        verifyThat("Inventory", NodeMatchers.isNotNull());
    }
    @Test
    public void weaponMatchAxeTest () {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Axe");
        clickOn("Next");
        clickOn("Inventory");
        verifyThat("Weapon: Axe", NodeMatchers.isNotNull());
        verifyThat("Axes: 1", NodeMatchers.isNotNull());
    }

    @Test
    public void weaponMatchShieldTest () {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        clickOn("Inventory");
        verifyThat("Weapon: Shield", NodeMatchers.isNotNull());
        verifyThat("Shields: 1", NodeMatchers.isNotNull());
    }

    @Test
    public void weaponMatchTorchTest () {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Torch");
        clickOn("Next");
        clickOn("Inventory");
        verifyThat("Weapon: Torch", NodeMatchers.isNotNull());
        verifyThat("Torches: 1", NodeMatchers.isNotNull());
    }

    @Test
    public void axeInventoryTest () {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Axe");
        clickOn("Next");
        clickOn("Inventory");
        verifyThat("Axes: 1", NodeMatchers.isNotNull());
    }

    @Test
    public void shieldInventoryTest () {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Shield");
        clickOn("Next");
        clickOn("Inventory");
        verifyThat("Shields: 1", NodeMatchers.isNotNull());
    }

    @Test
    public void inventoryWeaponsListTest () {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Axe");
        clickOn("Next");
        clickOn("Inventory");
        verifyThat("Sword: 0 Axes: 1 Shield: 0 Torch: 0 Bows and Arrow:0", NodeMatchers.isNotNull());
    }
    @Test
    public void buyHealthPotionButtonTest () {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Torch");
        clickOn("Next");
        clickOn("Inventory");
        verifyThat("Health Potion: 0", NodeMatchers.isNotNull());
        clickOn("Shop");
        clickOn("Buy Health Potion");
        clickOn("Inventory");
        verifyThat("Health Potions: 1", NodeMatchers.isNotNull());
    }
    @Test
    public void buyAttackPotionButtonTest () {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Torch");
        clickOn("Next");
        clickOn("Inventory");
        verifyThat("Attack Potion: 0", NodeMatchers.isNotNull());
        clickOn("Shop");
        clickOn("Buy Attack Potion");
        clickOn("Inventory");
        verifyThat("Attack Potions: 1", NodeMatchers.isNotNull());
    }
    @Test
    public void buySwordTest () {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Torch");
        clickOn("Next");
        clickOn("Inventory");
        verifyThat("Swords: 0", NodeMatchers.isNotNull());
        clickOn("Shop");
        clickOn("Buy Sword");
        clickOn("Inventory");
        verifyThat("Swords: 1", NodeMatchers.isNotNull());
    }
    @Test
    public void buyAxeTest () {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Torch");
        clickOn("Next");
        clickOn("Inventory");
        verifyThat("Axes: 0", NodeMatchers.isNotNull());
        clickOn("Shop");
        clickOn("Buy Axe");
        clickOn("Inventory");
        verifyThat("Axes: 1", NodeMatchers.isNotNull());
    }
    @Test
    public void buyShieldTest () {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Torch");
        clickOn("Next");
        clickOn("Inventory");
        verifyThat("Shields: 0", NodeMatchers.isNotNull());
        clickOn("Shop");
        clickOn("Buy Shield");
        clickOn("Inventory");
        verifyThat("Shields: 1", NodeMatchers.isNotNull());
    }
    @Test
    public void buyTorchTest () {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Torch");
        clickOn("Next");
        clickOn("Inventory");
        verifyThat("Torches: 1", NodeMatchers.isNotNull());
        clickOn("Shop");
        clickOn("Buy Torch");
        clickOn("Inventory");
        verifyThat("Torches: 2", NodeMatchers.isNotNull());
    }
    @Test
    public void buyBowAndArrowTest () {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Torch");
        clickOn("Next");
        clickOn("Inventory");
        verifyThat("Bow and Arrows: 0", NodeMatchers.isNotNull());
        clickOn("Shop");
        clickOn("Buy Bow and Arrow");
        clickOn("Inventory");
        verifyThat("Bow and Arrows: 1", NodeMatchers.isNotNull());
    }
    @Test
    public void inventoryShopTest() {
        clickOn("Start Game");
        write("Name");
        clickOn("Choose level difficulty");
        clickOn("Easy");
        clickOn("Choose your weapon");
        clickOn("Axe");
        clickOn("Next");
        clickOn("Inventory");
        verifyThat("Weapon: Axe", NodeMatchers.isNotNull());
        clickOn("Shop");
        verifyThat("Money: $100", NodeMatchers.isNotNull());
        clickOn("Inventory");
        verifyThat("Weapon: Axe", NodeMatchers.isNotNull());
    }









}
