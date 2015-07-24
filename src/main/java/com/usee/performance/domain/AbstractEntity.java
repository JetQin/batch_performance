/** 
 * Project Name:cf 
 * File Name:AbstractEntity.java 
 * Package Name:com.g360.repository.entity
 * Date:2015年2月11日上午9:42:12 
 * Copyright (c) 2015, jianlei.qin@sktlab.com All Rights Reserved. 
 * 
 */
package com.usee.performance.domain;


import java.util.Date;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;



/** 
 * ClassName: AbstractEntity  
 * 
 * @author jet 
 * @version Configuration Framework 1.0
 * @since JDK 1.7 
 */
@MappedSuperclass
public abstract @Data class AbstractEntity 
{
    /**
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 6983849776808432601L;

	@Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATED_TIME")
    private Date createdTime;
    
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="UPDATED_TIME")
    private Date updatedTime;

    @Column(name="CREATED_BY")
    private String createdBy;
    
}
