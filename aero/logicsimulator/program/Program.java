package aero.logicsimulator.program;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import aero.logicsimulator.GUI.MainFrame;
import aero.logicsimulator.program.Logger;
import aero.logicsimulator.program.Localization.Strings;

public abstract class Program
{
	public static Strings strings;
	
	public static void main(String[] args)
	{
		Logger.Log("Program baþlatýldý.");
		
		Localization localization = new Localization("TR");
		strings = localization.strings;
		
		SetLookAndFeel();
		
		@SuppressWarnings("unused")
		MainFrame mainFrame = new MainFrame();
	}
	
	public static void Exit()
	{
		System.exit(0);
	}
	
	private static void SetLookAndFeel()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (UnsupportedLookAndFeelException e) {}
		catch (ClassNotFoundException e) {}
		catch (InstantiationException e) {}
		catch (IllegalAccessException e) {}
	}
}
