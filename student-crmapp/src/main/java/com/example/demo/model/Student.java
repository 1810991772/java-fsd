package com.example.demo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="studentcrm")
@Table(name="studentcrm")
public class Student {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
 private int id;
	 @Column(name = "name")
private String name;
	 @Column(name = "email")
private String email;
	 @Column(name = "phone_no")
private int mbnumber;
	 
	public Student() {
		
	}

	public Student(int id, String name, String email, int mbnumber) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mbnumber = mbnumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMbnumber() {
		return mbnumber;
	}

	public void setMbnumber(int mbnumber) {
		this.mbnumber = mbnumber;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", mbnumber=" + mbnumber + "]";
	}

}
