package com.example.JavaFileCopier;

import org.apache.camel.DynamicRouter;
import org.apache.camel.Exchange;
import org.apache.camel.Header;

public class DynamicRouterBean2 {
	
@DynamicRouter
public String route(String body,
 @Header(Exchange.SLIP_ENDPOINT) String previous) {
 return whereToGo(body, previous);
}
private String whereToGo(String body, String previous) {
 if (previous == null) {
 return "direct://a2";
 } 
 else if ("direct://a2".equals(previous)) {
 return "language://simple:Bye ${body}2";
 } else {
 return null;
 }
}
}
