package com.incedo.bean;

import java.math.BigDecimal;

public class ItemState {
	
	public enum State {
		DELHI, UP
	}

	public enum Type {
		PETROL, DIESEL
	}

	private State purchaseState;
	private BigDecimal fuelAmount;
	private Type typeofItem;
	private BigDecimal localTax;
	private BigDecimal unit;
	private BigDecimal unitPrice;
	private BigDecimal taxType1;
	private BigDecimal taxType2;
	private BigDecimal taxType3;

	
	public BigDecimal getTaxType1() {
		return taxType1;
	}

	public void setTaxType1(BigDecimal taxType1) {
		this.taxType1 = taxType1;
	}

	public BigDecimal getTaxType2() {
		return taxType2;
	}

	public void setTaxType2(BigDecimal taxType2) {
		this.taxType2 = taxType2;
	}

	public BigDecimal getTaxType3() {
		return taxType3;
	}

	public void setTaxType3(BigDecimal taxType3) {
		this.taxType3 = taxType3;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setPurchaseState(State purchaseState) {
		this.purchaseState = purchaseState;
	}

	public State getPurchaseState() {
		return purchaseState;
	}

	public BigDecimal getFuelAmount() {
		return fuelAmount;
	}

	public void setFuelAmount(BigDecimal fuelAmount) {
		this.fuelAmount = fuelAmount;
	}

	public Type getTypeofItem() {
		return typeofItem;
	}

	public void setTypeofItem(Type typeofItem) {
		this.typeofItem = typeofItem;
	}

	public BigDecimal getLocalTax() {
		return localTax;
	}

	public void setLocalTax(BigDecimal localTax) {
		this.localTax = localTax;
	}

	public BigDecimal getUnit() {
		return unit;
	}

	public void setUnit(BigDecimal unit) {
		this.unit = unit;
	}

}
