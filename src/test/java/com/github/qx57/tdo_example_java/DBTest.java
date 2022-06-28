package com.github.qx57.tdo_example_java;

import com.github.qx57.tdo_example_java.context.DbContext;
import com.github.qx57.tdo_example_java.tdo.api.OrderApi;
import com.github.qx57.tdo_example_java.tdo.db.OrderDB;
import com.google.inject.Inject;
import org.apache.http.HttpStatus;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Guice(modules = {DbContext.class})
public class DBTest {

    @Inject
    private OrderApi orderApi;

    @Inject
    private OrderDB orderDB;

    private final Integer orderId = 123;
    private final String oldStatus = "new";
    private final String newStatus = "progress";

    @Test
    public void dbTestExample() {
        step("Check order status in DB", () -> {
            assertThat(orderDB.getStatus(orderId)).isEqualTo(oldStatus);
        });
        step("Change order status through API", () -> {
            orderApi.changeStatus(orderId, newStatus);
            assertThat(orderApi.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
            assertThat(orderApi.getResponse().getStatus()).isEqualTo(newStatus);
        });
        step("Check order status in DB again", () -> {
            assertThat(orderDB.getStatus(orderId)).isEqualTo(newStatus);
        });
    }
}
