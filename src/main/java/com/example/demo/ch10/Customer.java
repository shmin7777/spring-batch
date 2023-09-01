package com.example.demo.ch10;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class Customer {

//    @NotNull(message = "FirstName is required")
//    @Pattern(regexp = "[a-zA-Z]+", message = "First name mulst be alphabetical")
    private String firstName;
//    @Size(min = 1, max = 1)
//    @Pattern(regexp = "[a-zA-Z]", message = "middle initial must be alphabetical")
    private String middleInitial;
//    @NotNull(message = "last name is required")
//    @Pattern(regexp = "[a-zA-Z]+", message = "lastName initial must be alphabetical")
    private String lastName;
//    @NotNull(message = "address is required")
//    @Pattern(regexp = "[0-9a-zA-Z\\. ]+")
    private String address;
//    @NotNull(message = "city is required")
//    @Pattern(regexp = "[a-zA-Z\\. ]+")
    private String city;
//    @NotNull(message = "state is required")
//    @Size(min = 2, max = 2)
//    @Pattern(regexp = "[A-Z]{2}")
    private String state;
//    @NotNull(message = "state is required")
//    @Size(min = 5, max = 5)
//    @Pattern(regexp = "\\d{5}")
    private String zipCode;
}
