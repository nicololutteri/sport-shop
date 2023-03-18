package model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import view.ErroreArticoloGiaInserito;
import view.ErroreDB;
import view.ErroreGiacenza;
import view.ErroreVincoli;

public class Utilita {

	public static String get_SHA_512_SecurePassword(String passwordToHash, String salt)
	{
		String generatedPassword = null;
	  
		try 
		{
			MessageDigest md = MessageDigest.getInstance("SHA-512");
	        md.update(salt.getBytes(StandardCharsets.UTF_8));
	        
	        byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
	        StringBuilder sb = new StringBuilder();
	        for(int i=0; i< bytes.length ;i++){
	        	sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
	
	        generatedPassword = sb.toString();
	    }
	    catch (NoSuchAlgorithmException e){
	    	e.printStackTrace();
	    }
	    
		return generatedPassword;
	}
	
	public static String convertData(Date d)
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(d);
	}
	
	public static void MostraErroreVincoli(String errore)
	{
		ErroreVincoli frame = new ErroreVincoli();
		frame.label.setText("I valori inseriti non rispettano i vincoli");
		frame.setVisible(true);
		
		frame.dispose();
	}
	
	public static void MostraErroreDB(String errore)
	{
		ErroreDB frame = new ErroreDB();
		frame.label.setText("Errore nel DB");
		frame.setVisible(true);
		
		frame.dispose();
	}
	
	public static void MostraErroreGiacenza()
	{
		ErroreGiacenza frame = new ErroreGiacenza();
		frame.setVisible(true);
		
		frame.dispose();
	}	
	
	public static void MostraErroreArticoloGiaInserito() {
		ErroreArticoloGiaInserito frame = new ErroreArticoloGiaInserito();
		frame.setVisible(true);
		
		frame.dispose();
	}
	
	public static String dataattuale()
	{
		Date t = new Date();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(t);
	}
	
	public static String oraattuale()
	{
		Date t = new Date();
		
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(t);
	}
	
}
