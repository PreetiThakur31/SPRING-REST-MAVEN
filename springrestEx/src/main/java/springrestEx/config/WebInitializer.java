package springrestEx.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	
	 @Override
	 protected Class < ? > [] getRootConfigClasses() {
		return new Class[] { WebConfiguration.class };
	  
	  }
	 
	 @Override
	 protected Class < ? > [] getServletConfigClasses() {
	  return null;
	 }
	 
	 @Override
	 protected String[] getServletMappings() {
		 System.out.println("initializer");
	  return new String[] {
	   "/"
	  };
	 } 

}
