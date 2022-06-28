package com.github.qx57.tdo_example_java.context;

import com.github.qx57.tdo_example_java.configurations.WebDriver;
import com.github.qx57.tdo_example_java.tdo.api.OrderApi;
import com.github.qx57.tdo_example_java.tdo.ui.OrderPage;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class ApiContext extends AbstractModule {

    @Override
    protected void configure() {
        bind(WebDriver.class).in(Scopes.SINGLETON);
        bind(OrderPage.class).in(Scopes.SINGLETON);
        bind(OrderApi.class).in(Scopes.SINGLETON);
    }
}
