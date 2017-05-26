package com.skilldistillery.data;

public class Note {
	private Integer id;
	private Integer propId;
	private String note;
	
	public Note(String notes) {
		super();
		this.note = notes;
	}
	public Note() {
		
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
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Note [id=");
		builder.append(id);
		builder.append(", propId=");
		builder.append(propId);
		builder.append(", note=");
		builder.append(note);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
