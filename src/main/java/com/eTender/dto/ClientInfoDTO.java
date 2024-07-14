package com.eTender.dto;

public class ClientInfoDTO
{
	private int clientid;
	private String clientPersonName;
    private String address;
    private String phoneno;
    
    public ClientInfoDTO(Integer clientid,String clientPersonName, String address, String phoneno) 
    {
    	this.clientid=clientid;
        this.clientPersonName = clientPersonName;
        this.address = address;
        this.phoneno = phoneno;
    }

	public int getClientid() {
		return clientid;
	}

	public void setClientid(int clientid) {
		this.clientid = clientid;
	}

	public String getClientPersonName() 
	{
		return clientPersonName;
	}

	public void setClientPersonName(String clientPersonName) 
	{
		this.clientPersonName = clientPersonName;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPhoneno()
	{
		return phoneno;
	}

	public void setPhoneno(String phoneno)
	{
		this.phoneno = phoneno;
	}
}
