package org.snhu.cs320.contact;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ContactTest {

	@Test
	void testSuccessfulCreation() throws Exception {
		Contact contact = new Contact("1", "first", "last", "1234455677", "123 Lehi Lane");
		assertThat(contact)
			.hasFieldOrPropertyWithValue("contactId", "1")
			.hasFieldOrPropertyWithValue("firstName", "first")
			.hasFieldOrPropertyWithValue("lastName", "last")
			.hasFieldOrPropertyWithValue("phone", "1234455677")
			.hasFieldOrPropertyWithValue("address", "123 Lehi Lane");
	
	}
	
	@Test
		void testSuccessfulSetters() throws Exception {
			Contact contact = new Contact("1", "first", "last", "1234455677", "123 Lehi Lane");
		contact.setFirstName("Jim");
			contact.setLastName("Bob");
			contact.setPhone("1112223344");
			contact.setAddress("124 Lehi Lane");
			assertThat(contact)
				.hasFieldOrPropertyWithValue("firstName", "Jim")
				.hasFieldOrPropertyWithValue("lastName", "Bob")
				.hasFieldOrPropertyWithValue("phone", "1112223344")
				.hasFieldOrPropertyWithValue("address", "124 Lehi Lane");
			
			 
	}
	@CsvSource ({
	" '', first, last,1234455677,123 Lehi Lane", //blank Id
	",first, last,1234455677,123 Lehi Lane",//Null Id
	"12345678901,first, last,1234455677,123 Lehi Lane", //Id is too long
	
	"1234,'', last,1234455677,123 Lehi Lane\"//blank first name",//blank first name
	"1234, , last,1234455677,123 Lehi Lane\"//blank first name",//Null first name
	"1234,fffffffffirstName, last,1234455677,123 Lehi Lane\"//blank first name",// long first name
	
	" 1234, first, ,1234455677,123 Lehi Lane", //blank last name
	" 1234, first, ' ',1234455677,123 Lehi Lane", //null last name 
	" '', first, llllllllllllast,1234455677,123 Lehi Lane",//long last name
	
	"1234, first, last,12344556@!,123 Lehi Lane",//phone number with special characters
	"1234, first, last,12344556L7,123 Lehi Lane",//phone with letters
	"1234, first, last,12345678910,123 Lehi Lane",//phone with long entry
	
	"1234, first, last,1234455677, ",//address with null entry
	"1234, first, last,1234455677, ''",//address left blank
	"1234, first, last,1234455677,12345678210 Lehi town square by the river Lane",//address that is too long 
	})
	@ParameterizedTest
		void testFailedCreation(String customerId, String firstName, String lastName, String phone, String address) {
			assertThatThrownBy(() -> new Contact(customerId, firstName, lastName, phone, address))
			.isNotNull();
	}
	
	@CsvSource({
	 ",",
	 "'  ',",
	 "ThisFirstNameIsTooLong,"	
	})
	@ParameterizedTest
	void testSettingFirstName(String firstName) throws Exception {
		Contact contact = new Contact("1", "first", "last", "1234455677", "123 Lehi Lane");
		assertThatThrownBy(() -> contact.setFirstName(firstName))
			.isNotNull();
	}
	
}
