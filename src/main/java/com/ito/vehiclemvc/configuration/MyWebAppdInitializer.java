package com.ito.vehiclemvc.configuration;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppdInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { MyWebAppConfiguration.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    
    @Override
    protected Filter[] getServletFilters() {
    	Filter [] singleton = { new CORSFilter() };
    	return singleton;
	}
 
}