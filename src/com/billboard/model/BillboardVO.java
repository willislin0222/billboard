package com.billboard.model;

import java.sql.Date;

public class BillboardVO {
	private Integer bill_id;
	private String bill_title;
	private String bill_name;
	private Date bill_start;
	private Date bill_end;
	private String bill_content;
	private byte[] bill_file;
	
	public Integer getBill_id() {
		return bill_id;
	}
	public void setBill_id(Integer bill_id) {
		this.bill_id = bill_id;
	}
	public String getBill_title() {
		return bill_title;
	}
	public void setBill_title(String bill_title) {
		this.bill_title = bill_title;
	}
	public Date getBill_start() {
		return bill_start;
	}
	public void setBill_start(Date bill_start) {
		this.bill_start = bill_start;
	}
	public Date getBill_end() {
		return bill_end;
	}
	public void setBill_end(Date bill_end) {
		this.bill_end = bill_end;
	}
	public String getBill_name() {
		return bill_name;
	}
	public void setBill_name(String bill_name) {
		this.bill_name = bill_name;
	}
	public String getBill_content() {
		return bill_content;
	}
	public void setBill_content(String bill_content) {
		this.bill_content = bill_content;
	}
	public byte[] getBill_file() {
		return bill_file;
	}
	public void setBill_file(byte[] bill_file) {
		this.bill_file = bill_file;
	}
	
	
	
	
	
}
