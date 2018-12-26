package com.auma.deinwagen.filters;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class RouteFilter extends ZuulFilter {
 
  @Override
  public String filterType() {
    return "route";
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
  public Object run() {
   System.out.println("Inside Route Filter");
   RequestContext ctx = RequestContext.getCurrentContext();
	HttpServletRequest request = ctx.getRequest();
	HttpServletResponse response = ctx.getResponse();
	
	Enumeration<String> headerNames = request.getHeaderNames();
	for (int i = 0; i < 20 && headerNames.hasMoreElements(); i++) {
		String headerName = headerNames.nextElement();
		System.out.println("Header Name - " + headerName + ", Value - " + request.getHeader(headerName));
	}
    return null;
  }
}