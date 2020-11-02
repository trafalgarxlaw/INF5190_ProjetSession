package com.pronatation.Child;

import java.io.IOException;

import com.opensymphony.xwork2.ActionSupport;

public class ChildRegistrationAction extends ActionSupport {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName="";
	private String child_firstname="";
    private String child_lastname="";
    private String child_bdate="";
    
 
    
    public String execute() {
    	System.out.println(userName);

        return SUCCESS;
    }
 

 
    public void validate() {
    	
   		System.out.println("Registration of  "+child_firstname);
    	
//    	System.out.println(userName);
//    	System.out.println(child_firstname);
//    	System.out.println(child_lastname);
//    	System.out.println(child_bdate);
    	
    	
    	ChildDao childDao= new ChildDao();
    	
    	try {
			if(childDao.registerChild(child_firstname, child_lastname,child_bdate)==false){
			    addFieldError("child_firstname", "Error !!!");
			}
			else{
				childDao.addChild(userName, child_firstname);
				System.out.println(child_firstname+" Have been successfully registered ");

				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }



	public String getChild_firstname() {
		return child_firstname;
	}



	public void setChild_firstname(String child_firstname) {
		this.child_firstname = child_firstname;
	}



	public String getChild_lastname() {
		return child_lastname;
	}



	public void setChild_lastname(String child_lastname) {
		this.child_lastname = child_lastname;
	}



	public String getChild_bdate() {
		return child_bdate;
	}



	public void setChild_bdate(String child_bdate) {
		this.child_bdate = child_bdate;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}

}
