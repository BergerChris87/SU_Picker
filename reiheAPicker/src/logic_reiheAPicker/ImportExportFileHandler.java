package logic_reiheAPicker;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.ByteOrderMark;
import org.apache.commons.io.input.BOMInputStream;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import var_reiheAPicker.Constants;
import javafx.stage.Stage;

//handles imports and exports for multipApiCall: Excel/csv/tsv import and Excel export
public class ImportExportFileHandler {
	
	public static List<List<String>> importCsvOrTsvOrPsf() throws IOException
	{		
		File file = getFileOrFolder(true);		
		return(getFileStringListFromFile(file));
	}	
	
	
	
	public static void exportFile(String contentString, String location)
	{
		
		  try{			  
			  
			  /*
				javafx.stage.FileChooser fileChooser = new javafx.stage.FileChooser();
				fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
				File userSelection = fileChooser.showSaveDialog(new Stage());			  
			    */			  
			  
		FileWriter fstream = new FileWriter(location);
		
        BufferedWriter out = new BufferedWriter(fstream);
        out.write(contentString);
        //Close the output stream
        out.close();
    	}catch (Exception e){//Catch exception if any
    		System.err.println("Error: " + e.getMessage());
    	}
	}
	
	public static void saveFileList(List<String> list, String location)
	{
		
		  try{			  
			  		  
			  
		FileWriter fstream = new FileWriter(location);		
        BufferedWriter out = new BufferedWriter(fstream);  
              
        String saveString = "";
        
        	for(String column : list)
        	{
        		saveString += column;
        		saveString += "\t";
        	}    	
                 
        
        out.write(saveString);
        //Close the output stream
        out.close();
    	}catch (Exception e){//Catch exception if any
    		System.err.println("Error: " + e.getMessage());
    	}
	}
	
	public static void saveFileListList(List<List<String>> list, String location)
	{
		
		  try{			  
			  		  
			  
		FileWriter fstream = new FileWriter(location);		
        BufferedWriter out = new BufferedWriter(fstream);  
              
        String saveString = "";
        for (List<String> line : list)
        {
        	for(String column : line)
        	{
        		saveString += column;
        		saveString += "\t";
        	}
        	saveString += "\n";       	
        }             
        
        out.write(saveString);
        //Close the output stream
        out.close();
    	}catch (Exception e){//Catch exception if any
    		System.err.println("Error: " + e.getMessage());
    	}
	}
	
	public void openExportFileFolder() throws IOException
	{
		PropertyFileHandler propertyFileHandler = PropertyFileHandler.getInstance();
		Runtime.getRuntime().exec("explorer " + propertyFileHandler.propertyFileModel.get_settings_ExportFileFolder());
	}
	
	public static void openSaveFileFolder() throws IOException
	{
		PropertyFileHandler propertyFileHandler = PropertyFileHandler.getInstance();
		Runtime.getRuntime().exec("explorer " + propertyFileHandler.propertyFileModel.get_settings_SaveFileFolder());
	}
	
	public static String getTimeStamp()
	{
		SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMdd_HHmmss");
		String date = formatter.format(System.currentTimeMillis());
		return date;
	}	
	
	public static File getFileOrFolder(boolean folderFalseFileTrue)
	{
		//text: User input; 
		File fileChosen = null;
		
		
			
			if (folderFalseFileTrue)
			{
				FileChooser chooser = new javafx.stage.FileChooser();
				chooser.getExtensionFilters().addAll(new ExtensionFilter("Alle Dateien", "*.*"),
						new ExtensionFilter("CSV", "*.csv*"), 
						new ExtensionFilter("TSV", "*.tsv*"), 
						new ExtensionFilter("Picker Save Files", "*.psv*"));
				
				chooser.setTitle("Bitte Zieldatei auswählen");
				fileChosen = chooser.showOpenDialog(new Stage());
				
							
			} else
			{
				DirectoryChooser directoryChooser = new javafx.stage.DirectoryChooser();
				directoryChooser.setTitle("Bitte Zielordner auswählen");	
				fileChosen = directoryChooser.showDialog(new Stage());
			}			
	
		
		if (fileChosen == null)
		{		
			System.out.println("Vorgang abgebrochen oder Datei nicht gefunden.");
			return null;
		}
		
		return fileChosen;
	}
	
