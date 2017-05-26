package com.skilldistillery.data;

public class Address {
	private Integer id;
	private Integer propertyId;
	private String streetAddress;
	private String city;
	private String stateAbbreviation;
	private Integer zipCode;
	
	public Address(String streetAddress, String city, String stateAbbreviation, Integer zipCode) {
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.stateAbbreviation = stateAbbreviation;
		this.zipCode = zipCode;
	}
	
	public Address() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateAbbreviation() {
		return stateAbbreviation;
	}
	public void setStateAbbreviation(String stateAbbreviation) {
		this.stateAbbreviation = stateAbbreviation;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public Integer getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [id=");
		builder.append(id);
		builder.append(", propertyId=");
		builder.append(propertyId);
		builder.append(", streetAddress=");
		builder.append(streetAddress);
		builder.append(", city=");
		builder.append(city);
		builder.append(", stateAbbreviation=");
		builder.append(stateAbbreviation);
		builder.append(", zipCode=");
		builder.append(zipCode);
		builder.append("]");
		return builder.toString();
	}
	
	
}
