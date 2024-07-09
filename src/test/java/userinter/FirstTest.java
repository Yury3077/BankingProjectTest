package userinter;

import config.TestDataConfiguration;
import config.Configuration;
import logger.MyLogger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StartBankPage;
import pages.CustomChoosePage;
import pages.AccountPage;
import pages.TransactionsPage;
import utils.GetFibonachi;
import utils.CsvParser;

import java.io.IOException;

public class FirstTest extends BaseTest {
    private static final String SUCCESS_TEXT = "Deposit Successful";
    private static final String WITHDRAWN_TEXT = "Transaction successful";
    private static final String BALANCE_AFTER_TRANSACTIONS = "0";
    private static final String DEPOSIT_TABLE_TEXT = GetFibonachi.getNumber() + " " + "Credit";
    private static final String WITHDRAWN_TABLE_TEXT = GetFibonachi.getNumber() + " " + "Debit";
    private final MyLogger logger = MyLogger.getInstance();

    @Test
    public void bankServiceTest() throws InterruptedException, IOException {
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
        Assert.assertEquals(accountPage.getTextAfterDeposit(), SUCCESS_TEXT,
                "Message have to contain 'Deposit Successful'");
        accountPage.clickWithdrawlButton();
        Thread.sleep(100);
        accountPage.amountToWithdrawl(GetFibonachi.getNumber());
        Thread.sleep(100);
        accountPage.clickSubmitButton();
        Thread.sleep(100);
        Assert.assertEquals(accountPage.getTextAfterDeposit(), WITHDRAWN_TEXT,
                "Message have to contain 'Deposit Successful'");
        Assert.assertEquals(accountPage.getBalance(), BALANCE_AFTER_TRANSACTIONS);
        accountPage.clickTransactionsButton();

        TransactionsPage transactionsPage = new TransactionsPage();
        transactionsPage.state().waitForDisplayed();
        Assert.assertTrue(transactionsPage.state().isDisplayed(), "Transactions page should be opened");
        Assert.assertTrue(transactionsPage.getTableRows().stream().anyMatch(row -> row.contains(DEPOSIT_TABLE_TEXT)),
                "Table have to contains deposit transaction");
        Assert.assertTrue(transactionsPage.getTableRows().stream().anyMatch(row -> row.contains(WITHDRAWN_TABLE_TEXT)),
                "Table have to contains withdrawn transaction");
        CsvParser.createCsvFile(transactionsPage.getTableHeadForCsv(), transactionsPage.getTableRowsForCsv(),
                Configuration.getPathToCsvFile());
    }
}
