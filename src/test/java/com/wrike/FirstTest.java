package com.wrike;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

    @Test
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.wrike.com/");

    }
}
