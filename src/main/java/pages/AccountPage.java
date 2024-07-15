package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AccountPage extends Form{
    private final IButton depositButton = AqualityServices.getElementFactory()
            .getButton(By.xpath("//*[@ng-click='deposit()']"), "Deposit button");
    private final IButton withdrawlButton = AqualityServices.getElementFactory()
            .getButton(By.xpath("//*[@ng-click='withdrawl()']"), "Withdrawl button");
    private final IButton submitButton = AqualityServices.getElementFactory()
            .getButton(By.xpath("//*[@type='submit']"), "Submit button");
    private final ITextBox depositSuccessElement = AqualityServices.getElementFactory()
            .getTextBox(By.xpath("//*[@ng-show='message']"), "Submit button");
    private final ITextBox inputBox = AqualityServices.getElementFactory()
            .getTextBox(By.xpath("//input[@type='number']"),
                    "Amount to be deposited box");
    private final ITextBox withdrawlInputBox = AqualityServices.getElementFactory()
            .getTextBox(By.xpath("//input[@placeholder='amount']"),
                    "Amount to be deposited or withdrawl  box");
    private final ITextBox balanceText = AqualityServices.getElementFactory()
            .getTextBox(By.xpath("//*[@class='ng-binding'][2]"), "Balance text field");
    private final IButton transactionsButton = AqualityServices.getElementFactory()
            .getButton(By.xpath("//*[@ng-click='transactions()']"), "Transactions button");

    public AccountPage() {
        super(By.xpath("//*[@id='accountSelect']"), "Account page checking");
    }

    @Step("Click deposit button")
    public void clickDepositButton () {
        depositButton.click();
    }

    @Step("Fill in amount to deposit")
    public void amountToDeposit (int amount) {
        inputBox.clearAndType(String.valueOf(amount));
    }

    @Step("Fill in amount to withdrawl")
    public void amountToWithdrawl (int amount) {
        withdrawlInputBox.state().waitForDisplayed();
        withdrawlInputBox.clearAndType(String.valueOf(amount));
    }

    @Step("Click submit button")
    public void clickSubmitButton () {
        submitButton.state().waitForDisplayed();
        submitButton.click();
    }

    @Step("Getting text after click deposit")
    public String getTextAfterDeposit(){
        depositSuccessElement.state().waitForDisplayed();
        return depositSuccessElement.getText();
    }

    @Step("Click withdrawl button")
    public void clickWithdrawlButton () {
        withdrawlButton.click();
    }

    @Step("Click get balance button")
    public String getBalance() {
        return balanceText.getText();
    }

    @Step("Click transactions button")
    public void  clickTransactionsButton() {
        transactionsButton.click();
    }
}
