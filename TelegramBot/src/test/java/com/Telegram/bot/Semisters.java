package com.Telegram.bot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;
public class Semisters extends B {
	Connection con;
	HashMap<String, Integer> gradeVal = new HashMap<>();
	static double sem1Spga=0.0;
	static double sem2Spga=0.0;
	static double sem3Spga=0.0;
	static double sem4Spga=0.0;
	static double sem5Spga=0.0;
	static double sem6Spga=0.0;
	static double sem7Spga=0.0;
	static double sem8Spga=0.0;
	
	static int back_sem1=0;
	static int back_sem2=0;
	static int back_sem3=0;
	static int back_sem4=0;
	static int back_sem5=0;
	static int back_sem6=0;
	static int back_sem7=0;
	static int back_sem8=0;
	
	static double cgpa1=0.0;
	static double cgpa2=0.0;
	static double cgpa3=0.0;
	static double cgpa4=0.0;
	
	
	static int over=0;
    // Adding grade-value pairs to the HashMap
	
   
	ArrayList<String> sem1s = new ArrayList<>();
	ArrayList<String> sem2s = new ArrayList<>();
    
    public Semisters(Connection con)
    {
    	this.con=con;
    	gradeVal.put("O", 10);
        gradeVal.put("S", 9);
        gradeVal.put("A", 8);
        gradeVal.put("B", 7);
        gradeVal.put("C", 6);
        gradeVal.put("D", 5);
        gradeVal.put("F", 0);	 
    }
   
        
        
        
    
    
 public void Sem1(long chat_id, String id) {
	 ArrayList<String> strs = new ArrayList<>();
        
        try {
            
            String query = "SELECT * FROM sem1 WHERE ID=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String ids = rs.getString("ID");
                
                String m1 = rs.getString("Math");
                String eng = rs.getString("Eng");
                String che = rs.getString("Chem");
                String fc = rs.getString("CompSci");
                String ed = rs.getString("EngDraw");
                String eng_l = rs.getString("EngLab");
                String che_l = rs.getString("ChemLab");
                String fc_lab = rs.getString("ITWorkshop");
                String env=rs.getString("EnvSci");
                
                strs.add(m1);strs.add(eng); strs.add(che);strs.add(fc);strs.add(ed);strs.add(eng_l);strs.add(che_l);strs.add(fc_lab);
                
                sem1s=strs;
                
                String[] strArray = strs.toArray(new String[0]);
                
                
                sem1Spga=calcSem1(strArray);
                
                
                back_sem1=calcBack(strArray);
                System.out.println("backlogs "+back_sem1);
                
                String combinedMessage ="ID"+ids + "\n" +"Mathematics 1"+ m1 + "\n" +"English"+ eng + "\n"+"Chemistry" + che + "\n"+"Fundementals of C.S " + fc + "\n" +"Engineering Drawing"+ ed + "\n"
                        +"English Lab"+ eng_l + "\n"+"Chemistry lab" + che_l + "\n" +"FCS Lab"+ fc_lab+ "\n" +"SGPA "+ "\n" +"Env Science "+env+sem1Spga+ "\n" +
                		""+ "\n" +"No of Backlogs :" + back_sem1;
                
                
               //sem1Spga=calcSem1(m1,eng,che,fc,ed,eng_l,che_l,fc_lab);
               
               System.out.println(sem1Spga);
                
                System.out.println("here 1");
                
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText(combinedMessage);
                
                System.out.println("after msg");
                
                
                try {
                	if(over==0)
                	{
                		execute(message);
                	}
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                
            }
            else
            {
            elseMsg(chat_id);
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
   

    









	private double calcSem1(String[] subjects) {
    	System.out.println("sgpa cal");
    	HashMap<String, Double> cred = new HashMap<>();
        cred.put("m1", 3.0);
        cred.put("che", 3.0);
        cred.put("fcs", 3.0);
        cred.put("eng", 3.0);
        cred.put("ed", 2.5);
        cred.put("e_lab", 1.5);
        cred.put("itw", 1.5);
        cred.put("che_l", 1.5);
        
        //String[] subjects = {m1, che, fcs, eng, ed, e_lab, che_l, itw};
        String[] subj = {"m1", "che", "fcs", "eng", "ed", "e_lab", "che_l", "itw"};
       
        double sgpa=calculateSGPA(subjects,subj,cred);
        System.out.println("reru");
        return sgpa;
}

    





	public void Sem2(long chat_id, String id) {
		ArrayList<String> strs = new ArrayList<>();
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
                strs.add(ap);strs.add(prob_sol_c);strs.add(dig_logic_des);strs.add(math_ii);strs.add(math_iii);
                strs.add(eng_exp_proj);strs.add(ap_lab);strs.add(prob_sol_c_lab);strs.add(comm_skills_lab);
                
                String[] strArray = strs.toArray(new String[0]);
                
                sem2s=strs;
                sem2Spga=calcSem2(strArray);
                
                back_sem2=calcBack(strArray);
                
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
                              String.format("%-30s%-25s\n", "CONST_OF_INDIA:", constitution)+
                              String.format("%-30s%-25s\n", "SGPA  :",sem2Spga)+
                			  String.format("%-30s%-25s\n", "No OF Backlog   :",back_sem2);

                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText(comb);
                try {
                	if(over==0)
                	{
                		execute(message);
                	}
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else
            {
            	
           	elseMsg(chat_id);
           	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    
    
    
    private void elseMsg(long chat_id) {
		// TODO Auto-generated method stub
    	SendMessage message = new SendMessage();
   	 	message.setChatId(chat_id);
   	 	message.setText("Results Not Updated!!");
   	try {
   	     execute(message);
   	 } catch (TelegramApiException e) {
   	     e.printStackTrace();
   	 } 	
		
	}






	private double calcSem2(String[] subjects) {
    	
    	HashMap<String, Double> cred = new HashMap<>();
    	
    	cred.put("ap",3.0);
    	cred.put("prob_sol_c", 3.0);
    	cred.put("dig_logic_des",3.0);
    	cred.put("math_ii", 3.0);
    	cred.put("math_iii", 3.0);
    	cred.put("eng_exp_proj",1.0);
    	cred.put("ap_lab",1.5);
    	cred.put("prob_sol_c_lab", 1.5);
    	cred.put("comm_skills_lab", 2.0);
    	
    	
        String[] subj = {"ap", "prob_sol_c", "dig_logic_des", "math_ii", "math_iii", "eng_exp_proj", "ap_lab", "prob_sol_c_lab", "comm_skills_lab"};
        
        double sgpa=calculateSGPA(subjects,subj,cred);
        System.out.println("reru");
        return sgpa;
    
	}






	public void Sem3(long chat_id, String id) {
		ArrayList<String> strs = new ArrayList<>();
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
                strs.add(sw_eng);strs.add(py_prog);strs.add(ds);strs.add(comp_org);strs.add(oop_cpp);strs.add(math_found_cs);
                strs.add(ds_cpp_lab);strs.add(py_prog_lab);
                
                String[] strArray = strs.toArray(new String[0]);
                sem3Spga=calcSem3(strArray);
                
                back_sem3=calcBack(strArray);
                
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
                              "ESSENCE_OF_INDIAN_TRADITIONAL_KNOWLEDGE: " + indian_knowledge+ "\n" +
                               "SGPA "+sem3Spga+ "\n" +
                              "No of BackLogs "+back_sem3;
                
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText(comb);
                try {
                	if(over==0)
                	{
                		execute(message);
                	}
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else
            {
            elseMsg(chat_id);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    private double calcSem3(String[] subjects) {
		// TODO Auto-generated method stub
    	HashMap<String, Double> cred = new HashMap<>();
    	cred.put("sw_eng", 3.0);
    	cred.put("py_prog", 3.0);
    	cred.put("ds", 3.0);
    	cred.put("comp_org", 3.0);
    	cred.put("oop_cpp", 3.0);
    	cred.put("math_found_cs", 4.0);
    	cred.put("ds_cpp_lab", 1.5);
    	cred.put("py_prog_lab", 1.5);
    	
        String[] subj = {"sw_eng", "py_prog", "ds", "comp_org", "oop_cpp", "math_found_cs", "ds_cpp_lab", "py_prog_lab"};
        
        double sgpa=calculateSGPA(subjects,subj,cred);
        System.out.println("reru");
        return sgpa;
	}


	public void Sem4(long chat_id, String id) {
		ArrayList<String> strs = new ArrayList<>();

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
                
                strs.add(os);strs.add(dbms);strs.add(flat);strs.add(prob_stats);strs.add(java);strs.add(sr_project);strs.add(java_lab);
                strs.add(dbms_lab);strs.add(unix_lab);
                
                String[] strArray = strs.toArray(new String[0]);

                
                sem4Spga=calcSem4(strArray);
                back_sem4=calcBack(strArray);
                
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
                              "PROFESSIONAL_ETHICS_AND_HUMAN_VALUES: " + ethics+ "\n" +
                              "SGPA  : "+sem4Spga + "\n" +
                              "No of Backlogs :"+back_sem4;
                
                
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText(comb);
                try {
                	if(over==0)
                	{
                		execute(message);
                	}
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else
            {
            elseMsg(chat_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    private double calcSem4(String[] subjects) {
    	
    	HashMap<String, Double> cred = new HashMap<>();
    	cred.put("os",3.0);
    	cred.put("dbms", 4.0);
    	cred.put("flat",3.0);
    	cred.put("prob_stats", 3.0);
    	cred.put("java", 3.0);
    	cred.put("sr_project", 1.0);
    	cred.put("java_lab",1.5);
    	cred.put("dbms_lab",1.5);
    	cred.put("unix_lab",1.0);
		// TODO Auto-generated method stub
		
        String[] subj = {"os", "dbms", "flat", "prob_stats", "java", "sr_project", "java_lab", "dbms_lab", "unix_lab"};
        
        
        double sgpa=calculateSGPA(subjects,subj,cred);
        System.out.println("reru");
        return sgpa;

	}






	public void Sem5(long chat_id, String id) {
		ArrayList<String> strs = new ArrayList<>();

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
                
                strs.add(cn);strs.add(cd);strs.add(ai);strs.add(dwdm);strs.add(stm);strs.add(cn_lab);strs.add(ai_lab);
                strs.add(dm_lab);
                String[] strArray = strs.toArray(new String[0]);

                sem5Spga=calcSem5(strArray);
                
                back_sem5=calcBack(strArray);
                
                String comb = "ID: " + ids + "\n" +
                              "COMPUTER_NETWORKS: " + cn + "\n" +
                              "COMPILER_DESIGN: " + cd + "\n" +
                              "ARTIFICIAL_INTELLIGENCE: " + ai + "\n" +
                              "DATA_WAREHOUSING_AND_DATA_MINING: " + dwdm + "\n" +
                              "SOFTWARE_TESTING_METHODOLOGIES: " + stm + "\n" +
                              "EMPLOYABILITY_SKILLS_II: " + es_ii + "\n" +
                              "COMPUTER_NETWORKS_LAB: " + cn_lab + "\n" +
                              "AI_TOOLS_AND_TECHNIQUES_LAB: " + ai_lab + "\n" +
                              "DATA_MINING_LAB: " + dm_lab + "\n" +
                              "SGPA : "+sem5Spga+ "\n" +
                              "No of Backlogs "+back_sem5;
                
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText(comb);
                try {
                	if(over==0)
                	{
                		execute(message);
                	}
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else
            {
            elseMsg(chat_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    private double calcSem5(String[] subjects) {
		System.out.println("calcsem5");
    	HashMap<String, Double> cred = new HashMap<>();
    	cred.put("cn", 3.0);
    	cred.put("cd", 3.0);
    	cred.put("ai",3.0);
    	cred.put("dwdm",3.0);
    	cred.put("stm",3.0);
    	cred.put("cn_lab",1.0);
    	cred.put("ai_lab", 1.5);
    	cred.put("dm_lab", 1.5);
    	
        String[] subj = {"cn", "cd", "ai", "dwdm", "stm", "cn_lab", "ai_lab", "dm_lab"};
        System.out.println("fun..");
        double sgpa=calculateSGPA(subjects,subj,cred);
        System.out.println("reru");
        return sgpa;
	}


	public void Sem6(long chat_id, String id) {
		ArrayList<String> strs = new ArrayList<>();

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
                strs.add(res);strs.add(web_tech);strs.add(dist_sys);strs.add(daa);strs.add(mefa);strs.add(moocs);strs.add(web_tech_lab);strs.add(industrial_training);
                String[] strArray = strs.toArray(new String[0]);
                back_sem6=calcBack(strArray);
                
                
                sem6Spga=calcSem6(strArray);
                String comb = "ID: " + ids + "\n" +
                              "RENEWABLE_ENERGY_SOURCES: " + res + "\n" +
                              "WEB_TECHNOLOGIES: " + web_tech + "\n" +
                              "DISTRIBUTED_SYSTEMS: " + dist_sys + "\n" +
                              "DESIGN_AND_ANALYSIS_OF_ALGORITHMS: " + daa + "\n" +
                              "MANAGERIAL_ECONOMICS_AND_FINANCIAL_ACCOUNTANCY: " + mefa + "\n" +
                              "MOOCS: " + moocs + "\n" +
                              "INDUSTRIAL_TRAINING_SKILL_DEVELOP_RESEARCH_PROJECT: " + industrial_training + "\n" +
                              "WEB_TECHNOLOGIES_LAB: " + web_tech_lab + "\n" +
                              "SGPA :"+sem6Spga + "\n" +
                              "No of Backlogs "+back_sem6;
                
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText(comb);
                try {
                	if(over==0)
                	{
                		execute(message);
                	}
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else
            {
            elseMsg(chat_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    private double calcSem6(String[]subjects) {
    	HashMap<String, Double> cred = new HashMap<>();
    	cred.put("res",3.0);
    	cred.put("web_tech", 3.0);
    	cred.put("dist_sys", 3.0);
    	cred.put("daa", 3.0);
    	cred.put("mefa", 3.0);
    	cred.put("moocs", 3.0);
    	cred.put("industrial_training", 1.0);
    	cred.put("web_tech_lab", 2.0);
    	
        String[] subj = {"res", "web_tech", "dist_sys", "daa", "mefa", "moocs", "industrial_training", "web_tech_lab"};
        
        double sgpa=calculateSGPA(subjects,subj,cred);
        System.out.println("reru");
        return sgpa;
	}






	public void Sem7(long chat_id, String id) {
		ArrayList<String> strs = new ArrayList<>();

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
                strs.add(uml_dp);strs.add(sp_management);strs.add(crypto_network_security);strs.add(ml);strs.add(embedded_sys);
                strs.add(cloud_computing);strs.add(project_1);strs.add(uml_lab);
                
               
                String[] strArray = strs.toArray(new String[0]);
                sem7Spga=calcSem7(strArray);

                back_sem7=calcBack(strArray);
                String comb = "ID: " + ids + "\n" +
                              "UML_AND_DESIGN_PATTERNS: " + uml_dp + "\n" +
                              "SOFTWARE_PROJECT_MANAGEMENT: " + sp_management + "\n" +
                              "CRYPTOGRAPHY_AND_NETWORK_SECURITY: " + crypto_network_security + "\n" +
                              "MACHINE_LEARNING: " + ml + "\n" +
                              "EMBEDDED_SYSTEMS: " + embedded_sys + "\n" +
                              "CLOUD_COMPUTING: " + cloud_computing + "\n" +
                              "PROJECT_1: " + project_1 + "\n" +
                              "IPR_AND_PATENTS: " + ipr_patents + "\n" +
                              "UML_LAB: " + uml_lab+ "\n" +
                              "SGPA : "+sem7Spga+ "\n" +
                              "No of BackLogs "+back_sem7;
                
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText(comb);
                try {
                	if(over==0)
                	{
                		execute(message);
                	}
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else
            {
            elseMsg(chat_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    private double calcSem7(String[] subjects) {
		// TODO Auto-generated method stub
    	HashMap<String, Double> cred = new HashMap<>();
    	cred.put("uml_dp", 3.0);
    	cred.put("sp_management", 3.0);
    	cred.put("crypto_network_security", 3.0);
    	cred.put("ml", 3.0);
    	cred.put("embedded_sys", 3.0);
    	cred.put("cloud_computing", 3.0);
    	cred.put("project_1", 2.0);
    	cred.put("uml_lab", 1.0);
    	
        String[] subj = {"uml_dp", "sp_management", "crypto_network_security", "ml", "embedded_sys", "cloud_computing", "project_1", "uml_lab"};
    	
        double sgpa=calculateSGPA(subjects,subj,cred);
        System.out.println("reru");
        return sgpa;
    	
    	
    	
		
	}






	public void Sem8(long chat_id, String id) {
		ArrayList<String> strs = new ArrayList<>();

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
                strs.add(tqm);strs.add(devops);strs.add(mgmt_org_behavior);strs.add(project_ii);
                String[] strArray = strs.toArray(new String[0]);
                
                sem8Spga=calcSem8(strArray);
                back_sem8=calcBack(strArray);
                String comb = "ID: " + ids + "\n" +
                              "TOTAL_QUALITY_MANAGEMENT: " + tqm + "\n" +
                              "DEVOPS: " + devops + "\n" +
                              "MANAGEMENT_AND_ORGANIZATIONAL_BEHAVIOR: " + mgmt_org_behavior + "\n" +
                              "PROJECT_II: " + project_ii + "\n" +
                              "SGPA "+sem8Spga+ "\n" +
                              "No of Backlogs : "+back_sem8;
                
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText(comb);
                try {
                	if(over==0)
                	{
                		execute(message);
                	}
                    
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else
            {
            elseMsg(chat_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    private double calcSem8(String[] subjects) {
		// TODO Auto-generated method stub
    	HashMap<String, Double> cred = new HashMap<>();
    	
    	cred.put("tqm", 3.0);
    	cred.put("devops", 3.0);
    	cred.put("mgmt_org_behavior", 3.0);
    	cred.put("project_ii", 7.0);
    	
    	 String[] subj = {"tqm", "devops", "mgmt_org_behavior", "project_ii"};
    	 
    	 double sgpa=calculateSGPA(subjects,subj,cred);
         System.out.println("reru");
         return sgpa;
    	 
	
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
        
        row.add("sem1");
        row.add("sem2");
        row.add("sem3");
        // Add the first row to the keyboard
        keyboard.add(row);
        // Create another keyboard row
        KeyboardRow row2 = new KeyboardRow();
        row2.add("sem4");
        row2.add("sem5");
        row2.add("sem6");
        
        keyboard.add(row2);
        
        
        KeyboardRow row3 = new KeyboardRow();
        row3.add("sem7");
        row3.add("sem8");
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
    
    
    private double calculateSGPA(String[] subjects, String[] subj, HashMap<String, Double> cred){
    	System.out.println("calc sgpa");
    	System.out.println(Arrays.toString(subjects));
    	System.out.println(Arrays.toString(subj));
    	System.out.println(cred.get(subj[0]));
    	System.out.println(gradeVal.get(subjects[0]));
    	int count=0;
        double totalCredits = 0;
        double totalGradePoints = 0;
        
        for (int i = 0; i < subjects.length; i++) {
        	System.out.println("itr");
            Integer gradePoint = gradeVal.get(subjects[i]);
            Double credits = cred.get(subj[i]);
            
            totalGradePoints += gradePoint * credits;
            totalCredits += credits;
            
            if(gradePoint==0)
            {
            	count++;   
            }
        }
        System.out.println(totalCredits+" "+totalGradePoints);
        
        
        double sgpa = 0.0;
        if (totalCredits != 0) {
            sgpa = totalGradePoints / totalCredits;
        }
        
        
        System.out.println("end..");
        double formattedSGPA = Double.parseDouble(String.format("%.2f", sgpa));
        System.out.println(formattedSGPA);
        return formattedSGPA;
		
    }


    public void overview(long chat_id, String id)
    {
    	over=1;
    	Sem1(chat_id, id);
    	Sem2(chat_id, id);
    	Sem3(chat_id, id);
    	Sem4(chat_id, id);
    	Sem5(chat_id, id);
    	Sem6(chat_id, id);
    	Sem7(chat_id, id);
    	Sem8(chat_id, id);
    	
    	
    	cgpa1=(sem1Spga+sem2Spga)/2;
    	cgpa2=(sem3Spga+sem4Spga)/2;
    	cgpa3=(sem5Spga+sem6Spga)/2;
    	cgpa4=(sem7Spga+sem8Spga)/2;
    	String comb="1st Year CGPA :"+cgpa1+"\n"+
    			"Number of Backlogs :"+back_sem1+back_sem2+"\n"+"\n"+
    			"2nd Year CGPA :"+cgpa2+"\n"+
    			"Number of Backlogs :"+back_sem3+back_sem4+"\n"+"\n"+
    			"3rd Year CGPA :"+cgpa3+"\n"+
    			"Number of Backlogs :"+back_sem5+back_sem6+"\n"+"\n"+
    			"4th Year CGPA :"+cgpa4+"\n"+
    			"Number of Backlogs :"+back_sem7+back_sem8+"\n";
    		
    	SendMessage message = new SendMessage();
   	 	message.setChatId(chat_id);
   	 	message.setText(comb);
   	try {
   	     execute(message);
   	 } catch (TelegramApiException e) {
   	     e.printStackTrace();
   	 } 
    	over=0;
    }


    

	






	private int calcBack(String[] strArray) {
	// TODO Auto-generated method stub
		int c=0;
		for(int i=0;i<strArray.length;i++)
		{
			String st=strArray[i];
			if(st.equals("F"))
			{
				c++;
			}
		}
		
	return c;
	}
}







