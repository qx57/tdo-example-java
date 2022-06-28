package com.github.qx57.tdo_example_java;

import com.github.qx57.tdo_example_java.context.ApiContext;
import com.github.qx57.tdo_example_java.tdo.api.OrderApi;
import com.github.qx57.tdo_example_java.tdo.ui.OrderPage;
import com.google.inject.Inject;
import org.apache.http.HttpStatus;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Guice(modules = {ApiContext.class})
public class APITest {

    @Inject
    private OrderPage orderPage;

    @Inject
    private OrderApi orderApi;

    private final Integer orderId = 123;
    private final String oldStatus = "new";
    private final String newStatus = "progress";

    @Test
    public void apiTestExample() {
        step("open order page", () -> {
            orderPage.load(123);
            assertThat(orderPage.getOrderStatus()).isEqualTo(oldStatus);
        });
        step("change order status through API", () -> {
            orderApi.changeStatus(orderId, newStatus);
            assertThat(orderApi.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
            assertThat(orderApi.getResponse().getStatus()).isEqualTo(newStatus);
        });
        step("reload page and check status", () -> {
            orderPage.reload();
            assertThat(orderPage.getOrderStatus()).isEqualTo(newStatus);
        });
    }
}
