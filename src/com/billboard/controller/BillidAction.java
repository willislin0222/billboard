package com.billboard.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.billboard.model.BillboardService;
import com.billboard.model.BillboardVO;


public class BillidAction extends ActionSupport {
	private Integer bill_id;

	

	public Integer getBill_id() {
		return bill_id;
	}

	public void setBill_id(Integer bill_id) {
		this.bill_id = bill_id;
	}

	public String getOne_For_Display() {
		if (getOne()) {
			System.out.println("資料庫 getOne_For_Display 成功");
			return "success";
		} else {
			super.addFieldError("bill_id", "查無資料");
			return "input";
		}
	}

	public String getOne_For_Update() {
		if (getOne()) {
			System.out.println("資料庫 getOne_For_Update 成功");
			return "success";
		} else {
			super.addFieldError("bill_id", "查無資料");  //事實上, getOne_For_Update時, 並不會發生查無資料的情況
			
			return "input";
		}
	}

	public boolean getOne() {
		BillboardService billboardSvc = new BillboardService();
		BillboardVO billboardVO = billboardSvc.getOneBillboard(bill_id);
		if (billboardVO != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("billboardVO", billboardVO);
			return true;
		} else
			return false;
	}

	public String delete() {
		BillboardService billboardSvc = new BillboardService();
		billboardSvc.deleteBillboard(bill_id);
		System.out.println("資料庫 delete 成功");
		return "success";
	}

}
