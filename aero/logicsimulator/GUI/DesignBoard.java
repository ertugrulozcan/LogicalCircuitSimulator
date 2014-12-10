package aero.logicsimulator.GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DesignBoard extends JScrollPane
{
	private static final long serialVersionUID = 1L;

	public DesignBoard()
	{
		this.setViewportView(new DrawingPane());
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		this.addMouseMotionListener(new MouseMotionListener()
		{
			@Override
			public void mouseDragged(MouseEvent arg0)
			{}

			@Override
			public void mouseMoved(MouseEvent e)
			{
				MainFrame.UpdateCoordinateInfoLabel(e.getX(), e.getY());
			}
		});
	}
	
	public static class DrawingPane extends JPanel
	{
		private static final long serialVersionUID = 1L;
		
		public static int STAR = 10;
		
		private final int WIDTH = 2000;
		private final int HEIGHT = 2000;

		public DrawingPane()
		{
			this.setLayout(null);	
			this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
			
			new DropTarget(this, DnDConstants.ACTION_MOVE, ToolBoxPanel.toolBoxDragAndDropManager);
		}
		
		@Override
		public void paint(Graphics g)
		{
			super.paint(g);

			for(int i = 0; i < this.getHeight(); i += STAR)
			{
				for(int j = 0; j < this.getWidth(); j += STAR)
				{
					g.drawLine(i, j, i, j);
				}
			}
		}
	}
}
