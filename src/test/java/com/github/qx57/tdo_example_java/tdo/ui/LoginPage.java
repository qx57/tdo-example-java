package com.github.qx57.tdo_example_java.tdo.ui;

import com.github.qx57.tdo_example_java.configurations.WebDriver;
import com.google.inject.Inject;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    @Inject
    private WebDriver driver;

    private final String path = "http://localhost:4231/login";
    private final String loginCss = "#login";
    private final String passwordCss = "#password";
    private final String buttonCss = "form.signin input[type=submit]";

    @Getter
    private WebElement loginField;
    @Getter
    private WebElement passwordField;
    @Getter
    private WebElement signinButton;

    public void loadPage() {
        driver.getBrowser().get(path);
        loginField = driver.getBrowser().findElement(By.cssSelector(loginCss));
        passwordField = driver.getBrowser().findElement(By.cssSelector(passwordCss));
        signinButton = driver.getBrowser().findElement(By.cssSelector(buttonCss));
    }

    public Boolean isElementEnabled(WebElement el) { return el.isEnabled(); }

    public String getLogin() { return loginField.getAttribute("value"); }

    public void setLogin(String val) { loginField.sendKeys(val); }

    public String getPassword() { return passwordField.getAttribute("value"); }

    public void setPassword(String val) { passwordField.sendKeys(val); }

    public void signin() { signinButton.click(); }
}
