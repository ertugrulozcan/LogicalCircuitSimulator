package aero.logicsimulator.GUI.Components.LogicGates;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import aero.logicsimulator.program.Program;

public class RightClickPopupMenu extends JPopupMenu
{
	private static final long serialVersionUID = 1L;
	private JMenuItem rotateRightButton, rotateLeftButton, addPinButton, removePinButton;
	
	public RightClickPopupMenu(LogicGate logicGate)
	{
		String iconsFolderPath = null;
		try
		{
			iconsFolderPath = URLDecoder.decode(getClass().getClassLoader().getResource(".").getPath() + File.separator + "Assets" + File.separator + "Icons" + File.separator, "utf-8");
		}
		catch (UnsupportedEncodingException e)
		{}
		
		this.rotateRightButton = new JMenuItem(Program.strings.rotateRight, new ImageIcon(iconsFolderPath + "rotateRight.png"));
		this.rotateRightButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				logicGate.RotateRight();
			}	
		});
        this.add(this.rotateRightButton);
        
        this.rotateLeftButton = new JMenuItem(Program.strings.rotateLeft, new ImageIcon(iconsFolderPath + "rotateLeft.png"));
        this.rotateLeftButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				logicGate.RotateLeft();
			}	
		});
        this.add(this.rotateLeftButton);
        
        this.addPinButton = new JMenuItem(Program.strings.addPin, new ImageIcon(iconsFolderPath + "add.png"));
        this.addPinButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				logicGate.AddPin();
			}	
		});
        this.add(this.addPinButton);
        
        this.removePinButton = new JMenuItem(Program.strings.removePin, new ImageIcon(iconsFolderPath + "remove.png"));
        this.removePinButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				logicGate.RemovePin();
			}	
		});
        this.add(this.removePinButton);
	}
}
