package com.auma.deinwagen.filters;

import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import com.google.common.net.HttpHeaders;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class PreFilter extends ZuulFilter {
	private static Logger logger = LoggerFactory.getLogger(PreFilter.class);
	private long EXPIRATIONTIME = 1000 * 60 * 60 * 24 * 10; // 10 days
	private String secret = "ThisIsASecret";
	private String tokenPrefix = "Bearer";
	private String headerString = "Authorization";

	@Override
	public String filterType() {
		return "pre";
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
	@CrossOrigin(origins="http://localhost:4200", exposedHeaders="Authorization")
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		HttpServletResponse response = ctx.getResponse();
		ResponseEntity<HttpServletResponse> rssResponse=null;

		if(request.getHeader("Access-Control-Request-Headers")==null &&
				request.getHeader("access-control-request-method")==null && !request.getServletPath().toString().contains("/login"))
		{
			
			Set<String> headers = (Set<String>) ctx.get("ignoredHeaders");
			String host = ctx.getRequest().getHeaders("Host").nextElement();
			ctx.getZuulRequestHeaders().put("Host", host);
			String header = request.getHeader("Authorization");
			logger.info("***********************Authorizationheader***************" + header);
			logger.info(String.format("%s ******************request to %s", request.getMethod(),
					request.getRequestURL().toString()));
	
			String token = request.getHeader(headerString);
			String username = null;
			if (token != null && !token.equalsIgnoreCase("null")) {
				
				try {
					username = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();

				} catch (UnsupportedJwtException e) {
					throw new RuntimeException("Invalid token");
				} catch (MalformedJwtException e) {
					throw new RuntimeException("Invalid token");
				} catch (SignatureException e) {
					e.printStackTrace();
				} catch (Throwable e) {
					e.printStackTrace();
				}
				if (username != null) {
					logger.info("Valid Token");
					logger.info("Valid User" + username);
				}
			}
			Enumeration<String> headerNames = request.getHeaderNames();
			for (int i = 0; i < 20 && headerNames.hasMoreElements(); i++) {
				String headerName = headerNames.nextElement();
				System.out.println("Header Name - " + headerName + ", Value - " + request.getHeader(headerName));
			}

			if (header != null) {	 
				ctx.addZuulRequestHeader("Authorization", header);
				ctx.addZuulResponseHeader("Authorization", header);
				response.setHeader("Authorization", header);
				ctx.addZuulResponseHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
				ctx.addZuulResponseHeader("Access-Control-Allow-Headers",
						"Origin, X-Requested-With, Content-Type, Accept, Key, Authorization");
			}

			else if (header == null && !request.getServletPath().toString().contains("/login")) {
				try {
					ctx.getResponse().sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized Access");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

}