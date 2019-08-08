package com.wrike;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WrikeIndexPage {
    private WebElement content;
    private boolean isMobile = true;

    public WrikeIndexPage(WebDriver driver) {
        driver.get("https://wrike.com");
        this.content = driver.findElement(By.xpath("/html"));

        if (driver.manage().window().getSize().width > 1023) {
            this.isMobile = false;
        }
    }

    public WrikeGetStartedPage getStarted() {
        String xPathSelector = isMobile ? "/html/body/div[1]/header/div[2]/div[5]/nav/div/button" : "/html/body/div[1]/header/div[3]/div[2]/div/div/div[2]/div/form/button";

        if (isMobile) {
            content.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/span")).click();
        }

        // Revamp required
        // Advice further improvement
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement getStartedButton = content.findElement(By.xpath(xPathSelector));
        getStartedButton.click();

        return new WrikeGetStartedPage(content.findElement(By.xpath("//*[@id=\"modal-pro\"]/form")));
    }
}
