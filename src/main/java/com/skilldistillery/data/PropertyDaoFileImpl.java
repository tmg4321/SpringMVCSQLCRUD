package com.skilldistillery.data;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class PropertyDaoFileImpl implements PropertyDao {

	private static final String FILE_NAME = "WEB-INF/properties.csv";
	private static final String DELIM = "|";

	private List<Property> properties = new ArrayList<>();

	@Autowired
	private WebApplicationContext wac;

	@PostConstruct
	public void loadFile() {

		try (InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line = "";
			properties.clear();
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split("\\|");
				String address = tokens[0];
				Double rent = Double.parseDouble(tokens[1]);
				Double purchasePrice = Double.parseDouble(tokens[2]);
				properties.add(new Property(address, rent, purchasePrice));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void updateFile() throws IOException {
		
		FileOutputStream fw = new FileOutputStream(wac.getServletContext().getRealPath(FILE_NAME));
        PrintWriter pw = new PrintWriter(fw);
		for (Property p : properties) {
			pw.println(p.getAddress()+DELIM+p.getRent()+DELIM+
					p.getPurchasePrice()+DELIM+p.getCapRate());
			pw.flush();
		}

		pw.close();
		loadFile();
		
	}
	
	@Override
	public List<Property> getAllProperties() {
		return new ArrayList<>(properties);
	}

	@Override
	public void addProperty(Property property) throws IOException {
		
		properties.add(property);
		updateFile();
	}
	
	@Override
	public Property getPropertyByAddress(String address) {
		for (Property p : properties) {
			if (address.equals(p.getAddress())) {
				return p;
			}
		}
		
		return null;
	}
	
	@Override
	public void removeProperty(String address) throws IOException {
		Property p = getPropertyByAddress(address);
		properties.remove(properties.indexOf(p));
		updateFile();
	}
	
	@Override
	public void editProperty(String aBE, String address, 
			Double rent, Double purchasePrice, Double capRate) {
		Property propToEdit = getPropertyByAddress(aBE);
		properties.remove(propToEdit);
		if (address != null){propToEdit.setAddress(address);}
		if (rent != null){propToEdit.setRent(rent);}
		if (purchasePrice != null){propToEdit.setPurchasePrice(purchasePrice);}
		properties.add(propToEdit);
		try {
			updateFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PropertyDaoFileImpl() {
		
	}

	@Override
	public void addAddress(Address address) {
		// TODO Auto-generated method stub
		
	}


}
