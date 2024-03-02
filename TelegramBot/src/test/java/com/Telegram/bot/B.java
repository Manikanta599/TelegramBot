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
import java.sql.*;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand.*;
public class B extends TelegramLongPollingBot {
	
	private static final String url = "jdbc:mysql://localhost:3306/STU_dATA";
    private static final String username = "root";
    private static final String password = "root";
    
    
	static String fname="";
	static int first_msg = 0;
//    static int keyb = 0;
    static int lg = 0;
    static int sr=0;
    static int sem_up =0;
    static String sem_name = "";
    static boolean sem_val = false;
    static int log=0;
    static int rg=0;
    static int nam=0;
    static int em=0;
    static int ph=0;
    static int reg=0;
    
    static int logout=0;
    static int e=0;
    Connection con1;
    @Override
    
    public void onUpdateReceived(Update update) {
    	
    	
    		System.out.println("logout "+logout);
    	
    	try {
    		
			Connection con = DriverManager.getConnection(url, username, password);
			con1=con;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    	
    	System.out.println("0");
    	Profile p=new Profile(con1);
    	Semisters sems=new Semisters(con1);
    	UpdateM up =new UpdateM(con1);
    	Registration r=new Registration(con1);
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
        	
        	lg=0;
        	System.out.println("main inner");
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            if (message_text.equals("/start")) {
            	System.out.println("1");
            	
           	System.out.println(message_text);
            	sendStartMessage(chat_id);
            	   	
            }
            else if(sem_up ==1) {
            	
           
               System.out.println(message_text);
           	if(message_text.startsWith("sem")) {
           		SendMessage message = new SendMessage();
         		 message.setChatId(chat_id);
                  message.setText("Enter Subject Code and Grade"+"\n"+" Example : ES1112 O");
           		
           		sem_name = message_text; 
           		
           		System.out.println("11"+sem_name);
           		try {
                    execute(message);
           		}
           		catch (TelegramApiException e) {
                    e.printStackTrace();
                }
          	}
           	else if(message_text.equals("return")) {
        		sem_up = 0;
        		getMainKeyboardMarkup(chat_id);
        	}
           	else {
        		
                up.semsUpdate(message_text,sem_name,p.stu_id,chat_id);
           		}
        	
         }
           
            else if(message_text.equals("sem 1")) {
            	
            	sems.Sem1(chat_id,p.stu_id);
            	
            }
            
            else if(message_text.equals("sem 2")) {
            	
            	sems.Sem2(chat_id,p.stu_id);
            	
            }
            
            else if(message_text.equals("sem 3")) {
            	
            	 sems.Sem3(chat_id, p.stu_id);
            		
            }
            
            else if(message_text.equals("sem 4")) {
            	
            	 sems.Sem4(chat_id, p.stu_id);
            		
            }
            
            else if(message_text.equals("sem 5")) {
            	
            	 sems.Sem5(chat_id, p.stu_id);
            	
            		
            }
            
            else if(message_text.equals("sem 6")) {
            	
            	 sems.Sem6(chat_id, p.stu_id);
            		
            }
            
            else if(message_text.equals("sem 7")) {
            	
            	 sems.Sem7(chat_id, p.stu_id);
            }
            
            else if(message_text.equals("sem 8")) {
            	 sems.Sem8(chat_id, p.stu_id);
            }
            
            else if(message_text.equals("return")) {
            	SendMessage message = new SendMessage();
            	 message.setChatId(chat_id);
            	 getMainKeyboardMarkup(chat_id);
            	message.setText("returned..");
            	
            	try {
            	     execute(message);
            	 } catch (TelegramApiException e) {
            	     e.printStackTrace();
            	 } 	
            }
            
            else if(message_text.equals("Overview"))
            {
            	System.out.println("ovov");
            	sems.overview(chat_id,p.stu_id);
            }
            
            else if(message_text.equals("View Profile"))
            {	
           	 	p.viewProfile(chat_id);
            }
            else if(message_text.equals("Login")) {
            	log= 1;
            	reg=0;
            	SendMessage message = new SendMessage(); 
         		message.setChatId(chat_id);
         		message.setText("Enter Your ID");
         		
         		try {
                    execute(message); 
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            
             
            
            else if(log==1)
            {
            	
            	//log=0;
            	if(!message_text.equals("Login"))
            	{
            		
            		//System.out.println(p.again+"again");
//                	inputName(message_text,chat_id);
                	if(message_text.equals("Registration"))
                	{
                		
                		System.out.println("in reg");
                		reg=1;
                		log=0;
                		e=1;
                		SendMessage message = new SendMessage();
                   	 	message.setChatId(chat_id);
                   	 	message.setText("Enter regdno");
                   	try {
                   			execute(message);
                   			
                	}
                   	catch (TelegramApiException e) {
                  	     e.printStackTrace();
                  	 } 
                	}
                	
                	else
                	{
                		if(e!=1)
                		{
                			p.userValidation(message_text, chat_id);
                        	System.out.println(message_text);
                        	System.out.println("3");
                        	lg=1;
                        	first_msg=0;
                        	p.again=0;
                        	System.out.println("kyb"+p.keyb);
                        	if(p.keyb==1)
                            {
                            	System.out.println("keyboard");
                            	getMainKeyboardMarkup(chat_id);
                            }
                		}
                		
                	}
            	}
            	else
            	{
            		if(message_text.equals("Registration"))
                	{
                		
                		System.out.println("in reg");
                		reg=1;
                		log=0;
                		e=1;
                		SendMessage message = new SendMessage();
                   	 	message.setChatId(chat_id);
                   	 	message.setText("Enter regdno");
                   	try {
                   			execute(message);
                	}
                   	catch (TelegramApiException e) {
                  	     e.printStackTrace();
                  	 } 
                	}
            	}
            	
            }
            

            
  
            else if(message_text.equals("profile"))
            {
            	profileMethod(chat_id);
            }
            
            else if(message_text.equals("sem_results"))
            {
            	 selectSem(chat_id);
            	
            	System.out.println("cur");
          }
            
            else if(message_text.equals("View Results"))
            {
            	sem_Results(chat_id);
            }
            else if(message_text.equals("Update Results"))
            {
            	sems.updatesems(chat_id);
            	System.out.println("update res..");
            	
            	sem_up =1;
            }
            else if(message_text.equals("LogOut"))
            {
            	logOutMet();
            	SendMessage message = new SendMessage();
           	 	message.setChatId(chat_id);
           	 	message.setText("Logout Successfull!!"+"\n"+"If you want to Login again"+"\n"+"Press /start");
           	 	
           	try {
           	     execute(message);
           	     logout=0;
           	     
           	 } catch (TelegramApiException e) {
           	     e.printStackTrace();
           	 } 
            }
            else if(message_text.equals("attendence"))
            {
            	System.out.println("att");
            	attendenceMethod(chat_id,p.stu_id);
            }
            else if(message_text.equals("Registration"))
            {
            	reg=1;
            	System.out.println("regstarion");
            	SendMessage message = new SendMessage();
           	 	message.setChatId(chat_id);
           	 	message.setText("Enter Regd number");
           	try {
           	     execute(message);
           	 } catch (TelegramApiException e) {
           	     e.printStackTrace();
           	 } 	
            }
            
            else if(reg==1)
            {
            	System.out.println("reg==1");
            	regm(chat_id,message_text,r);
            	
            }
  
        } 
        
        
   }
    
    private void regm(long chat_id,String message_text,Registration r) {
		// TODO Auto-generated method stub
    	System.out.println("reg "+reg);
    	if(!message_text.equals("Registration"))
    	{
    		//String msg="";
    		if(rg==0)
        	{
    			
        		r.regdID(chat_id,message_text);
        		SendMessage message = new SendMessage();
           	 	message.setChatId(chat_id);
           	 	message.setText("Enter Name");
           	try {
           		if(reg!=0)
           		{
           			execute(message);
           		}
           	     
           	 } catch (TelegramApiException e) {
           	     e.printStackTrace();
           	 } 	
        	}
        	else if(nam==0)
        	{
        		r.nameReg(chat_id,message_text);
        		SendMessage message = new SendMessage();
           	 	message.setChatId(chat_id);
           	 	message.setText("Enter Email");
           	try {
           	     execute(message);
           	 } catch (TelegramApiException e) {
           	     e.printStackTrace();
           	 } 	
        	}
        	else if(em==0)
        	{
        		r.emailReg(chat_id,message_text);
        		SendMessage message = new SendMessage();
           	 	message.setChatId(chat_id);
           	 	message.setText("Enter Phone Number");
           	try {
           	     execute(message);
           	 } catch (TelegramApiException e) {
           	     e.printStackTrace();
           	 } 	
        	}
        	else if(ph==0)
        	{
        		r.phnoReg(chat_id,message_text);
        		
        		if(rg==1&&nam==1&&em==1&&ph==1)
            	{
            		
            		
            			reg=0;
            			SendMessage message = new SendMessage();
                   	 	message.setChatId(chat_id);
                   	 	message.setText("Registration Successfull!!");
                   	 	e=0;
                   	 	
                   	try {
                   	     execute(message);
                   	 } catch (TelegramApiException e) {
                   	     e.printStackTrace();
                   	 } 	
            			
            		
            	}
        		
        	}
        	
    	}
		
	}

	private void logOutMet() {
		// TODO Auto-generated method stub
    	final int logou=1;
    	System.out.println("in log "+logout);
		
	}

	private void sendStartMessage(long chatId) {
    		
    	System.out.println("send key");
   
    	SendMessage message = new SendMessage(); 
 		message.setChatId(chatId);
 		message.setText("Please select option & ");
    	
 		
 		ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a keyboard row
        KeyboardRow row = new KeyboardRow();
        // Set each button, you can also use KeyboardButton objects if you need something else than text
        
        row.add("Login");
        row.add("Registration");
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
    
    
   
   
    
    private void profileMethod(long chatid)
    {
    	SendMessage message = new SendMessage(); 
 		message.setChatId(chatid);
 		message.setText("Please select option..");
 		ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a keyboard row
        KeyboardRow row = new KeyboardRow();
        // Set each button, you can also use KeyboardButton objects if you need something else than text
        
        row.add("View Profile");
        
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
    
    
 
    
   
    private void sem_Results(long chatid)
    {
    	sr=1;
    	SendMessage message = new SendMessage(); 
 		message.setChatId(chatid);
 		message.setText("sem results..");
 		ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a keyboard row
        KeyboardRow row = new KeyboardRow();
        // Set each button, you can also use KeyboardButton objects if you need something else than text
        
        row.add("sem 1");
        row.add("sem 2");
        row.add("sem 3");
        // Add the first row to the keyboard
        keyboard.add(row);
        // Create another keyboard row
        KeyboardRow row2 = new KeyboardRow();
        row2.add("sem 4");
        row2.add("sem 5");
        row2.add("sem 6");
        
        keyboard.add(row2);
        
        
        KeyboardRow row3 = new KeyboardRow();
        row3.add("sem 7");
        row3.add("sem 8");
        row3.add("return");
        
        keyboard.add(row3);
        
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
    
  
    private void notesMethod(long chatid)
    {
    	SendMessage message = new SendMessage(); 
 		message.setChatId(chatid);
 		message.setText("notes method");
 		
 		try {
            execute(message); 
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    
    
    private void attendenceMethod(long chatid,String id)
    {
    	
 		String query="SELECT Attendance FROM attendance WHERE ID=?";
 		
 		PreparedStatement pst;
		try {
			pst = con1.prepareStatement(query);
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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    private void codingMethod(long chatid)
    {
    
    	SendMessage message = new SendMessage(); 
 		message.setChatId(chatid);
 		message.setText("your coding");
 		
 		try {
            execute(message); 
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    
    
    private  void getMainKeyboardMarkup(long chatid) {
    	
    	SendMessage message = new SendMessage(); // Create a message object object
		message.setChatId(chatid);
		message.setText("Here is your keyboard");
    	
		ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a keyboard row
        KeyboardRow row = new KeyboardRow();
        // Set each button, you can also use KeyboardButton objects if you need something else than text
        
        row.add("profile");
        row.add("sem_results");
        row.add("attendence");
        // Add the first row to the keyboard
        keyboard.add(row);
        // Create another keyboard row
        row = new KeyboardRow();
        // Set each button for the second line
        row.add("Notes");
        row.add("Overview");
        row.add("Update Results");
        row.add("LogOut");
        // Add the second row to the keyboard
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
    
    private void selectSem(long chatid) 
    {
    	System.out.println("select kb");
    	SendMessage message = new SendMessage(); // Create a message object object
		message.setChatId(chatid);
		message.setText("Select keyboard");
		
    	
		ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a keyboard row
        KeyboardRow row = new KeyboardRow();
        // Set each button, you can also use KeyboardButton objects if you need something else than text
        
        row.add("View Results");
       
        row.add("return");
        // Add the first row to the keyboard
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);
        // Add it to the message
        message.setReplyMarkup(keyboardMarkup);
        try {
            execute(message); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        
    }

    
    
    
    
    @Override
    public String getBotUsername() {
        // Return bot username
        // If bot username is @MyAmazingBot, it must return 'MyAmazingBot'
        return "Tetrississ_bot";
    }

    @Override
    public String getBotToken() {
        // Return bot token from BotFather
        return "6791707338:AAHuCpcnlysc-PqzwmeDom_3X4gbDOmZK4M";
    }
    
    
    
    
	
}
