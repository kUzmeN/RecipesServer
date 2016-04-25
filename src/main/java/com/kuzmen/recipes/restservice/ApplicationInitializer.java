package com.kuzmen.recipes.restservice;

import com.kuzmen.recipes.restservice.config.WebConfig;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer implements WebApplicationInitializer {
    public final static String DISPATCHER = "dispatcher";


    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);
        servletContext.addListener(new ContextLoaderListener(context));

        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        //dispatcherServlet.init();

        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER, dispatcherServlet);
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
//        Чтобы можно было через lazy loading получить данные в контроллере
        FilterRegistration.Dynamic fr = servletContext.addFilter("openSessionInViewFilter", new OpenEntityManagerInViewFilter());
        fr.addMappingForUrlPatterns(null, true, "/*");
    }
}