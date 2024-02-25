package com.Telegram.bot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class Semisters extends B {
	Connection con;
    
    public Semisters(Connection con)
    {
    	this.con=con;
    }

    public void Sem1(long chat_id, String id) {
        
        try {
            
            String query = "SELECT * FROM sem1 WHERE ID=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String ids = rs.getString("ID");
                String m1 = rs.getString("mathematics1");
                String eng = rs.getString("english");
                String che = rs.getString("chemistry");
                String fc = rs.getString("fcs");
                String ed = rs.getString("ed");
                String eng_l = rs.getString("eng_lab");
                String che_l = rs.getString("che_l");
                String fc_lab = rs.getString("fc_lab");
                String combinedMessage ="ID"+ids + "\n" +"Mathematics 1"+ m1 + "\n" +"English"+ eng + "\n"+"Chemistry" + che + "\n"+"Fundementals of C.S" + fc + "\n" +"Engineering Drawing"+ ed + "\n"
                        +"English Lab"+ eng_l + "\n"+"Chemistry lab" + che_l + "\n" +"FCS Lab"+ fc_lab;
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText(combinedMessage);
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
    
    
   

    public void Sem2(long chat_id, String id) {
        try {
            String query = "SELECT * FROM sem2 WHERE Id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                String ids = rs.getString("Id");
                String ap = rs.getString("AP");
                String prob_sol_c = rs.getString("PROB_SOL_C");
                String dig_logic_des = rs.getString("DIG_LOGIC_DES");
                String math_ii = rs.getString("MATH_II");
                String math_iii = rs.getString("MATH_III");
                String eng_exp_proj = rs.getString("ENG_EXP_PROJ");
                String ap_lab = rs.getString("AP_LAB");
                String prob_sol_c_lab = rs.getString("PROB_SOL_C_LAB");
                String comm_skills_lab = rs.getString("COMM_SKILLS_LAB");
                String constitution = rs.getString("CONSTITUTION");
                
                // Constructing the message with clear alignment
                String comb = String.format("%-35s%-15s\n", "***Subject Name***", "***Grade***") +
                              String.format("%-5s%-30s%-15s\n", "ID:", ids, "") +
                              String.format("%-30s%-25s\n", "APPLIED_PHYSICS:", ap) +
                              String.format("%-30s%-25s\n", "C_LANGUAGE:", prob_sol_c) +
                              String.format("%-30s%-25s\n", "DIGITAL_L_DESIGN:", dig_logic_des) +
                              String.format("%-30s%-25s\n", "MATHEMATICS_II:", math_ii) +
                              String.format("%-30s%-25s\n", "MATHEMATICS_III:", math_iii) +
                              String.format("%-30s%-25s\n", "ENG_E_PROJECT:", eng_exp_proj) +
                              String.format("%-30s%-25s\n", "PHYSICS_LAB:", ap_lab) +
                              String.format("%-30s%-25s\n", "C_LAB:", prob_sol_c_lab) +
                              String.format("%-30s%-25s\n", "COMM_SKILLS_LAB:", comm_skills_lab) +
                              String.format("%-30s%-25s\n", "CONST_OF_INDIA:", constitution);

                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText(comb);
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



    
    
    
    public void Sem3(long chat_id, String id) {
        try {
            String query = "SELECT * FROM sem3 WHERE ID=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                String ids = rs.getString("ID");
                String sw_eng = rs.getString("SW_ENG");
                String py_prog = rs.getString("PY_PROG");
                String ds = rs.getString("DS");
                String comp_org = rs.getString("COMP_ORG");
                String oop_cpp = rs.getString("OOP_CPP");
                String math_found_cs = rs.getString("MATH_FOUND_CS");
                String ds_cpp_lab = rs.getString("DS_CPP_LAB");
                String py_prog_lab = rs.getString("PY_PROG_LAB");
                String em_skills = rs.getString("EM_SKILLS");
                String indian_knowledge = rs.getString("INDIAN_KNOWLEDGE");
                
                String comb = "ID: " + ids + "\n" +
                              "SOFTWARE_ENGINEERING: " + sw_eng + "\n" +
                              " PYTHON_PROGRAMMING: " + py_prog + "\n" +
                              "DATA_STRUCTURES : " + ds + "\n" +
                              "COMPUTER_ORGANIZATION: " + comp_org + "\n" +
                              "OBJECT_ORIENTED_PROGRAMM_THROUGH_CPP: " + oop_cpp + "\n" +
                              "MATHEMATICAL_FOUNDATIONS_OF_COMPUTER_SCIENCE: " + math_found_cs + "\n" +
                              "DATA_STRUCTURES_THROUGH_CPP_LAB: " + ds_cpp_lab + "\n" +
                              "PYTHON_PROGRAMMING_LAB: " + py_prog_lab + "\n" +
                              "EMPLOYABILITY_SKILLS_I: " + em_skills + "\n" +
                              "ESSENCE_OF_INDIAN_TRADITIONAL_KNOWLEDGE: " + indian_knowledge;
                
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText(comb);
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
    
    
    
    
    public void Sem4(long chat_id, String id) {
        try {
            String query = "SELECT * FROM sem4 WHERE ID=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                String ids = rs.getString("ID");
                String os = rs.getString("OS");
                String dbms = rs.getString("DBMS");
                String flat = rs.getString("FLAT");
                String prob_stats = rs.getString("PROB_STATS");
                String java = rs.getString("JAVA");
                String sr_project = rs.getString("SR_PROJECT");
                String java_lab = rs.getString("JAVA_LAB");
                String dbms_lab = rs.getString("DBMS_LAB");
                String unix_lab = rs.getString("UNIX_LAB");
                String ethics = rs.getString("ETHICS");
                
                String comb = "ID: " + ids + "\n" +
                              "OPERATING_SYSTEMS: " + os + "\n" +
                              "DATABASE_MANAGEMENT_SYSTEMS: " + dbms + "\n" +
                              "FORMAL_LANGUAGES_AND_AUTOMATA_THEORY: " + flat + "\n" +
                              "PROBABILITY_AND_STATISTICS: " + prob_stats + "\n" +
                              "JAVA_PROGRAMMING: " + java + "\n" +
                              "SOCIALLY_RELEVANT_PROJECT: " + sr_project + "\n" +
                              "JAVA_PROGRAMMING_LAB: " + java_lab + "\n" +
                              "DATABASE_MANAGEMENT_SYSTEMS_LAB: " + dbms_lab + "\n" +
                              "UNIX_OPERATING_SYSTEMS_LAB: " + unix_lab + "\n" +
                              "PROFESSIONAL_ETHICS_AND_HUMAN_VALUES: " + ethics;
                
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText(comb);
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
    
    
    public void Sem5(long chat_id, String id) {
        try {
            String query = "SELECT * FROM sem5 WHERE ID=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                String ids = rs.getString("ID");
                String cn = rs.getString("CN");
                String cd = rs.getString("CD");
                String ai = rs.getString("AI");
                String dwdm = rs.getString("DWDM");
                String stm = rs.getString("STM");
                String es_ii = rs.getString("ES_II");
                String cn_lab = rs.getString("CN_LAB");
                String ai_lab = rs.getString("AI_LAB");
                String dm_lab = rs.getString("DM_LAB");
                
                String comb = "ID: " + ids + "\n" +
                              "COMPUTER_NETWORKS: " + cn + "\n" +
                              "COMPILER_DESIGN: " + cd + "\n" +
                              "ARTIFICIAL_INTELLIGENCE: " + ai + "\n" +
                              "DATA_WAREHOUSING_AND_DATA_MINING: " + dwdm + "\n" +
                              "SOFTWARE_TESTING_METHODOLOGIES: " + stm + "\n" +
                              "EMPLOYABILITY_SKILLS_II: " + es_ii + "\n" +
                              "COMPUTER_NETWORKS_LAB: " + cn_lab + "\n" +
                              "AI_TOOLS_AND_TECHNIQUES_LAB: " + ai_lab + "\n" +
                              "DATA_MINING_LAB: " + dm_lab;
                
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText(comb);
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

    
    
    public void Sem6(long chat_id, String id) {
        try {
            String query = "SELECT * FROM sem6 WHERE ID=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                String ids = rs.getString("ID");
                String res = rs.getString("RES");
                String web_tech = rs.getString("WEB_TECH");
                String dist_sys = rs.getString("DIST_SYS");
                String daa = rs.getString("DAA");
                String mefa = rs.getString("MEFA");
                String moocs = rs.getString("MOOCS");
                String industrial_training = rs.getString("INDUSTRIAL_TRAINING");
                String web_tech_lab = rs.getString("WEB_TECH_LAB");
                
                String comb = "ID: " + ids + "\n" +
                              "RENEWABLE_ENERGY_SOURCES: " + res + "\n" +
                              "WEB_TECHNOLOGIES: " + web_tech + "\n" +
                              "DISTRIBUTED_SYSTEMS: " + dist_sys + "\n" +
                              "DESIGN_AND_ANALYSIS_OF_ALGORITHMS: " + daa + "\n" +
                              "MANAGERIAL_ECONOMICS_AND_FINANCIAL_ACCOUNTANCY: " + mefa + "\n" +
                              "MOOCS: " + moocs + "\n" +
                              "INDUSTRIAL_TRAINING_SKILL_DEVELOP_RESEARCH_PROJECT: " + industrial_training + "\n" +
                              "WEB_TECHNOLOGIES_LAB: " + web_tech_lab;
                
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText(comb);
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
    
    
    
    public void Sem7(long chat_id, String id) {
        try {
            String query = "SELECT * FROM sem7 WHERE ID=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                String ids = rs.getString("ID");
                String uml_dp = rs.getString("UML_DP");
                String sp_management = rs.getString("SP_MANAGEMENT");
                String crypto_network_security = rs.getString("CRYPTO_NETWORK_SECURITY");
                String ml = rs.getString("ML");
                String embedded_sys = rs.getString("EMBEDDED_SYS");
                String cloud_computing = rs.getString("CLOUD_COMPUTING");
                String project_1 = rs.getString("PROJECT_1");
                String ipr_patents = rs.getString("IPR_PATENTS");
                String uml_lab = rs.getString("UML_LAB");
                
                String comb = "ID: " + ids + "\n" +
                              "UML_AND_DESIGN_PATTERNS: " + uml_dp + "\n" +
                              "SOFTWARE_PROJECT_MANAGEMENT: " + sp_management + "\n" +
                              "CRYPTOGRAPHY_AND_NETWORK_SECURITY: " + crypto_network_security + "\n" +
                              "MACHINE_LEARNING: " + ml + "\n" +
                              "EMBEDDED_SYSTEMS: " + embedded_sys + "\n" +
                              "CLOUD_COMPUTING: " + cloud_computing + "\n" +
                              "PROJECT_1: " + project_1 + "\n" +
                              "IPR_AND_PATENTS: " + ipr_patents + "\n" +
                              "UML_LAB: " + uml_lab;
                
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText(comb);
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

    
    
    public void Sem8(long chat_id, String id) {
        try {
            String query = "SELECT * FROM sem8 WHERE ID=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                String ids = rs.getString("ID");
                String tqm = rs.getString("TQM");
                String devops = rs.getString("DEVOPS");
                String mgmt_org_behavior = rs.getString("MGMT_ORG_BEHAVIOR");
                String project_ii = rs.getString("PROJECT_II");
                
                String comb = "ID: " + ids + "\n" +
                              "TOTAL_QUALITY_MANAGEMENT: " + tqm + "\n" +
                              "DEVOPS: " + devops + "\n" +
                              "MANAGEMENT_AND_ORGANIZATIONAL_BEHAVIOR: " + mgmt_org_behavior + "\n" +
                              "PROJECT_II: " + project_ii;
                
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText(comb);
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
    
    
    public void updatesems(long chatid)
    {
    	SendMessage message = new SendMessage(); 
 		message.setChatId(chatid);
 		message.setText("sem results..");
 		ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a keyboard row
        KeyboardRow row = new KeyboardRow();
        // Set each button, you can also use KeyboardButton objects if you need something else than text
        
        row.add("sem-1");
        row.add("sem-2");
        row.add("sem-3");
        // Add the first row to the keyboard
        keyboard.add(row);
        // Create another keyboard row
        KeyboardRow row2 = new KeyboardRow();
        row2.add("sem-4");
        row2.add("sem-5");
        row2.add("sem-6");
        
        keyboard.add(row2);
        
        
        KeyboardRow row3 = new KeyboardRow();
        row3.add("sem-7");
        row3.add("sem-8");
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

	


    	
    }