	//global import method, will handle csv/tsv
		//will create and return a list (lines) of a List (columns) 
		//the subsequent mechanism all handle that specific file.
	/*
		public static String getFileStringListFromFile(String fileString) throws IOException
			{
					List<List<String>> rows = new ArrayList<List<String>>();		
					InputStream inputStream = new FileInputStream(new File(fileString));
														
						String defaultEncoding = "UTF-8";	
						String separator = "";
					
						BOMInputStream bOMInputStream = new BOMInputStream(inputStream);
					    ByteOrderMark bom = bOMInputStream.getBOM();
					    String charsetName = bom == null ? defaultEncoding : bom.getCharsetName();
					    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(bOMInputStream), charsetName));
					    String line;
					    String file = "";
						while ((line = bufferedReader.readLine()) != null) {	
							file += line;					
							  	
							  }
						  	inputStream.close();
						  	bufferedReader.close();						 
						
					
					return file;
				}
				*/
	
	//global import method, will handle csv/tsv
	//will create and return a list (lines) of a List (columns) 
	//the subsequent mechanism all handle that specific file.
	public static List<List<String>> getFileStringListFromFile(File fileChosen) throws IOException
		{
				List<List<String>> rows = new ArrayList<List<String>>();		
				InputStream inputStream = new FileInputStream(fileChosen.getAbsolutePath());
													
					String defaultEncoding = "UTF-8";	
					String separator = "";
				
					BOMInputStream bOMInputStream = new BOMInputStream(inputStream);
				    ByteOrderMark bom = bOMInputStream.getBOM();
				    String charsetName = bom == null ? defaultEncoding : bom.getCharsetName();
				    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(bOMInputStream), charsetName));
				    String line;
					  while ((line = bufferedReader.readLine()) != null) {	
						  
						  int commaCounter = 0;
						  int tabCounter = 0;
						  int semicolonCounter = 0;
						  int seperatorCounter = 0;
						  if (separator.isEmpty())
						  {
							  //count Commas and Tabs in the first line (headings) and use that as a separator
							  //using comma as separator is a bit weird: Authors often use commas as separators for their names
							  //might still be useful if people only want to enrich very reduced file (issn/titel/...)
							  for (char character : line.toCharArray())
							  {
								  if (character == ',')
								  {
									  commaCounter ++; 
								  } else if (character == '\t')
								  {
									  tabCounter ++; 
								  } else if (character == ';')
								  {
									  semicolonCounter ++;
								  }
							  } 
							  
							  if (commaCounter > tabCounter && commaCounter > semicolonCounter)
							  {
								  separator = ",";
								  seperatorCounter = commaCounter;
							  }
							  if (tabCounter > commaCounter && tabCounter > semicolonCounter)
							  {
								  separator = "\t";
								  seperatorCounter = tabCounter;
							  }
							  if (semicolonCounter > tabCounter && semicolonCounter > commaCounter)
							  {
								  separator = ";";
								  seperatorCounter = semicolonCounter;
							  }
							  
							  //separator = (commaCounter > tabCounter) ? "," : "\t";
						  }
						 
						  if (separator.isEmpty())
						  {
							  //no separator? maybe its a file with only one issn per line...
							  	ArrayList<String> columns = new ArrayList<String>();							 
								 columns.add(line.toString());	
								 rows.add(columns);
						  } else
						  {							  
							  
														  
							  String[] array = line.split(separator);
							  ArrayList<String> columns = new ArrayList<String>();
							  for (String string : array)
							  {
								  columns.add(string);
							  }
							  rows.add(columns);		
							  }
						  	
						  }
					  	inputStream.close();
					  	bufferedReader.close();						 
					
				
				return rows;
			}
			
			
			//lineformatter: UI uses monospace font.
			//so we need to count the chars in order to display the data properly
			// i.e.:
			//column A:    Value 1
			//col. B:	   Value 2			
			public static String lineFormatter(String heading, String data)
			{				
				if (heading.toCharArray().length > 25)
				{
					heading = heading.substring(0,20);
					heading += " (..):   ";
				} else
				{
					heading += ":";
					int counter = 29 - heading.toCharArray().length;
					for (;counter > 0; counter --)
					{
						heading += " ";
					}
					
				}
				return heading + data + "\n";
				
			}

	        
 
			

}