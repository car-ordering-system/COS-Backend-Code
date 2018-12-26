package com.auma.deinwagen.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.hibernate.mapping.Map;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	private TokenAuthenticationService tokenAuthenticationService;

	public JWTLoginFilter(String url, AuthenticationManager authenticationManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authenticationManager);
		tokenAuthenticationService = new TokenAuthenticationService();
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
		
		java.util.Map<String, String[]> params=httpServletRequest.getParameterMap();
		UsernamePasswordAuthenticationToken token=null;
		if(httpServletRequest.getParameter("username")!=null && httpServletRequest.getParameter("password")!=null) {
			String username=httpServletRequest.getParameter("username");
			String password=httpServletRequest.getParameter("password");
			token = new UsernamePasswordAuthenticationToken(username,password);
		}
		logger.info("**********params*****"+params.entrySet().size());

		return getAuthenticationManager().authenticate(token);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authentication) throws IOException, ServletException {
		String name = authentication.getName();
		System.out.println("***************************"+response.getHeader("Authorization"));
		tokenAuthenticationService.addAuthentication(request,response, name);
		System.out.println("***************************"+response.getHeader("newAuthorization"));
		//chain.doFilter(request, response);
		System.out.println("*****************allowed methods**********"+response.getHeader("Access-Control-Allow-Methods"));
	}
}
