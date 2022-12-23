package control;

import org.openqa.selenium.By;

public class TextArea extends Control{
    public TextArea(By locator){
        super(locator);
    }

    public void setText(String value){
        this.find();
        this.control.sendKeys(value);
    }

    public void cleanSetText(String value){
        this.find();
        this.control.clear();
        this.control.sendKeys(value);
    }
}