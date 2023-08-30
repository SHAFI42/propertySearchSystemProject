package com.amdocs.propertySearch.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Add {
	public Property Add1(Property p) throws NumberFormatException, IOException {
		
		Scanner sc = new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
        System.out.println("Enter property id: ");
        int pid=Integer.parseInt(br.readLine());
        p.setPropertyId(pid);
        
        System.out.println("Enter no of rooms(1bhk/2bhk/3bhk..): ");
        String noOfRooms=br.readLine();
        p.setNoOfRooms(noOfRooms);
        
        System.out.println("Enter area in sqft: ");
        double area=Double.parseDouble(br.readLine());
        p.setAreaInSqft(area);
        
        System.out.println("Enter floor no: ");
        int floor=Integer.parseInt(br.readLine());
        p.setFloorNo(floor);
        
        System.out.println("Enter city name: ");
        String city=br.readLine();
        p.setCity(city);
        
        System.out.println("Enter state name: ");
        String state=br.readLine();
        p.setState(state);
        
        System.out.println("Enter property cost: ");
        double cost=Double.parseDouble(br.readLine());
        p.setCost(cost);
        
        System.out.println("Enter property owner name: ");
        String name=br.readLine();
        p.setOwnerName(name);
        
        System.out.println("Enter owner contact number: ");
        String contact=br.readLine();
        p.setOwnerContactNo(contact);
        
		return p;
	}
}