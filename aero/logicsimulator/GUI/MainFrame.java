package aero.logicsimulator.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aero.logicsimulator.program.Logger;
import aero.logicsimulator.program.Program;

public class MainFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	//
	// Deðiþkenler, sabitler, sýnýf üyeleri
	//
	private JPanel HeaderPanel;
	private JPanel CenterPanel;
	private JPanel FooterPanel;
	private LogConsole logConsolePanel;
	
	private ToolBoxPanel toolBoxPanel;
	
	private static JLabel coordinateInfoLabel;
	
	private ImageIcon appIcon;
	private ImageIcon settingsButtonIcon = null;
	private ImageIcon minButtonIcon = null;
	private ImageIcon closeButtonIcon = null;
	private ImageIcon settingsButtonHoverIcon = null;
	private ImageIcon minButtonHoverIcon = null;
	private ImageIcon closeButtonHoverIcon = null;
	
	//
	// Kurucu Metodlar - Constructors
	//
	public MainFrame() throws HeadlessException
	{
		super(Program.strings.mainFrameTitle + " | " + Program.strings.authorName);
		
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height - Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration()).bottom);
		//this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2);
		this.setResizable(false);
		this.setUndecorated(true);
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLayout(new BorderLayout());
		
		this.InitializeAssets();
		
		this.SetHeaderPanel();
		this.SetCenterPanel();
		this.SetFooterPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		Logger.Log("MainFrame penceresi oluþturuldu.");
	}
	
	private void SetHeaderPanel()
	{
		this.HeaderPanel = new JPanel(new BorderLayout());
		this.HeaderPanel.setPreferredSize(new Dimension(0, 100));
		this.add(this.HeaderPanel, BorderLayout.NORTH);
		
		this.SetTitleBar();
	}
	
	private void SetTitleBar()
	{
		JPanel titleBar = new JPanel(new BorderLayout());
		titleBar.setBorder(new EmptyBorder(5,5,0,10));
		this.HeaderPanel.add(titleBar, BorderLayout.NORTH);
		
		JLabel iconLabel = new JLabel(this.appIcon);
		titleBar.add(iconLabel, BorderLayout.WEST);
		
		@SuppressWarnings("serial")
		JLabel appTitle = new JLabel(this.getTitle())
		{
			@Override
			public void paint(Graphics g)
			{
				super.paint(g);
				g.drawLine(5, this.getHeight() - 1, this.getWidth() - 10, this.getHeight() - 1);
			}
		};
		appTitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		appTitle.setBorder(new EmptyBorder(0, 5, 10, 0));
		titleBar.add(appTitle, BorderLayout.CENTER);
		
		JPanel appButtonsPanel = new JPanel(new GridLayout(1, 3));
		
		JLabel settingsButton = new JLabel(settingsButtonIcon);
		settingsButton.addMouseListener(new MouseAdapter()
		{
			@Override
            public void mouseEntered(MouseEvent e)
			{
				settingsButton.setIcon(settingsButtonHoverIcon);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
            	settingsButton.setIcon(settingsButtonIcon);
            }
        });
		appButtonsPanel.add(settingsButton);
		
		JLabel minimizeButton = new JLabel(minButtonIcon);
		minimizeButton.addMouseListener(new MouseAdapter()
		{
			@Override
            public void mouseEntered(MouseEvent e)
			{
				minimizeButton.setIcon(minButtonHoverIcon);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
            	minimizeButton.setIcon(minButtonIcon);
            }
            
            @Override
            public void mouseClicked(MouseEvent e)
            {
            	setState(JFrame.ICONIFIED);
            }
        });
		appButtonsPanel.add(minimizeButton);
		
		JLabel closeButton = new JLabel(closeButtonIcon);
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
            	Program.Exit();
            }
        });
		appButtonsPanel.add(closeButton);
		
		appButtonsPanel.setMinimumSize(new Dimension(90, 30));
		titleBar.add(appButtonsPanel, BorderLayout.EAST);
	}
	
	private void SetCenterPanel()
	{
		this.CenterPanel = new JPanel(new BorderLayout());
		this.add(this.CenterPanel, BorderLayout.CENTER);
		this.CenterPanel.add(new DesignPanel(), BorderLayout.CENTER);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		leftPanel.setPreferredSize(new Dimension(200, 0));
		this.CenterPanel.add(leftPanel, BorderLayout.WEST);
		
		this.toolBoxPanel = new ToolBoxPanel();
		leftPanel.add(this.toolBoxPanel, BorderLayout.CENTER);
		
		this.logConsolePanel = new LogConsole();
		this.CenterPanel.add(this.logConsolePanel, BorderLayout.SOUTH);
	}
	
	private void SetFooterPanel()
	{
		this.FooterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.FooterPanel.setPreferredSize(new Dimension(0, 25));
		this.FooterPanel.setBackground(Color.LIGHT_GRAY);
		this.add(this.FooterPanel, BorderLayout.SOUTH);
		
		coordinateInfoLabel = new JLabel(String.format("(%d, %d)", 0, 0));
		this.FooterPanel.add(coordinateInfoLabel);
	}
	
	public static void UpdateCoordinateInfoLabel(int x, int y)
	{
		coordinateInfoLabel.setText(String.format("(%d, %d)", x, y));
	}
	
	private void InitializeAssets()
	{
		try
		{
			String assetsPath = URLDecoder.decode(getClass().getClassLoader().getResource(".").getPath() + "Assets", "utf-8");
			
			this.appIcon = new ImageIcon(ImageIO.read(new File(assetsPath + "/Images/ic.png")).getScaledInstance(50, 25, Image.SCALE_SMOOTH));
			this.settingsButtonIcon = new ImageIcon(ImageIO.read(new File(assetsPath + "/Icons/settings.png")));
			minButtonIcon = new ImageIcon(ImageIO.read(new File(assetsPath + "/Icons/minimize.png")));
			closeButtonIcon = new ImageIcon(ImageIO.read(new File(assetsPath + "/Icons/close.png")));
			
			settingsButtonHoverIcon = new ImageIcon(ImageIO.read(new File(assetsPath + "/Icons/settings_hover.png")));
			minButtonHoverIcon = new ImageIcon(ImageIO.read(new File(assetsPath + "/Icons/minimize_hover.png")));
			closeButtonHoverIcon = new ImageIcon(ImageIO.read(new File(assetsPath + "/Icons/close_hover.png")));
		}
		catch (IOException e)
		{}
	}
}
