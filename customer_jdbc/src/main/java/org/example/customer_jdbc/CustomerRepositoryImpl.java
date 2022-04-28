package org.example.customer_jdbc;

import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

	@Override
	public void getAllCustomers(List l) {
		// TODO Auto-generated method stub
		for (int i= 0;i<l.size();i++) { 		      
	          System.out.println(l.get(i)); 		
	      }  
	}
	}


