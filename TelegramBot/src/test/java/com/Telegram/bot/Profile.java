package com.Telegram.bot;
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

public class Profile extends B{
	Connection con;
	
	public Profile(Connection con)
	{
		this.con=con;
	}
	
	
	
    
	public int keyb=0;
	static String fname="";
	static String stu_id;
	public int again=0;
	boolean f=true;
	
	public void userValidation(String name,long chatid)
	{
		
		
		System.out.println("user valid");
    	System.out.println("name "+name);
    	fname=name;
    	try {	
    	String ids=name.substring(0,3);
    	int id=Integer.parseInt(ids);
    	stu_id=ids;
    	System.out.println(id);
    	String query="SELECT * FROM profile WHERE id=?";   	
    	PreparedStatement pst=con.prepareStatement(query);	
    	pst.setInt(1, id);   	
    	ResultSet rs=pst.executeQuery();   	
    	if(rs.next())
    	{
    	 SendMessage message = new SendMessage();
       	 message.setChatId(chatid);
       	message.setText("Valid user");
       	f=false;
       	keyb=1;
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
          	message.setText("InValid user Try again");
          	again=1;
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
	
	
	public void overviewMet(long chat_id,String stu_id)
	{
		
	}
	
	
	 public void updateProfile(long chat_id)
	    {
	    	
	        
	        System.out.println("update ");
	        SendMessage message = new SendMessage(); 
	 		message.setChatId(chat_id);
	 		message.setText("update datails");
	 		ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
	        // Create the keyboard (list of keyboard rows)
	        List<KeyboardRow> keyboard = new ArrayList<>();
	        // Create a keyboard row
	        KeyboardRow row = new KeyboardRow();
	        // Set each button, you can also use KeyboardButton objects if you need something else than text
	        
	        row.add("Update email");
	        row.add("Update number");
	        row.add("return");
	    	
	        keyboard.add(row);
	    	
	        
	     // Set the keyboard to the markup
	        keyboardMarkup.setKeyboard(keyboard);
	        // Add it to the message
	        message.setReplyMarkup(keyboardMarkup);
	        
	        
	 		
	 		
	 		try {
	            execute(message); // Sending our message object to user
	        } catch (TelegramApiException e) {
	            e.printStackTrace();
	        }
	        
	        
	    }
	 
	 public void updateEmail(long chat_id)
	    {
		 System.out.println("update metd");
	    }
	    
	    
}