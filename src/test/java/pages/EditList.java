package pages;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;
public class EditList {
    public TextBox editTextBox = new TextBox(By.id("edit-project-name"));
    public Button saveEditText = new Button(By.xpath("//button[text()='Save']"));
}
