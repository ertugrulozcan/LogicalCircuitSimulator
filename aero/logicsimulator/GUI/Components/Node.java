package aero.logicsimulator.GUI.Components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import aero.logicsimulator.GUI.DesignBoard.DrawingPane;

public class Node extends Component
{
	private static final long serialVersionUID = 1L;

	private Color color;
	
	public Node()
	{
		this.setSize(DrawingPane.STAR, DrawingPane.STAR);
		this.setPreferredSize(getSize());
		
		this.color = Color.BLUE;
		
		this.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent e)
			{}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				color = Color.RED;
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				color = Color.BLUE;
				repaint();
			}

			@Override
			public void mousePressed(MouseEvent e)
			{}

			@Override
			public void mouseReleased(MouseEvent e)
			{}
			
		});
		
		this.removeMouseMotionListener(this.getMouseMotionListeners()[0]);
	}
	
	@Override
	public void paint(Graphics g)
	{
		g.setColor(this.color);
		g.fillRect(0, 0, DrawingPane.STAR / 2 , DrawingPane.STAR / 2);
	}
}
