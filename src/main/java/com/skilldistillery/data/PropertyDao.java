package com.skilldistillery.data;

import java.io.IOException;
import java.util.List;

public interface PropertyDao {
	void loadFile();
	List<Property> getAllProperties();
	void addProperty(Property p) throws IOException;
	void removeProperty(String s) throws IOException;
	Property getPropertyByAddress(String address);
}
