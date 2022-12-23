package pages;
import control.Button;
import org.openqa.selenium.By;

public class CreateTaskList {
    public Button buttonPlusAddList = new Button(By.xpath("//p[text()='Lists']/following-sibling::button//div//*[local-name() = 'svg' and @class='icon-list-add w-[18px] h-[18px] cursor-pointer transform text-sidebar-color-60 relative z-[1]']"));

}