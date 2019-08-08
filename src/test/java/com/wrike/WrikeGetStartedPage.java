package com.wrike;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WrikeGetStartedPage {
    private WebElement content;

    public WrikeGetStartedPage(WebElement form) {
        content = form;
    }

    public void fillEmail(String email) {
        content.findElement(By.xpath("//*[@id=\"modal-pro\"]/form/label[1]/input")).sendKeys(email);
    }

    public void submit() {
        content.findElement(By.xpath("//*[@id=\"modal-pro\"]/form/label[2]/button")).click();
    }
}
