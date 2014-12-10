package aero.logicsimulator.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSourceContext;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import aero.logicsimulator.GUI.DesignBoard.DrawingPane;
import aero.logicsimulator.GUI.ToolBoxPanel.ToolBoxItem;
import aero.logicsimulator.program.Logger;

public class ToolBoxDragAndDropManager implements DragGestureListener, DragSourceListener, DropTargetListener, Transferable
{
	static final DataFlavor[] dataflavor = { null };
	Object object;
	static
	{
		try
		{
			dataflavor[0] = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//
	// Transferable methods.
	//
	@Override
	public Object getTransferData(DataFlavor flavor)
	{
		if (flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType))
		{
			return object;
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public DataFlavor[] getTransferDataFlavors()
	{
		return dataflavor;
	}
	
	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor)
	{
		return flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType);
	}
	
	//
	// DragGestureListener method.
	//
	@Override
	public void dragGestureRecognized(DragGestureEvent dge)
	{
		dge.startDrag(null, this, this);
	}
	
	//
	// DragSourceListener methods.
	//
	@Override
	public void dragDropEnd(DragSourceDropEvent dsde)
	{
	}
	
	@Override
	public void dragEnter(DragSourceDragEvent dsde)
	{
	}
	
	@Override
	public void dragExit(DragSourceEvent dse)
	{
	}
	
	@Override
	public void dragOver(DragSourceDragEvent dsde)
	{
		object = dsde.getSource();
	}
	
	@Override
	public void dropActionChanged(DragSourceDragEvent dsde)
	{
	}
	
	//
	// DropTargetListener methods.
	//
	@Override
	public void dragEnter(DropTargetDragEvent dtde)
	{
	}
	
	@Override
	public void dragExit(DropTargetEvent dte)
	{
	}
	
	@Override
	public void dragOver(DropTargetDragEvent dtde)
	{
		dropTargetDrag(dtde);
	}
	
	@Override
	public void dropActionChanged(DropTargetDragEvent dtde)
	{
		dropTargetDrag(dtde);
	}
	
	@Override
	public void drop(DropTargetDropEvent dtde)
	{
		dtde.acceptDrop(dtde.getDropAction());
		try
		{
			Object source = dtde.getTransferable().getTransferData(dataflavor[0]);
			Object target = dtde.getSource();
			DrawingPane designBoard = (DrawingPane)((DropTarget)target).getComponent();
			
			ToolBoxItem toolBoxItem = (ToolBoxItem)((DragSourceContext)source).getComponent();
			
			Component component = (Component)toolBoxItem.toolType.newInstance();
			designBoard.add(component);
			int x = dtde.getLocation().x - dtde.getLocation().x % DrawingPane.STAR;
			int y = dtde.getLocation().y - dtde.getLocation().y % DrawingPane.STAR;
			component.setBounds(x, y, component.getWidth(), component.getHeight());
			
			designBoard.validate();
			designBoard.repaint();
			
			Logger.Log("Bir " + component.getClass().getSimpleName() + " eklendi. [" + component.getLocation().x + ", " + component.getLocation().y + "]");
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		dtde.dropComplete(true);
	}
	
	//
	// 
	//
	void dropTargetDrag(DropTargetDragEvent dtde)
	{
		dtde.acceptDrag(dtde.getDropAction());
	}
}
