package geoorg.config;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverUtil {

    private static final Logger LOGGER = Logger.getLogger(DriverUtil.class);

    private DriverUtil() {
    }

    private static WebDriver CHROME_DRIVER;

    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROME_EXE_PATH = "src\\main\\resources\\drivers\\chromedriver.exe";

    public final static WebDriver getChromeDriver() {
        if (CHROME_DRIVER == null) {

            System.setProperty(WEBDRIVER_CHROME_DRIVER, CHROME_EXE_PATH);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");

            CHROME_DRIVER = new ChromeDriver(options);
        }
        return CHROME_DRIVER;
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                LOGGER.info("Shutting down after tests");

                CHROME_DRIVER.quit();
            }
        }));
    }

}
