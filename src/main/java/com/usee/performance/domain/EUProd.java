package com.usee.performance.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

import org.hibernate.annotations.Type;

/**
 * 
 * @ClassName: EUFINANCIALIntfNov
 * @Description: TODO
 * @author: jinling.dang(Lola)
 * @date:2014年12月26日
 */
@Entity
@Table(name = "INTF_NOVISTAR_PROD")
@IdClass(ProdPK.class)
public @Data class EUProd extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7549909475489638611L;

	@Id
	@Column(name = "COMPLETION_ID", length = 15)
	private String completionId;

	@Column(name = "COMPLETION_NAME", length = 70)
	private String completionName;

	@Column(name = "COMPLETION_DATE")
	@Type(type = "date")
	private Date completionDate;

	@Column(name = "WELL_NAME", length = 70)
	private String wellName;

	@Column(name = "LEASE_USER_KEY", length = 15)
	private String leaseUserKey;

	@Column(name = "LEASE_NAME", length = 70)
	private String leaseName;

	@Column(name = "RESERVOIR_USER_KEY", length = 15)
	private String reservoirUserKey;

	@Column(name = "API_WELL_CODE", length = 15)
	private String apiWellCode;

	@Column(name = "STATE", length = 3)
	private String state;

	@Column(name = "COUNTY", length = 15)
	private String county;

	@Id
	@Column(name = "PRODUCTION_PERIOD")
	@Type(type = "date")
	private Date productionPeriod;

	@Column(name = "GAS", length = 10)
	private Long gas;

	@Column(name = "OIL", length = 10)
	private Long oil;

	@Column(name = "WATER", length = 10)
	private Long water;

	@Column(name = "INJ_GAS", length = 10)
	private Long injGas;

	@Column(name = "RESERVOIR_NAME", length = 120)
	private String reservoirName;

	@Column(name = "FIELD_NAME", length = 70)
	private String fieldName;

	@Column(name = "ACTIVE_STATUS", length = 1)
	private String activeStatus;

	@Column(name = "COMPLETION_CLASS", length = 6)
	private String completionClass;

	@Column(name = "PRODUCTION_STATUS", length = 6)
	private String productionStatus;

	@Column(name = "PROD_YEAR", length = 4)
	private String prodYear;

	@Column(name = "PROD_MONTH",nullable=true, length = 2)
	private int prodMonth;

	public EUProd(String completionId, String completionName,
			Date completionDate, String wellName, String leaseUserKey,
			String leaseName, String reservoirUserKey, String apiWellCode,
			String state, String county, Date productionPeriod, Long gas,
			Long oil, Long water, Long injGas, String reservoirName,
			String fieldName, String activeStatus, String completionClass,
			String productionStatus, String prodYear, int prodMonth) {
		super();
		this.completionId = completionId;
		this.completionName = completionName;
		this.completionDate = completionDate;
		this.wellName = wellName;
		this.leaseUserKey = leaseUserKey;
		this.leaseName = leaseName;
		this.reservoirUserKey = reservoirUserKey;
		this.apiWellCode = apiWellCode;
		this.state = state;
		this.county = county;
		this.productionPeriod = productionPeriod;
		this.gas = gas;
		this.oil = oil;
		this.water = water;
		this.injGas = injGas;
		this.reservoirName = reservoirName;
		this.fieldName = fieldName;
		this.activeStatus = activeStatus;
		this.completionClass = completionClass;
		this.productionStatus = productionStatus;
		this.prodYear = prodYear;
		this.prodMonth = prodMonth;
	}

	public EUProd() {
		// TODO Auto-generated constructor stub
	}

	public String getCompletionId() {
		return completionId;
	}

	public void setCompletionId(String completionId) {
		this.completionId = completionId;
	}

	public String getCompletionName() {
		return completionName;
	}

	public void setCompletionName(String completionName) {
		this.completionName = completionName;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public String getWellName() {
		return wellName;
	}

	public void setWellName(String wellName) {
		this.wellName = wellName;
	}

	public String getLeaseUserKey() {
		return leaseUserKey;
	}

	public void setLeaseUserKey(String leaseUserKey) {
		this.leaseUserKey = leaseUserKey;
	}

	public String getLeaseName() {
		return leaseName;
	}

	public void setLeaseName(String leaseName) {
		this.leaseName = leaseName;
	}

	public String getReservoirUserKey() {
		return reservoirUserKey;
	}

	public void setReservoirUserKey(String reservoirUserKey) {
		this.reservoirUserKey = reservoirUserKey;
	}

	public String getApiWellCode() {
		return apiWellCode;
	}

	public void setApiWellCode(String apiWellCode) {
		this.apiWellCode = apiWellCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public Date getProductionPeriod() {
		return productionPeriod;
	}

	public void setProductionPeriod(Date productionPeriod) {
		this.productionPeriod = productionPeriod;
	}

	public Long getGas() {
		return gas;
	}

	public void setGas(Long gas) {
		this.gas = gas;
	}

	public Long getOil() {
		return oil;
	}

	public void setOil(Long oil) {
		this.oil = oil;
	}

	public Long getWater() {
		return water;
	}

	public void setWater(Long water) {
		this.water = water;
	}

	public Long getInjGas() {
		return injGas;
	}

	public void setInjGas(Long injGas) {
		this.injGas = injGas;
	}

	public String getReservoirName() {
		return reservoirName;
	}

	public void setReservoirName(String reservoirName) {
		this.reservoirName = reservoirName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getCompletionClass() {
		return completionClass;
	}

	public void setCompletionClass(String completionClass) {
		this.completionClass = completionClass;
	}

	public String getProductionStatus() {
		return productionStatus;
	}

	public void setProductionStatus(String productionStatus) {
		this.productionStatus = productionStatus;
	}

	public String getProdYear() {
		return prodYear;
	}

	public void setProdYear(String prodYear) {
		this.prodYear = prodYear;
	}

	public int getProdMonth() {
		return prodMonth;
	}

	public void setProdMonth(int prodMonth) {
		this.prodMonth = prodMonth;
	}
}
