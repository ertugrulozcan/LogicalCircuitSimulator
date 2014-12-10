package aero.logicsimulator.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import aero.logicsimulator.program.Logger;
import aero.logicsimulator.program.Program;

public class DesignPanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	//
	// Deðiþkenler, sabitler, sýnýf üyeleri
	//
	private static JTabbedPane tabbedPane;
	
	private static ImageIcon closeButtonIcon = null;
	private static ImageIcon closeButtonHoverIcon = null;
	
	public DesignPanel()
	{
		this.InitializeAssets();
		
		this.setLayout(new BorderLayout());
		this.tabbedPane = new JTabbedPane();
		this.add(this.tabbedPane);
		
		this.tabbedPane.addChangeListener(new ChangeListener()
		{
	        public void stateChanged(ChangeEvent e)
	        {
	        	if(tabbedPane.getTabCount() == 0)
	        	{
	        		AddStartPageTab();
	        	}
	        }
	    });
	
		AddStartPageTab();
	}
	
	private void InitializeAssets()
	{
		String assetsPath;
		try
		{
			assetsPath = URLDecoder.decode(getClass().getClassLoader().getResource(".").getPath() + "Assets", "utf-8");
			closeButtonIcon = new ImageIcon(ImageIO.read(new File(assetsPath + "/Icons/close.png")));
			closeButtonHoverIcon = new ImageIcon(ImageIO.read(new File(assetsPath + "/Icons/close_hover.png")));
		}
		catch (UnsupportedEncodingException e)
		{}
		catch (IOException e)
		{}
	}
	
	public static void AddNewTab(String tabTitle)
	{
		tabbedPane.addTab(tabTitle, new DesignBoard());
		JPanel pnlTab = new JPanel(new GridBagLayout());
		pnlTab.setOpaque(false);
		JLabel lblTitle = new JLabel(tabTitle);
		lblTitle.setBorder(new EmptyBorder(3, 0, 3, 20));
		JLabel closeButton = new JLabel(closeButtonIcon);
		closeButton.setPreferredSize(new Dimension(10, 10));
		closeButton.addMouseListener(new MouseAdapter()
		{
			@Override
            public void mouseEntered(MouseEvent e)
			{
				closeButton.setIcon(closeButtonHoverIcon);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
            	closeButton.setIcon(closeButtonIcon);
            }
            
            @Override
            public void mouseClicked(MouseEvent e)
            {
            	tabbedPane.remove(tabbedPane.getSelectedIndex());
            }
        });

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;

		pnlTab.add(lblTitle, gbc);

		gbc.gridx++;
		gbc.weightx = 0;
		pnlTab.add(closeButton, gbc);
		tabbedPane.setTabComponentAt(tabbedPane.getTabCount() - 1, pnlTab);
		
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
	}
	
	public static void AddStartPageTab()
	{
		String tabTitle = Program.strings.start;
		tabbedPane.addTab(tabTitle, new StartPage());
		JPanel pnlTab = new JPanel(new GridBagLayout());
		pnlTab.setOpaque(false);
		JLabel lblTitle = new JLabel(tabTitle);
		lblTitle.setBorder(new EmptyBorder(3, 0, 3, 20));
		JLabel closeButton = new JLabel(closeButtonIcon);
		closeButton.setPreferredSize(new Dimension(10, 10));
		closeButton.addMouseListener(new MouseAdapter()
		{
			@Override
            public void mouseEntered(MouseEvent e)
			{
				closeButton.setIcon(closeButtonHoverIcon);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
            	closeButton.setIcon(closeButtonIcon);
            }
            
            @Override
            public void mouseClicked(MouseEvent e)
            {
            	tabbedPane.remove(tabbedPane.getSelectedIndex());
            }
        });

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;

		pnlTab.add(lblTitle, gbc);

		gbc.gridx++;
		gbc.weightx = 0;
		pnlTab.add(closeButton, gbc);
		tabbedPane.setTabComponentAt(tabbedPane.getTabCount() - 1, pnlTab);
	}
}
