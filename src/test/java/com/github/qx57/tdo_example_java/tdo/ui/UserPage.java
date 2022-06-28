package com.github.qx57.tdo_example_java.tdo.ui;

import com.github.qx57.tdo_example_java.configurations.WebDriver;
import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UserPage {

    @Inject
    private WebDriver driver;

    private final String path = "http://localhost:4231/cabinet";
    private final String usernameCss = "#info > span.username";

    private WebElement username;

    public UserPage getContext() {
        username = driver.getBrowser().findElement(By.cssSelector(usernameCss));
        return this;
    }

    public String getUsernameText() { return username.getText(); }
}
