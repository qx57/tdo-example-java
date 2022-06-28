package com.github.qx57.tdo_example_java;

import com.github.qx57.tdo_example_java.context.UiContext;
import com.github.qx57.tdo_example_java.tdo.ui.LoginPage;
import com.github.qx57.tdo_example_java.tdo.ui.UserPage;
import com.google.inject.Inject;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Guice(modules = {UiContext.class})
public class UITest {

    @Inject
    private LoginPage loginPage;

    @Inject
    private UserPage userPage;

    private String login = "my_login";
    private String password = "very_secret_password";

    @Test
    public void uiTestExample() {
        step("load sign in page", () -> {
            loginPage.loadPage();
            assertThat(loginPage.isElementEnabled(loginPage.getLoginField())).isTrue();
            assertThat(loginPage.isElementEnabled(loginPage.getPasswordField())).isTrue();
            assertThat(loginPage.isElementEnabled(loginPage.getSigninButton())).isTrue();
        });
        step("set login field", () -> {
            loginPage.setLogin(login);
            assertThat(loginPage.getLogin()).isEqualTo(login);
        });
        step("set password field", () -> {
            loginPage.setPassword(password);
            assertThat(loginPage.getPassword()).isEqualTo(password);
        });
        step("send form", () -> {
            loginPage.signin();
            assertThat(userPage.getContext().getUsernameText()).isEqualTo(login);
        });
    }
}
