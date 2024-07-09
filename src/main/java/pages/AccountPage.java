package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
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

    public void clickDepositButton () {
        depositButton.click();
    }

    public void amountToDeposit (int amount) {
        inputBox.clearAndType(String.valueOf(amount));
    }

    public void amountToWithdrawl (int amount) throws InterruptedException {
        withdrawlInputBox.clearAndType(String.valueOf(amount));
    }

    public void clickSubmitButton () throws InterruptedException {
        submitButton.click();
    }

    public String getTextAfterDeposit(){
        return depositSuccessElement.getText();
    }

    public void clickWithdrawlButton () {
        withdrawlButton.click();
    }

    public String getBalance() {
        return balanceText.getText();
    }

    public void  clickTransactionsButton() {
        transactionsButton.click();
    }
}
