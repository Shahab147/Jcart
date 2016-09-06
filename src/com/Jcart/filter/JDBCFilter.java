package com.Jcart.filter;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
@WebFilter(filterName = "jdbcfilter", urlPatterns = {"/*"})
public class JDBCFilter implements Filter{
	
	public JDBCFilter(){
		
	}
	@Override
	public void init(FilterConfig fconfig) throws ServletException{
		
	}
	@Override
	public void destroy(){
		
	}
	
	//ServletRegistration interface is used to configure further ServletRegistration
	private boolean needJDBC(HttpServletRequest request){
		System.out.println("JDBC Filter");
		String servletPath = request.getServletPath();
		String pathInfo = request.getPathInfo();
		String urlPattern = servletPath;
		if(pathInfo != null){
			urlPattern = servletPath + "/*";
		}
		Map<String, ? extends ServletRegistration> servletRegistration = request.getServletContext().getServletRegistrations();
		Collection<? extends ServletRegistration> values = servletRegistration.values();
		for(ServletRegistration sr : values){
			Collection<String> mappings = sr.getMappings();//gives <url-pattern> registration for a servlet
			if(mappings.equals(urlPattern)){
				return true;
			}
		}
		return false;
		
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
	

}
