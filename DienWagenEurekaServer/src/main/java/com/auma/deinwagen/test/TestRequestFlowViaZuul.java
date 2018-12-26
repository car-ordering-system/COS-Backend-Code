package com.auma.deinwagen.test;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Controller
public class TestRequestFlowViaZuul {

		@Autowired
		private DiscoveryClient discoveryClient;

		public void getEmployee() throws RestClientException, IOException {

			List<ServiceInstance> instances = discoveryClient.getInstances("auth");
			ServiceInstance serviceInstance = instances.get(0);

			String baseUrl = serviceInstance.getUri().toString();

			baseUrl = baseUrl + "/vehiclebodydetail";

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = null;
			try {
				response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
			} catch (Exception ex) {
				System.out.println(ex);
			}
			System.out.println(response.getBody());
		}

		private static HttpEntity<?> getHeaders() throws IOException {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
			return new HttpEntity<>(headers);
		}
		
		
		private ResponseEntity doLogininAuth() {
			RestTemplate restTemplate1 = new RestTemplate();
			User u = new User();
            u.setName("Johnathan M Smith");
            u.setUser("JS01");
			ResponseEntity hSresponse=
					(ResponseEntity) restTemplate1.postForEntity("http://localhost:9001/auth/login?username=sphilipo&password=lion", u, HttpServletResponse.class);
			hSresponse.getBody();
			hSresponse.getHeaders();
			String token=null;
			HttpHeaders headers = hSresponse.getHeaders();
			Set<String> keys = headers.keySet();
			for (String header : keys) {
				System.out.println("Header: "+header);
				List<String> values = headers.get(header);
				for (String value : values) {
					if(header.equalsIgnoreCase("Authorization")) {
						token=value;
					}
					System.out.println("Header Value: "+ value);
				}
			}
			System.out.println("token is:"+token);
			//System.out.println(hSresponse.);
			return (ResponseEntity) hSresponse;
		}
		
		
		
		public static void main(String[] args) {
			
			TestRequestFlowViaZuul test= new TestRequestFlowViaZuul();
					try {
						test.doLogininAuth();
					} catch (RestClientException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}
		
		class User{
		 String user;
		  String name;
		    public User()
		    {
		    }
		    public User(String user, String name)
		    {
		        this.user = user;
		        this.name = name;
		    }
		    public String getUser()
		    {
		        return user;
		    }
		    public void setUser(String user)
		    {
		        this.user = user;
		    }
		    public String getName()
		    {
		        return name;
		    }
		    public void setName(String name)
		    {
		        this.name = name;
		    }
		}
	}
