package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contactServices.ContactService;

class contactServiceTest {

	@Test
	void contact_services_test() {
		//Create test object
		ContactService service = new ContactService();
		
		service.createContact("Eric",  "Breznen", "123 Drury Lane", "4255550241");
		assertTrue(service.countList() == 1);
		
		//Test delete contact
		service.deleteContact("1");
		assertTrue(service.countList() == 0);
		
		//Create exception test
		ContactService service2 = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> service2.createContact("HowdyPardner", "Breznen", "The Middle of Absolutely No W", "4255550241"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> service2.createContact(null, "Breznen", "The Middle of Absolutely No W", "4255550241"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> service2.createContact("Eric", "aBreznenish", "The Middle of Absolutely No W", "4255550241"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> service2.createContact("Eric", null, "The Middle of Absolutely No W", "4255550241"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> service2.createContact("Eric", "Breznen", "The Middle of Absolutely No Where", "4255550241"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> service2.createContact("Eric", "Breznen", null, "4255550241"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> service2.createContact("Eric", "Breznen", "Here", "425555024"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> service2.createContact("Eric", "Breznen", "Here", "42555502410"));
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> service2.createContact("Eric", "Breznen", "Here", null));
		
	}
	
	@Test
	void contact_Service_updateables_Test() {
		
		//Create 3 test object
				ContactService service = new ContactService();
				
				service.createContact("Eric",  "Breznen", "123 Drury Lane", "4255550241");
				service.createContact("Samuel", "Franklin", "805 148th St", "1234567890");
				service.createContact("Dean", "Roosevelt", "1600 Pennslvania Ave.", "5462138790");
				
				assertTrue(service.countList() == 3);
				
				service.updateFName("1", "Michael");
				service.updateLName("1", "Lincoln");
				service.updateAddress("1", "1234 MadeUp Boulevard");
				service.updatePhone("1", "1234567890");
				
				assertTrue(service.getContact("1").getfName().equals("Michael"));
				assertTrue(service.getContact("1").getlName().equals("Lincoln"));
				assertTrue(service.getContact("1").getAddress().equals("1234 MadeUp Boulevard"));
				assertTrue(service.getContact("1").getPhone().equals("1234567890"));
	}
}
