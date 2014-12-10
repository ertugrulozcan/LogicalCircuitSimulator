package aero.logicsimulator.program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.google.gson.Gson;


public class Localization
{
	public Strings strings;
	
	public class Strings
	{
		public String lang;
		public String language;
		public String mainFrameTitle;
		public String authorName;
		public String newProject;
		public String createNewProject;
		public String start;
		public String logicGate;
		public String logicGates;
		public String andGate;
		public String orGate;
		public String rotateLeft;
		public String rotateRight;
		public String addPin;
		public String removePin;
		public String console;
	}
	
	public Localization(String language)
	{
		String jsonFileName = "lang" + language.toUpperCase() + ".json";
		
		// FileSystems.getDefault().getSeparator() // Ýþletim sisteminin kullandýðý seperatoru tespit için
		
		try
		{
			this.ReadFromJsonFile(URLDecoder.decode(getClass().getClassLoader().getResource(".").getPath() + jsonFileName, "utf-8"));
		}
		catch (UnsupportedEncodingException e)
		{
			Logger.ErrorLog(jsonFileName + " dosyasý okunurken Path Decode hatasý oluþtu.");
		}
	}
	
	private void ReadFromJsonFile(String filePath)
	{
		BufferedReader br = null;
		try 
		{
			br = new BufferedReader (new FileReader (filePath));
			StringBuilder jsonStringSB = new StringBuilder();
			String line;
			while( (line = br.readLine()) != null)
			{
			       jsonStringSB.append(line);
			}
			String jsonString = jsonStringSB.toString();
			
			Gson gson = new Gson();
			this.strings =  gson.fromJson(jsonString, Strings.class);
			
			Logger.Log(this.strings.language + " dili yüklendi.");
		}
		catch (IOException e)
		{
			Logger.ErrorLog("Localizasyon JSON dosyasý okunamadý. Dosya yolu : " + filePath);
		}
	}
}
