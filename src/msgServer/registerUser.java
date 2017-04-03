package msgServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class registerUser implements Command{

	private BufferedReader in;
	private BufferedWriter out;
	private MsgSvrConnection conn;
	public ArrayList<UserInfo> Users = new ArrayList<UserInfo>();


public registerUser(BufferedReader in, BufferedWriter out, MsgSvrConnection serverConn)
{
  this.in = in;
  this.out = out;
  this.conn = serverConn;
}

public void execute() throws IOException
{
	
	Boolean check = null;
	String Username, Password, DOB, Telephone, Address;
	FileReader my = new FileReader("C:\\Users\\Mizan\\Documents\\ECLIPSE\\FInalNwrkCW\\src\\pwd.txt");
    BufferedReader br = new BufferedReader(my);

   
    	
	out.write("Enter New Username: ");
	out.flush();
	Username= in.readLine();
	
	out.write("Enter New Password: ");
	out.flush();
	Password = in.readLine();
	
	out.write("Enter Date of Birth: ");
	out.flush();
	DOB = in.readLine();
	
	out.write("Enter Telephone Number: ");
	out.flush();
	Telephone = in.readLine();
	
	out.write("Enter Your Address: ");
	out.flush();
	Address = in.readLine();
	
	
	UserInfo newUsr = new UserInfo(Username, Password, DOB, Telephone, Address);
	
	
	String line;
	while ((line = br.readLine()) != null) {
	    
		
		if(line.contains(Username)){
			 
			out.write("User Exists");
			out.flush();
			check = true;
			break;
			
			
		}else{
			
			check=false;
			
		}
	    
	}
				
	if(check == false){
		
		createUser(Username, Password);
		Users.add(newUsr); // adds users to arraylist
		displayAllUsers(Users);
		out.write("\r\n200 \r\n");
		out.flush();

	}
			
		
	
		
		
	}

private void displayAllUsers(ArrayList<UserInfo> users2) throws IOException {
	
	
		for(int i = 0;i<Users.size();i++){
			
			out.write(Users.get(i).toString());
			out.flush();
			
		}
	
	
}

private void createUser(String Username, String Password) throws IOException {
	// TODO Auto-generated method stub
	  
	try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Mizan\\Documents\\ECLIPSE\\FInalNwrkCW\\src\\pwd.txt", true)))) {
				pw.println(Username+"="+Password);
				

		}catch (IOException e) {
				out.write("There was a problem creating this user");
				out.flush();
		}

	


}
	
	
	

	
	

}


