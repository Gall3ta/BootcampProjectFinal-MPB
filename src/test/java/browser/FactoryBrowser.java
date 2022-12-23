package browser;

public class FactoryBrowser {
    public static IBrowser make(String browserType){
        IBrowser browser;
        switch (browserType){
            case "chrome":
                browser = new Chrome();
                break;
            case "headless":
                browser = new Headless();
                break;
            default:
                browser = new Firefox();
                break;
        }
        return browser;
    }
}
