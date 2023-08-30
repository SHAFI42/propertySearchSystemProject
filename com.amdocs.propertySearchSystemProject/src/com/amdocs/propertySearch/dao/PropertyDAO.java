package com.amdocs.propertySearch.dao;



import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.amdocs.propertySearch.model.Add;
import com.amdocs.propertySearch.model.Property;
import com.amdocs.propertySearch.model.UpdateCost;

public class PropertyDAO {
	PreparedStatement pst =null;
	ConnectionDB c1 = new ConnectionDB();
	
	
	Scanner sc = new Scanner(System.in);
	
	public int addProperty(Property p) {
	    int count = 0;
	    Connection c ;
	    PreparedStatement pst;

	    try {
	        c = c1.getConnection();
	        Add a1 = new Add();
	        Property p1 = a1.Add1(p);

	        String query = "INSERT INTO propertysearch VALUES (?,?,?,?,?,?,?,?,?)";
	        pst = c.prepareStatement(query);
	        pst.setInt(1, p1.getPropertyId());
	        pst.setString(2, p1.getNoOfRooms());
	        pst.setDouble(3, p1.getAreaInSqft());
	        pst.setInt(4, p1.getFloorNo());
	        pst.setString(5, p1.getCity());
	        pst.setString(6, p1.getState());
	        pst.setDouble(7, p1.getCost());
	        pst.setString(8, p1.getOwnerName());
	        pst.setString(9, p1.getOwnerContactNo());
	        count = pst.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace(); 
	    } 

	    return count;
	}

	
	// delete property
	public int deleteProperty(int propertyId) {
		Connection c = c1.getConnection();
        int count = 0;
        try {
            String sql = "DELETE FROM Propertysearch WHERE PId = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, propertyId);
            count = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }
	
	//update property
	public int updatePropertyCost(int id) {
		Connection c = c1.getConnection();
		int count = 0;
		try {
			System.out.println("Enter the cost: ");
			double cost = sc.nextDouble();

			String query = "update propertysearch set PCost=? where PId =? ";
			pst = c.prepareStatement(query);
						
			pst.setDouble(1, cost);
			pst.setInt(2, id);
			count = pst.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return count;
	}
	
	
	//search by city
	public ArrayList<Property> searchByCity(String city) {
		Connection c = c1.getConnection();
		ArrayList<Property> l1 = new ArrayList<>();
		try {
			
			String query = "select * from propertysearch where city = ?";
			pst = c.prepareStatement(query);
						
			pst.setString(1, city);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Property p = new Property(
				rs.getInt("PId"),
				rs.getString("noOfRooms"),
				rs.getDouble("areaInSqrt"),
				rs.getInt("floorNo"),
				rs.getString("city"),
				rs.getString("state"),
				rs.getDouble("Pcost"),
				rs.getString("ownerName"),
				rs.getString("ownerNo")
				);
			
			l1.add(p);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return l1;
	}
	
	
	
	// show all property
	public ArrayList<Property> showAllProperties() {
		Connection c = c1.getConnection();
		ArrayList<Property> l4 = new ArrayList<>();
		try {
			String query = "select * from propertysearch";
			pst = c.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Property p = new Property(
				rs.getInt("PId"),
				rs.getString("noOfRooms"),
				rs.getDouble("areaInSqrt"),
				rs.getInt("floorNo"),
				rs.getString("city"),
				rs.getString("state"),
				rs.getDouble("Pcost"),
				rs.getString("ownerName"),
				rs.getString("ownerNo")
				);
				
				l4.add(p);	
			}
		}
		catch(SQLException e) {
		e.printStackTrace();
		}
		return l4;
	}
	
	
	// search by cost
	public ArrayList<Property> searchByCost(double minValue, double maxValue) {
		ArrayList<Property> l2 = new ArrayList<>();
		Connection c = c1.getConnection();
		try {
			String query = "select * from propertysearch where pcost between ? and ?";
			pst = c.prepareStatement(query);
			pst.setDouble(1, minValue);
			pst.setDouble(2, maxValue);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Property p = new Property(
				rs.getInt("PId"),
				rs.getString("noOfRooms"),
				rs.getDouble("areaInSqrt"),
				rs.getInt("floorNo"),
				rs.getString("city"),
				rs.getString("state"),
				rs.getDouble("Pcost"),
				rs.getString("ownerName"),
				rs.getString("ownerNo")
				);
				l2.add(p);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();	
		}
		return l2;
	}
	
	// search by city and number of rooms
	public ArrayList<Property> searchByNoOfRoomsAndCity(String x, String y) {
		ArrayList<Property> l3 = new ArrayList<>();
		Connection c = c1.getConnection();
		try {
			String query = "select * from propertysearch where noOfRooms = ? and city = ?";
			pst = c.prepareStatement(query);
			pst.setString(1, x);
			pst.setString(2, y);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Property p = new Property(
						rs.getInt("PId"),
						rs.getString("noOfRooms"),
						rs.getDouble("areaInSqrt"),
						rs.getInt("floorNo"),
						rs.getString("city"),
						rs.getString("state"),
						rs.getDouble("Pcost"),
						rs.getString("ownerName"),
						rs.getString("ownerNo")
						);
				l3.add(p);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return l3;
	}
	
}

