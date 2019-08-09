package com.wrike;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class WrikeSurveyPage {
    private WebElement content;
    private List<WebElement> buttons;
    private WebElement submitButton;
    private List<WebElement> icons;
    private String type;

    public WrikeSurveyPage(){

    }

    public void WrikeSurveyPageA(WebDriver driver) {
        this.type="a";
        this.content = driver.findElement(By.xpath("/html"));
        this.buttons = content.findElements(By.className("switch__button"));
        this.submitButton = content.findElement(By.className("js-survey-submit"));
        this.icons = content.findElements(By.className("wg-footer__social-icon"));
    }

    public void WrikeSurveyPageB(WebDriver driver) {
        this.type="b";
        this.content = driver.findElement(By.xpath("/html"));
        this.buttons = content.findElements(By.className("survey-question-radio__button"));
        this.submitButton =content.findElement(By.className("survey__submit"));
        this.icons = content.findElements(By.className("wg-footer__social-icon"));
    }

    public void chooseOptionA(int buttonIndex) {
       buttons.get(buttonIndex).click();
       if (buttonIndex == 9){
           WebElement form = content.findElement(By.className("switch__input"));
           form.sendKeys(getRandomComment());
       }
    }

    public void chooseOption(int buttonIndex) {
        if (type.equals("a")) {
            chooseOptionA(buttonIndex);
        }
        else {
            chooseOptionB(buttonIndex);
        }
    }

    public void chooseOptionB(int buttonIndex) {
        buttons.get(buttonIndex).click();
        if (buttonIndex == 9){
            WebElement form = content.findElement(By.className("survey-question-radio__other-input"));
            form.sendKeys(getRandomComment());
        }
    }

    public void checkImageLink(){
        WebElement twitter = content.findElement(By.cssSelector("[href=\"https://twitter.com/wrike\"]"));
        Assert.assertTrue(twitter.getAttribute("href").equals("https://twitter.com/wrike"));
    }

    public void checkIconImage(int iconIndex) {
        String path = icons.get(iconIndex).getAttribute("innerHTML");
        String checkPath = "<use xlink:href=\"/content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg?v2#twitter\"></use>";
        Assert.assertTrue(path.toLowerCase().contains(checkPath.toLowerCase()));
    }
    public void submit() {
        submitButton.click();
    }

    static String getRandomComment() {

        Random rand = new Random();

        int number = rand.nextInt(12);

        number += 1;

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(number);

        for (int i = 0; i < number; i++) {

            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

}
