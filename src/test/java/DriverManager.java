import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverManager extends TestBase {

        public static void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "C://Users//umesh.j.kumar//git//ui_automation//ui_test_automation//driver//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}
