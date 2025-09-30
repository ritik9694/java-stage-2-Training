package com.cognizant.boot.beans;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("writerData")
public class ReaderData {
    
	public ReaderData() {
		System.out.println("Reader :: constructor");
	}
}
