package com.Telegram.bot.Operations;

public interface UpdateM {
	
	public void semsUpdate(String msg, String sem_name, String id,long chatid);
	public void forSubCodes(long chat_id, String sem_name);

}
