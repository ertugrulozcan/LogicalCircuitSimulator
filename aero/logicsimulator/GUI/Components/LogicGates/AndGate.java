package aero.logicsimulator.GUI.Components.LogicGates;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import aero.logicsimulator.GUI.DesignBoard.DrawingPane;
import aero.logicsimulator.program.Logger;

public class AndGate extends LogicGate
{
	private static final long serialVersionUID = 1L;

	public AndGate()
	{
		
	}

	@Override
	public void DrawLogicGateBody(Graphics2D brush)
	{
		int star = DrawingPane.STAR;
		brush.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		
		switch(this.GetOrientation())
		{
			case UP:
			{
				brush.drawLine(2*star, 6*star, 6*star, 6*star);
				brush.drawLine(2*star, 4*star, 2*star, 6*star);
				brush.drawLine(6*star, 4*star, 6*star, 6*star);
				brush.drawArc(2*star, 2*star, 4*star, 4*star, 180, -180);
			}
			break;
			
			default:
			case RIGHT:
			{
				brush.drawLine(2*star, 2*star, 2*star, 6*star);
				brush.drawLine(2*star, 2*star, 4*star, 2*star);
				brush.drawLine(2*star, 6*star, 4*star, 6*star);
				brush.drawArc(2*star, 2*star, 4*star, 4*star, 270, 180);
			}
			break;
			
			case DOWN:
			{
				brush.drawLine(2*star, 2*star, 6*star, 2*star);
				brush.drawLine(2*star, 2*star, 2*star, 4*star);
				brush.drawLine(6*star, 2*star, 6*star, 4*star);
				brush.drawArc(2*star, 2*star, 4*star, 4*star, 180, 180);
			}
			break;
			
			case LEFT:
			{
				brush.drawLine(6*star, 2*star, 6*star, 6*star);
				brush.drawLine(4*star, 2*star, 6*star, 2*star);
				brush.drawLine(4*star, 6*star, 6*star, 6*star);
				brush.drawArc(2*star, 2*star, 4*star, 4*star, 90, 180);
			}
			break;
		}
	}

