package pages;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class LoginPage {
    public TextBox emailTxt = new TextBox(By.id("emailOrPhone"));
    public TextBox pwdTxt = new TextBox(By.id("password"));
    public Button loginButton = new Button(By.xpath("//button[text()='Sign In']"));

}