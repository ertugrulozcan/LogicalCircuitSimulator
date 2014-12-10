package aero.logicsimulator.project;

import aero.logicsimulator.program.Program;

public class Project
{
	private String projectName;
	
	public Project(String name)
	{
		this.SetProjectName(name);
	}
	
	public Project()
	{
		this.SetProjectName(Program.strings.newProject);
	}
	
	public String GetProjectName()
	{
		return this.projectName;
	}
	
	public void SetProjectName(String name)
	{
		this.projectName = name;
	}
}
