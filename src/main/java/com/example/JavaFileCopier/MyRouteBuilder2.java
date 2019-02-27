package com.example.JavaFileCopier;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRouteBuilder2 extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:start2")
		 .dynamicRouter(method(DynamicRouterBean2.class, "route"))
		 .to("stream:out");
		
		from("direct:a2").to("stream:out");
		
	}
}
