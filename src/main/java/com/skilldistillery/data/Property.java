package com.skilldistillery.data;

public class Property {
	private String address;
	private Double rent;
	private Double purchasePrice;
	private Double capRate;

	public Property() {
		
	}
	
	public Property(String address, Double rent, Double purchasePrice, Double capRate) {
		super();
		this.address = address;
		this.rent = rent;
		this.purchasePrice = purchasePrice;
		this.capRate = capRate;
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
	}
	public Double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public Double getCapRate() {
		return capRate;
	}
	public void setCapRate(Double capRate) {
		this.capRate = capRate;
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
