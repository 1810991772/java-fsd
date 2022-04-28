package org.example.demo.repo;

import java.util.List;

import javax.persistence.TypedQuery;

import org.example.demo.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.openSession();

		// create a query
		TypedQuery<Customer> query = currentSession.createQuery("FROM customermvc", Customer.class);

		// execute query and get result list
		List<Customer> customers = query.getResultList();
		System.out.print(customers);
		// return the results
		return customers;
	}

}
