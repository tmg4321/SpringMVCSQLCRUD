package com.skilldistillery.data;

public class Caprate {
	private Integer id;
	private Integer propId;
	private Integer monthlyOpCosts;
	private Integer monthlyRent;
	private Integer purchasePrice;
	private Double rate;
	
	public Caprate(Integer monthlyOpCosts, Integer monthlyRent, Integer purchasePrice) {
		super();
		this.monthlyOpCosts = monthlyOpCosts;
		this.monthlyRent = monthlyRent;
		this.purchasePrice = purchasePrice;
		this.rate = setRate(monthlyOpCosts, monthlyRent, purchasePrice);
	}
	
	public Caprate(){
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMonthlyOpCosts() {
		return monthlyOpCosts;
	}
	public void setMonthlyOpCosts(Integer monthlyOpCosts) {
		this.monthlyOpCosts = monthlyOpCosts;
	}
	public Integer getMonthlyRent() {
		return monthlyRent;
	}
	public void setMonthlyRent(Integer monthlyRent) {
		this.monthlyRent = monthlyRent;
	}
	
	public Integer getPropId() {
		return propId;
	}

	public void setPropId(Integer propId) {
		this.propId = propId;
	}

	public Integer getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Integer purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Double getRate() {
		return rate;
	}
	private Double setRate(Integer costs, Integer rent, Integer purchasePrice) {
		Double rate = (double)(((rent-costs)/purchasePrice)*100);
		this.rate = rate;
		return rate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Caprate [id=");
		builder.append(id);
		builder.append(", monthlyOpCosts=");
		builder.append(monthlyOpCosts);
		builder.append(", monthlyRent=");
		builder.append(monthlyRent);
		builder.append(", rate=");
		builder.append(rate);
		builder.append("]");
		return builder.toString();
	}

}
