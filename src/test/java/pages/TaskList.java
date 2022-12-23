package pages;

import control.Label;
import org.openqa.selenium.By;

public class TaskList {

    public Label labelTask(String nameTaskList) {
        Label labelName = new Label(By.xpath(" //p[text()='"+nameTaskList+"' and @class='text-s font-normal flex-auto truncate leading-[20px] text-grey']"));
        return labelName;
    }
}