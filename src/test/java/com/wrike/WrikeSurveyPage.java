package com.wrike;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WrikeSurveyPage {
    private WebElement content;
    private List<WebElement> buttons;
    private WebElement submitButton;

    public WrikeSurveyPage(WebDriver driver) {
        this.content = driver.findElement(By.xpath("/html"));
        this.buttons = content.findElements(By.className("switch__button"));
        this.submitButton = content.findElement(By.className("js-survey-submit"));
    }

    public void chooseOption(int buttonIndex) {
       buttons.get(buttonIndex).click();
    }

    public void submit() {
        submitButton.click();
    }
}
