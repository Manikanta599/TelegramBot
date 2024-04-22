package com.Telegram.bot.Operations;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.exceptions.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.Telegram.bot.Bot;

public class ProfileImpl extends Bot implements Profile{
	
	Connection con;
	SemistersImpl ss;
	static double cgpa1=0.0;
	static double cgpa2=0.0;
	static double cgpa3=0.0;
	static double cgpa4=0.0;
	static String reg_id="";
	
	public int keyb=0;
	static String fname="";
	static String stu_id;
	public int again=0;
	boolean f=true;
	public ProfileImpl(Connection con)
	{
		this.con=con;

	}
	
	
	
	public  String getReg_id() {
		return reg_id;
	}



	public static void setReg_id(String reg_id) {
		ProfileImpl.reg_id = reg_id;
	}



	public int getKeyb() {
		return keyb;
	}



	public void setKeyb(int keyb) {
		this.keyb = keyb;
	}



	public  String getStu_id() {
		return stu_id;
	}



	public static void setStu_id(String stu_id) {
		ProfileImpl.stu_id = stu_id;
	}
	
	



	
	
	public int getAgain() {
		return again;
	}



	public void setAgain(int again) {
		this.again = again;
	}



	public void userValidation(String name,long chatid)
	{
		
		
		System.out.println("user valid");
    	System.out.println("name "+name);
    	fname=name;
    	try {	
    	String ids=name.substring(0,3);
    	//int id=Integer.parseInt(ids);
    	String id=ids;
    	if(id==null)
    	{
    		Bot.reg=1;
    	}
    	stu_id=ids;
    	System.out.println(id);
    	String query="SELECT * FROM profile WHERE id=?";   	
    	PreparedStatement pst=con.prepareStatement(query);	
    	pst.setString(1, id);   	
    	ResultSet rs=pst.executeQuery();   	
    	if(rs.next())
    	{
    	 SendMessage message = new SendMessage();
       	 message.setChatId(chatid);
       	 reg_id=id;
       	message.setText("Valid user "+" \n"+" Enter Your Password..");
       	Bot.log=0;
       	System.out.println(log+"in valid");
       	f=false;
       	
       	Bot.passValid=1;
       	try {
       	     execute(message);
       	 } catch (TelegramApiException e) {
       	     e.printStackTrace();
       	 } 	
    	}
    	else
    	{
    		SendMessage message = new SendMessage();
          	 message.setChatId(chatid);
          	message.setText("InValid user Try again "+"\n "+"or Register if you don't have account !!");
          	again=1;
          	//B.reg=1;
          	Bot.log=1;
          	try {
          	     execute(message);
          	 } catch (TelegramApiException e) {
          	     e.printStackTrace();
          	 } 	
    	}
	}
    catch(SQLException e)
    	{
    	e.printStackTrace();
    	}
  
	}


	
	public void viewProfile(long chat_id)
    {
    	String name=fname;
    	System.out.println("profile met");
    	System.out.println("name "+name);
    	try {
    	String ids=name.substring(0,3);
    	int id=Integer.parseInt(ids);
    	System.out.println(id);
    	String query="SELECT * FROM profile WHERE id=?";   	
    	PreparedStatement pst=con.prepareStatement(query);	
    	pst.setInt(1, id);   	
    	ResultSet rs=pst.executeQuery();   	
    	if(rs.next())
    	{
    		int i=rs.getInt("id");
    		String names=rs.getString("name");
    		String email=rs.getString("email");
    		String phno=rs.getString("phno");   		
    		
    		// Construct the combined message
    		String combinedMessage = i + "\n" + names + "\n" + email + "\n" + phno;

    		// Create a single SendMessage object
    		SendMessage message = new SendMessage();
    		message.setChatId(chat_id);
    		message.setText(combinedMessage);

    		try {
    		    // Execute the single message
    		    execute(message);
    		} catch (TelegramApiException e) {
    		    e.printStackTrace();
    		}

    		
    	}
    	else
    	{
    		System.out.println("invalid user try again");
    	} 
    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }



	public void loginMet(long chat_id, String message_text) {
		// TODO Auto-generated method stub
		
		
		
		
	}



	public void regd(long chat_id, String message_text) {
		// TODO Auto-generated method stub
		Bot.rg=1;
		System.out.println("id "+message_text);
	}



	public void namer(long chat_id, String message_text) {
		// TODO Auto-generated method stub
		Bot.nam=1;
		System.out.println("name"+message_text);
	}



	public void email(long chat_id, String message_text) {
		// TODO Auto-generated method stub
		Bot.em=1;
		System.out.println("email "+message_text);
		
	}



	public void phno(long chat_id, String message_text) {
		// TODO Auto-generated method stub
		Bot.ph=1;
		System.out.println("phno "+message_text);
	}



	public void PassWordValidation(String message_text, long chat_id) {
		
		String query="select Password from profile where ID= ?";
		
		System.out.println("password "+message_text);
		
		System.out.println("reg id "+reg_id);
		
		try {
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,reg_id);
			
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
			{
				String password=rs.getString("Password");
				System.out.println("password from db "+password);
				if(password.equals(message_text))
				{
					Bot.passValid=0;
					keyb=1;
					SendMessage msg=new SendMessage();
					msg.setChatId(chat_id);
					msg.setText("correct password!!");
					try {
		    		    // Execute the single message
		    		    execute(msg);
		    		} catch (TelegramApiException e) {
		    		    e.printStackTrace();
		    		}
					
					System.out.println("profile PassValid "+Bot.passValid +" keyb "+keyb);
				}
				else
				{
					Bot.passValid=1;
					System.out.println("in else..");
					SendMessage msg=new SendMessage();
					msg.setChatId(chat_id);
					msg.setText("please enter correct password!!");
					try {
		    		    // Execute the single message
		    		    execute(msg);
		    		} catch (TelegramApiException e) {
		    		    e.printStackTrace();
		    		}
				}
				
			}
			else
			{
				
			}
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public void ChangePassword(String message_text, long chat_id) {
		
		System.out.println("in change password..");
		Bot.change_pass=0;
		String query="update profile set Password = ? where id= ?";
		
		PreparedStatement pst;
		
		System.out.println("new password "+message_text +" reg id"+ reg_id);
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, message_text);
			pst.setString(2, reg_id);
			
			int res=pst.executeUpdate();
			
			if(res>0)
			{
				SendMessage message=new SendMessage();
        		message.setChatId(chat_id);
        		message.setText("Password Updated..");
        		
        		try {
					execute(message);
				} catch (TelegramApiException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				SendMessage message=new SendMessage();
        		message.setChatId(chat_id);
        		message.setText("Password not updated");
        		
        		try {
					execute(message);
				} catch (TelegramApiException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
		



	
	
	
	
	 
}
