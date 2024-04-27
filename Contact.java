package contactServices;

public class Contact {
	private final String contactId;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNum;
	public Object getfName;
	
	//Constructor
	public Contact(String id, String fName, String lName, String initAddress, String phone) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if (fName == null || fName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if (lName == null || lName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if (initAddress == null || initAddress.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invald phone number");
		}
		this.contactId = id;
		this.firstName = fName;
		this.lastName = lName;
		this.address = initAddress;
		this.phoneNum = phone;
	}
	
	//Getters
	public String getId() {
		return this.contactId;
	}
	public String getfName() {
		return this.firstName;
	}
	public String getlName() {
		return this.lastName;
	}
	public String getAddress() {
		return this.address;
	}
	public String getPhone() {
		return this.phoneNum;
	}
	
	//Setters
	public void setFName(String nameToSet) {
		if (nameToSet == null || nameToSet.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = nameToSet;
	}
	
	public void setLName(String nameToSet) {
		if (nameToSet == null || nameToSet.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = nameToSet;
	}
	
	public void setAddress(String addressToSet) {
		if (addressToSet == null || addressToSet.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		this.address = addressToSet;
	}
	
	public void setPhone(String phoneToSet) {
		if (phoneToSet == null || phoneToSet.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		this.phoneNum = phoneToSet;
	}
}