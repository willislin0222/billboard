package com.billboard.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;



import hibernate.util.HibernateUtil;

public class BillboardDAO implements BillboardDAO_interface{
	
	private static final String GET_ALL_STMT="From BillboardVO";
	
	@Override
	public void insert(BillboardVO billboardVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			session.saveOrUpdate(billboardVO);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		
	}

	@Override
	public void update(BillboardVO billboardVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			session.saveOrUpdate(billboardVO);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		
	}

	@Override
	public void delete(int bill_id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			BillboardVO billboardVO =(BillboardVO) session.get(BillboardVO.class, bill_id);
			session.delete(billboardVO);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		
	}

	@Override
	public BillboardVO findByPrimaryKey(int bill_id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		BillboardVO billboardVO =null;
		try {
			session.beginTransaction();
			billboardVO =(BillboardVO) session.get(BillboardVO.class, bill_id);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		return billboardVO;
	}

	@Override
	public List<BillboardVO> getAll() {
		List<BillboardVO> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		return list;
	}

}
