package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Students;
import service.StudentsDao;

public class StudentsDaoImpl implements StudentsDao {

	@Override
	public List<Students> queryAllStudents() {
		Transaction tx = null;
		List<Students> list = null;
		String hql = "";
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql="from Students";
			Query query = session.createQuery(hql);
			list= query.list();
			tx.commit();
			return list;
		}
		catch(Exception e){
			e.printStackTrace();
			tx.commit();
			return list;
		}
		finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

	@Override
	public Students queryStudentsBySid(String sid) {
		Transaction tx = null;
		Students s = null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			s = (Students) session.get(Students.class, sid);
			tx.commit();
			return s;
		}
		catch(Exception e){
			e.printStackTrace();
			tx.commit();
			return s;
		}
		finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

	
	@Override
	public boolean updateStudents(Students s) {
		Transaction tx = null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(s);
			tx.commit();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			tx.commit();
			return false;
		}
		finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

	@Override
	public boolean deleteStudents(String sid) {
		Transaction tx = null;
		try{
			
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Students s = (Students) session.get(Students.class, sid);
			session.delete(s);
			tx.commit();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			tx.commit();
			return false;
		}
		finally{
			if(tx!=null){
				tx=null;
			}
		}
	}
	//����ѧ��ѧ��
	public String getNewSid(){
		Transaction tx = null;
		String hql = "";
		String sid = null;
		
		try{
			
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			//��õ�ǰѧ���������
			hql="select  max(sid) from Students";
			Query query = session.createQuery(hql);
			sid = (String) query.uniqueResult();
			if(sid==null||"".equals(sid)){
				//��һ��Ĭ�ϵ������
				sid = "s0000001";
			}else{
				String temp = sid.substring(1);//ȡ����λ
				int i =  Integer.parseInt(temp);//��������
				i++;
				//�ٻ�ԭΪ�ַ���
				temp = String.valueOf(i);
				int len = temp.length();
				//�չ���λ
				for(int j=0;j<7;j++){
					temp="0"+temp;
				}
				sid = "s"+temp;
			}
			tx.commit();
			return sid;
			
		}
		catch(Exception e){
			e.printStackTrace();
			tx.commit();
			return null;
		}
		finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

	@Override
	public boolean addStudents(Students s) {
		s.setSid(getNewSid());//����ѧ��
		Transaction tx = null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(s);
			tx.commit();
			return true;  
		}
		catch(Exception e){
			e.printStackTrace();
			tx.commit();
			return false;
		}
		finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

	@Override
	public Students queryStudentsBySname(String sname) {
		Transaction tx = null;
		Students s = null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			s = (Students) session.get(Students.class,sname);
			tx.commit();
			return s;
		}
		catch(Exception e){
			e.printStackTrace();
			tx.commit();
			return s;
		}
		finally{
			if(tx!=null){
				tx=null;
			}
		}
	}
		
	}
	