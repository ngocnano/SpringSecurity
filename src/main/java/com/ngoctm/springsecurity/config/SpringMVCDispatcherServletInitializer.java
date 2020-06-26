package com.ngoctm.springsecurity.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMVCDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		@SuppressWarnings("rawtypes")
		Class[] classes = {AppConfig.class};
	
		// TODO Auto-generated method stub
		return classes;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		
		String[] strings = {"/"};
		return strings;
	}

}
