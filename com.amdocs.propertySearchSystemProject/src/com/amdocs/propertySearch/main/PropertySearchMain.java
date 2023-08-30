package com.amdocs.propertySearch.main;

import com.amdocs.propertySearch.dao.*;
import com.amdocs.propertySearch.model.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PropertySearchMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		String ch = "";
		do {
    		System.out.println("Choose an option from below: ");
    		System.out.println("\n1. Add new Property");
    		System.out.println("2. Update property cost");
    		System.out.println("3. Delete property");
    		System.out.println("4. Find by city");
    		System.out.println("5. View all properties");
    		System.out.println("6. Find by cost");
    		System.out.println("7. Find by no of rooms and city");
    		System.out.println("8. Exit");
    		
		choice = sc.nextInt();
		Property p1= new Property();
		PropertyDAO dao = new PropertyDAO();
		
		switch(choice) {
			case 1: 
				// add
				int i = dao.addProperty(p1);
				System.out.println(i + " new property is added.");
				break;
			case 2: 
				// update
				System.out.println("Enter property Id that you want to update cost: ");
				int x = sc.nextInt();
				int a = dao.updatePropertyCost(x);
				System.out.println(x + " property cost updated");
				break;
			case 3: 
				// delete
				System.out.println("Enter the property Id that you want to delete: ");
				int id = sc.nextInt();
				int b = dao.deleteProperty(id);
				System.out.println(b + " property deleted" );
				break;
			case 4: 
				// find by city
				ArrayList<Property> l3 = new ArrayList<Property>();
				System.out.println("Enter the city name to find property: ");
				String cname = sc.next();
				l3 = dao.searchByCity(cname);
				Property p4 = new Property();
				Iterator<Property> it = l3.iterator();
				while(it.hasNext()) {
					p4 = it.next();
					p4.DisplayProperty();
				}
				break;
			case 5: 
				// view all
				ArrayList<Property> l = new ArrayList<Property>();
				l = dao.showAllProperties();
				Property p = new Property();
				Iterator<Property> it4 = l.iterator();
				while(it4.hasNext()) {
					p = it4.next();
					p.DisplayProperty();
				}
				break;
			case 6: 
				// find by cost
				ArrayList<Property> l1 = new ArrayList<Property>();
				System.out.println("Enter the cost range(min - max)");
				System.out.println("Enter min value: ");
				Double a1 = sc.nextDouble();
				System.out.println("Enter max value: ");
				Double a2 = sc.nextDouble();
				Property p2 = new Property();
				l1 =dao.searchByCost(a1, a2);
				Iterator<Property> it1 = l1.iterator();
				while(it1.hasNext()) {
					p2 = it1.next();
					p2.DisplayProperty();
				}
				break;
			case 7: 
				// find no of rooms and city
				ArrayList<Property> l2 = new ArrayList<Property>();
				System.out.println("Enter number of rooms(1bhk/2bhk/..) and city name: ");
				String x1 = sc.next();
				String y1 = sc.next();
				Property p3 = new Property();
				l2 =dao.searchByNoOfRoomsAndCity(x1, y1);
				Iterator<Property> it2 = l2.iterator();
				while(it2.hasNext()) {
					p3 = it2.next();
					p3.DisplayProperty();
				}
				break;
			case 8: 
				// exit
				System.out.println("Successfully exited.");
				break;
			default:
			    System.out.println("Invalid output!");
			    break;
			}
		}while(choice!=8);
		
		sc.close();
		
	}

}

