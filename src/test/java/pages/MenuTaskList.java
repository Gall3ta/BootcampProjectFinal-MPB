package pages;

import control.Button;
import org.openqa.selenium.By;

public class MenuTaskList {
    public Button textEdit = new Button(By.xpath("//*[text()='Edit']"));
    public Button textDelete = new Button(By.xpath("//*[text()='Delete']"));
    public Button buttonMeatball(String nameTaskList) {
        Button buttonAddList = new Button(By.xpath("//p[text()='"+nameTaskList+"']/following-sibling::div//div//*[local-name() = 'svg' and @class='icon-more-for-folder w-[18px] h-[18px] hover:text-sidebar-color text-sidebar-color-40 ']"));
        return buttonAddList;
    }
}
