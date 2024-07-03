package com.browserstack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.percy.selenium.Percy;


public class SingleTest extends BrowserStackTestNGTest {
    private static Percy percy;
    @Test
    public void test() throws Exception {
        driver.get("https://portal.mobysoft.uk/#/");
        
        percy = new Percy(driver);
        percy.snapshot("RentSense Login-Page");

        Thread.sleep(10000);

        WebElement usernameField = driver.findElement(By.id("loginUsername"));
        usernameField.sendKeys("");

        WebElement passwordField = driver.findElement(By.id("loginPassword"));
        passwordField.sendKeys("");

        WebElement login = driver.findElement(By.id("loginButton"));
        login.click();

        Thread.sleep(5000);

        percy.snapshot("RentSense Home-Page");

        Thread.sleep(5000);
    }
}
