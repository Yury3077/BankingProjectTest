package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CustomChoosePage extends Form  {
    private final IComboBox chooseCustomerElem = AqualityServices.getElementFactory()
            .getComboBox(By.xpath("//*[@ng-model='custId']"), "Choose customer");
    private final IButton loginButton = AqualityServices.getElementFactory()
            .getButton(By.xpath("//*[@type='submit']"), "Login button");

    public CustomChoosePage() {
        super(By.xpath("//*[@ng-model='custId']"), "Choose customer page checking");
    }

    public void chooseCustomer (String customerName) {
        chooseCustomerElem.selectByContainingText(customerName);
        chooseCustomerElem.click();
    }

    public void clickLoginButton () {
        loginButton.click();
    }

}
