package aero.logicsimulator.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import aero.logicsimulator.program.Program;

public class LogConsole extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private static JTextArea console;
	private static List<String> logHistory = new ArrayList<String>();

	public LogConsole()
	{
		super(new BorderLayout());
		
		this.setPreferredSize(new Dimension(0, 200));
		this.setBorder(BorderFactory.createTitledBorder(Program.strings.console));
		
		console = new JTextArea();
		console.setEditable(false);
		console.setFont(new Font("Courier New", Font.BOLD, 12));
		JScrollPane scrollPane = new JScrollPane(console);
		this.add(scrollPane, BorderLayout.CENTER);
	}
	
	public static void Print(String message)
	{
		logHistory.add(message + "\n");
		try
		{
			console.setText("");
			for(String line : logHistory)
				console.setText(console.getText() + line);
		}
		catch(NullPointerException exc)
		{}
	}
}
