package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.hql.internal.ast.HqlASTFactory;

import db.MyHibernateSessionFactory;
import entity.Users;
import service.UsersDao;

public class UsersDaoImpl implements UsersDao {

	@Override
	public boolean usersLogin(Users u) {
		//事务对象
		Transaction tx = null;
		String hql = "";
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Users where username=? and password=? ";
			Query query = session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			System.out.println(u.getUsername());
			List list = query.list();
			tx.commit();//提交事务
			System.out.println(list.size());
			if(list.size()>0){
				return true;
			}else{
				return false;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		finally{
			if(tx!=null){
				tx= null;
			}
			
		}
		
		
		
}
}
	


