package com.usee.performance.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.usee.performance.domain.AbstractEntity;
import com.usee.performance.domain.EUProd;
import com.usee.performance.domain.EUProdTemp;
import com.usee.performance.domain.Person;

public class EntityItemProcessor implements  ItemProcessor<EUProdTemp,EUProd>
{

	private static final Logger log = LoggerFactory.getLogger(EntityItemProcessor.class);


	/* (non-Javadoc)
	 * @see org.springframework.batch.item.ItemProcessor#process(java.lang.Object)
	 */
	@Override
	public EUProd process(EUProdTemp temp) throws Exception {
		// TODO Auto-generated method stub
		EUProd prod = new EUProd();
		
		prod.setCompletionId(temp.getCompletionId());
		prod.setCompletionName(temp.getCompletionName());
		prod.setCompletionDate(temp.getCompletionDate());
		prod.setWellName(temp.getWellName());
		prod.setLeaseUserKey(temp.getLeaseUserKey());
		prod.setLeaseName(temp.getLeaseName());
		prod.setReservoirUserKey(temp.getReservoirUserKey());
		prod.setApiWellCode(temp.getApiWellCode());
		prod.setState(temp.getState());
		prod.setCounty(temp.getCounty());
		prod.setProductionPeriod(temp.getProductionPeriod());
		prod.setGas(temp.getGas());
		prod.setOil(temp.getOil());
		prod.setWater(temp.getWater());
		prod.setInjGas(temp.getInjGas());
		prod.setReservoirName(temp.getReservoirName());
		prod.setFieldName(temp.getFieldName());
		prod.setActiveStatus(temp.getActiveStatus());
		prod.setCompletionClass(temp.getCompletionClass());
		prod.setProductionStatus(temp.getProductionStatus());
		prod.setProdYear(temp.getProdYear());
		prod.setProdMonth(temp.getProdMonth());
		return prod;
	}

}
