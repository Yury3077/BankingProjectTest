package config;

public class TestDataConfiguration {
    private static final DataManager dataManager = new DataManager("src/test/resources/data.json");

    private TestDataConfiguration() {
    }

    public static String getCustomerName() {
        return (String) dataManager.getParser().get("customer_name");
    }

    public static String getDepositText() {
        return (String) dataManager.getParser().get("deposit_text");
    }

    public static String getWithdrawnText() {
        return (String) dataManager.getParser().get("withdrawn_text");
    }

    public static String getBalanceAfterTransactions() {
        return (String) dataManager.getParser().get("balance_after_transactions");
    }

    public static String getDepositTableText() {
        return (String) dataManager.getParser().get("deposit_table_text");
    }

    public static String getWithdrawnTableText() {
        return (String) dataManager.getParser().get("withdrawn_table_text");
    }
}
