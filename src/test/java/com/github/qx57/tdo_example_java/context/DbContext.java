package com.github.qx57.tdo_example_java.context;

import com.github.qx57.tdo_example_java.configurations.DB;
import com.github.qx57.tdo_example_java.tdo.api.OrderApi;
import com.github.qx57.tdo_example_java.tdo.db.OrderDB;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class DbContext extends AbstractModule {

    @Override
    protected void configure() {
        bind(DB.class).in(Scopes.SINGLETON);
        bind(OrderDB.class).in(Scopes.SINGLETON);
        bind(OrderApi.class).in(Scopes.SINGLETON);
    }
}
