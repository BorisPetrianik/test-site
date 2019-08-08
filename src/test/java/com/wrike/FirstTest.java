package com.wrike;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Thread.sleep(10000);

        String[] possibleUrls = new String[]{"https://www.wrike.com/resend-va/", "https://www.wrike.com/resend-vb/", "https://www.wrike.com/resend/"};
        boolean hasBeenRedirected = new LinkedList<String>(Arrays.asList(possibleUrls)).contains(driver.getCurrentUrl());
        Assert.assertTrue(hasBeenRedirected);
        WrikeSurveyPage wsp = new WrikeSurveyPage();
        if (driver.getCurrentUrl().equals(possibleUrls[1])) {
                wsp.WrikeSurveyPageB(driver);
            }
        else
        {
            wsp.WrikeSurveyPageA(driver);
        }
        wsp.chooseOption(0);
        wsp.chooseOption(5);
        wsp.chooseOption(7);
        wsp.submit();

        WebElement twitter = driver.findElement(By.cssSelector("[href=\"https://twitter.com/wrike\"]"));
        Assert.assertTrue(twitter.getAttribute("href").equals("https://twitter.com/wrike"));
    }

}
