package aero.logicsimulator.GUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureRecognizer;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import aero.logicsimulator.GUI.Components.Node;
import aero.logicsimulator.GUI.Components.LogicGates.*;
import aero.logicsimulator.program.Program;

public class ToolBoxPanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	private JPanel logicGatesPanel;
	public static ToolBoxDragAndDropManager toolBoxDragAndDropManager;
	
	public ToolBoxPanel()
	{
		this.setLayout(new GridLayout(4, 1));
		this.SetLogicGatesPanel();
	}
	
	private void SetLogicGatesPanel()
	{
		this.logicGatesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.add(this.logicGatesPanel);
		TitledBorder title = BorderFactory.createTitledBorder(Program.strings.logicGates);
		this.logicGatesPanel.setBorder(title);
		
		String logicGatesFolder = null;
		try
		{
			logicGatesFolder = URLDecoder.decode(getClass().getClassLoader().getResource(".").getPath() + File.separator + "Assets" + File.separator + "LogicGates" + File.separator, "utf-8");
		}
		catch (UnsupportedEncodingException e)
		{}
		
		DragSource dragSource = new DragSource();
		toolBoxDragAndDropManager = new ToolBoxDragAndDropManager();
		
		ToolBoxItem andGateTool = new ToolBoxItem(AndGate.class, new ImageIcon(logicGatesFolder + "andGate.png"));
		this.logicGatesPanel.add(andGateTool);
		dragSource.createDefaultDragGestureRecognizer(andGateTool, DnDConstants.ACTION_MOVE, toolBoxDragAndDropManager);
		
		ToolBoxItem nandGateTool = new ToolBoxItem(NandGate.class, new ImageIcon(logicGatesFolder + "nandGate.png"));
		this.logicGatesPanel.add(nandGateTool);
		dragSource.createDefaultDragGestureRecognizer(nandGateTool, DnDConstants.ACTION_MOVE, toolBoxDragAndDropManager);
	}
	
	public class ToolBoxItem extends JLabel
	{
		Class toolType;
		
		public ToolBoxItem(Class type, ImageIcon icon)
		{
			this.toolType = type;
			this.setIcon(icon);
		}
	}
}
