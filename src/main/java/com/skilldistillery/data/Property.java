package com.skilldistillery.data;

public class Property {
	private String address;
	private double rent;
	private double purchasePrice;
	private double capRate;
	
	public Property() {
		
	}
	
	public Property(String address, double rent, double purchaserPrice, double capRate) {
		super();
		this.address = address;
		this.rent = rent;
		this.purchasePrice = purchaserPrice;
		this.capRate = capRate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchaserPrice) {
		this.purchasePrice = purchaserPrice;
	}
	public double getCapRate() {
		return capRate;
	}
	public void setCapRate(double capRate) {
		this.capRate = capRate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(address);
		builder.append(",");
		builder.append(rent);
		builder.append(",");
		builder.append(purchasePrice);
		builder.append(",");
		builder.append(capRate);
		return builder.toString();
	}
	
	
	
	
}
