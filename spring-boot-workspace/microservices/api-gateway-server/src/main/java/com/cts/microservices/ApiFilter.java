package com.cts.microservices;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ApiFilter extends ZuulFilter {

	Logger logger=LoggerFactory.getLogger(ApiFilter.class);
	
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		logger.info("Request Intercepted");
		RequestContext context=RequestContext.getCurrentContext();
		HttpServletRequest request=context.getRequest();
		logger.info("Fetching Header");
		String header=request.getHeader("token");
		if(header!=null) {
			logger.info("Header Found");
			logger.info("Routing to "+request.getRequestURI());
			return null;
		}
		logger.error("Header Not Found");
		context.setSendZuulResponse(false);
		context.setResponseStatusCode(401);
		context.setResponseBody("Unauthorized");
		logger.error("Returning - 401-Unauthorized");
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

	
	
	
}
