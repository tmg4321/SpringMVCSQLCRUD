package com.skilldistillery.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PropertyDaoDbImpl implements PropertyDao {
	private static String url = "jdbc:mysql://localhost:3306/incomeproperties";
	private String user = "ipuser";
	private String pass = "ipuser";
	
	public PropertyDaoDbImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error loading MySQL Driver!!!");
		}
	}
	
	@Override
	public void loadFile() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Property> getAllProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Property addPropertyToDb(Property property) {
		int newId = 0;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);

			String sql = "INSERT INTO property (address_id) VALUES (?);";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, property.getAddress().getId());
			stmt.executeUpdate();
			ResultSet keys = stmt.getGeneratedKeys();
			if (keys.next()) {
				newId = keys.getInt(1);
			}
			property.setId(newId);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return property;
	}


	@Override
	public void removeProperty(String s) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void editProperty(String aBE, String address, Double rent, Double purchasePrice, Double capRate) {
		// TODO Auto-generated method stub

	}

	@Override
	public Property addAddressToDb(Address address) {
		int newId = 0;
		Property property = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);

			String sql = "INSERT into address (street_address, city, state_abbreviation)"+
					"values(?,?,?);";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, address.getStreetAddress());
			stmt.setString(2, address.getCity());
			stmt.setString(3, address.getStateAbbreviation());
			stmt.executeUpdate();
			ResultSet keys = stmt.getGeneratedKeys();
			if (keys.next()) {
				newId = keys.getInt(1);
			}
			address.setId(newId);
			property = useNewAddressToCreateNewPropAndAddToDb(address);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return property;
	}
	
	public Property useNewAddressToCreateNewPropAndAddToDb(Address a) {
		int newPropId = 0;
		Property property = new Property(a);
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);

			String sql = "INSERT INTO property (address_id) VALUES (?);";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, a.getId());
			stmt.executeUpdate();
			ResultSet keys = stmt.getGeneratedKeys();
			if (keys.next()) {
				newPropId = keys.getInt(1);
			}
			a.setPropertyId(newPropId);
			String sql1 = "INSERT INTO address (property_id) VALUES (?) WHERE id = ?;";
			PreparedStatement stmt1 = conn.prepareStatement(sql1);
			stmt1.setInt(1, newPropId);
			stmt1.setInt(2, a.getId());
			stmt1.executeUpdate();
			
			stmt.close();
			stmt1.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return property;
	}
	
	@Override
	public Address getAddressByPropId(Integer propId) {
		Address address = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT id, property_id, street_address, city, state_abbreviation,"
					+ "zip_code FROM address WHERE property_id = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, propId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int addrId = rs.getInt(1);
				int propertyId = rs.getInt(2);
				String streetAddr = rs.getString(3);
				String city = rs.getString(4);
				String stateAbbr = rs.getString(5);
				int zip = rs.getInt(6);
				address = new Address(streetAddr, city, stateAbbr, zip);
				address.setId(addrId);
				address.setPropertyId(propertyId);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return address;
	}

	@Override
	public Property getPropertyById(Integer id) {
		Property property = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT id, address_id, caprate_id, note_id, picture_id, "
					+ "rent, purchase_price FROM property WHERE id = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int propId = rs.getInt(1);
				int addressId = rs.getInt(2);
				int capRateId = rs.getInt(3);
				int noteId = rs.getInt(4);
				int picSetId = rs.getInt(5);
				double rent = rs.getDouble(6);
				double purchasePrice = rs.getDouble(7);
				Address address = getAddressByPropId(propId);
				property = new Property(address);
				property.setId(propId);
				List<Note> notes = new ArrayList<>();
				notes = getNotesByPropId(propId);
				property.setNotes(notes);
				List<Picture> pictures = new ArrayList<>();
				pictures = getPicturesByPropId(propId);
				property.setRent(rent);
				property.setPurchasePrice(purchasePrice);
				
				Caprate cr = getCaprateById(capRateId);
				property.setCapRate(cr);
				
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Caprate getCaprateById(Integer id) {
		Caprate capRate = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT id, property_id, street_address, city, state_abbreviation,"
					+ "zip_code FROM address WHERE id = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int capRateId = rs.getInt(1);
				int propId = rs.getInt(2);
				int monthlyOpCosts = rs.getInt(3);
				int monthlyRent = rs.getInt(4);
				int purchasePrice = rs.getInt(5);
				capRate = new Caprate(monthlyOpCosts, monthlyRent, purchasePrice);
				capRate.setId(capRateId);
				capRate.setPropId(propId);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return capRate;
	}

	@Override
	public List<Note> getNotesByPropId(Integer propId) {
		List<Note> notes = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT id, property_id, note FROM note WHERE property_id = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, propId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int noteId = rs.getInt(1);
				int propertyId = rs.getInt(2);
				String note = rs.getString(3).trim();
				Note n = new Note(note, propertyId);
				n.setId(noteId);
				notes.add(n);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notes;
	}

	@Override
	public List<Picture> getPicturesByPropId(Integer propId) {
		List<Picture> pictures = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT id, property_id, picture FROM picture WHERE property_id = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, propId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int picId = rs.getInt(1);
				int propertyId = rs.getInt(2);
				String pic = rs.getString(3).trim();
				Picture picture = new Picture(pic, propertyId);
				picture.setId(picId);
				pictures.add(picture);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pictures;
	}

}

