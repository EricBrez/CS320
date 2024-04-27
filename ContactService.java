package contactServices;

import java.util.ArrayList;

public class ContactService {
	String lastID;
	String newID;
	ArrayList<Contact> contactList = new ArrayList<Contact>();
	int j = 1;
	
	//Create unique ID
	public static String GenID(String LastID, int j) {
		int i = Integer.parseInt(LastID);
		++i;
		String uniqueID = String.valueOf(i);
		if (uniqueID.length() > 10 ) {
			uniqueID = uniqueID.substring(j);
		}
		return uniqueID;
	}
	
	//Create new contact
	public void createContact(String fName, String lName, String address, String phoneNum) {
		if (contactList.isEmpty()) {
			newID = "1";
			lastID = "1";
		}
		else {
			lastID = contactList.get(contactList.size()-1).getId();
			newID = GenID(lastID, j);
			lastID = newID;
			++j;
		}
		
		Contact thisContact = new Contact(newID, fName, lName, address, phoneNum);
		contactList.add(thisContact);
	}
	
	//Delete existing contact
	public void deleteContact(String idToDelete) {
		for (int x = 0; x < contactList.size(); ++x) {
			if (contactList.get(x).getId() == idToDelete) {
				contactList.remove(x);
			}
		}
	}
	
	//Update existing contact first name
	public void updateFName(String idToUpdate, String newName) {
		for (int x = 0; x < contactList.size(); ++x) {
			if (contactList.get(x).getId() == idToUpdate) {
				contactList.get(x).setFName(newName);
			}
		}
	}
	
	//Update existing contact last name
	public void updateLName(String idToUpdate, String newName) {
		for (int x = 0; x < contactList.size(); ++x) {
			if (contactList.get(x).getId() == idToUpdate) {
				contactList.get(x).setLName(newName);
			}
		}
	}
	
	
	//Update existing contact address
	public void updateAddress(String idToUpdate, String newAddress) {
		for (int x = 0; x < contactList.size(); ++x) {
			if (contactList.get(x).getId() == idToUpdate) {
				contactList.get(x).setLName(newAddress);
			}
		}
	}
	
	//Update existing contact phone number
	public void updatePhone(String idToUpdate, String newPhone) {
		for (int x = 0; x < contactList.size(); ++x) {
			if (contactList.get(x).getId() == idToUpdate) {
				contactList.get(x).setPhone(newPhone);
			}
		}
	}
	
	public Contact getContact(String idToGet) {
		for (int x = 0; x < contactList.size(); ++x) {
			if (contactList.get(x).getId() == idToGet) {
				return contactList.get(x);
			}
		}
		return null;
	}
	
	public int countList() {
		return contactList.size();
	}
	
	public ArrayList getContactList() {
		return this.contactList;
	}
}
