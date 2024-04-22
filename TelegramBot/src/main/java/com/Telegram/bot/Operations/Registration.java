package com.Telegram.bot.Operations;

public interface Registration {
	public void regdID(long chat_id, String message_text);
	public void nameReg(long chat_id, String message_text);
	public void emailReg(long chat_id, String message_text);
	public void phnoReg(long chat_id, String message_text);
	public void pass_Reg(long chat_id, String message_text);

}
