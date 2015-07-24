/** 
 * Project Name:performance 
 * File Name:EUProdRepository.java 
 * Package Name:com.usee.performance.repository
 * Date:Jul 24, 201512:11:42 PM 
 * Copyright (c) 2015, jianlei.qin@sktlab.com All Rights Reserved. 
 * 
 */
package com.usee.performance.repository;

import org.springframework.data.repository.CrudRepository;

import com.usee.performance.domain.EUProd;
import com.usee.performance.domain.ProdPK;



/** 
 * ClassName: EUProdRepository  
 * 
 * @author jetq 
 * @version Configuration Framework 1.0
 * @since JDK 1.7 
 */
public interface EUProdTempRepository extends CrudRepository<EUProd, ProdPK> {

}
