package config;

public class TestDataConfiguration {
    private static final DataManager dataManager = new DataManager("src/test/resources/data.json");

    private TestDataConfiguration() {
    }

    public static String getCustomerName() {
        return (String) dataManager.getParser().get("customer_name");
    }
}
