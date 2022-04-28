package org.example;

import org.example.model.Customer;
import org.example.service.CustomerService;
import org.example.service.CustomerServiceImpl;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final Scanner SC = new Scanner(System.in);

            try {

                int choice = 0;
                CustomerService customerService = new CustomerServiceImpl();

                do {
                    System.out.println("1. Create customer.");
                    System.out.println("2. Get all customers.");
                    System.out.println("3. Get customer by ID.");
                    System.out.println("4. Delete customer by ID.");
                    System.out.println("5. Update customer by ID.");
                    System.out.println("0. Exit");
                    System.out.println("Enter your choice: ");
                    choice = SC.nextInt();

                    switch (choice) {
                        case 1:
                            Customer customer = new Customer();
                            System.out.println("Enter Customer ID: ");
                            customer.setCustomerId(SC.nextInt());
                            System.out.println("Enter First Name: ");
                            customer.setFirstName(SC.next());
                            System.out.println("Enter Last Name: ");
                            customer.setLastName(SC.next());
                            System.out.println("Enter Email: ");
                            customer.setEmail(SC.next());
                            customerService.createCustomer(customer);
                            break;

                        case 2:
                            List<Customer> list = customerService.displayAllCustomers();
                            for(Customer c:list) {
                                System.out.println(c);
                            }
                            break;

                        case 3:
                            System.out.println("Enter Customer ID: ");
                            Customer c1 = customerService.getCustomerById(SC.nextInt());

                            if(c1 == null) {
                                System.out.println("No such customer found...");
                            }
                            else {
                                System.out.println("Customer Found: " + c1);
                            }
                            break;

                        case 4:
                            System.out.println("Enter Customer ID to be Deleted: ");
                            customerService.deleteCustomerById(SC.nextInt());
                            break;

                        case 5:
                            int c;
                            System.out.println("1. Update First Name.");
                            System.out.println("2. Update Last Name.");
                            System.out.println("3. Update Email.");
                            System.out.println("Enter your choice: ");
                            c = SC.nextInt();

                            switch (c) {
                                case 1:
                                    System.out.println("Enter Customer ID to be Updated: ");
                                    customerService.updateCustomerFirstNameById(SC.nextInt());
                                    break;

                                case 2:
                                    System.out.println("Enter Customer ID to be Updated: ");
                                    customerService.updateCustomerLastNameById(SC.nextInt());
                                    break;

                                case 3:
                                    System.out.println("Enter Customer ID to be Updated: ");
                                    customerService.updateCustomerEmailById(SC.nextInt());
                                    break;

                                default :
                                    System.out.println("Invalid Choice");
                                    break;
                            }
                            break;

                        case 0:
                            System.out.println("Bye...");
                            System.exit(0);

                        default:
                            System.out.println("Invalid Choice");
                            break;
                    }

                } while (choice != 0);

            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
