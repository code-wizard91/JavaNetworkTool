package msgServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public class UserInfo {
	
	
	


	private String Username;
	private String Password;
	private String DOB;
	private String Telephone;
	private String Address;
	
	
	public UserInfo(String UsernameIn, String PasswordIn, String DOBIn, String TelephoneIn, String AddressIn){
		
		Username = UsernameIn;
		Password = PasswordIn;
		DOB = DOBIn;
		Telephone = TelephoneIn;
		Address = AddressIn;
		
		
		
	}


	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getDOB() {
		return DOB;
	}


	public void setDOB(String dOB) {
		DOB = dOB;
	}


	public String getTelephone() {
		return Telephone;
	}


	public void setTelephone(String telephone) {
		Telephone = telephone;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}
	
	
	public String toString() {
		return "UserInfo [Username=" + Username + ", Password=" + Password
				+ ", DOB=" + DOB + ", Telephone=" + Telephone + ", Address="
				+ Address + "]";
	}

}
