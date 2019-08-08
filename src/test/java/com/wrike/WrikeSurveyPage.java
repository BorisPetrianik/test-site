package com.wrike;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WrikeSurveyPage {
    private WebElement content;
    private List<WebElement> buttons;
    private WebElement submitButton;

    public WrikeSurveyPage(){

    }

    public void WrikeSurveyPageA(WebDriver driver) {
        this.content = driver.findElement(By.xpath("/html"));
        this.buttons = content.findElements(By.className("switch__button"));
        this.submitButton = content.findElement(By.className("js-survey-submit"));
    }

    public void WrikeSurveyPageB(WebDriver driver) {
        this.content = driver.findElement(By.xpath("/html"));
        this.buttons = content.findElements(By.className("survey-question-radio__button"));
        this.submitButton = content.findElement(By.cssSelector("body > div.wg-layout.wg-layout--outline > main > div > div > div > div.resend-page__cell--form > div > form > button"));
    }

    public void chooseOption(int buttonIndex) {
       buttons.get(buttonIndex).click();
    }
    public void submit() {
        submitButton.click();
    }
}
