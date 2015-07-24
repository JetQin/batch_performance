package com.usee.performance.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

/**
 * 
 * @ClassName: ProdPK  
 * @Description: TODO 
 * @author: wenjuan.li(Lewis) 
 * @date:2014年1月31日 下午2:59:36
 */
@Embeddable
public class ProdPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String completionId;
	
	private Date productionPeriod;

	public String getCompletionId() {
		return completionId;
	}

	public void setCompletionId(String completionId) {
		this.completionId = completionId;
	}

	public Date getProductionPeriod() {
		return productionPeriod;
	}

	public void setProductionPeriod(Date productionPeriod) {
		this.productionPeriod = productionPeriod;
	}

	public ProdPK() {
		// TODO Auto-generated constructor stub
	}

	public ProdPK(String completionId, Date productionPeriod) {
		super();
		this.completionId = completionId;
		this.productionPeriod = productionPeriod;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((completionId == null) ? 0 : completionId.hashCode());
		result = prime
				* result
				+ ((productionPeriod == null) ? 0 : productionPeriod.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdPK other = (ProdPK) obj;
		if (completionId == null) {
			if (other.completionId != null)
				return false;
		} else if (!completionId.equals(other.completionId))
			return false;
		if (productionPeriod == null) {
			if (other.productionPeriod != null)
				return false;
		} else if (!productionPeriod.equals(other.productionPeriod))
			return false;
		return true;
	}
	
	
}