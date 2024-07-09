package config;

public class Configuration {
    private static final DataManager dataManager = new DataManager("src/test/resources/config.json");

    private Configuration() {
    }

    public static String getUrl(){
        return (String) dataManager.getParser().get("basePage");
    }

    public static String getPathToCsvFile(){
        return (String) dataManager.getParser().get("pathToFile");
    }

    public static String getUrlForGrid(){
        return (String) dataManager.getParser().get("urlForGrid");
    }
    public static String getChromeVersionForGrid(){
        return (String) dataManager.getParser().get("chromeVersionForGrid");
    }

    public static String getPlatformNameForGrid(){
        return (String) dataManager.getParser().get("platformNameForGrid");
    }
}
