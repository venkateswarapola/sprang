package com.example.demo;


public class l_user {

	private int b_user_id;
	private int b_unit_id;
	private String b_user_name;
	private String b_user_role;
	private int b_mkr_id;
	private String b_mkr_date;
	private int b_ckr_id;
	private String b_ckr_date;
	private String b_user_title;
	private String b_user_fn;
	private String b_user_mail;
	private String b_user_status;
	private String b_user_action;
	
	public l_user() {

	}
	
	public l_user(int b_user_id,int b_unit_id, String b_user_name,String b_user_role,int b_mkr_id,String b_mkr_date,int b_ckr_id,String b_ckr_date,String b_user_title,String b_user_fn,String b_user_mail,String b_user_status,String b_user_action) {
		super();
		this.b_user_id =b_user_id;
		this.b_unit_id =b_unit_id;
		this.b_user_name =b_user_name;
		this.b_user_role =b_user_role;
		this.b_mkr_id =b_mkr_id;
		this.b_mkr_date =b_mkr_date;
		this.b_ckr_id =b_ckr_id;
		this.b_ckr_date =b_ckr_date;
		this.b_user_title =b_user_title;
		this.b_user_fn =b_user_fn;
		this.b_user_mail =b_user_mail;
		this.b_user_status =b_user_status;
		this.b_user_action =b_user_action;
		
		
	}

	public int getb_user_id() {
		return b_user_id;
	}
	
	public int getb_unit_id() {
		return b_unit_id;
	}

	public String getb_user_name() {
		return b_user_name;
	}
	public String getb_user_role() {
		return b_user_role;
	}
	
	public int getb_mkr_id() {
		return b_mkr_id;
	}

	public String getb_mkr_date() {
		return b_mkr_date;
	}
	public int getb_ckr_id() {
		return b_ckr_id;
	}

	public String getb_ckr_date() {
		return b_ckr_date;
	}
	public String getb_user_title() {
		return b_user_title;
	}
	public String getb_user_fn() {
		return b_user_fn;
	}
	public String getb_user_mail() {
		return b_user_mail;
	}
	public String getb_user_status() {
		return b_user_status;
	}
	public String getb_user_action() {
		return b_user_action;
	}
	
	
	 public void setb_user_id(int num1) {
		   b_user_id = num1;
		  }
	 public void setb_unit_id(int num2) {
		   b_unit_id=num2;
		}

		public void setb_user_name(String name1) {
			 b_user_name=name1;
		}
		public void setb_user_role(String name2) {
			b_user_role=name2;
		}
		
		public void setb_mkr_id(int num3) {
			b_mkr_id=num3;
		}

		public void setb_mkr_date(String date1) {
			 b_mkr_date=date1;
		}
		public void setb_ckr_id(int num4) {
			b_ckr_id=num4;
		}

		public void setb_ckr_date(String date2) {
		    b_ckr_date=date2;
		}
		public void setb_user_title(String name3) {
			b_user_title=name3;
		}
		public void setb_user_fn(String name4) {
			b_user_fn=name4;
		}
		public void setb_user_mail(String name5) {
			b_user_mail=name5;
		}
		public void setb_user_status(String name6) {
			b_user_status=name6;
		}
		public void setb_user_action(String name7) {
			b_user_action=name7;
		}
		
}
