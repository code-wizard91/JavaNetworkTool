package msgServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateRegistration implements Command{
	
	private BufferedReader in;
	private BufferedWriter out;
	private MsgSvrConnection conn;
	
	
	public UpdateRegistration(BufferedReader in, BufferedWriter out, MsgSvrConnection serverConn)
	{
	  this.in = in;
	  this.out = out;
	  this.conn = serverConn;
	  
	}
	
	
	public void execute() throws IOException {
		
		registerUser usr = new registerUser(in, out, conn);
		String OldUsername, OldPassword, NUsername, NPassword, DOB, Telephone, Address;
		FileReader my = new FileReader("C:\\Users\\Mizan\\Documents\\ECLIPSE\\FInalNwrkCW\\src\\pwd.txt");
	    BufferedReader br = new BufferedReader(my);
	    Boolean check = null;
	    
	    
		out.write("Enter old Username: ");
		out.flush();
		OldUsername= in.readLine();
		
		out.write("Enter NEW Username: ");
		out.flush();
		NUsername= in.readLine();
		
		out.write("Enter Date of Birth: ");
		out.flush();
		DOB = in.readLine();
		
		out.write("Enter Telephone Number: ");
		out.flush();
		Telephone = in.readLine();
		
		out.write("Enter Your Address: ");
		out.flush();
		Address = in.readLine();
		
		
			String liner;
			while ((liner = br.readLine()) != null) {
			    
				
				if(liner.contains(OldUsername)){
					 
					out.write("User Found!");
					out.flush();
					check = true;
					break;
					
					
				}else{
					
					
					check = false;
				
				}
			    
			}
						
			if(check == true){ //If the user was found
				
				try
		        {
		        File file = new File("C:\\Users\\Mizan\\Documents\\ECLIPSE\\FInalNwrkCW\\src\\pwd.txt");
		        BufferedReader reader = new BufferedReader(new FileReader(file));
		        String line = "", oldtext = "";
		        while((line = reader.readLine()) != null)
		            {
		            oldtext += line + "\r\n";
		        }
		        reader.close();
		        // replace a word in a file
		        String newtext = oldtext.replaceAll(OldUsername, NUsername);
		        
		        FileWriter writer = new FileWriter("C:\\Users\\Mizan\\Documents\\ECLIPSE\\FInalNwrkCW\\src\\pwd.txt");
		        writer.write(newtext);
		        writer.close();
		        
		    }
		    catch (IOException e)
		        {
		        e.printStackTrace();
		    }
				
			
			
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			//Here we update the user information inside the arraylist
				
				UserInfo updateuser = new UserInfo(NUsername, "****", DOB, Telephone, Address);
				usr.Users.add(updateuser);
				
				for(int i = 0; i <usr.Users.size();i++){
					
					out.write(usr.Users.toString());
					out.flush();
					
				}
				out.write("200\r\n");
				out.flush();
		
	}else{
		
		out.write("User Does not Exist");
		out.flush();
		
	}
	
	
	
	
	
	
	

	}
	}

