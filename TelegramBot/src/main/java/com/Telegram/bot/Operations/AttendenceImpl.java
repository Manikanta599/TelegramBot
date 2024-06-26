package com.Telegram.bot.Operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.Telegram.bot.Bot;

public class AttendenceImpl extends Bot implements Attendence {
	Connection con;
	
	

	public AttendenceImpl(Connection con) {
		super();
		this.con = con;
	}



	@Override
	public void attendenceMethod(long chatid, String id) {
		// TODO Auto-generated method stub
		String query="SELECT Attendance FROM attendance WHERE ID=?";
 		
 		PreparedStatement pst;
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, id);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
			{
				double att=rs.getDouble("Attendance");
				
				SendMessage message1 = new SendMessage(); 
		 		message1.setChatId(chatid);
		 		message1.setText("your Attendence "+att);
		 		System.out.println(att);
		 		try {
		            execute(message1); 
		        } catch (TelegramApiException e) {
		            e.printStackTrace();
		        }
				
				
			}
			else
			{
				SendMessage message = new SendMessage();
		   	 	message.setChatId(chatid);
		   	 	message.setText("Attendence Not Updated Yet!!");
		   	try {
		   	     execute(message);
		   	 } catch (TelegramApiException e) {
		   	     e.printStackTrace();
		   	 } 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
