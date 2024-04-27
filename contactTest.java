package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contactServices.Contact;

class contactTest {

	@Test
	void contact_test() {
		//Create new object
		Contact contact = new Contact("1111111", "Eric", "Breznen", "123 Drury Lane", "4255550241");
		
		//ID test
		assertNotNull(contact.getId());
		assertTrue(contact.getId().equals("1111111"));
		assertFalse(contact.getId().length() > 10);
		assertTrue(contact.getId().length() < 10 || contact.getId().length() == 10);
		
		//First name test
		assertNotNull(contact.getfName());
		assertTrue(contact.getfName().equals("Eric"));
		assertFalse(contact.getfName().length() > 10);
		assertTrue(contact.getfName().length() < 10 || contact.getfName().length() == 10);
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> contact.setFName("Billy Bob McFail"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> contact.setFName(null));
		
		contact.setFName("Alex");
		assertTrue(contact.getfName().equals("Alex"));
		
		//Last name test
		assertNotNull(contact.getlName());
		assertTrue(contact.getlName().equals("Breznen"));
		assertFalse(contact.getlName().length() > 10);
		assertTrue(contact.getlName().length() < 10 || contact.getlName().length() == 10);
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> contact.setLName("AppleJack Flynn"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> contact.setLName(null));
		
		contact.setLName("Harper");
		assertTrue(contact.getlName().equals("Harper"));
		
		//Address test
		assertNotNull(contact.getAddress());
		assertTrue(contact.getAddress().equals("123 Drury Lane"));
		assertFalse(contact.getAddress().length() > 30);
		assertTrue(contact.getAddress().length() < 30 || contact.getAddress().length() == 30);
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> contact.setAddress("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> contact.setAddress(null));
		
		contact.setAddress("1895 Waverly Place");
		assertTrue(contact.getAddress().equals("1895 Waverly Place"));
		
		//Phone number test
		assertNotNull(contact.getPhone());
		assertTrue(contact.getPhone().equals("4255550241"));
		assertTrue(contact.getPhone().length() == 10);
		assertFalse(contact.getPhone().length() < 10);
		assertFalse(contact.getPhone().length() > 10);
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> contact.setPhone("42555502411"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> contact.setPhone("425555024"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> contact.setPhone(null));
		
		contact.setPhone("8975642310");
		assertTrue(contact.getPhone().equals("8975642310"));
	}
	
	@Test
	void ContactInitTest() {
		
		//Constructor tests
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Contact("11111111111", "Eric", "Breznen", "123 Drury Lane", "4255550241"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Contact(null, "Eric", "Breznen", "123 Drury Lane", "4255550241"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Contact("1111111", "EricMichael", "Breznen", "123 Drury Lane", "4255550241"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Contact("1111111", null, "Breznen", "123 Drury Lane", "4255550241"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Contact("1111111", "Eric", "BreznenMcGillicutty", "123 Drury Lane", "4255550241"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Contact("1111111", "Eric", null, "123 Drury Lane", "4255550241"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Contact("1111111", "Eric", "Breznen", "123 Drury Lanexxxxxxxxxxxxxxxxxxxxxx", "4255550241"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Contact("1111111", "Eric", "Breznen", null, "4255550241"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Contact("1111111", "Eric", "Breznen", "123 Drury Lane", "425555024"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Contact("1111111", "Eric", "Breznen", "123 Drury Lane", "42555502410"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new Contact("1111111", "Eric", "Breznen", "123 Drury Lane", null));
	}

}
