package aero.logicsimulator.GUI.Components.LogicGates;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import aero.logicsimulator.GUI.DesignBoard.DrawingPane;
import aero.logicsimulator.GUI.Components.Component;
import aero.logicsimulator.GUI.Components.Node;
import aero.logicsimulator.program.Logger;

public abstract class LogicGate extends Component implements LogicGateInterface
{
	private static final long serialVersionUID = 1L;

	//
	// Degiskenler, sabitler, sinif uyeleri
	//
	// PIN sayisi
	private int pinCount;
	
	protected Node[] inputNodes;
	protected Node outputNode;
	
	//
	// Kurucu Metod
	//
	public LogicGate()
	{
		this.SetPinCount(2);
		
		this.setSize(DrawingPane.STAR * 8 + 1, DrawingPane.STAR * 8 + 1);
		this.setPreferredSize(this.getSize());
		
		// Sag tus menusunun ayarlanmasi
		this.addMouseListener(new RightClickPopupMenuAdapter());

		this.AddInputOutputNodes();
	}
	
	//
	// PinCount Getter/Setter Metodlari
	//
	protected void SetPinCount(int c)
	{
		if(c < 6 && c > 1)
			this.pinCount = c;
	}
	
	protected int GetPinCount()
	{
		return this.pinCount;
	}
	
	@Override
	public void paint(Graphics g)
	{
		int star = DrawingPane.STAR;
		
		// Izgaranin cizimi;
		/*
		g.setColor(Color.LIGHT_GRAY);
		for(int i = 0; i <= 8; i++)
		{
			g.drawLine(0, i * star, star * 8, i * star);
		}
		
		for(int j = 0; j <= 8; j++)
		{
			g.drawLine(j * star, 0, j * star, star * 8);
		}
		*/
		g.setColor(Color.BLACK);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		this.DrawLogicGateBody(g2);
		this.DrawLogicGatePins(g2);
		
		super.paint(g);
	}
	
	protected void AddPin()
	{
		this.SetPinCount(this.GetPinCount() + 1);
		
		this.UpdateNodesVisibility();
		this.repaint();
	}
	
	protected void RemovePin()
	{
		this.SetPinCount(this.GetPinCount() - 1);
		
		this.UpdateNodesVisibility();
		this.repaint();
	}
	
	@Override
	public void RotateRight()
	{
		super.RotateRight();
		
		this.UpdateNodesPosition();
	}
	
	@Override
	public void RotateLeft()
	{
		super.RotateLeft();
		
		this.UpdateNodesPosition();
	}
	
	//
	// Giris/Cikis pinlerine baglanti dugumlerinin eklenmesi
	//
	private void AddInputOutputNodes()
	{
		// Giris dugumleri
		this.inputNodes = new Node[5];
		for(int i = 0; i < 5; i++)
		{
			inputNodes[i] = new Node();
			this.add(inputNodes[i]);
		}
		
		// Cikis dugumu
		this.outputNode = new Node();
		this.add(outputNode);
		
		this.UpdateNodesPosition();
		this.UpdateNodesVisibility();
	}
	
	private void UpdateNodesPosition()
	{
		int star = DrawingPane.STAR;
		
		switch(this.GetOrientation())
		{
			default :
			case RIGHT :
			{
				for(int i = 0; i < 5; i++)
					inputNodes[i].setBounds(0, 2*star + i*star - star/4, inputNodes[i].getWidth(), inputNodes[i].getHeight());
				
				outputNode.setBounds(8*star - star/2 + 1, 4*star - star/4, outputNode.getWidth(), outputNode.getHeight());
			}
			break;
			
			case DOWN :
			{
				for(int i = 0; i < 5; i++)
					inputNodes[i].setBounds(6*star - i*star - star/4, 0, inputNodes[i].getWidth(), inputNodes[i].getHeight());
				
				outputNode.setBounds(4*star - star/4, 8*star - star/2 + 1, outputNode.getWidth(), outputNode.getHeight());
			}
			break;
			
			case LEFT :
			{
				for(int i = 0; i < 5; i++)
					inputNodes[i].setBounds(8*star - star/2 + 1, 6*star - i*star - star/4, inputNodes[i].getWidth(), inputNodes[i].getHeight());
				
				outputNode.setBounds(0, 4*star - star/4, outputNode.getWidth(), outputNode.getHeight());
			}
			break;
			
			case UP :
			{
				for(int i = 0; i < 5; i++)
					inputNodes[i].setBounds(2*star + i*star - star/4, 8*star - star/2 + 1, inputNodes[i].getWidth(), inputNodes[i].getHeight());
				
				outputNode.setBounds(4*star - star/4, 0, outputNode.getWidth(), outputNode.getHeight());
			}
			break;
		}
	}
	
	private void UpdateNodesVisibility()
	{
		switch(this.GetPinCount())
		{
			default:
			case 2 : 
			{
				this.inputNodes[0].setVisible(false);
				this.inputNodes[1].setVisible(true);
				this.inputNodes[2].setVisible(false);
				this.inputNodes[3].setVisible(true);
				this.inputNodes[4].setVisible(false);
			}
			break;
			
			case 3 : 
			{
				this.inputNodes[0].setVisible(true);
				this.inputNodes[1].setVisible(false);
				this.inputNodes[2].setVisible(true);
				this.inputNodes[3].setVisible(false);
				this.inputNodes[4].setVisible(true);
			}
			break;
			
			case 4 : 
			{
				this.inputNodes[0].setVisible(true);
				this.inputNodes[1].setVisible(true);
				this.inputNodes[2].setVisible(false);
				this.inputNodes[3].setVisible(true);
				this.inputNodes[4].setVisible(true);
			}
			break;
			
			case 5 : 
			{
				this.inputNodes[0].setVisible(true);
				this.inputNodes[1].setVisible(true);
				this.inputNodes[2].setVisible(true);
				this.inputNodes[3].setVisible(true);
				this.inputNodes[4].setVisible(true);
			}
			break;
		}
	}
}
