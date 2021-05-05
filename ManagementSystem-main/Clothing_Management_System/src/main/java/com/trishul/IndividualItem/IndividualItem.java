package com.trishul.IndividualItem;


public class IndividualItem {

	
	private String brand;
	private String color;
	private String instock;
	private String price;
	private String AgentName;
	private String CategoryName;
	private int PurchaseId;
	
	public IndividualItem (String brand,String color,String instock,String price) {
		
		this.brand=brand;
		this.color=color;
		this.instock=instock;
		this.price=price;
	}
	
	
	public IndividualItem(String nString, String nString2, String nString3, String nString4, String nString5,int instock) {
	// TODO Auto-generated constructor stub
		this.brand=nString;
		this.color=nString2;
		this.price=nString3;
		this.AgentName=nString4;
		this.CategoryName=nString5;
		this.PurchaseId=instock;
}

	public String getBrand(){return brand;}
	public String getColor(){return color;}
	public String getInstock(){return instock;}
	public String getPrice(){return price;}
	public String getAgent(){return AgentName;}
	public String getCategory(){return CategoryName;}
	public int getPurchaseId(){return PurchaseId;}
		
}
