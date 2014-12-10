package aero.logicsimulator.GUI.Components;

import javax.swing.JComponent;

import aero.logicsimulator.GUI.Components.LogicGates.DragListener;

public class Component extends JComponent
{
	private static final long serialVersionUID = 1L;
	
	//
	// Degiskenler, sabitler, sinif uyeleri
	//
	// Yon / Oryantasyon
	private Orientation orientation;
	
	//
	// Kurucu Metod
	//
	public Component()
	{
		super.setLayout(null);
		this.SetOrientation(Orientation.RIGHT);
	
		// Surukle/Tasi islemleri ici listener ayarlarinin yapilmasi
		DragListener dragListener = new DragListener();
		this.addMouseListener(dragListener);
		this.addMouseMotionListener(dragListener);
	}
	
	//
	// Orientation Getter/Setter Metodlari
	//
	public void SetOrientation(Orientation newOrientation)
	{
		this.orientation = newOrientation;
	}
	
	public Orientation GetOrientation()
	{
		return this.orientation;
	}
	
	public enum Orientation
	{
		UP, RIGHT, DOWN, LEFT
	}
	
	public void RotateRight()
	{
		switch(this.orientation)
		{
			case DOWN:	this.SetOrientation(Orientation.LEFT);
				break;
			case LEFT:	this.SetOrientation(Orientation.UP);
				break;
			case RIGHT:	this.SetOrientation(Orientation.DOWN);
				break;
			case UP:	this.SetOrientation(Orientation.RIGHT);
				break;
		}
		
		this.repaint();
	}
	
	public void RotateLeft()
	{
		switch(this.orientation)
		{
			case DOWN:	this.SetOrientation(Orientation.RIGHT);
				break;
			case LEFT:	this.SetOrientation(Orientation.DOWN);
				break;
			case RIGHT:	this.SetOrientation(Orientation.UP);
				break;
			case UP:	this.SetOrientation(Orientation.LEFT);
				break;
		}
		
		this.repaint();
	}
}
