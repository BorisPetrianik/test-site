package com.wrike;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class FirstTest extends WebDriverSettings {

    static String getRandomEmail() {

        Random rand = new Random();

        int number = rand.nextInt(12);

        number += 5;

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

        return sb.toString() + "wpt@wriketask.qaa";
    }

    @Test
    public void firstTest() throws InterruptedException {

        WrikeIndexPage wip = new WrikeIndexPage(driver);

        WrikeGetStartedPage getStartedPage = wip.getStarted();
        getStartedPage.fillEmail(FirstTest.getRandomEmail());
        getStartedPage.submit();

        // Wait for loading survey page
        Thread.sleep(10000);
        String[] possibleUrls = new String[]{"https://www.wrike.com/resend-va/", "https://www.wrike.com/resend-vb/", "https://www.wrike.com/resend/"};
        boolean hasBeenRedirected = new LinkedList<String>(Arrays.asList(possibleUrls)).contains(driver.getCurrentUrl());
        Assert.assertTrue(hasBeenRedirected);

        WrikeSurveyPage wsp = new WrikeSurveyPage(driver);
        wsp.chooseOption(0);
        wsp.chooseOption(5);
        wsp.chooseOption(8);
        wsp.submit();
//Assert.assertTrue(new LinkedList("https://www.wrike.com/resend-va/", "https://www.wrike.com/resend-vb/").contains(driver.getCurrentUrl()));
//        WrikeSurveyPage wsp = new WrikeSurveyPage(driver);


        //
//        assertTrue(title.equals("Your online project management software - Wrike"));
//
//        WebDriverWait wait = new WebDriverWait(driver, 2);
//
//        WebElement dbutton = driver.findElement(By.cssSelector("body > div.wg-layout.wg-layout--outline > header > div.wg-header__desktop > div.wg-header__sticky-menu > div > div > div.wg-header__cell.wg-header__cell--xs-3.wg-header__cell--sm-6.wg-header__cell--md-5.wg-header__cell--xl-5 > div > form > button"));
//
//        WebElement dbutton = driver.findElement(By.className("wg-header__free-trial-button wg-btn wg-btn--green"));
//        dbutton.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-pro\"]/form")));
//
//        driver.findElement(By.xpath("//*[@id=\"modal-pro\"]/form/label[1]/input")).sendKeys("flexAir2_0@gmail.com");
    }

}
