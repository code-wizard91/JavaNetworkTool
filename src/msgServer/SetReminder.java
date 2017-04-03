package msgServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class SetReminder extends Thread implements Command{

	private BufferedReader in;
	private BufferedWriter out;
	private MsgSvrConnection conn;
	Timer timer;
	ArrayList<Integer> noOfRem = new ArrayList<Integer>();
	
	public SetReminder(BufferedReader in, BufferedWriter out, MsgSvrConnection serverConn ){
		
		this.in = in;
		this.out = out;
		this.conn = serverConn;
		timer = new Timer();
		
	}


	
	public void execute() throws IOException {
		
		String seconds,Username;
		Boolean timeup = null;
		FileReader my = new FileReader("C:\\Users\\Mizan\\Documents\\ECLIPSE\\FInalNwrkCW\\src\\pwd.txt");
	    BufferedReader br = new BufferedReader(my);
		
	    out.write("Welcome to Message Reminder \n\r");
		out.flush();
	    
	    out.write("Enter Username: ");
		out.flush();
		Username = in.readLine();
	
		
		
		String line;
		while ((line = br.readLine()) != null) {
		    
			
			if(line.contains(Username)){
				 
				out.write("User Exists\n\r");
				conn.setCurrentUser(Username);
				out.write("Enter time for reminder: ");
				out.flush();
				seconds= in.readLine();
				int sec = Integer.parseInt(seconds);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run(){
						
						Boolean myvalue = true;
						try {
							out.write("Reminder Alert!       ");
							out.flush();
							out.write("200\r\n");
							out.flush();
							
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						timer.cancel();
					
					}
				}, sec*1000);
				
				try {
					sleep((long)(sec * 1100));
					out.write("Reminder Message \n\r");
					sendmessage();
					
					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
				
			}
		
	      
		
		
		
	}



	



	



	

	}



	protected void sendmessage() throws IOException {
	
		
		
			
		
		  out.write("Enter sender Name : ");
		  out.flush();
	      String sender = in.readLine();
	      out.write("Enter Reciepient Name : ");
		  out.flush();
	      String recipient = in.readLine();
	      out.write("Enter Message : ");
		  out.flush();
	      String content = in.readLine();
	      if (conn.getCurrentUser() != null && 
	          conn.getCurrentUser().equals(sender)) {
	        if (sender != null && recipient != null & content != null) 
	        {
	            Message m = new Message(recipient, sender, content);
	            if (conn.getServer().isValidUser(recipient)) {
	              conn.getServer().getMessages().addMessage(m);
		      out.write("200\r\n");
		      out.flush();
		      return;
	            } else 
	            {
	              (new ErrorCommand(in, out,conn, "No such recipient")).execute();                                
	            }
	        } else {
		  (new ErrorCommand(in, out,conn, "Error trying to send message")).execute();                  
		}
	      } else 
	      {
	        (new ErrorCommand(in, out,conn, "You are not logged in")).execute();                          
	      }
		
		
	}
	}
	

	

