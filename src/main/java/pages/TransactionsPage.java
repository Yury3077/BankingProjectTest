package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import  utils.ParseDateTime;

import java.util.ArrayList;
import java.util.List;

public class TransactionsPage extends Form {
    private final IElement transactionsTable = AqualityServices.getElementFactory()
            .getTextBox(By.xpath("//table[@class='table table-bordered table-striped']//tbody"), "Table with transactions");
    private final IElement transactionsTableHead = AqualityServices.getElementFactory()
            .getTextBox(By.xpath("//table[@class='table table-bordered table-striped']//thead/tr"), "Table with transactions");

    public TransactionsPage() {
        super(By.xpath("//*[@class='table table-bordered table-striped']"),
                "Transaction page checking");
    }

    @Step("Getting table with data")
    public List<String> getTableRows () {
        ArrayList<String> dataTable = new ArrayList<>();
        List<ITextBox> allRows = transactionsTable.findChildElements(By.tagName("tr"), ElementType.TEXTBOX);
        for (ITextBox e : allRows) {
            dataTable.add(e.getText());
        }
        return dataTable;
    }

    @Step("Getting head of table for .csv file")
    public ArrayList<String> getTableHeadForCsv() {
        ArrayList<String> dataTableHead = new ArrayList<>();
        List<ITextBox> namesOfColons = transactionsTableHead.findChildElements(By.tagName("td"), ElementType.TEXTBOX);
        for (ITextBox colonName : namesOfColons) {
            dataTableHead.add(colonName.getText());
        }
        return dataTableHead;
    }

    @Step("Getting table data for .csv file")
    public ArrayList<String> getTableRowsForCsv () {
        ArrayList<String> dataTable = new ArrayList<>();
        List<ITextBox> allRows = transactionsTable.findChildElements(By.tagName("tr"), ElementType.TEXTBOX);
        for (ITextBox trElement : allRows) {
            List<ITextBox> separateRow = trElement.findChildElements(By.tagName("td"), ElementType.TEXTBOX);
            ArrayList<String> rowData = new ArrayList<>();
            for (ITextBox tdElement : separateRow)
                if (tdElement.getText().contains("AM") || tdElement.getText().contains("PM")) {
                    String data = ParseDateTime.parseDateForCsvFile(tdElement.getText());
                    rowData.add(data);
                }
                else {
                    rowData.add(tdElement.getText());
                }
            dataTable.add(String.join(",", rowData) + "\n");
        }
        return dataTable;
    }
}
