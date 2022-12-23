package pages;
import control.Button;
import control.Label;
import control.TextBox;
import org.openqa.selenium.By;

public class AddList {
    public Label titleAddList = new Label(By.xpath("//h1[text()='Add List']"));
    public TextBox nameTaskList = new TextBox(By.id("edit-project-name"));
    public Button saveList = new Button(By.xpath("//button[text()='Save']"));
}

