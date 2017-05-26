package com.skilldistillery.data;

import java.io.IOException;
import java.util.List;

public interface PropertyDao {
	void loadFile();
	List<Property> getAllProperties();
	Property addPropertyToDb(Property p);
	void removeProperty(String s) throws IOException;
	void editProperty(String aBE, String address, Double rent, Double purchasePrice, Double capRate);
	Property addAddressToDb(Address address);
	Property getPropertyById(Integer propertyId);
	Address getAddressByPropId(Integer propId);
	Caprate getCaprateById(Integer capRateId);
	List<Note> getNotesByPropId(Integer propertyId);
	List<Picture> getPicturesByPropId(Integer propertyId);
}
