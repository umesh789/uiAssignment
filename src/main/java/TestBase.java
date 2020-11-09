import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
    protected static String Application_URL = null;
    public static WebDriver driver;
   // public static WebDriverWait wait= new WebDriverWait(driver, 20);
    static {
        try {
            Application_URL = "https://www.demoblaze.com/index.html";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
