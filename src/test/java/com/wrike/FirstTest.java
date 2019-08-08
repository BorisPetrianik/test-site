package com.wrike;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class FirstTest extends WebDriverSettings {

    @Test
    public void firstTest() {
        driver.get("https://www.wrike.com/");
        String title = driver.getTitle();
        assertTrue(title.equals("Your online project management software - Wrike"));

        WebElement button = driver.findElement(By.cssSelector("body > div.wg-layout.wg-layout--outline > header > div.wg-header__desktop > div.wg-header__sticky-menu > div > div > div.wg-header__cell.wg-header__cell--xs-3.wg-header__cell--sm-6.wg-header__cell--md-5.wg-header__cell--xl-5 > div > form > button"));

        button.click();
    }


}
