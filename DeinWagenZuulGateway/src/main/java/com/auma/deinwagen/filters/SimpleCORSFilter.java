package com.auma.deinwagen.filters;

import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

public class SimpleCORSFilter extends OncePerRequestFilter {
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		 logger.info("> doFilter");
		    
		 ServletRequest sr=(ServletRequest)request;
		 Enumeration<String> headerNames = request.getHeaderNames();
			for (int i = 0; i < 10 && headerNames.hasMoreElements(); i++) {
				String headerName = headerNames.nextElement();
				System.out.println("Header Name - " + headerName + ", Value - " + request.getHeader(headerName));
			}
			
			
			Collection<String> rsheaderNames =  response.getHeaderNames();
			
			for (Iterator iterator = rsheaderNames.iterator(); iterator.hasNext();)
			{
				String headerName = (String) iterator.next();
				System.out.println("Header Name - " + headerName + ", Value - " + request.getHeader(headerName));
			}
			
			
		    filterChain.doFilter(request, response);
		    logger.info("< doFilter");
		
	}
}