	@Override
	public void DrawLogicGatePins(Graphics2D brush)
	{
		int star = DrawingPane.STAR;
		brush.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		
		switch(this.GetOrientation())
		{
			case UP:
			{
				// Giris pinlerinin cizimi
				
				switch(this.GetPinCount())
				{
					default :
					case 2 : 
					{
						brush.drawLine(3*star, 6*star, 3*star, 8*star);
						brush.drawLine(5*star, 6*star, 5*star, 8*star);
					}
					break;
					
					case 3 : 
					{
						brush.drawLine(2*star, 6*star, 2*star, 8*star);
						brush.drawLine(4*star, 6*star, 4*star, 8*star);
						brush.drawLine(6*star, 6*star, 6*star, 8*star);
					}
					break;
					
					case 4 : 
					{
						brush.drawLine(2*star, 6*star, 2*star, 8*star);
						brush.drawLine(3*star, 6*star, 3*star, 8*star);
						brush.drawLine(5*star, 6*star, 5*star, 8*star);
						brush.drawLine(6*star, 6*star, 6*star, 8*star);
					}
					break;
					
					case 5 : 
					{
						brush.drawLine(2*star, 6*star, 2*star, 8*star);
						brush.drawLine(3*star, 6*star, 3*star, 8*star);
						brush.drawLine(4*star, 6*star, 4*star, 8*star);
						brush.drawLine(5*star, 6*star, 5*star, 8*star);
						brush.drawLine(6*star, 6*star, 6*star, 8*star);
					}
					break;
				}
				
				// Cikis pininin cizimi
				brush.drawLine(4*star, 0, 4*star, 2*star);
			}
			break;
			
			default:
			case RIGHT:
			{
				// Giris pinlerinin cizimi
				
				switch(this.GetPinCount())
				{
					default :
					case 2 : 
					{
						brush.drawLine(0, 3*star, 2*star, 3*star);
						brush.drawLine(0, 5*star, 2*star, 5*star);
					}
					break;
					
					case 3 : 
					{
						brush.drawLine(0, 2*star, 2*star, 2*star);
						brush.drawLine(0, 4*star, 2*star, 4*star);
						brush.drawLine(0, 6*star, 2*star, 6*star);
					}
					break;
					
					case 4 : 
					{
						brush.drawLine(0, 2*star, 2*star, 2*star);
						brush.drawLine(0, 3*star, 2*star, 3*star);
						brush.drawLine(0, 5*star, 2*star, 5*star);
						brush.drawLine(0, 6*star, 2*star, 6*star);
					}
					break;
					
					case 5 : 
					{
						brush.drawLine(0, 2*star, 2*star, 2*star);
						brush.drawLine(0, 3*star, 2*star, 3*star);
						brush.drawLine(0, 4*star, 2*star, 4*star);
						brush.drawLine(0, 5*star, 2*star, 5*star);
						brush.drawLine(0, 6*star, 2*star, 6*star);
					}
					break;
				}
				
				// Cikis pininin cizimi
				brush.drawLine(6*star, 4*star, 8*star, 4*star);
			}
			break;
			
			case DOWN:
			{
				// Giris pinlerinin cizimi
				
				switch(this.GetPinCount())
				{
					default :
					case 2 : 
					{
						brush.drawLine(3*star, 2*star, 3*star, 0);
						brush.drawLine(5*star, 2*star, 5*star, 0);
					}
					break;
					
					case 3 : 
					{
						brush.drawLine(2*star, 2*star, 2*star, 0);
						brush.drawLine(4*star, 0, 4*star, 2*star);
						brush.drawLine(6*star, 0, 6*star, 2*star);
					}
					break;
					
					case 4 : 
					{
						brush.drawLine(2*star, 2*star, 2*star, 0);
						brush.drawLine(3*star, 2*star, 3*star, 0);
						brush.drawLine(5*star, 2*star, 5*star, 0);
						brush.drawLine(6*star, 0, 6*star, 2*star);
					}
					break;
					
					case 5 : 
					{
						brush.drawLine(2*star, 2*star, 2*star, 0);
						brush.drawLine(3*star, 2*star, 3*star, 0);
						brush.drawLine(4*star, 0, 4*star, 2*star);
						brush.drawLine(5*star, 2*star, 5*star, 0);
						brush.drawLine(6*star, 0, 6*star, 2*star);
					}
					break;
				}
				
				// Cikis pininin cizimi
				brush.drawLine(4*star, 6*star, 4*star, 8*star);
			}
			break;
			
			case LEFT:
			{
				// Giris pinlerinin cizimi
				
				switch(this.GetPinCount())
				{
					default :
					case 2 : 
					{
						brush.drawLine(6*star, 3*star, 8*star, 3*star);
						brush.drawLine(6*star, 5*star, 8*star, 5*star);
					}
					break;
					
					case 3 : 
					{
						brush.drawLine(6*star, 2*star, 8*star, 2*star);
						brush.drawLine(6*star, 4*star, 8*star, 4*star);
						brush.drawLine(6*star, 6*star, 8*star, 6*star);
					}
					break;
					
					case 4 : 
					{
						brush.drawLine(6*star, 2*star, 8*star, 2*star);
						brush.drawLine(6*star, 3*star, 8*star, 3*star);
						brush.drawLine(6*star, 5*star, 8*star, 5*star);
						brush.drawLine(6*star, 6*star, 8*star, 6*star);
					}
					break;
					
					case 5 : 
					{
						brush.drawLine(6*star, 2*star, 8*star, 2*star);
						brush.drawLine(6*star, 3*star, 8*star, 3*star);
						brush.drawLine(6*star, 4*star, 8*star, 4*star);
						brush.drawLine(6*star, 5*star, 8*star, 5*star);
						brush.drawLine(6*star, 6*star, 8*star, 6*star);
					}
					break;
				}
				
				// Cikis pininin cizimi
				brush.drawLine(0, 4*star, 2*star, 4*star);
			}
			break;
			
		}
	}
}
