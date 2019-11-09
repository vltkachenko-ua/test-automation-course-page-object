package pages;

import data.ApplicationContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminLoginPage extends Page {

    @FindBy(name = "username")
    private WebElement usernameElement;
    @FindBy(name = "password")
    private WebElement passwordElement;
    @FindBy(css = "button.btn.btn-default")
    private WebElement loginElement;


    public AdminLoginPage(ApplicationContext apContext) {
        super(apContext);
        PageFactory.initElements(driver, this);
    }

    public AdminLoginPage open() {
        driver.get(baseUrl + "/admin");

        if (isOnThisPage()) {
            this
                    .enterUsername(appContext.getAdmin().getLogin())
                    .enterPassword(appContext.getAdmin().getPassword())
                    .submitLogin();
        }

        return this;
    }

    public boolean isOnThisPage() {
        return driver.findElements(By.id("box-login")).size() > 0;
    }

    public AdminLoginPage enterUsername(String username) {
        usernameElement.clear();
        usernameElement.sendKeys(username);
        return this;
    }

    public AdminLoginPage enterPassword(String password) {
        passwordElement.clear();
        passwordElement.sendKeys(password);
        return this;
    }

    public void submitLogin() {
        loginElement.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("notices")));
    }
}
