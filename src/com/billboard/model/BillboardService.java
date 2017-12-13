package com.billboard.model;

import java.sql.Date;
import java.util.List;


public class BillboardService {
private BillboardDAO_interface dao;
	
	public BillboardService(){
		dao =new BillboardDAO();
	}
	//Struts2用
	public void addBillboard(BillboardVO billboardVO) {
		dao.insert(billboardVO);
	}
	
	public void updateBillboard(BillboardVO billboardVO) {
		dao.update(billboardVO);
	}

	public void deleteBillboard(Integer bill_id) {
		dao.delete(bill_id);
	}

	public BillboardVO getOneBillboard(Integer bill_id) {
		return dao.findByPrimaryKey(bill_id);
	}

	public List<BillboardVO> getAll() {
		return dao.getAll();
	}
}
