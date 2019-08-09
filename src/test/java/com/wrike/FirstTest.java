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

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    @Test
    public void firstTest() throws InterruptedException {

        WrikeIndexPage wip = new WrikeIndexPage(driver);

        WrikeGetStartedPage getStartedPage = wip.getStarted();
        getStartedPage.fillEmail(FirstTest.getRandomEmail());
        getStartedPage.submit();
            // Wait for loading survey page
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.urlContains("resend"));

            String[] possibleUrls = new String[]{"https://www.wrike.com/resend-va/", "https://www.wrike.com/resend-vb/", "https://www.wrike.com/resend/"};
            boolean hasBeenRedirected = new LinkedList<String>(Arrays.asList(possibleUrls)).contains(driver.getCurrentUrl());
            Assert.assertTrue(hasBeenRedirected);
            WrikeSurveyPage wsp = new WrikeSurveyPage();
            if (driver.getCurrentUrl().equals(possibleUrls[1])) {
                wsp.WrikeSurveyPageB(driver);
            } else {
                wsp.WrikeSurveyPageA(driver);
            }
            wsp.chooseOption(getRandomNumberInRange(0,1));
            wsp.chooseOption(getRandomNumberInRange(2,6));
            wsp.chooseOption(getRandomNumberInRange(7,9));
            wsp.submit();
            wsp.checkImageLink();
            wsp.checkIconImage(0);
    }

}
