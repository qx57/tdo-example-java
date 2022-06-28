package com.github.qx57.tdo_example_java.configurations;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriver {

    private ChromeDriver driver;

    /**
     * Web driver initialization
     *
     * You can move properties into settings file
     */
    public WebDriver() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public ChromeDriver getBrowser() {
        return driver;
    }
}
