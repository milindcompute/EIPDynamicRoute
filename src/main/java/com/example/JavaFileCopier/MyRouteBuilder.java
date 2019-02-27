package com.example.JavaFileCopier;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:start")
		 .dynamicRouter(method(DynamicRouterBean.class, "route"))
		 .to("stream:out");
		
		from("direct:a").to("stream:out");
		
	}
}
