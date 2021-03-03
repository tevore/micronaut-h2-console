package com.tevore.h2.console;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Requires;
import io.micronaut.servlet.tomcat.TomcatFactory;
import org.h2.server.web.WebServlet;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Requires(property="h2.console", value = "true")
public class H2ConsoleSupport {

    //TODO load your own server of choice programatically?
    private TomcatFactory tomcatFactory;

    @Inject
    public H2ConsoleSupport(TomcatFactory tomcatFactory) {
        this.tomcatFactory = tomcatFactory;
    }

    //WebServlet webServlet = new WebServlet();
    @Bean
    public void init() {
        tomcatFactory.getApplicationContext().registerSingleton(WebServlet.class);
    }
}
