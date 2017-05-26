package com.skilldistillery.data;

public class Picture {
	private Integer id;
	private Integer propId;
	private String picture;
	
	public Picture() {}
	
	public Picture(String picture, Integer propId) {
		super();
		this.propId = propId;
		this.picture = picture;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPropId() {
		return propId;
	}
	public void setPropId(Integer propId) {
		this.propId = propId;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Picture [id=");
		builder.append(id);
		builder.append(", propId=");
		builder.append(propId);
		builder.append(", picture=");
		builder.append(picture);
		builder.append("]");
		return builder.toString();
	}
	
}
