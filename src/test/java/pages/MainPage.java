package pages;


import control.Label;
import org.openqa.selenium.By;
public class MainPage {
    public Label inboxLabel = new Label(By.xpath("//h5[text()='Inbox']"));

}
