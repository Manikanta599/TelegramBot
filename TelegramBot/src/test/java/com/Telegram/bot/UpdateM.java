package com.Telegram.bot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
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
import java.util.*;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.mysql.cj.jdbc.PreparedStatementWrapper;

public class UpdateM extends B{
	Connection con;
	
	public UpdateM(Connection con)
	{
		this.con=con;
		
	}
	static int m=0;
	
	public void semsUpdate(String msg, String sem_name, String id,long chatid) {
	    System.out.println("sem name "+sem_name);
	    String arr[] = msg.split(" ");
	    String sub_code = arr[0];
	    String sub_grade = arr[1];
	    if (sem_name.equals("sem1")) {
	    	sem1Update(sub_code,sub_grade,id,sem_name,chatid);
	    	System.out.println("semupdate1");
	    }
	    else if(sem_name.equals("sem2"))
	    {
	    	sem2Update(sub_code,sub_grade,id,sem_name,chatid);
	    	System.out.println("semupdate1");
	    }
	    else if(sem_name.equals("sem3"))
	    {
	    	sem3Update(sub_code,sub_grade,id,sem_name,chatid);
	    	System.out.println("semupdate3");
	    }
	    else if(sem_name.equals("sem4"))
	    {
	    	sem4Update(sub_code,sub_grade,id,sem_name,chatid);
	    	System.out.println("semupdate3");
	    }
	    else if(sem_name.equals("sem5"))
	    {
	    	sem5Update(sub_code,sub_grade,id,sem_name,chatid);
	    	System.out.println("semupdate3");
	    }
	    else if(sem_name.equals("sem6"))
	    {
	    	sem6Update(sub_code,sub_grade,id,sem_name,chatid);
	    	System.out.println("semupdate3");
	    }
	    else if(sem_name.equals("sem7"))
	    {
	    	sem7Update(sub_code,sub_grade,id,sem_name,chatid);
	    	System.out.println("semupdate3");
	    }
	    else if(sem_name.equals("sem8"))
	    {
	    	sem8Update(sub_code,sub_grade,id,sem_name,chatid);
	    	System.out.println("semupdate3");
	    }
	    
	    }

	private void sem8Update(String sub_code, String sub_grade, String id, String sem_name,long chatid) {
		// TODO Auto-generated method stub
		HashMap<String, String> sem8 = new HashMap<>();

        // Add the data to the HashMap
		sem8.put("HS4201", "MGMT_ORG_BEHAVIOR");
		sem8.put("OE4201", "CLOUD_COMPUTING");
		sem8.put("PE4201", "DEVOPS");
		sem8.put("PR4201", "PROJECT_II");
		
		boolean f=false;
		for (String key : sem8.keySet()) {
            String sub = sem8.get(key);
            if (key.equals(sub_code)) {
            	
            	updateMet(sem_name,sub,sub_grade,id,chatid);
            }
		}
		if(!f)
		{
			dispMsg(chatid);
			
		}
		
	}

	private void sem7Update(String sub_code, String sub_grade, String id, String sem_name,long chatid) {
		// TODO Auto-generated method stub
		HashMap<String, String> sem7 = new HashMap<>();

        // Add the data to the HashMap
		sem7.put("CS4101", "CRYPTO_NETWORK_SECURITY");
		sem7.put("CS4102", "UML_DP");
		sem7.put("CS4103", "ML");
		sem7.put("OE4101", "EMBEDDED_SYS");
		sem7.put("PE4101", "SP_MANAGEMENT");
		sem7.put("PE4102", "CLOUD_COMPUTING");
		sem7.put("CS4104", "UML_LAB");
		sem7.put("PR4101", "PROJECT_1");
		sem7.put("MC4101", "IPR_PATENTS");
		
		boolean f=false;
		for (String key : sem7.keySet()) {
            String sub = sem7.get(key);
            if (key.equals(sub_code)) {
            	
            	updateMet(sem_name,sub,sub_grade,id,chatid);
            }
		}
		
		if(!f)
		{
			dispMsg(chatid);
			
		}
		
	}




