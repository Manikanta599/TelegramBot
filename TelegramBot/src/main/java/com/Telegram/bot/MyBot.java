package com.Telegram.bot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.exceptions.*;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyBot extends TelegramLongPollingBot {
	static int vER = 0;
	static int mER = 0;
	static int lg=0;
	
	public static boolean validUser(String s) {
		System.out.println("inner valid");
		String ar[]= s.split(" ");
		String id = ar[0];
		String password = ar[1];
		System.out.println(id+" "+password);
		if(id.equals("501") && password.equals("sat8985")) {
			
			return true;
		}
		else {
			return false;
		}
	}
	
	
    @Override
    public void onUpdateReceived(Update update) {

        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            if (message_text.equals("/start")) {
                SendMessage message = new SendMessage(); // Create a message object object
                       message.setChatId(chat_id);
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
                    vER =1;
                    // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } 
            else if(message_text.equals("profile")) {
            	 SendMessage message = new SendMessage(); // Create a message object object
         		message.setChatId(chat_id);
         		message.setText("profile details");
         try {
             execute(message); // Sending our message object to user
         } catch (TelegramApiException e) {
             e.printStackTrace();
         }
            }
            
            else if(message_text.equals("sem_results"))
            {
            	SendMessage message = new SendMessage(); 
         		message.setChatId(chat_id);
         		message.setText("sem results..");
         		
         		try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            
            else if(message_text.equals("check_attendence"))
            {
            	SendMessage message = new SendMessage(); 
         		message.setChatId(chat_id);
         		message.setText("check_attendence..");
         		
         		try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            
            else if(message_text.equals("Notes_pdf"))
            {
            	SendMessage message = new SendMessage(); 
         		message.setChatId(chat_id);
         		message.setText("notes_pdf");
         		
         		try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
         		
            }
            
            else if(message_text.equals("LogOut"))
            {
            	lg=1;
            	SendMessage message = new SendMessage(); 
         		message.setChatId(chat_id);
         		message.setText("logout...");
         		
         		try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            
             else if (mER ==1) {
                SendMessage message = new SendMessage(); // Create a message object object
                		message.setChatId(chat_id);
                		message.setText("Here is your keyboard");
                // Create ReplyKeyboardMarkup object
                ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                // Create the keyboard (list of keyboard rows)
                List<KeyboardRow> keyboard = new ArrayList<>();
                // Create a keyboard row
                KeyboardRow row = new KeyboardRow();
                // Set each button, you can also use KeyboardButton objects if you need something else than text
                
                row.add("profile");
                row.add("sem_results");
                row.add("check_attendence");
                // Add the first row to the keyboard
                keyboard.add(row);
                // Create another keyboard row
                row = new KeyboardRow();
                // Set each button for the second line
                row.add("Notes_pdf");
                row.add("Row 2 Button 2");
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
                
                      
            }else if(vER==1){
            	SendMessage message = new SendMessage(); // Create a message object object
        		message.setChatId(chat_id);
        		System.out.println("outer valid");
        		String mes = "";
        		boolean b = validUser(message_text);
        	    if(b) {
        	    	mes = "valid user";
        	    	vER=0;
        	    	mER =1;
        	    	if(lg!=1)
        	    	{
        	    		onUpdateReceived(update);
        	    	}
        	    	
        	    }
        	    else {
        	    	mes = "INVALID USER TRY AGAIN";
        	    }
        		message.setText(mes);
        		 try {
                     execute(message); // Sending our message object to user
                 } catch (TelegramApiException e) {
                     e.printStackTrace();
                 }
            }
             
             else {
                SendMessage message = new SendMessage(); // Create a message object object
                		message.setChatId(chat_id);
                		message.setText("Unknown command");
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
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