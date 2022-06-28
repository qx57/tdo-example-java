package com.github.qx57.tdo_example_java.tdo.ui;

import com.github.qx57.tdo_example_java.configurations.WebDriver;
import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OrderPage {

    @Inject
    private WebDriver driver;

    private final String path = "http://localhost:4231/order_page";
    private final String statusCss = "span#status";

    private Integer orderId;

    private WebElement status;

    public void load(Integer orderId) {
        this.orderId = orderId;
        reload();
    }

    public void reload() {
        driver.getBrowser().get(String.format("%s?order_id=%d", path, orderId));
        status = driver.getBrowser().findElement(By.cssSelector(statusCss));
    }

    public String getOrderStatus() { return status.getText(); }
}
