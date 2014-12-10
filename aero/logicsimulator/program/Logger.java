package aero.logicsimulator.program;

import aero.logicsimulator.GUI.LogConsole;

public class Logger
{
	private static String logBook;
	private static int logCount;
	
	public Logger()
	{
		logBook = new String();
		logCount = 0;
	}
	
	public static void Log(String message)
	{
		logBook += ++logCount + ". " + message + "\n";
		System.out.println(logCount + ". " + message);
		
		LogConsole.Print(message);
	}
	
	public static void ErrorLog(String errorMessage)
	{
		logBook += ++logCount + ". " + "Hata : " + errorMessage + "\n";
		System.err.println(logCount + ". " + errorMessage);
		
		LogConsole.Print("[HATA] " + errorMessage);
	}
	
	public static void PrintAll()
	{
		System.out.println(logBook);
	}

	public static void Log(int i)
	{
		Log("" + i);
	}
	
	public static void Log(double d)
	{
		Log("" + d);
	}
	
	public static void Log(float f)
	{
		Log("" + f);
	}
	
	public static void Log(char c)
	{
		Log("" + c);
	}
}
