package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import converter.FullName;

@RequestScoped
@ManagedBean
public class Customer {
	private String name;
	private FullName fullName;

	public Customer(){
		
	}
	public Customer(FullName name) {
		this.fullName = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public FullName getFullName() {
		return fullName;
	}
	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}


}
