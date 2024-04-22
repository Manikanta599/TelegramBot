package com.Telegram.bot.GetObjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.Telegram.bot.Operations.Attendence;
import com.Telegram.bot.Operations.AttendenceImpl;
import com.Telegram.bot.Operations.Notes;
import com.Telegram.bot.Operations.NotesImpl;
import com.Telegram.bot.Operations.Profile;
import com.Telegram.bot.Operations.ProfileImpl;
import com.Telegram.bot.Operations.Registration;
import com.Telegram.bot.Operations.RegistrationImpl;
import com.Telegram.bot.Operations.Semisters;
import com.Telegram.bot.Operations.SemistersImpl;
import com.Telegram.bot.Operations.UpdateImpl;
import com.Telegram.bot.Operations.UpdateM;
import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

public class GetObject {
	
	
	
	public Connection getConnectionObject()
	{
		String url = "jdbc:mysql://localhost:3306/STU_dATA";
	    String username = "root";
	    String password = "root";
		Connection con;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			return con;
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return null;
	}
	
	
	
	
	public Notes getNotesObject() {
	    // Instantiate an object of type Notes
	    Notes notes = new NotesImpl();
	    // Return the object
	    return notes;
	}
	
	public Profile getProfileObject()
	{
		Connection con=getConnectionObject();
		
		Profile profile= (Profile) new ProfileImpl(con);
		
		return profile;
	}
	
	public Registration getRegistrationObject()
	{
		Connection con=getConnectionObject();
		
		Registration registration=(Registration) new RegistrationImpl(con);
		
		return registration;
	}
	
	public Semisters getSemistersObject()
	{
		Connection con=getConnectionObject();
		Semisters semisters=(Semisters) new SemistersImpl(con);
		
		return semisters;
	}
	
	public UpdateM getUpdateObject()
	{
		Connection con=getConnectionObject();
		UpdateM update =(UpdateM) new UpdateImpl(con);
		
		return update;
	}
	
	public Attendence getAttendenceObject()
	{
		Connection con=getConnectionObject();
		
		Attendence attendence=(Attendence) new AttendenceImpl(con);
		
		return attendence;
	}


}
