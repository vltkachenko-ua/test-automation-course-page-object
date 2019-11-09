package tests.Homework4;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import tests.BaseTest;

import java.util.List;

public class AddNewCountryTest extends BaseTest {

    @Test
    public void arrowIconTest() {
        List<WebElement> arrowIcons = app.getAllArrowIconOnAddNewCountryPage();

        for (int i = 0; i < arrowIcons.size(); i++) {
            arrowIcons.get(i).click();
            Assert.assertTrue("New window is not opened", app.waitForNewWindow());
        }

    }

}
