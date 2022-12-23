package control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

public class Frame extends Control{
    public Frame(By locator) {
        super(locator);
    }

    public void switchFrame(String nameFrame){
        WebElement frameElementEmail = Session.getInstance().getBrowser().findElement(By.id(nameFrame));
        Session.getInstance().getBrowser().switchTo().frame(frameElementEmail);
    }

    public void switchDefaultFrame(){
        Session.getInstance().getBrowser().switchTo().defaultContent();
    }
}
