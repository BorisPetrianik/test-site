package com.wrike;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class FirstTest extends WebDriverSettings {

    @Test
    public void firstTest() {
        driver.get("https://www.wrike.com/");
        String title = driver.getTitle();
        assertTrue(title.equals("Your online project management software - Wrike"));

        WebDriverWait wait = new WebDriverWait(driver, 2);

        WebElement dbutton = driver.findElement(By.cssSelector("body > div.wg-layout.wg-layout--outline > header > div.wg-header__desktop > div.wg-header__sticky-menu > div > div > div.wg-header__cell.wg-header__cell--xs-3.wg-header__cell--sm-6.wg-header__cell--md-5.wg-header__cell--xl-5 > div > form > button"));
        dbutton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-pro\"]/form")));

        driver.findElement(By.xpath("//*[@id=\"modal-pro\"]/form/label[1]/input")).sendKeys("flexAir2_0@gmail.com");
    }

}