	private void sem6Update(String sub_code, String sub_grade, String id, String sem_name,long chatid) {
		// TODO Auto-generated method stub
		
		HashMap<String, String> sem6 = new HashMap<>();

        // Add the data to the HashMap
		sem6.put("CS3201", "WEB_TECH");
		sem6.put("CS3202", "DIST_SYS");
		sem6.put("CS3203", "DAA");
		sem6.put("PE3201", "MOOCS");
		sem6.put("OE3201", "RES");
		sem6.put("HS3201", "MEFA");
		sem6.put("CS3204", "WEB_TECH_LAB");
		sem6.put("PR3201", "INDUSTRIAL_TRAINING");
		
		boolean f=false;
		for (String key : sem6.keySet()) {
            String sub = sem6.get(key);
            if (key.equals(sub_code)) {
            	
            	updateMet(sem_name,sub,sub_grade,id,chatid);
            }
		}
		if(!f)
		{
			dispMsg(chatid);
			
		}
		
	}




	private void sem5Update(String sub_code, String sub_grade, String id, String sem_name,long chatid) {
		// TODO Auto-generated method stub
		
		HashMap<String, String> sem5 = new HashMap<>();

        // Add the data to the HashMap
		sem5.put("CS3101", "DWDM");
		sem5.put("CS3102", "CN");
		sem5.put("CS3103", "CD");
		sem5.put("CS3104", "AI");
		sem5.put("PE3101", "STM");
		sem5.put("CS3105", "CN_LAB");
		sem5.put("CS3106", "AI_LAB");
		sem5.put("CS3107", "DM_LAB");
		sem5.put("MC3101", "ES_II");
		
		boolean f=false;
		for (String key : sem5.keySet()) {
            String sub = sem5.get(key);
            if (key.equals(sub_code)) {
            	
            	updateMet(sem_name,sub,sub_grade,id,chatid);
            }
		}
		if(!f)
		{
			dispMsg(chatid);
			
		}
	}
	
	




	private void sem4Update(String sub_code, String sub_grade, String id, String sem_name,long chatid) {
		// TODO Auto-generated method stub
		HashMap<String, String> sem4 = new HashMap<>();

        // Add the data to the HashMap
		sem4.put("BS2201", "PROB_STATS");
		sem4.put("CS2201", "JAVA");
		sem4.put("CS2202", "OS");
		sem4.put("CS2203", "DBMS");
		sem4.put("CS2204", "FLAT");
		sem4.put("CS2205", "JAVA_LAB");
		sem4.put("CS2206", "UNIX_LAB");
		sem4.put("CS2207", "DBMS_LAB");
		sem4.put("MC2201", "ETHICS");
		sem4.put("PR2201", "SR_PROJECT");

		boolean f=false;
		for (String key : sem4.keySet()) {
            String sub = sem4.get(key);
            if (key.equals(sub_code)) {
            	
            	updateMet(sem_name,sub,sub_grade,id,chatid);
            }
		}
		if(!f)
		{
			dispMsg(chatid);
			
		}
	}




	private void sem3Update(String sub_code, String sub_grade, String id, String sem_name,long chatid) {
		// TODO Auto-generated method stub
		
		 HashMap<String, String> sem3 = new HashMap<>();

	        // Add the data to the HashMap
		 sem3.put("CS2101", "MATH_FOUND_CS");
		 sem3.put("CS2102", "SW_ENG");
		 sem3.put("ES2101", "PY_PROG");
		 sem3.put("CS2103", "DS");
		 sem3.put("CS2104", "OOP_CPP");
		 sem3.put("CS2105", "COMP_ORG");
		 sem3.put("ES2102", "PY_PROG_LAB");
		 sem3.put("CS2106", "DS_CPP_LAB");
		 sem3.put("MC2101", "INDIAN_KNOWLEDGE");
		 sem3.put("MC2102", "EM_SKILLS");
		 
		 boolean f=false;
		 for(String key:sem3.keySet())
		 {
			 String sub = sem3.get(key);
	            if (key.equals(sub_code)) {
	            	
	            	updateMet(sem_name,sub,sub_grade,id,chatid);
	            }
		 }
		 if(!f)
			{
				dispMsg(chatid);
				
			}
		
	}




