package geoorg.pages;

import geoorg.config.DriverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHomePage {

    private static WebDriver webDriver = DriverUtil.getChromeDriver();

    public GoogleHomePage() {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(name = "q")
    private WebElement searchInput;

    @FindBy(id = "res")
    private WebElement resultsDiv;

    public void visitHomePage() {
        webDriver.get("https:\\www.google.com");
    }

    public void searchFor(final String term) {
        searchInput.sendKeys(term);
        searchInput.submit();
    }

    public void waitForResults() {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOf(resultsDiv));
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public void closeWindow() {
        webDriver.close();
    }
}
