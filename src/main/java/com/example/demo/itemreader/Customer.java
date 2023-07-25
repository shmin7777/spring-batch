package com.example.demo.itemreader;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	private String firstName;
	private String middleInitial;
	private String lastName;
	private String address;
//	private String street;
	private String city;
	private String state;
	private String zipCode;
}
