package com.eTender.dto;

public class ProjectworkInfoDTO 
{
	private Integer projectno;
	private String clientProjectName;
	private String description;
	private String status;
	
	ProjectworkInfoDTO(Integer projectno,String clientProjectName,String description,String status)
	{
		this.projectno=projectno;
        this.clientProjectName = clientProjectName;
        this.description=description;
        this.status = status;
	}

	public Integer getProjectno()
	{
		return projectno;
	}

	public void setProjectno(Integer projectno)
	{
		this.projectno = projectno;
	}

	public String getClientProjectName() 
	{
		return clientProjectName;
	}

	public void setClientProjectName(String clientProjectName) 
	{
		this.clientProjectName = clientProjectName;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}
}
