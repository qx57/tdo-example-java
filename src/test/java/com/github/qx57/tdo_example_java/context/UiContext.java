package com.github.qx57.tdo_example_java.context;

import com.github.qx57.tdo_example_java.configurations.WebDriver;
import com.github.qx57.tdo_example_java.tdo.ui.LoginPage;
import com.github.qx57.tdo_example_java.tdo.ui.UserPage;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class UiContext extends AbstractModule {

    @Override
    protected void configure() {
        bind(WebDriver.class).in(Scopes.SINGLETON);
        bind(LoginPage.class).in(Scopes.SINGLETON);
        bind(UserPage.class).in(Scopes.SINGLETON);
    }
}
