package com.Telegram.bot.Operations;

public interface Profile {
	
	public void userValidation(String name,long chatid);
	
	public void viewProfile(long chat_id);
	
	public void regd(long chat_id, String message_text);
	
	public void namer(long chat_id, String message_text);
	
	public void email(long chat_id, String message_text);
	
	public void phno(long chat_id, String message_text);
	
	public void PassWordValidation(String message_text, long chat_id);
	
	public void ChangePassword(String message_text, long chat_id);
	
	public int getKeyb();
	public  String getReg_id();
	
	public  String getStu_id();
	
	public int getAgain();
	
	public void setAgain(int again);

}
