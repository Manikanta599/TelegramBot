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
public class B extends TelegramLongPollingBot {
	
	private static final String url = "jdbc:mysql://localhost:3306/STU_dATA";
    private static final String username = "root";
    private static final String password = "root";
    
    
	static String fname="";
	static int first_msg = 0;
//    static int keyb = 0;
    static int lg = 0;
    static int sr=0;
    Connection con1;
    @Override
    
    public void onUpdateReceived(Update update) {
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
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
        	lg=0;
        	System.out.println("main inner");
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            if (message_text.equals("/start")) {
            	System.out.println("1");
//           	System.out.println(message_text);
            	sendStartMessage(chat_id);
            	
            	
            }
            
            
           
            
            else if(message_text.equals("sem 1")) {
            	SendMessage message = new SendMessage();
            	 message.setChatId(chat_id);
            	message.setText("sem-1 selected");
            	sems.Sem1(chat_id,p.stu_id);
            	try {
            	     execute(message);
            	 } catch (TelegramApiException e) {
            	     e.printStackTrace();
            	 } 	
            }
            
            else if(message_text.equals("sem 2")) {
            	SendMessage message = new SendMessage();
            	 message.setChatId(chat_id);
            	message.setText("sem-2 selected");
            	sems.Sem2(chat_id,p.stu_id);
            	try {
            	     execute(message);
            	 } catch (TelegramApiException e) {
            	     e.printStackTrace();
            	 } 	
            }
            
            else if(message_text.equals("sem 3")) {
            	SendMessage message = new SendMessage();
            	 message.setChatId(chat_id);
            	 sems.Sem3(chat_id, p.stu_id);
            	message.setText("sem-3 selected");
            	try {
            	     execute(message);
            	 } catch (TelegramApiException e) {
            	     e.printStackTrace();
            	 } 	
            }
            
            else if(message_text.equals("sem 4")) {
            	SendMessage message = new SendMessage();
            	 message.setChatId(chat_id);
            	 sems.Sem4(chat_id, p.stu_id);
            	message.setText("sem-4 selected");
            	try {
            	     execute(message);
            	 } catch (TelegramApiException e) {
            	     e.printStackTrace();
            	 } 	
            }
            
            else if(message_text.equals("sem 5")) {
            	SendMessage message = new SendMessage();
            	 message.setChatId(chat_id);
            	 sems.Sem5(chat_id, p.stu_id);
            	message.setText("sem-5 selected");
            	try {
            	     execute(message);
            	 } catch (TelegramApiException e) {
            	     e.printStackTrace();
            	 } 	
            }
            
            else if(message_text.equals("sem 6")) {
            	SendMessage message = new SendMessage();
            	 message.setChatId(chat_id);
            	 sems.Sem6(chat_id, p.stu_id);
            	message.setText("sem-6 selected");
            	try {
            	     execute(message);
            	 } catch (TelegramApiException e) {
            	     e.printStackTrace();
            	 } 	
            }
            
            else if(message_text.equals("sem 7")) {
            	SendMessage message = new SendMessage();
            	 message.setChatId(chat_id);
            	 sems.Sem7(chat_id, p.stu_id);
            	message.setText("sem-7 selected");
            	try {
            	     execute(message);
            	 } catch (TelegramApiException e) {
            	     e.printStackTrace();
            	 } 	
            }
            
            else if(message_text.equals("sem 8")) {
            	SendMessage message = new SendMessage();
            	 message.setChatId(chat_id);
            	 sems.Sem8(chat_id, p.stu_id);
            	message.setText("sem-8 selected");
            	try {
            	     execute(message);
            	 } catch (TelegramApiException e) {
            	     e.printStackTrace();
            	 } 	
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
            	p.overviewMet(chat_id,p.stu_id);
            }
            
            else if(message_text.equals("View Profile"))
            {	
           	 	p.viewProfile(chat_id);
            }
            else if(message_text.equals("Update Profile"))
            {
            	System.out.println("update");
            	p.updateProfile(chat_id);
            }
            
            else if(message_text.equals("Update email"))
            {
            	p.updateEmail(chat_id);
            }
            
            
            else if(first_msg==1)
            {
            	//System.out.println(p.again+"again");
//            	inputName(message_text,chat_id);
            	
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
            

            else if(p.again==1)
            {
            	System.out.println(p.again+"again");
//            	inputName(message_text,chat_id);
            	
            	p.userValidation(message_text, chat_id);
            	System.out.println(message_text);
            	System.out.println("3");
            	//lg=1;
            	//first_msg=0;
            	p.again=0;
            	System.out.println("kyb"+p.keyb);
            	if(p.keyb==1)
                {
                	System.out.println("keyboard");
                	getMainKeyboardMarkup(chat_id);
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
            }
            else if(message_text.equals("attendence"))
            {
            	System.out.println("att");
            	attendenceMethod(chat_id,p.stu_id);
            }
            else if(message_text.equals("Notes_pdf"))
            {
            	notesMethod(chat_id);
            }
            else if(message_text.equals("Coding"))
            {
            	codingMethod(chat_id); 
            }  
            
           
            
            
        } 
   }
    
    private void sendStartMessage(long chatId) {
    	SendMessage message = new SendMessage(); // Create a message object object
        message.setChatId(chatId);
         message.setText("‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗\n" +
                 " HI IAM STARK 😎 \n" +
                 " ENTER YOUR REGISTER_NUMBER(ID)\n" +
                 " AND PASSWORD\n" +
                 " YOUR PASSWORD = FIRST FOUR LETTER \n" +
                 " OF YOUR EMAIL + FIRST FOUR DIGITS \n" +
                 " OF YOUR MOBILE NUMBER\n" +
                 " FORMAT:\n" +
                 " ID(LAST-3 DIGITS)  SPACE PASSWORD\n" +
                 " Ex : 501 SATI8639");
 try {
     execute(message);
     first_msg =1;
     System.out.println("2");
     // Sending our message object to user
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
        row.add("Update Profile");
        row.add("return");
        row.add("Overview");
    	
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
        row.add("Notes_pdf");
        row.add("Coding");
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
        row.add("Update Results");
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
        return "6791707338:AAHYG_UX7KzsntHNXJWhMKmLu_jXFAnLBpk";
    }
    
    
    
    
	
}