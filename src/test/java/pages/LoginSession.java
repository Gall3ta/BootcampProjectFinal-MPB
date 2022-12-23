package pages;

import control.Button;
import org.openqa.selenium.By;

public class LoginSession {
    public Button loginButton = new Button(By.xpath("//a[text()='Sign In']"));
}
