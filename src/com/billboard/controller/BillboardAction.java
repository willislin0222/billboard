package com.billboard.controller;


import com.billboard.model.BillboardService;
import com.billboard.model.BillboardVO;
import com.opensymphony.xwork2.ActionSupport;

public class BillboardAction extends ActionSupport {
	private BillboardVO billboardVO;

	

	public BillboardVO getBillboardVO() {
		return billboardVO;
	}

	public void setBillboardVO(BillboardVO billboardVO) {
		this.billboardVO = billboardVO;
	}

	public String add() {
		System.out.println("codehere");
		BillboardService billboardSvc = new BillboardService();
		billboardSvc.addBillboard(billboardVO);
		
		System.out.println("資料庫 insert 成功");
		return "success";
	}
	
	public String update() {
		BillboardService billboardSvc = new BillboardService();
		billboardSvc.updateBillboard(billboardVO);
		System.out.println("資料庫 update 成功");
		return "success";
	}

}
