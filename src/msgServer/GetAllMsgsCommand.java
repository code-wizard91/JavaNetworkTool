package msgServer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GetAllMsgsCommand implements Command 
{
  private BufferedReader in;
  private BufferedWriter out;
  private MsgSvrConnection conn;

  public GetAllMsgsCommand(BufferedReader in, BufferedWriter out, MsgSvrConnection serverConn)
  {
    this.in = in;
    this.out = out;
    this.conn = serverConn;
  }

  public void execute() throws IOException
  {
	//declare a variable user of type String and use it to get the user from the inputstream
	  String user; 
	  user = in.readLine();
	  Message[] msgs = null;
	  MessageCollection my = new MessageCollection();
        //check if current user is not equal to null and current user is equal to the user (use the method getCurrentUser())
	  	if(conn.getCurrentUser() != null && 
	            conn.getCurrentUser().equals(user)){
	  			
	  		
	  	
	  		
	  		
	  		msgs = conn.getServer().getMessages().getAllMessages(user);
	  				
	  				//my.getAllMessages(user);
	  		
	  		
	  		
	  			
	  			
	  			if(msgs!=null){
	  				
	  				
	  				
	  				for(int i = 0; i<msgs.length; i++){
	  				
	  				out.write(MsgProtocol.GET_ALL_MESSAGES +"\r\n");
	  				out.flush();
	  				out.write(msgs.length +"\r\n");
	  				out.flush();
	  				
	  				out.write("Sender:  ");
	  				out.flush();
	  				out.write(msgs[i].getSender()+"\r\n");
	  				out.flush();
	  				
	  				out.write("Date:  ");
	  				out.flush();
	  				out.write(msgs[i].getDate()+"\r\n");
	  				out.flush();
	  				
	  				out.write("Content:   ");
	  				out.flush();
	  				out.write(msgs[i].getContent()+"\r\n");
	  				out.flush();
	  				out.write("********End of Message********* \n\r");
	  				out.flush();
	  				
	  				
	  				
	  			}
	  			
	  		}else{
	  			
	  			(new ErrorCommand(in, out,conn, 
	  		
	  			  "There Are No Messages")).execute();
	  		}
	  		
	  	}else{
	  			
	  			(new ErrorCommand(in, out,conn, 
	  		
	  			  "You Are Not Logged on")).execute();
	  		}
      
        //intialise an array (msgs) that is used to hold all the messages read and set it's initialised value to null 
         
        //use the method getAllMessages(user) to populate the msgs array
        
        //check if msgs is not equal to null 
          
        //write to the OutputStream the message status code as specified in the protocol   
            
        //write the length of the messages returned
            
        //Loop through the messages and write the sender, date and cotent to the outputstream (use provided methods) 
          
        //Flush the outputstream
           
        //capture adequet errors (No messages) or (You are not logged on)
          
}
}