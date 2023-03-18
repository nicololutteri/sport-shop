package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.ErroreNelDB;
import model.GestioneDB;

public class Utilita {

	public static int prendiIdDaTabella(JTable table)
	{
		if (table.getSelectedRow() != -1)
		{
			return (int) table.getValueAt(table.getSelectedRow(), 0);
		}
		else
		{
			return -1;
		}
	}

	public static void cancellaTabella(JTable table) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
	}
	
	@SuppressWarnings("deprecation")
	public static void scriviArticoli() throws IOException, ErroreNelDB 
	{
		if (fineMese(Calendar.getInstance()))
		{
			int numeromese = (new Date()).getMonth();
			String numeroentrati = new Integer(GestioneDB.getInstance().articolientrati(numeromese)).toString();
			String numerouscite = new Integer(GestioneDB.getInstance().articoliusciti(numeromese)).toString();
			String valore = numeroentrati + ";" + numerouscite + System.lineSeparator();
			
			File file = new File("Riassunto.txt");
			if (!file.exists())
			{
				file.createNewFile();
			}
			Files.write(Paths.get("Riassunto.txt"), valore.getBytes(), StandardOpenOption.APPEND);		
		}
	}
	
	public static boolean fineMese(Calendar calendar)
	{
        return calendar.get(Calendar.DATE) == calendar.getActualMaximum(Calendar.DATE);
    }
	
}
