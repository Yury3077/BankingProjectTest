package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class StartBankPage extends Form{
    private final IButton customerLogin = AqualityServices.getElementFactory()
            .getButton(By.xpath("//*[@ng-click='customer()']"), "Customer login button");

    public StartBankPage() {
        super(By.xpath("//*[@class='mainHeading']"), "Start page checking");
    }

    public void clickCustomerButton() {
        customerLogin.click();
    }
}
