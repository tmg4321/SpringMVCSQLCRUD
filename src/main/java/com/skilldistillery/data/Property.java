package com.skilldistillery.data;

import java.util.List;

public class Property {
	private Integer id;
	private Address address;
	private Double rent;
	private Double purchasePrice;
	private Caprate capRate;
	private List<Note> notes;
	private List<Picture> pictures;

	public Property() {
		
	}
	
	public Property(Address address) {
		super();
		this.address = address;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
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
	public Caprate getCapRate() {
		return capRate;
	}
	public void setCapRate(Caprate capRate) {
		this.capRate = capRate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
