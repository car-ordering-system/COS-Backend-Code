package com.auma.deinwagen.filters;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class PostFilter extends ZuulFilter {
	private static Logger logger = LoggerFactory.getLogger(PostFilter.class);
	private long EXPIRATIONTIME = 1000 * 60 * 60 * 24 * 10; // 10 days
	private String secret = "ThisIsASecret";
	private String tokenPrefix = "Bearer";
	private String headerString = "Authorization";
 
  @Override
  public String filterType() {
    return "post";
  }
 
  @Override
  public int filterOrder() {
    return 1;
  }
 
  @Override
  public boolean shouldFilter() {
    return true;
  }
 
  @Override
  @CrossOrigin(origins="http://localhost:4200")
  public Object run() {
   System.out.println("Inside Response Filter");
   
   RequestContext ctx = RequestContext.getCurrentContext();
	HttpServletRequest request = ctx.getRequest();
	HttpServletResponse response = ctx.getResponse();
	
	
	Set<String> headers = (Set<String>) ctx.get("ignoredHeaders");
    String host = ctx.getRequest().getHeaders("Host").nextElement();
    ctx.getZuulRequestHeaders().put("Host", host);
    String header = request.getHeader("authorization");
    String headerCap = request.getHeader("Authorization");
    response.getContentType();
    String token=null;
   
    
	logger.info(String.format("%s ******************request to %s", request.getMethod(),
			request.getRequestURL().toString()));
	
	
	Collection<String> rsheaderNames =  response.getHeaderNames();
	for (Iterator iterator = rsheaderNames.iterator(); iterator.hasNext();)
	{
		String headerName = (String) iterator.next();
		System.out.println("Response Header Name - " + headerName + ", Value - " + request.getHeader(headerName));
	}
	Enumeration<String> headerNames = request.getHeaderNames();
	for (int i = 0; i < 20 && headerNames.hasMoreElements(); i++) {
		String headerName = headerNames.nextElement();
		System.out.println("Request Header Name - " + headerName + ", Value - " + request.getHeader(headerName));
	}

    return null;
  }
  
 

}