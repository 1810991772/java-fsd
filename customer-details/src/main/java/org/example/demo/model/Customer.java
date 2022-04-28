package org.example.demo.model;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String stream;
    private String email;

    public Customer(String firstn, String lastn, String stream2, String email2) {
        super();
    }

    public Customer(int customerId, String firstName, String lastName,String stream, String email) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.stream = stream;
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer [Customer Id=" + customerId + ", First Name=" + firstName + ", Last Name=" + lastName + ", Stream= "+stream+", email="
                + email + "]";
    }

}
