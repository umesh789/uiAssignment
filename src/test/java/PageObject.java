import Utility.PropertyUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class PageObject extends TestBase {
    public static void purchaseProduct() throws IOException {
        DriverManager.launchBrowser();
        driver.get(Application_URL);
        driver.findElement(By.xpath(PropertyUtil.getLocator("laptop_link"))).click();
        driver.findElement(By.xpath(PropertyUtil.getLocator("Sony_vaio_i5_link"))).click();
        driver.findElement(By.xpath(PropertyUtil.getLocator("Add_to_cart_Link"))).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        goToHomePage();
        addDellLaptopToCart();
        goToCartPage();
        selectItemToDelet("Dell i7 8gb");
        driver.findElement(By.xpath(PropertyUtil.getLocator("Place_Order_Button"))).click();
        fillOrderForm();
        getResult();
        driver.quit();
    }

    public static void addDellLaptopToCart() throws IOException {
        driver.findElement(By.xpath(PropertyUtil.getLocator("laptop_link"))).click();
        driver.findElement(By.xpath(PropertyUtil.getLocator("Dell_I7_8GB_link"))).click();
        driver.findElement(By.xpath(PropertyUtil.getLocator("Add_to_cart_Link"))).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

    }

    public static void goToHomePage() throws IOException {
        driver.findElement(By.xpath(PropertyUtil.getLocator("Home_Page_Link"))).click();
    }

    public static void goToCartPage() throws IOException {
        driver.findElement(By.xpath(PropertyUtil.getLocator("Home_Page_Cart_link"))).click();
    }

    public static void selectItemToDelet(String itemName) throws IOException {
        List<WebElement> cartItems = driver.findElements(By.xpath(PropertyUtil.getLocator("Added_Item_Table_List")));
        for (WebElement ele : cartItems) {
            String item = ele.getText();
            // once date is 28 then click and break
            if (item.equalsIgnoreCase(itemName)) {
                driver.findElement(By.xpath(PropertyUtil.getLocator("Click_ON_Delete_Link"))).click();
                break;
            }
        }
    }

    public static void getResult() throws IOException {
        WebElement item = driver.findElement(By.xpath(PropertyUtil.getLocator("Place_Order_Result")));
        String output = item.getText();
        System.out.println("Output=" + output);
        driver.findElement(By.xpath(PropertyUtil.getLocator("OK_button"))).click();
    }

    public static void fillOrderForm() throws IOException {
        driver.findElement(By.xpath(PropertyUtil.getLocator("Place_Order_Name_Input"))).sendKeys("name");
        driver.findElement(By.xpath(PropertyUtil.getLocator("Place_Order_Country_Input"))).sendKeys("ncountryame");
        driver.findElement(By.xpath(PropertyUtil.getLocator("Place_Order_City_Input"))).sendKeys("city");
        driver.findElement(By.xpath(PropertyUtil.getLocator("Place_Order_Card_Input"))).sendKeys("card");
        driver.findElement(By.xpath(PropertyUtil.getLocator("Place_Order_month_Input"))).sendKeys("10");
        driver.findElement(By.xpath(PropertyUtil.getLocator("Place_Order_year_Input"))).sendKeys("2020");
        driver.findElement(By.xpath(PropertyUtil.getLocator("Place_Order_Purchase_Button"))).click();
    }

}
