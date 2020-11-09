import org.testng.annotations.Test;

import java.io.IOException;

public class MyScenarios extends TestBase {

    @Test
    public void laptopPurchaseScenario() throws IOException {
        PageObject.purchaseProduct();
    }
}
