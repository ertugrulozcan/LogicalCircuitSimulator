package aero.logicsimulator.GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import aero.logicsimulator.program.Program;
import aero.logicsimulator.project.Project;
import aero.logicsimulator.project.ProjectManager;

public class StartPage extends JPanel
{
	private static final long serialVersionUID = 1L;

	private JButton createNewProjectButton;
	
	public StartPage()
	{
		super(new FlowLayout(FlowLayout.LEFT));
		this.createNewProjectButton = new JButton(Program.strings.createNewProject);
		this.createNewProjectButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				Project newProject = ProjectManager.NewProject();
				DesignPanel.AddNewTab(newProject.GetProjectName());
			}	
		});
		this.add(this.createNewProjectButton);
	}
}