	private void sem2Update(String sub_code, String sub_grade, String id, String sem_name,long chatid) {
		// TODO Auto-generated method stub
		HashMap<String, String> sem2 = new HashMap<>();
        // Add the data to the HashMap
        sem2.put("BS1202", "MATH_II");
        sem2.put("BS1203", "MATH_III");
        sem2.put("BS1204", "AP");
        sem2.put("ES1201", "PROB_SOL_C");
        sem2.put("ES1213", "DIG_LOGIC_DES");
        sem2.put("BS1205", "AP_LAB");
        sem2.put("HS1203", "COMM_SKILLS_LAB");
        sem2.put("ES1202", "PROB_SOL_C_LAB");
        sem2.put("PR1201", "ENG_EXP_PROJ");
        sem2.put("MC1204", "CONSTITUTION");
        
        boolean f=false;
        for (String key : sem2.keySet()) {
            String sub = sem2.get(key);
            if (key.equals(sub_code)) {
            	
            	updateMet(sem_name,sub,sub_grade,id,chatid);
            }
		}
        
        if(!f)
		{
			dispMsg(chatid); 
		}
	}

	private void sem1Update(String sub_code,String sub_grade,String id,String sem_name,long chatid)
	{
		System.out.println("sem name "+sem_name);
		System.out.println("sem1");
		HashMap<String, String> sem1 = new HashMap<>();
		sem1.put("BS1101", "Math");
		sem1.put("HS1101", "Eng");
		sem1.put("BS1106", "Chem");
		sem1.put("ES1112", "CompSci");
		sem1.put("ES1103", "EngDraw");
		sem1.put("HS1102", "EngLab");
		sem1.put("BS1107", "ChemLab");
		sem1.put("ES1105", "ITWorkshop");
		sem1.put("MC1101", "EnvSci");
		
		boolean f=false;
		for (String key : sem1.keySet()) {
            String sub = sem1.get(key);
            if (key.equals(sub_code)) {
            	f=true;
            	updateMet(sem_name,sub,sub_grade,id,chatid);
            }
		}
		
		if(!f)
		{
			dispMsg(chatid);
			
		}
	}


	//method for display enter correct sub code.
	private void dispMsg(long chatid) {
		// TODO Auto-generated method stub
		SendMessage message = new SendMessage();
      	 message.setChatId(chatid);
         	message.setText("Please Enter Correct Subject Code");
         	try {
       	     execute(message);
       	 } catch (TelegramApiException e) {
       	     e.printStackTrace();
       	 } 	
		
	}

	private void updateMet(String sem_name, String sub, String sub_grade, String id,long chatid) {
		// TODO Auto-generated method stub
		System.out.println("sem name "+sem_name);
		String query = "UPDATE "+ sem_name + " SET " + sub + " = ? WHERE ID = ?";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, sub_grade);
            pst.setString(2, id);

            String msg="";
            int c = pst.executeUpdate();
            if (c > 0) {
            	
            	msg="In "+sem_name+" "+sub+" "+"is Updated with Grade "+sub_grade;
            	SendMessage message = new SendMessage();
            	 message.setChatId(chatid);
               	message.setText(msg);
               	try {
             	     execute(message);
             	 } catch (TelegramApiException e) {
             	     e.printStackTrace();
             	 } 	
            }
            else {
            	msg="Not Updated";
            	SendMessage message = new SendMessage();
            	 message.setChatId(chatid);
               	message.setText(msg);
               	try {
             	     execute(message);
             	 } catch (TelegramApiException e) {
             	     e.printStackTrace();
             	 } 	
   
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
	}
