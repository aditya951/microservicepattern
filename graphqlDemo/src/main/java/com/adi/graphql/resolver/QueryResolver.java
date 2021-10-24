package com.adi.graphql.resolver;

import org.springframework.stereotype.Component;

import com.adi.graphql.resolver.model.SampleRequest;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class QueryResolver implements GraphQLQueryResolver {
	
	public String firstQuery0() {
		return "firstquery0 from resolver class";
	}

	public String firstQuery1() {
		return "firstquery1 from resolver class";
	}
	public String firstQuery2() {
		return "firstquery2 from resolver class";
	}
	public String firstQuery3() {
		return "firstquery3 from resolver class";
	}
	
	public String fullName(String first,String last) {
		return first+" "+last ;
	}
	
	
	public String fullName(SampleRequest sample) {
		return sample.getFirst()+" "+sample.getMiddle()+" "+sample.getLast() ;
	}
	  
	
}
