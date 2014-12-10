package aero.logicsimulator.GUI.Components.LogicGates;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RightClickPopupMenuAdapter extends MouseAdapter
{
    public void mousePressed(MouseEvent e)
    {
        if (e.isPopupTrigger())
        	doPop(e);
    }

    public void mouseReleased(MouseEvent e)
    {
        if (e.isPopupTrigger())
        	doPop(e);
    }

    private void doPop(MouseEvent e)
    {
    	RightClickPopupMenu menu = new RightClickPopupMenu((LogicGate)e.getComponent());
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}
