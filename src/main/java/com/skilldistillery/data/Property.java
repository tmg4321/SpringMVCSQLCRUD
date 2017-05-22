package com.skilldistillery.data;

public class Property {
	private String address;
	private Double rent;
	private Double purchasePrice;
	private Double capRate;

	public Property() {
		
	}
	
	public Property(String address, Double rent, Double purchasePrice) {
		super();
		this.address = address;
		this.rent = rent;
		this.purchasePrice = purchasePrice;
		setCapRate(rent, purchasePrice);
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getRent() {
		return rent;
	}
	public void setRent(Double rent) {
		this.rent = rent;
		setCapRate(rent, getPurchasePrice());
	}
	public Double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
		setCapRate(getRent(), purchasePrice);
	}
	public Double getCapRate() {
		return capRate;
	}
	public void setCapRate(Double rent, Double purchasePrice) {
		this.capRate = ((((rent-800)*12))/purchasePrice)*100;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(address);
		builder.append("|");
		builder.append(rent);
		builder.append("|");
		builder.append(purchasePrice);
		builder.append("|");
		builder.append(capRate);
		return builder.toString();
	}
	
	
	
	
}
