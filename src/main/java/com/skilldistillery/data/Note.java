package com.skilldistillery.data;

public class Note {
	private Integer id;
	private Integer propId;
	private String line;
	
	public Note(String note, Integer propId) {
		super();
		this.line = note;
		this.propId = propId;
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
	public String getLine() {
		return line;
	}
	public void setLine(String note) {
		this.line = note;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(line);
		return builder.toString();
	}
	
	
	
}
