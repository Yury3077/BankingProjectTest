package userinter;

import config.TestDataConfiguration;
import config.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StartBankPage;
import pages.CustomChoosePage;
import pages.AccountPage;
import pages.TransactionsPage;
import utils.GetFibonachi;
import utils.CsvParser;

public class FirstTest extends BaseTest {
    @Test(description = "This test is made for checking transactions in a web page and a csv file")
    public void bankServiceTest() {
        StartBankPage startBankPage = new StartBankPage();
        startBankPage.state().waitForDisplayed();
        Assert.assertTrue(startBankPage.state().isDisplayed(), "Main page should be opened");
        startBankPage.clickCustomerButton();

        CustomChoosePage customChoosePage = new CustomChoosePage();
        customChoosePage.state().waitForDisplayed();
        Assert.assertTrue(customChoosePage.state().isDisplayed(), "Customer page should be opened");
        customChoosePage.chooseCustomer(TestDataConfiguration.getCustomerName());
        customChoosePage.clickLoginButton();

        AccountPage accountPage = new AccountPage();
        accountPage.state().waitForDisplayed();
        Assert.assertTrue(accountPage.state().isDisplayed(), "Account page should be opened");
        accountPage.clickDepositButton();
        accountPage.amountToDeposit(GetFibonachi.getNumber());
        accountPage.clickSubmitButton();
        Assert.assertEquals(accountPage.getTextAfterDeposit(), TestDataConfiguration.getDepositText(),
                "Message have to contain 'Deposit Successful'");
        accountPage.clickWithdrawlButton();
        accountPage.amountToWithdrawl(GetFibonachi.getNumber());
        accountPage.clickSubmitButton();
        Assert.assertEquals(accountPage.getTextAfterDeposit(), TestDataConfiguration.getWithdrawnText(),
                "Message have to contain 'Deposit Successful'");
        Assert.assertEquals(accountPage.getBalance(), TestDataConfiguration.getBalanceAfterTransactions());
        accountPage.clickTransactionsButton();

        TransactionsPage transactionsPage = new TransactionsPage();
        transactionsPage.state().waitForDisplayed();
        Assert.assertTrue(transactionsPage.state().isDisplayed(), "Transactions page should be opened");
        Assert.assertTrue(transactionsPage.getTableRows().stream().anyMatch(row ->
                        row.contains(GetFibonachi.getNumber() + TestDataConfiguration.getDepositTableText())),
                "Table have to contains deposit transaction");
        Assert.assertTrue(transactionsPage.getTableRows().stream().anyMatch(row ->
                        row.contains(GetFibonachi.getNumber() + TestDataConfiguration.getWithdrawnTableText())),
                "Table have to contains withdrawn transaction");
        CsvParser.createCsvFile(transactionsPage.getTableHeadForCsv(), transactionsPage.getTableRowsForCsv(),
                Configuration.getPathToCsvFile());
    }
}
