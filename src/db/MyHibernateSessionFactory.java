package db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MyHibernateSessionFactory {
	private static SessionFactory sessionFactory;//会话工厂模式
	//保证单例模式
	private MyHibernateSessionFactory(){
		
	}
	//共有的静态方法，获得会话工厂模式
	public static SessionFactory getSessionFactory(){
		if(sessionFactory==null){
			Configuration config = new Configuration().configure();
			//创建服务注册对象
			ServiceRegistry serviceregistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			//创建sessionFactory
			 sessionFactory =  config.buildSessionFactory(serviceregistry);
			
			return sessionFactory;
		}else{
			return sessionFactory;
		}
	
	}
}
