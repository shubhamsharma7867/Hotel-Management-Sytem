package hotel.management;

import java.sql.*;

public class conn {

 Statement s;
 Connection c;
 public conn(){
   try {
	   
	   Class.forName("com.mysql.jdbc.Driver");
	   c = DriverManager.getConnection("jdbc:mysql:///shubhamproject","root","1234");
	   s = c.createStatement();
   }
   catch(Exception e){
	   e.printStackTrace();
   }
 }
 
 
      
		
	}




