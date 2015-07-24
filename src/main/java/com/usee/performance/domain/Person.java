/** 
 * Project Name:performance 
 * File Name:Person.java 
 * Package Name:com.usee.performance.model
 * Date:Jul 22, 201510:32:14 PM 
 * Copyright (c) 2015, jianlei.qin@sktlab.com All Rights Reserved. 
 * 
 */
package com.usee.performance.domain;

import lombok.Data;

/** 
 * ClassName: Person  
 * 
 * @author jet 
 * @version Configuration Framework 1.0
 * @since JDK 1.7 
 */
public @Data class Person
{
	
	
	/**
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	private String firstName;
	
	private String lastName;
	
	
}
